import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public interface IReport {
	
	// helper for addDailyReport()
	IReport makeReport(GregorianCalendar gregor, LinkedList<Double> temper, LinkedList<Double> RF);

	//get temperature
	LinkedList<Double> getTemp();
	
	//get rainfall
	LinkedList<Double> getRF();

	//get date
	Calendar getGregor();

}

