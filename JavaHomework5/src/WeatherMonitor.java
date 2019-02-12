import java.util.GregorianCalendar;
import java.util.LinkedList;

import javax.print.attribute.Size2DSyntax;

/**
 * This class holds the two main functions for this 
 * assignment, averageTempForMonth and totalRainfallForMonth
 * 
 * @author Linda Puzey and Sarah Love
 */
public class WeatherMonitor {

	IReport report;
	LinkedList<IReport> IReports;

	WeatherMonitor(IReport report) {
		this.report = report;
		this.IReports = new LinkedList<IReport>();
	}

	/**
	 * @param Takes in a month
	 * @param Takes in a year
	 * @return a double which represents the average temperature for that month
	 */
	double averageTempForMonth(int month, int year) {
		double sum = 0;
		double num = 0;
		
		for (int i = 0; i < this.IReports.size(); i++) {
			IReport newReport = this.IReports.get(i);
			if (newReport.getGregor().get(GregorianCalendar.YEAR) == year) {
				if (newReport.getGregor().get(GregorianCalendar.MONTH) == month) {
					//System.out.println("SumBefore:" + sum);
					//System.out.println("NumBefore:" + num);
					sum = sum + ListSummer(newReport.getTemp());
					num = num + newReport.getTemp().size();
				}
			}
		}
		return sum / num;
	}
	
	/**
	 * 
	 * @param a month
	 * @param a year
	 * @return a double that represents the total rainfall in that month
	 */
	double totalRainfallForMonth (int month, int year) {
		LinkedList<DailyWeatherReport> empty = new LinkedList<DailyWeatherReport>();
		double sum = 0;
		for (int i = 0; i < this.IReports.size(); i++) {
		IReport newReport = this.IReports.get(i);
		if (newReport.getGregor().get(GregorianCalendar.YEAR) == year) {
			if (newReport.getGregor().get(GregorianCalendar.MONTH) == month) {
				sum = sum + ListSummer(newReport.getRF());
			}
		}
	}
		return sum;
}
	/**
	 * 
	 * @param A list of doubles
	 * @return the sum of all the doubles in the list
	 */
	public double ListSummer(LinkedList<Double> blep)
	{
		double sum = 0;	
		for(int i = 0; i < blep.size(); i++)
		{
			//System.out.println("Where r nums?" + blep.get(i));
			
			sum = sum + blep.get(i); 
			//System.out.println(sum);
		}
		
		return sum;
	}

	/**
	 * Adds an IReport for the specified date with the specified readings
	 * @param Gregorian Calendar gregor
	 * @param A list of readings kate
	 * @return a void
	 */
	void addDailyReport(GregorianCalendar gregor, LinkedList<Reading> readings) {
		LinkedList<Double> ListOfRain = new LinkedList<Double>();
		LinkedList<Double> ListOfTemp = new LinkedList<Double>();
		
		for(int i = 0; i < readings.size(); i++) {
			ListOfRain.add(readings.get(i).rainFall);
			ListOfTemp.add(readings.get(i).temp);
		}
		
		IReport newReport = report.makeReport(gregor, ListOfTemp, ListOfRain);
		this.IReports.add(newReport);
	}

}
