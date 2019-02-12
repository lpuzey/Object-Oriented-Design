
public class Athlete {

	FinalResult overallScore; //includes the Shooting and SkiingResult
	
	Athlete(FinalResult overallScore){
		this.overallScore = overallScore;
	}
	
	//produces the athlete with the lower score
	public Athlete betterSkiier(Athlete competitor) {
		if (overallScore.ski.pointsEarned() > competitor.overallScore.ski.pointsEarned()) {
			return competitor;
		} else {
			return this;
		}
	}
	
	//produces a boolean if the inputed athlete has a lower score
	public boolean hasBeaten(Athlete competitor) {
		if(overallScore.shoot.pointsEarned() < competitor.overallScore.shoot.pointsEarned()) {
			return true;
		} else if (overallScore.ski.pointsEarned() > competitor.overallScore.ski.pointsEarned()) {
			return true;
		} else {
			return false;
		}
	}
}
