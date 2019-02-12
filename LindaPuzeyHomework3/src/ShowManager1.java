import java.util.LinkedList;

/**
 * This class deals with organizing shows and ShowSummaries
 * @author Linda Puzey, Sarah Love
 */

class ShowManager1 {
	
	ShowManager1() {}

	  /**
		 * This method returns the total of the points across all laps in the list
		 * @param a LinkedList of shows
		 * @return a ShowSummary of organized shows by daytime or primetime
		 */
	
	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		ShowSummary summary = new ShowSummary();
		for (Show n : shows) {
			if ((n.broadcastTime >= 600) && (n.broadcastTime < 1700)) {
				summary.daytime.add(n);
			} if ((n.broadcastTime >= 1700) && (n.broadcastTime < 2300)) {
				summary.primetime.add(n);
			} 
		}
		return summary;
	}
	
}


