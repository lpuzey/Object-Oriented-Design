
public class FinalResult {

	ShootingResult shoot; //includes 4 rounds
	SkiingResult ski; //includes 5 lap times 
	
	FinalResult(ShootingResult shoot, SkiingResult ski){
		this.shoot = shoot;
		this.ski = ski;
	}

	/**
	 * This method returns a total of the penalties for the targets missed
	 * @param shoot a ShootingResult that you want to get the penalties for
	 * @return adds 60 for every target missed
	 */
	double getShootingPenalties(ShootingResult shoot){
		double total = shoot.pointsEarned();
		double penalty = ((20 - total)*60);
		return penalty;
	}	
	
	/**
	 * This method returns the final score of all the points, position, and penalties applied
	 * @param shoot a ShootingResult that you want to get the penalties for
	 * @return totals up the ski points and shootingPenalties, minus the position
	 */
	double finalScore() {
		double finishTime = ski.pointsEarned() + getShootingPenalties(shoot);
		if (ski.position == 1) {
			return finishTime - 10;
		} else if (ski.position == 2) {
			return finishTime - 7;
		} else if (ski.position == 3) {
			return finishTime - 3;
		} else {
			return finishTime;
		}   
	}
}