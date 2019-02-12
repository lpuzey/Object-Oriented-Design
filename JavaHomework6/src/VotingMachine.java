import java.util.Scanner;


/**
 * VotingMachine runs main, and the interface for the voting system
 * @author Linda Puzey and Sarah Love
 *
 */
public class VotingMachine {

	
    public static void main(String [] args) throws UnknownCandidateException, DuplicateVotesException {
    	
    	
    	ElectionData ED = new ElectionData();
    	VotingMachine votah = new VotingMachine(ED);
	    
    	try {
	    	ED.addCandidate("steve");
		    ED.addCandidate("jonathan");
		    ED.addCandidate("billy");
		    
    	} catch (Exception e) {}
	        
      boolean keepVoting = true;
      
      
      while(keepVoting == true) {
      String[] voteResults = ED.screen();
      votah.voteProcessor(voteResults[0], voteResults[1], voteResults[2]);
      System.out.println("Would you like to vote again? Enter N to stop voting");
      char input2 = ED.keyboard.next().charAt(0);
      
      if (input2 == 'N' || input2 == 'n')
      {
    	  keepVoting = false;
      }
      }

        
    }
	
	
	private ElectionData ed = new ElectionData();
	
	VotingMachine(ElectionData ed) {
		this.ed = ed;
	}
	
	/**
	 * interface to vote for first, second, and third choices
	 * 
	 * @param first name of candidate voted for
	 * @param second name of candidate voted for
	 * @param third name of candidate voted for
	 * @throws UnknownCandidateException - candidate does not exist
	 * @throws DuplicateVotesException - so the user cannot vote for the same candidate twice
	 * @throws CandidateExistsException - the candidate does exist
	 */
  public void voteProcessor (String first, String second, String third) 
		  throws UnknownCandidateException, DuplicateVotesException {
	  
	  boolean processing = true;
			  
			  while(processing==true) {
			 
				  try {
					  this.ed.processVote(first, second, third);
					  processing=false;
				  }
				  catch (UnknownCandidateException e) {
					  System.out.println(e.name + " is not a valid candidate. Would you like to add this canidate? Type 'y' for yes.");
					  char input = this.ed.keyboard.next().charAt(0);
					  if(input == 'y' || input == 'Y') {
						  try {
							addWriteIn(e.name);
						} 
						  
						  catch (CandidateExistsException e1) {
							e1.printStackTrace();
						}
						  
					  }
				  }
				  catch (DuplicateVotesException e) {
					  System.out.println("You can only vote for " + e.name + " once.");
				  }
			  }
  		}
		  
  /**
   * Adding a candidate to the voting booth through the voting booth itself
   * @param name of the candidate
   * @throws CandidateExistsException - checks to see if the candidate already exists
   */
  public void addWriteIn(String name) throws CandidateExistsException{
	  try {
		  this.ed.addCandidate(name);
		  System.out.println("The candidate was added sucessfully.");
	  }
	  catch(CandidateExistsException e) {
		  System.out.println("The candidate already exists.");
	  }
  }

}