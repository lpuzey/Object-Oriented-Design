import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * ElectionData holds all the information for the VotingMachine class
 * 		-processes votes
 * 		-adding candidates
 * 		-candidate with most votes
 * 		-candidate with most points
 * 
 * @author Linda Puzey and Sarah Love
 *
 */
class ElectionData {
  HashMap<String,LinkedList<Integer>> votes = new HashMap<String,LinkedList<Integer>>();
  
  LinkedList<String> ballot = new LinkedList<String>();
  Scanner keyboard = new Scanner(System.in);
  
  ElectionData() {
    this.ballot.add("Gompei");
    this.ballot.add("Husky");
  }
  
  public void printBallot() {
    System.out.println("The candidates are ");
    for (String s : ballot) {
      System.out.println(s);
    }
  }
  
  public String[] screen() {
    this.printBallot();
    
    System.out.println ("Welcome to the voting booth!"); 
    
    String strings[] = new String[3];
    
    
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Type in the name you would like to vote for then press enter");
    for(int i=0; i<3; i++) //do 3 times
    {
        System.out.println("Enter name: ");

        //get user input
        String input = keyboard.nextLine();
        strings[i] = input;
        System.out.println("You voted for " + input);
    }
    
    return strings;
    
  }
  

  /**
   * This method stores a single voter's choices in the data structure
   * @param first, a candidate name (string)
   * @param second, a candidate name (string)
   * @param third, a candidate name (string)
   * @throws UnknownCandidateException - candidate does not exist
   * @throws DuplicateVotesException - cannot vote for candidate twice
   */
  public void processVote (String first, String second, String third) 
		  throws UnknownCandidateException, DuplicateVotesException {
	  if (!(votes.containsKey(first))) {
		  throw new UnknownCandidateException(first);
	  } 
	  if (!(votes.containsKey(second))) {
		  throw new UnknownCandidateException(second);
	  }
	  if (!(votes.containsKey(third))) {
		  throw new UnknownCandidateException(third);
	  }
	  if (second == first) {
		  throw new DuplicateVotesException(second);
	  } else if (third == second || third == first) {
		  throw new DuplicateVotesException(third);
	  }
	  int newval1 = votes.get(first).get(0) + 1;
	  votes.get(first).set(0, newval1);
	  int newval2 = votes.get(second).get(1) + 1;
	  votes.get(second).set(1, newval2);
	  int newval3 = votes.get(third).get(2) + 1;
	  votes.get(third).set(2, newval3);
	  
  }

  /**
   * Adds a candidate to the ballot of candidates
   * @param name of the candidate
   * @throws CandidateExistsException the name of the candidate already exists
   */
  public void addCandidate(String name) throws CandidateExistsException {
	  {
		  try {
			  this.candAdder(name);
		  } catch (CandidateExistsException e) {
			  System.out.println(e.name + " already exists.");
		  }
	  }
  }
  
  /**
   * Helper function for addCandidate. Adds initial votes to a list
   * @param name of the candidate
   * @throws CandidateExistsException the name of the candidate already exists
   */
  private void candAdder(String name) throws CandidateExistsException {
	  if (votes.containsKey(name)) {
		  throw new CandidateExistsException(name);
	  } else {
		  LinkedList<Integer> initialVotes = new LinkedList<Integer>();
		  initialVotes.add(0);
		  initialVotes.add(0);
		  initialVotes.add(0);
		  votes.put(name, initialVotes);
	  }
  }
  
  /**
   * @return  the name of the candidate with the highest number of first votes
   */
  public String findWinnerMostFirstVotes() {
	  int totalFirsts = 0;
	  for (LinkedList<Integer> counts : votes.values()) {
		  totalFirsts += counts.get(0);
	  }
	  int fiftyPercent = totalFirsts / 2;
	  for (String cand : votes.keySet()) {
		  if (votes.get(cand).get(0) > fiftyPercent) {
			  return cand;
		  }
	  }
	  return "Runoff required.";
  }
  
  /**
   * @return candidate with highest number of total points
   */
  public String findWinnerMostPoints() {
	  int mostVotes = 0;
	  String winner = "There were no votes.";
	  for(String cand : votes.keySet()) {
		  int points = 0;
		  points += votes.get(cand).get(0)*3;
		  points += votes.get(cand).get(1)*2;
		  points += votes.get(cand).get(2);
		  if(points > mostVotes) {
			  mostVotes = points;
			  winner = cand;
		  }
	  }
	  return winner;
  }
  
  }
