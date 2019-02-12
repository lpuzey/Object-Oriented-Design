
public class SkiingResult extends AbsSki implements IEvent{
	
	int position; //1 for first, 2 for second, etc
	
	SkiingResult(int position, double lap1Time, double lap2Time, double lap3Time, double lap4Time, double lap5Time){
		super(lap1Time,lap2Time,lap3Time,lap4Time,lap5Time);
		this.position = position;	
	}
	
}
