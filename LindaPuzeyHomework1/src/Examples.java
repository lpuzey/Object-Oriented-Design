import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import org.junit.Before;

public class Examples {
	ShootingRound zero = new ShootingRound(0,true);
	ShootingRound one = new ShootingRound(1,true);
	ShootingRound two = new ShootingRound(2,true);
	ShootingRound three = new ShootingRound(3,false);
	ShootingRound four = new ShootingRound(4,false);
	ShootingRound five = new ShootingRound(5,false);
	
	LinkedList<ShootingRound> lowList = new LinkedList<ShootingRound>();
	LinkedList<ShootingRound> medList = new LinkedList<ShootingRound>();
	LinkedList<ShootingRound> highList = new LinkedList<ShootingRound>();
	LinkedList<ShootingRound> firstList = new LinkedList<ShootingRound>();
	LinkedList<ShootingRound> thirdList = new LinkedList<ShootingRound>();
	LinkedList<ShootingRound> fourthList = new LinkedList<ShootingRound>();
	LinkedList<ShootingRound> zeroList = new LinkedList<ShootingRound>();
	LinkedList<ShootingRound> tylerList = new LinkedList<ShootingRound>();
	
	LinkedList<String> stringList = new LinkedList<String>();
	LinkedList<String> emptyStringList = new LinkedList<String>();
	
	LinkedList<Athlete> epicList = new LinkedList<Athlete>();
	LinkedList<Athlete> epic2List = new LinkedList<Athlete>();
	LinkedList<Athlete> epic4List = new LinkedList<Athlete>();
	LinkedList<Athlete> epic5List = new LinkedList<Athlete>();
	LinkedList<Athlete> betterList1 = new LinkedList<Athlete>();
	LinkedList<Athlete> betterList2 = new LinkedList<Athlete>();
	LinkedList<Athlete> worseList = new LinkedList<Athlete>();

	ShootingResult lowShot = new ShootingResult(lowList);
	ShootingResult medShot = new ShootingResult(medList);
	ShootingResult highShot = new ShootingResult(highList);
	ShootingResult zeroShot = new ShootingResult(zeroList);
	
	SkiingResult firstSki = new SkiingResult(3, 1, 3, 4, 5, 1);
	SkiingResult secondSki = new SkiingResult(1, 3.1, 2.3, 1.4, 5, 1);
	SkiingResult thirdSki = new SkiingResult(5, 4.1, 3.3, 4.4, 1.5, 1);
	SkiingResult thirdSki2 = new SkiingResult(3, 1.1, 3.1, 4.2, 5.3, 1);
	SkiingResult thirdSki3 = new SkiingResult(6, 1, 3, 4, 5, 1);
	SkiingResult fourthSki = new SkiingResult(1, 1.2, 4.3, 4.4, 5, 1);
	SkiingResult OkayResult = new SkiingResult(5,5,5,5,5,1);
	SkiingResult BadResult = new SkiingResult(0,0,0,0,0,1);	
	
	FinalResult F1 = new FinalResult(lowShot,fourthSki);
	FinalResult F2 = new FinalResult(medShot, thirdSki);
	FinalResult F3 = new FinalResult(medShot, secondSki);
	FinalResult F4 = new FinalResult(highShot, firstSki);
	
	
	Athlete athl = new Athlete (F1, "Andrew");
	Athlete ath2 = new Athlete (F1, "Erica");
	Athlete ath3 = new Athlete (F1, "Lewis");
	Athlete ath4 = new Athlete (F2, "Rachel");
	Athlete tyler = new Athlete (F2, "Tyler");
	Athlete sarah = new Athlete (F3, "Sarah");
	Athlete tyler2 = new Athlete (F3, "Tyler");
	Athlete tyler3 = new Athlete (F4, "Tyler");
	Athlete sarah2 = new Athlete (F4, "Sarah");
	Athlete ath32 = new Athlete (F4, "Lewis");
	Athlete ath33 = new Athlete (F3, "Lewis");
	
	MassStartResult mass1 = new MassStartResult (2, 1, 3, 4, 5, 1, 2);
	MassStartResult mass2 = new MassStartResult (1, 4, 4, 5, 3, 3, 2);
	
	Competition epicBattle4 = new Competition(4, epicList);
	Competition epicBattle5 = new Competition(5, epicList);
	Competition epicBattle2 = new Competition(2, epicList);
	Competition betterBattle1 = new Competition(4, betterList1);
	Competition betterBattle2 = new Competition(3, betterList2);
	Competition worseBattle = new Competition(4, worseList);
	
	
	@Before
	public void setUp() {
		lowList.add(one);
		lowList.add(three);
		lowList.add(zero);
		lowList.add(two);
		medList.add(new ShootingRound(3,true));
		medList.add(new ShootingRound(3,true));
		medList.add(new ShootingRound(3,true));
		medList.add(new ShootingRound(3,true));
		highList.add(five);
		highList.add(new ShootingRound(5,false));
		highList.add(new ShootingRound(4,false));
		highList.add(new ShootingRound(5,false));
		firstList.add(new ShootingRound(2,false));
		firstList.add(new ShootingRound(3,false));
		firstList.add(new ShootingRound(4,false));
		firstList.add(new ShootingRound(5,false));
		thirdList.add(zero);
		thirdList.add(zero);
		thirdList.add(zero);
		thirdList.add(one);
		fourthList.add(five);
		fourthList.add(new ShootingRound(4,true));
		fourthList.add(new ShootingRound(3,true));
		fourthList.add(new ShootingRound(2,true));
		zeroList.addFirst(zero);
		zeroList.addFirst(zero);
		zeroList.addFirst(zero);
		zeroList.addFirst(zero);
		zeroList.addFirst(zero);
		stringList.add("Erica");
		stringList.add("Lewis");
		stringList.add("Rachel");
		stringList.add("Tyler");
		stringList.add("Sarah");
		tylerList.add(two);
		tylerList.add(zero);
		tylerList.add(one);
		epicList.add(ath2);
		epicList.add(ath3);
		epicList.add(ath4);
		epicList.add(tyler);
		epicList.add(sarah);
		epic4List.add(tyler);
		epic5List.add(ath2);
		epic5List.add(ath3);
		epic5List.add(ath4);
		epic5List.add(tyler);
		//two athletes have better scores
		betterList1.add(ath2);
		betterList1.add(ath32);
		betterList1.add(ath4);
		betterList1.add(tyler2);
		betterList1.add(sarah);
		//one athlete has better score and two have worse scores
		betterList2.add(ath4);
		betterList2.add(sarah2);
		betterList2.add(tyler3);
		betterList2.add(ath32);
		betterList2.add(ath2);
		//three athletes have worse scores
		worseList.add(sarah2);
		worseList.add(ath2);
		worseList.add(ath33);
		worseList.add(ath4);
		worseList.add(tyler3);
	}

	@Test
	public void secondPen() {
		assertEquals(OkayResult.pointsEarned(), 21, 0.1);
	}
	
	@Test
	public void firstPoints() {
		assertEquals(BadResult.pointsEarned(), 1, 0.1);
	}
	
	@Test
	public void lowPoints() {
		assertEquals(lowShot.pointsEarned(), 6, 0.1);
	}
	
	@Test
	public void highPoints() {
		assertEquals(highShot.pointsEarned(), 19, 0.1);
	}
	
	@Test
	public void secondPoints() {
		assertEquals(secondSki.pointsEarned(), 12.8, 0.1);
	}
	
	@Test
	public void thirdPoints() {
		assertEquals(thirdSki.pointsEarned(), 14.3, 0.1);
	}
	
	@Test
	public void fourthPoints() {
		assertEquals(fourthSki.pointsEarned(), 15.9, 0.1);
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
		assertFalse(athl.hasBeaten(ath2));
	}
	
	@Test
	public void beaten34() {
		assertTrue(ath3.hasBeaten(ath4));
	}
	
	@Test
	public void beaten32() {
		assertFalse(ath2.hasBeaten(ath3));
	}
	
	@Test
	public void massPoints1() {
		assertEquals(mass1.pointsEarned(), 15, .1);
	}
	
	@Test
	public void massPoints2() {
		assertEquals(mass2.pointsEarned(), 17, .1);
	}
	
	@Test
	public void dnf4() {
		assertEquals(epicBattle4.shootingDNF(), emptyStringList);
	}
	
	@Test
	public void dnf5() {
		assertEquals(epicBattle5.shootingDNF(), stringList);
	}
	
	@Test
	public void dnf2() {
		assertEquals(epicBattle2.shootingDNF(), epic2List);
	}
	
	@Test
	public void noImprovement() {
		assertFalse(epicBattle4.anyImprovement(epicBattle5));
	}
	
	@Test
	public void improvement1() {
		assertTrue(epicBattle4.anyImprovement(betterBattle1));
	}
	
	@Test
	public void improvement2() {
		assertTrue(epicBattle4.anyImprovement(betterBattle2));
	}
	
	@Test
	public void worseImprovement() {
		assertTrue(epicBattle4.anyImprovement(worseBattle));
	}
	
	@Test
	public void improvement3() {
		assertFalse(worseBattle.anyImprovement(betterBattle2));
	}
	
	@Test
	public void improvement4() {
		assertTrue(betterBattle2.anyImprovement(betterBattle1));
	}
}
