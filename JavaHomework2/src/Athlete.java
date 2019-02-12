
public class Athlete {

	FinalResult overallScore; //includes the Shooting and SkiingResult
	String name;
	
	Athlete(FinalResult overallScore, String name){
		this.overallScore = overallScore;
		this.name = name;
	}
	
	/**
	 * This method returns the Athlete with the lower score
	 * @param competitor an Athlete that you want to compare
	 * @return produces the athlete with the lower score
	 */
	public Athlete betterSkiier(Athlete competitor) {
		if (overallScore.ski.pointsEarned() > competitor.overallScore.ski.pointsEarned()) {
			return competitor;
		} else {
			return this;
		}
	}
	
	/**
	 * This method returns a boolean if the inputed athlete has a lower score
	 * @param competitor an Athlete that you want to compare
	 * @return produces a boolean if the competitor has a lower score
	 */
	public boolean hasBeaten(Athlete competitor) {
		if(overallScore.shoot.pointsEarned() < competitor.overallScore.shoot.pointsEarned()) {
			return true;
		} if (overallScore.ski.pointsEarned() > competitor.overallScore.ski.pointsEarned()) {
			return true;
		} else {
			return false;
		}
	}
}