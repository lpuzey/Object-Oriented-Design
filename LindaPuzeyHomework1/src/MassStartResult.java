

public class MassStartResult extends AbsSki implements IEvent {

	int startPosition;
	int endPosition;

	MassStartResult(int startPosition, int endPosition,double lap1Time, double lap2Time, double lap3Time, double lap4Time, double lap5Time){
		super (lap1Time,lap2Time,lap3Time,lap4Time,lap5Time);
			
			this.startPosition = startPosition;
			this.endPosition = endPosition;	
		}

}
