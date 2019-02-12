import java.util.LinkedList;

public class ShootingResult implements IEvent{
	
	LinkedList<ShootingRound> rounds;
	
	ShootingResult(LinkedList<ShootingRound> rounds){
		this.rounds = rounds;
	}
	/**
	 * This method returns the totals of all of the targets that were hit for each round
	 * 
	 * @return total of numTargets per each round
	 */
	public double pointsEarned() {
		double acc = 0;
		if (rounds == null || rounds.isEmpty()) {
			return 0;
		}
		for (ShootingRound n : rounds) {
			acc += n.numTargets;
		}
		return acc;

	}
	
	/**
	 * This method returns the total of the points across all laps in the list
	 * @param form A boolean, true for standing and false for prone
	 * @return sum of every lap
	 */
	public ShootingRound bestRoundByType(Boolean form) {
		if(form) {
			ShootingRound best= rounds.getFirst();
			for (ShootingRound s : rounds) {
				if(s.numTargets> best.numTargets) {
					best = s;
				}
			}
			return best;
		}
		if(!form) {
			ShootingRound best= rounds.getFirst();
			for (ShootingRound s : rounds) {
				if(s.numTargets> best.numTargets) {
					best = s;
				}
			}
		return best;
		}
		else {
			return null;
		}
		
	}
	
}
