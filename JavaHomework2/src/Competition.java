import java.util.LinkedList;

public class Competition {

	int numShootRounds;
	LinkedList<Athlete> athletes;

	Competition(int numShootRounds, LinkedList<Athlete> athletes) {
		this.numShootRounds = numShootRounds;
		this.athletes = athletes;
	}

	/**
	 * This method returns a linked list of the names of the Athletes in the competition 
	 * whose list of ShootingRounds is less than the number of rounds stored in the Competition class
	 * 
	 * @return produces a linkedList of athlete names
	 */
	public LinkedList<String> shootingDNF() {
		LinkedList<String> dnf = new LinkedList<String>();
		for (Athlete n : this.athletes) {
			if (n.overallScore.shoot.rounds.size() < this.numShootRounds) {
				dnf.add(n.name);
			}
		}
		return dnf;
	}

	/**
	 * This method returns a the final score that the athlete earned in the biathlon
	 * @param name a String of an Athlete you want to find
	 * @return produces a double of the score they earned
	 */
	public double finalScoreForAthlete(String name) {
		double score = 0.0;
		for (Athlete n : this.athletes) {
			if (name.equals(n.name)) {
				score = n.overallScore.ski.pointsEarned();
			}
		}
		return score;
	}
	
	/**
	 * This method returns a boolean if any of the athletes in "this" competition had a 
	 * better final score than they had in the given competition
	 * @param comp an Competition that you want to compare
	 * @return produces a boolean if the competitor has a better score
	 */
	public Boolean anyImprovement(Competition comp) {
		boolean improvement = false;
		for(Athlete n : this.athletes) {
			for(Athlete c : comp.athletes) {
				if(c.name == n.name) {
					if(c.overallScore.ski.pointsEarned() < n.overallScore.ski.pointsEarned()) {
						improvement = true;
					}
				}
			}
		}
		return improvement;
	}
}

/* We can see a helper method which could have been used. There could have been a find function. The find function
 would take a name and return the score of the athlete with that name. It would be called on a Competition object.
 This would have been useful for both functions. */

