import java.util.LinkedList;

/**
 * This class deals with Shows and their runtimes
 * @author Linda Puzey, Sarah Love
 */

class DataSmooth1 {
  DataSmooth1(){}
  
	/**
	 * This method returns the total of the points across all laps in the list
	 * @param a LinkedList of shows
	 * @return a LinkedList of doubles, the sum of the episode runtimes
	 */
  
  public LinkedList<Double> dataSmooth(LinkedList<Show> shows) 
  {
	  LinkedList<Double> avgs = new LinkedList<Double>();
	  if (shows.size() > 1) {
		  for (Show n : shows) {
			  double sum = 0;
			  for (Episode e : n.episodes) {
				  sum += e.runTime;
			  }
			  avgs.add(sum/n.episodes.size());
		  }
		  LinkedList<Double> runtimes = new LinkedList<Double>();
		  runtimes.add(avgs.get(0));
		  double prev = avgs.get(0);
		  double next = avgs.get(2);
		  for (int i = 1; i < avgs.size() - 1; i++) {
			  runtimes.add((avgs.get(i) + prev + next)/3);
			  prev = avgs.get(i);
			  if (i < avgs.size()-2) {
			  next = avgs.get(i+2);
			  }
		  }
		  runtimes.add(avgs.get(avgs.size()-1));
		  return runtimes;
		 } else if (shows.size() == 1) {
			 return avgs;
		 } else {
			 return new LinkedList<Double>();
		 }
  
  }
}