import java.util.LinkedList;

/**
 * This class deals with organizing shows and ShowSummaries
 * @author Linda Puzey, Sarah Love
 */


class ShowSummary {
	
	LinkedList<Show> daytime;
	LinkedList<Show> primetime;
	
	ShowSummary() 
	{
		this.daytime = new LinkedList<Show>();
		this.primetime = new LinkedList<Show>();
	}
	
	ShowSummary(LinkedList<Show> daytime, LinkedList<Show> primetime)
	{
		this.daytime = daytime;
		this.primetime = primetime;
	}

	// the equals method for use in testing
	 public boolean equals(Object other) 
	 {
		if(!(other instanceof ShowSummary)) 
		{
			return false;
		}
		 
	    ShowSummary otherS = (ShowSummary) other;
	    
	    return this.equalsHelper(this.daytime, otherS.daytime) && 
	    	   this.equalsHelper(this.primetime, otherS.primetime);
	 }
	 
	 private boolean equalsHelper(LinkedList<Show> theseShows, LinkedList<Show> otherShows)
	 {	
		if(theseShows.size() != otherShows.size())
		{
			return false;
		}
		 
	    for(int i = 0; i < theseShows.size(); i++)
	    {
	    	Show thisShow = theseShows.get(i);
	    	Show otherShow = otherShows.get(i);
	    	
	    	if(!thisShow.title.equals(otherShow.title))
	    	{
	    		return false;
	    	}
	    	else if(thisShow.broadcastTime != otherShow.broadcastTime)
	    	{
	    		return false;
	    	}
	    }
	    
	    return true;
	 }
	  
	 // the toString method so that reports display when tests fail
	 public String toString()
	 {
		 return this.toStringHelper(this.daytime) + "--- \n\n" + this.toStringHelper(this.primetime);  
	  }
	 
	 private String toStringHelper(LinkedList<Show> theseShows)
	 {
		String output = "";
		
	    for(Show thisShow : theseShows)
	    {
	    	output = output + 
	    			"Title: " + thisShow.title + " | " +
	    			"Broadcast Time: " + thisShow.broadcastTime + "\n";
	    	
	    	for(Episode thisEp : thisShow.episodes)
	    	{
	    		output = output + 
	    				"Episode Title: " + thisEp.epTitle + " | " +
	    				"Runtime: " + thisEp.runTime + "\n";
	    	}
	    	
	    	output = output + "\n";
	    }
	    
		return output;
	 }
	 
	 //adds a show to its daytime or primetime list as appropriate
	 public void sortShow(Show show) {
		 if (show.broadcastTime < 2300) {
			 if (show.broadcastTime >= 1700) {
				this.primetime.add(show);
			 }
		 }
		 if (show.broadcastTime < 1700) {
				if (show.broadcastTime >= 600) {
					this.daytime.add(show);
				}
			}
	 }
}
