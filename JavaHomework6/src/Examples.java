import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Examples {

	//testing ElectionData that has candidates with no votes, for the method findWinnerMostPoints()
	@Test
	public void mostEmpty() {
		ElectionData strangerVotes = new ElectionData();
	    try {
	    	strangerVotes.addCandidate("steve");
		    strangerVotes.addCandidate("jonathan");
		    strangerVotes.addCandidate("billy");
	    } catch (Exception e) {}
		assertEquals(strangerVotes.findWinnerMostPoints(), "There were no votes.");
	}
	
	//testing ElectionData that has candidates with no votes, for the method findWinnerMostFirstVotes()
	@Test
	public void firstEmpty() {
		ElectionData strangerVotes = new ElectionData();
	    try {
	    	strangerVotes.addCandidate("steve");
		    strangerVotes.addCandidate("jonathan");
		    strangerVotes.addCandidate("billy");
	    } catch (Exception e) {}
		assertEquals(strangerVotes.findWinnerMostFirstVotes(), "Runoff required.");
	}

	//testing to see if findWinnerMostFirstVotes() works correctly
	@Test
	public void someVotes() {
		ElectionData strangerVotes = new ElectionData();
	    try {
	    	strangerVotes.addCandidate("steve");
		    strangerVotes.addCandidate("jonathan");
		    strangerVotes.addCandidate("billy");
		    strangerVotes.addCandidate("mike");
		    strangerVotes.addCandidate("dustin");
		    strangerVotes.addCandidate("lucas");
		    strangerVotes.addCandidate("will");
		    strangerVotes.processVote("steve", "will", "jonathan");
		    strangerVotes.processVote("steve", "lucas", "dustin");
		    strangerVotes.processVote("steve", "jonathan", "mike");
		    strangerVotes.processVote("steve", "mike", "dustin");
		    strangerVotes.processVote("steve", "lucas", "mike");
	    } catch (Exception e) {}
	    assertEquals(strangerVotes.findWinnerMostFirstVotes(),"steve");
	}
	
	//testing findWinnerMostFirstVotes() to see if it works correctly 
	//if all the candidates have equal first votes
	@Test
	public void equalFirstVotes() {
		ElectionData strangerVotes = new ElectionData();
	    try {
	    	strangerVotes.addCandidate("steve");
		    strangerVotes.addCandidate("jonathan");
		    strangerVotes.addCandidate("billy");
		    strangerVotes.addCandidate("mike");
		    strangerVotes.addCandidate("dustin");
		    strangerVotes.addCandidate("lucas");
		    strangerVotes.addCandidate("will");
		    strangerVotes.processVote("mike", "will", "lucas");
		    strangerVotes.processVote("will", "lucas", "dustin");
		    strangerVotes.processVote("lucas", "dustin", "mike");
		    strangerVotes.processVote("dustin", "mike", "will");
	    } catch (Exception e) {}
	    assertEquals(strangerVotes.findWinnerMostFirstVotes(),"Runoff required.");
	}
	
	//testing findWinnerMostPoints() to see if it works correctly if all the candidates have equal votes
	@Test
	public void equalMostVotes() {
		ElectionData strangerVotes = new ElectionData();
	    try {
	    	strangerVotes.addCandidate("steve");
		    strangerVotes.addCandidate("jonathan");
		    strangerVotes.addCandidate("billy");
		    strangerVotes.addCandidate("mike");
		    strangerVotes.addCandidate("dustin");
		    strangerVotes.addCandidate("lucas");
		    strangerVotes.addCandidate("will");
		    strangerVotes.processVote("mike", "will", "lucas");
		    strangerVotes.processVote("will", "lucas", "dustin");
		    strangerVotes.processVote("lucas", "dustin", "mike");
		    strangerVotes.processVote("dustin", "mike", "will");
	    } catch (Exception e) {}
	    String tieWinner = strangerVotes.findWinnerMostPoints();
	    assertTrue(tieWinner == "mike" || tieWinner == "lucas" || tieWinner == "dustin" || tieWinner == "will");
	}
	
	//testing findWinnerMostFirstVotes() to see if it throws the correct exception 
	//if the same candidate is voted for first, second, and third
	@Test
	public void sameFSTvotes() {
		String result = "";
		String comparator = "steve error";
		ElectionData strangerVotes = new ElectionData();
	    try {
	    	strangerVotes.addCandidate("steve");
		    strangerVotes.addCandidate("jonathan");
		    strangerVotes.addCandidate("billy");
		    strangerVotes.addCandidate("mike");
		    strangerVotes.addCandidate("dustin");
		    strangerVotes.addCandidate("lucas");
		    strangerVotes.addCandidate("will");
		    strangerVotes.processVote("steve", "steve", "steve");
	    } catch (DuplicateVotesException e) {result = e.name + " error";}
	    catch (Exception e) {}
	    strangerVotes.findWinnerMostFirstVotes();
	    assertEquals(comparator, result);
	}
	
	//testing findWinnerMostFirstVotes() to see if it throws the correct exception 
	//if the same candidate is voted for second and third
	@Test
	public void sameSTvotes() {
		String result = "";
		String comparator = "dustin error";
		ElectionData strangerVotes = new ElectionData();
	    try {
	    	strangerVotes.addCandidate("steve");
		    strangerVotes.addCandidate("jonathan");
		    strangerVotes.addCandidate("billy");
		    strangerVotes.addCandidate("mike");
		    strangerVotes.addCandidate("dustin");
		    strangerVotes.addCandidate("lucas");
		    strangerVotes.addCandidate("will");
		    strangerVotes.processVote("steve", "dustin", "dustin");
	    } catch (DuplicateVotesException e) {result = e.name + " error";}
	    catch (Exception e) {}
	    strangerVotes.findWinnerMostFirstVotes();
	    assertEquals(comparator, result);
	}
	
	//testing findWinnerMostFirstVotes() to see if it throws the correct exception 
	//if the candidate voted for does not exist
	@Test
	public void bob() {
		String result = "";
		String comparator = "bob error";
		ElectionData strangerVotes = new ElectionData();
	    try {
	    	strangerVotes.addCandidate("steve");
		    strangerVotes.addCandidate("jonathan");
		    strangerVotes.addCandidate("billy");
		    strangerVotes.addCandidate("mike");
		    strangerVotes.addCandidate("dustin");
		    strangerVotes.addCandidate("lucas");
		    strangerVotes.addCandidate("will");
		    strangerVotes.processVote("steve", "dustin", "bob");
	    } catch (UnknownCandidateException e) {result = e.name + " error";}
	    catch (Exception e) {}
	    strangerVotes.findWinnerMostFirstVotes();
	    assertEquals(comparator, result);
	}
	
	//testing findWinnerMostPoints() to see if is doing math correctly
	@Test
	public void jonathan() {
		ElectionData strangerVotes = new ElectionData();
	    try {
	    	strangerVotes.addCandidate("steve");
		    strangerVotes.addCandidate("jonathan");
		    strangerVotes.addCandidate("billy");
		    strangerVotes.addCandidate("mike");
		    strangerVotes.addCandidate("dustin");
		    strangerVotes.addCandidate("lucas");
		    strangerVotes.addCandidate("will");
		    strangerVotes.processVote("steve", "mike", "jonathan");
		    strangerVotes.processVote("dustin", "jonathan", "will");
		    strangerVotes.processVote("lucas", "jonathan", "steve");
	    } catch (Exception e) {}
	    assertEquals(strangerVotes.findWinnerMostPoints(),"jonathan");
	}
	
	//testing findWinnerMostPoints() to see if is doing math correctly
	@Test
	public void mike() {
		ElectionData strangerVotes = new ElectionData();
	    try {
	    	strangerVotes.addCandidate("steve");
		    strangerVotes.addCandidate("jonathan");
		    strangerVotes.addCandidate("billy");
		    strangerVotes.addCandidate("mike");
		    strangerVotes.addCandidate("dustin");
		    strangerVotes.addCandidate("lucas");
		    strangerVotes.addCandidate("will");
		    strangerVotes.processVote("steve", "mike", "jonathan");
		    strangerVotes.processVote("dustin", "mike", "will");
		    strangerVotes.processVote("lucas", "mike", "steve");
	    } catch (Exception e) {}
	    assertEquals(strangerVotes.findWinnerMostPoints(),"mike");
	}

	//testing findWinnerMostPoints() to see if is doing math correctly
	@Test
	public void lucas() {
		ElectionData strangerVotes = new ElectionData();
	    try {
	    	strangerVotes.addCandidate("steve");
		    strangerVotes.addCandidate("jonathan");
		    strangerVotes.addCandidate("billy");
		    strangerVotes.addCandidate("mike");
		    strangerVotes.addCandidate("dustin");
		    strangerVotes.addCandidate("lucas");
		    strangerVotes.addCandidate("will");
		    strangerVotes.addCandidate("bob");
		    strangerVotes.addCandidate("barb");
		    strangerVotes.processVote("steve", "will", "lucas");
		    strangerVotes.processVote("dustin", "mike", "lucas");
		    strangerVotes.processVote("bob", "billy", "lucas");
		    strangerVotes.processVote("jonathan", "barb", "lucas");
	    } catch (Exception e) {}
	    assertEquals(strangerVotes.findWinnerMostPoints(),"lucas");
	}
	
	//testing findWinnerMostFirstVotes() to see if it works correctly 
	//if all the candidates have equal first votes, but another candidate has more total votes
	@Test
	public void notLucas() {
		ElectionData strangerVotes = new ElectionData();
	    try {
	    	strangerVotes.addCandidate("steve");
		    strangerVotes.addCandidate("jonathan");
		    strangerVotes.addCandidate("billy");
		    strangerVotes.addCandidate("mike");
		    strangerVotes.addCandidate("dustin");
		    strangerVotes.addCandidate("lucas");
		    strangerVotes.addCandidate("will");
		    strangerVotes.addCandidate("bob");
		    strangerVotes.addCandidate("barb");
		    strangerVotes.processVote("steve", "will", "lucas");
		    strangerVotes.processVote("dustin", "mike", "lucas");
		    strangerVotes.processVote("bob", "billy", "lucas");
		    strangerVotes.processVote("jonathan", "barb", "lucas");
	    } catch (Exception e) {}
	    assertEquals(strangerVotes.findWinnerMostFirstVotes(), "Runoff required.");
	}
	
}
