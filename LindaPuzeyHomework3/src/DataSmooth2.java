import java.util.LinkedList;

/**
 * This class deals with Shows and their runtimes
 * @author Linda Puzey, Sarah Love
 */

class DataSmooth2 {
  DataSmooth2(){}
  
  public LinkedList<Double> dataSmooth(LinkedList<Show> shows) 
  {
	  for (Show n : shows) {
		  double acc = 0;
		  for (Episode e : n.episodes) {
			  acc = acc + e.runTime;
		  }
		  double avg = acc / n.episodes.size();
		  n.setAvgLength(avg);
	  }
	  LinkedList<Double> acc = new LinkedList<Double>();
	  for (int i = 0; i < shows.size(); i++) {
		  if(i == 0 || i == shows.size() - 1) {
			  acc.add(shows.get(i).avgLength);
		  } else {
			  double previous = shows.get(i - 1).avgLength;
			  double current = shows.get(i).avgLength;
			  double next = shows.get(i + 1).avgLength;
			  double newVal = (previous + current + next)/ 3;
			  acc.add(newVal);
		  }
	  }
	  return acc;
  }
}