
public class ShootingResult implements IEvent{
	
	ShootingRound round1; //numbers of targets hit for round 1
	ShootingRound round2; //numbers of targets hit for round 2
	ShootingRound round3; //numbers of targets hit for round 3
	ShootingRound round4; //numbers of targets hit for round 4
	
	ShootingResult(ShootingRound round1, ShootingRound round2, ShootingRound round3, ShootingRound round4){
		this.round1 = round1;
		this.round2 = round2;
		this.round3 = round3;
		this.round4 = round4;
	}
	
	//totals all of the targets that were hit for each round
	public double pointsEarned() {
		double totalShootPoints;
		totalShootPoints = (round1.numTargets + round2.numTargets + round3.numTargets + round4.numTargets);
		return totalShootPoints;
	}
	
}
