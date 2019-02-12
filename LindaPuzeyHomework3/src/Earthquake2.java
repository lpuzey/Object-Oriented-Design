import java.util.LinkedList;

/**
 * This class deals with datasmoothing tests
 * @author Linda Puzey, Sarah Love
 */

class Earthquake2 {
  Earthquake2(){}
      
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
	  LinkedList<DayReport> days = new LinkedList<DayReport>();
	   for (int i = 0; i < data.size(); i++) {
		   if (isDate(data.get(i)) == true) {
			   LinkedList<Double> todayReadings = new LinkedList<Double>();
			   boolean sameDay = true;
			   for (int j = i + 1; j < data.size(); j++) {
				   if (sameDay == true && isDate(data.get(j)) == false) {
					   todayReadings.add(data.get(j));
				   } else {
					   sameDay = false;
				   }
			   }
			   days.add(new DayReport(data.get(i), todayReadings));
		   }
	   }
	   for (DayReport n : days) {
		   if (extractMonth(n.date) == month) {
			   double max = 0.0;
			   for (double r : n.readings) {
				   if (r > max) {
					   max = r;
				   }
			   }
			   report.add(new MaxHzReport(n.date, max));
		   }
	   }
	   return report;
	}
  
  class DayReport {
		double date;
		LinkedList<Double> readings;
		
		DayReport(double date, LinkedList<Double> readings) {
			this.date = date;
			this.readings = readings;
		}
  }
}