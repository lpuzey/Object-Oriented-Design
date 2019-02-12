import java.util.LinkedList;

/**
 * This class deals with 
 * @author Linda Puzey, Sarah Love
 */

class Earthquake1 {
  Earthquake1(){}

  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum > 10000000; }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }
  
  /**
	 * This method returns the total of the points across all laps in the list
	 * @param a LinkedList of doubles (sensor data) and the month it was recording
	 * @return a LinkedList of MazHzReports
	 */
 
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data,
                                                  int month) {
	  LinkedList<MaxHzReport> report = new LinkedList<MaxHzReport>();
	   for (int i = 0; i < data.size(); i++) {
		   double d = data.get(i);
		   if (isDate(d) == true) {
			   if (extractMonth(d) == month) {
				   double currentMax = 0;
				   boolean past = false;
				   for (int j = i+1; j < data.size(); j++) {
					   if (isDate(data.get(j)) == false && past == false) {
						   if (data.get(j) > currentMax) {
							   currentMax = data.get(j);
						   }
					   } else {
						   past = true;
					   }
				   }
				   MaxHzReport today = new MaxHzReport(d, currentMax);
				   report.add(today);
			   }
		   }
	   }
	   return report;
	  }
}  


