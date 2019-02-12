import java.util.LinkedList;

/**
 * This class deals with defining shows
 * @author Linda Puzey, Sarah Love
 */

class Show {

	String title;
	double broadcastTime;
	LinkedList<Episode> episodes;
	double avgLength;
	
	Show(String title, double broadcastTime, LinkedList<Episode> episodes)
	{
		this.title = title;
		this.broadcastTime = broadcastTime;
		this.episodes = episodes;
	}
	
	public void setAvgLength(double avgLength)
	{
		this.avgLength = avgLength;
	}
	
}
