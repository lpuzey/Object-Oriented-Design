import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Examples {

	ShootingResult lowShot = new ShootingResult(new ShootingRound(1), new ShootingRound(3), new ShootingRound(0), new ShootingRound(2));
	ShootingResult medShot = new ShootingResult(new ShootingRound(3), new ShootingRound(3), new ShootingRound(3), new ShootingRound(3));
	ShootingResult highShot = new ShootingResult(new ShootingRound(5), new ShootingRound(5), new ShootingRound(4), new ShootingRound(5));
	
	SkiingResult firstSki = new SkiingResult(2.1,1,3,4,2.2, 3);
	SkiingResult secondSki = new SkiingResult(3.5, 2, 4, 4.5, 3, 2 );
	SkiingResult thirdSki = new SkiingResult(5.6, 3, 5,7, 8, 2 );
	SkiingResult fourthSki = new SkiingResult(10.8, 4, 7, 2, 5, 1);
	
	FinalResult BadResult = new FinalResult(lowShot,fourthSki);
	FinalResult OkayResult = new FinalResult(medShot, thirdSki);
	FinalResult OkayResult2 = new FinalResult(medShot, secondSki);
	FinalResult AwesomeResult = new FinalResult(highShot, firstSki);
	
	Athlete athl = new Athlete (BadResult);
	Athlete ath2 = new Athlete (OkayResult);
	Athlete ath3 = new Athlete (OkayResult2);
	Athlete ath4 = new Athlete (AwesomeResult);
	
	
	@Test
	public void lowPoints() {
		assertEquals(lowShot.pointsEarned(), 6, 0.1);
	}
	
	@Test
	public void highPoints() {
		assertEquals(highShot.pointsEarned(), 19, 0.1);
	}
	
	
	@Test
	public void firstPen() {
		assertEquals(BadResult.getShootingPenalties(lowShot), 840, 0.1);
	}
	
	@Test
	public void secondPen() {
		assertEquals(OkayResult.getShootingPenalties(medShot), 480, 0.1);
	}
	
	@Test
	public void firstPoints() {
		assertEquals(firstSki.pointsEarned(), 12.3, 0.1);
	}
	
	@Test
	public void secondPoints() {
		assertEquals(secondSki.pointsEarned(), 17, 0.1);
	}
	
	@Test
	public void thirdPoints() {
		assertEquals(thirdSki.pointsEarned(), 28.6, 0.1);
	}
	
	@Test
	public void fourthPoints() {
		assertEquals(fourthSki.pointsEarned(), 28.8, 0.1);
	}
	
	@Test
	public void badScore() {
		assertEquals(BadResult.finalScore(),858.8,0.1);
	}
	
	@Test
	public void okayScore() {
		assertEquals(OkayResult.finalScore(),501.6,0.1);
	}
	
	@Test
	public void okay2Score() {
		assertEquals(OkayResult2.finalScore(),490.0,0.1);
	}
	
	@Test
	public void awesomeScore() {
		assertEquals(AwesomeResult.finalScore(),69.3,0.1);
	}
	
	@Test
	public void betterAth23() {
		assertEquals(ath3.betterSkiier(ath2), ath3);
	}
	
	@Test
	public void betterAth34() {
		assertEquals(ath3.betterSkiier(ath4), ath4);
	}
	
	@Test
	public void beaten12() {
		assertFalse(ath2.hasBeaten(athl));
	}
	
	@Test
	public void beaten13() {
		assertTrue(athl.hasBeaten(ath4));
	}
	
	@Test
	public void beaten32() {
		assertFalse(ath3.hasBeaten(ath2));
	}
	
}