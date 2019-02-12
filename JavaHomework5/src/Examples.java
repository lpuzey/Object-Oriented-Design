import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class Examples {

	GregorianCalendar byebyewill = new GregorianCalendar(1983, 10, 6);
	
	GregorianCalendar mileven = new GregorianCalendar(1983, 10, 8);
	
	GregorianCalendar boisteve = new GregorianCalendar(1983, 10, 12);
	
	GregorianCalendar idiotnancy = new GregorianCalendar(1983, 10, 11);
	
	GregorianCalendar slug = new GregorianCalendar(1983, 11, 11);
	
	GregorianCalendar steveisagem = new GregorianCalendar(1966, 7, 7);
	
	GregorianCalendar future = new GregorianCalendar(1955, 10, 6);
	
	
	Time tim1 = new Time(1, 2);
	Time tim2 = new Time(2, 3);
	Time tim3 = new Time(3, 4);
	Time tim4 = new Time(12, 0);
	Time tim11 = new Time(14,2);
	Time tim8 = new Time(8, 9);
	Time tim9 = new Time(10, 11);
	
	Reading eleven = new Reading(tim1, 11,5);
	Reading sevenEleven = new Reading(tim2, 7,6);
	Reading elevensies = new Reading(tim3, 0,7);
	Reading eleventyOne = new Reading(tim4, 100,8);
	Reading elevenSevenElevens = new Reading(tim11, 19,9);
	Reading eleventhHour = new Reading(tim8, 14,10);
	Reading elevensPower = new Reading(tim9, 22,11);
	
	LinkedList<Reading> thesselhydra = new LinkedList<Reading>();
	LinkedList<Reading> upsideDown = new LinkedList<Reading>();
	LinkedList<Reading> hawkinsLab = new LinkedList<Reading>();
	LinkedList<Reading> indiana = new LinkedList<Reading>();
	LinkedList<Reading> castleByers = new LinkedList<Reading>();
	
	
	LinkedList<Double> Yeeehaw = new LinkedList<Double>(); //temp
	LinkedList<Double> DoubleDate = new LinkedList<Double>(); //RF
	LinkedList<Double> WhyMe = new LinkedList<Double>(); //temp
	LinkedList<Double> addjoname = new LinkedList<Double>(); //RF

	IReport justiceForBarb = new DailyWeatherReport(idiotnancy, Yeeehaw, DoubleDate);
	
	IReport idiotSteve = new DailyWeatherReport(boisteve, WhyMe, addjoname);
	
	WeatherMonitor demogorgon = new WeatherMonitor(justiceForBarb);
	WeatherMonitor enoughofthis = new WeatherMonitor(idiotSteve);
	
	@Before
	public void upsideDown() {
		Yeeehaw.add(2.0);
		Yeeehaw.add(6.0);
		Yeeehaw.add(8.0);
		addjoname.add(2.0);
		addjoname.add(8.0);
		DoubleDate.add(8.0);
		DoubleDate.add(16.0);
		WhyMe.add(2.0);
		WhyMe.add(4.0);
		
		thesselhydra.add(eleven);
		thesselhydra.add(sevenEleven);
		thesselhydra.add(elevensies);
		thesselhydra.add(eleventyOne);
		thesselhydra.add(elevenSevenElevens);
		thesselhydra.add(elevensPower);
		upsideDown.add(sevenEleven);
		upsideDown.add(elevenSevenElevens);
		hawkinsLab.add(eleven);
		hawkinsLab.add(eleventhHour);
		hawkinsLab.add(elevensPower);
		indiana.add(eleventyOne);
		demogorgon.addDailyReport(boisteve, thesselhydra);
		demogorgon.addDailyReport(byebyewill, castleByers);
		demogorgon.addDailyReport(mileven, upsideDown);
		demogorgon.addDailyReport(slug, indiana);
		demogorgon.addDailyReport(steveisagem, thesselhydra);
		demogorgon.addDailyReport(future, hawkinsLab);
		demogorgon.addDailyReport(idiotnancy, indiana);
	}
	
	// high temperature - multiple values
	@Test
	public void stevesBat() {
		assertEquals(demogorgon.averageTempForMonth(10, 1983), 31.66, 0.1) ;
	}
	
	// low temperature - same year, different month - one value
	@Test
	public void steveIsMine() {
		assertEquals(demogorgon.averageTempForMonth(11, 1983), 100.0, 0.1);
	}
	
	
	// low temperature - same month, different year - two values
	@Test
	public void soccerMomSteve() {
		assertEquals(demogorgon.averageTempForMonth(10, 1955), 15.66, 0.1);
	}
	
	@Test
	public void soccer() {
		assertEquals(demogorgon.totalRainfallForMonth(10, 1955), 26, 0.1);
	}
	
	@Test
	public void soccer2() {
		assertEquals(demogorgon.totalRainfallForMonth(10, 1983), 69, 0.1);
	}
	
	@Test
	public void soccer3() {
		assertEquals(demogorgon.totalRainfallForMonth(11, 1983), 8, 0.1);
	}
	
	
	
}
