
public class SkiingResult implements IEvent{

	double lap1Time; //time the athlete crossed the finish line for lap 1
	double lap2Time; //time the athlete crossed the finish line for lap 2
	double lap3Time; //time the athlete crossed the finish line for lap 3
	double lap4Time; //time the athlete crossed the finish line for lap 4
	double lap5Time; //time the athlete crossed the finish line for lap 5
	
	int position; //1 for first, 2 for second, etc
	
	SkiingResult(double lap1Time, double lap2Time, double lap3Time, double lap4Time, double lap5Time, int postion){
		this.lap1Time = lap1Time;
		this.lap2Time = lap2Time;
		this.lap3Time = lap3Time;
		this.lap4Time = lap4Time;
		this.lap5Time = lap5Time;
		this.position = postion;
		
	}
	
	//totals up each lap time
	public double pointsEarned() {
		double totalSkiPoints;
		totalSkiPoints = (lap1Time + lap2Time + lap3Time + lap4Time + lap5Time);
		return totalSkiPoints;
	}
}
