import java.util.LinkedList;

abstract class AbsSki implements IEvent{
	
	LinkedList<Double> laps = new LinkedList<Double>();


	AbsSki(double lap1Time, double lap2Time, double lap3Time, double lap4Time, double lap5Time){
			laps.add(lap1Time);
			laps.add(lap2Time);
			laps.add(lap3Time);
			laps.add(lap4Time);
			laps.add(lap5Time);
			
		}
	/**
	 * This method returns the total of the points across all laps in the list
	 * 
	 * @return sum of every lap
	 */
	public double pointsEarned() {
		double sum = 0;
		if (laps == null || laps.isEmpty()) {
			return 0;
		}
		for (double x : laps) {
			sum += x;
		}
		return sum;

	}
}
