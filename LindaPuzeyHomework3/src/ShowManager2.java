import java.util.LinkedList;

/**
 * This class deals with organizing shows and ShowSummaries
 * @author Linda Puzey, Sarah Love
 */


class ShowManager2 {
	
	ShowManager2() {}

	 /**
	 * This method returns the total of the points across all laps in the list
	 * @param a LinkedList of shows
	 * @return a ShowSummary of organized shows by daytime or primetime
	 */
	
	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		ShowSummary summary = new ShowSummary();
		for(int i=0; i < shows.size(); i++) {
			summary.sortShow(shows.get(i));
		}
		return summary;
	}
	
}


