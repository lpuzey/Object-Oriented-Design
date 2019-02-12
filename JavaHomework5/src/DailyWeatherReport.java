import java.util.GregorianCalendar;
import java.util.LinkedList;

public class DailyWeatherReport implements IReport {

	private GregorianCalendar gregor;
	private LinkedList<Double> Temp = new LinkedList<Double>();
	private LinkedList<Double> RF = new LinkedList<Double>();
	
	//constructor
	DailyWeatherReport(GregorianCalendar gregor, LinkedList<Double> Temp, LinkedList<Double> RF) {
		this.setGregor(gregor);
		this.setTemp(Temp);
		this.setRF(RF);
	}
	
	// encapsulated helper function for addDailyReport()
	public IReport makeReport(GregorianCalendar gregor, LinkedList<Double> Temp, LinkedList<Double> RF) {
		LinkedList<Double> newTemp = new LinkedList<Double>();
		for (int i = 0; i < Temp.size(); i++) {
				newTemp.add(Temp.get(i));
			}
		return new DailyWeatherReport(gregor, newTemp, RF);
	}

	//get temperature
	public LinkedList<Double> getTemp() {
		return Temp;
	}

	//get date
	public GregorianCalendar getGregor() {
		return gregor;
	}
	
	//get RF
	public LinkedList<Double> getRF() {
		return RF;
	}
	
	//set RF
	public void setRF(LinkedList<Double> RF) {
		this.RF = RF;
	}

	//set date
	private void setGregor(GregorianCalendar gregor) {
		this.gregor = gregor;
	}

	//set temperature
	private void setTemp(LinkedList<Double> Temp) {
		this.Temp = Temp;
	}
	
}
