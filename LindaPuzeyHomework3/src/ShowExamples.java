import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.LinkedList;
import java.util.Arrays;

/**
 * This class deals with ShowManager tests
 * @author Linda Puzey, Sarah Love
 */

public class ShowExamples 
{
	ShowManager1 sm1 = new ShowManager1();
	LinkedList<Show> shows = new LinkedList<Show>();
	ShowSummary report1 = new ShowSummary();
	
	public ShowExamples()
	{
		LinkedList<Episode> eps1 = new LinkedList<Episode>();
		eps1.add(new Episode("Best of Both Worlds", 88));
		eps1.add(new Episode("The Ultimate Computer", 49));
		eps1.add(new Episode("Trials and Tribble-ations", 43));		
		Show s1 = new Show("Star Trek", 1800, eps1);
		shows.add(s1);
		report1.primetime.add(s1);
		
		LinkedList<Episode> eps2 = new LinkedList<Episode>();
		eps2.add(new Episode("Fear of a Bot Planet", 23));
		eps2.add(new Episode("The Why of Fry", 21));
		eps2.add(new Episode("Roswell that Ends Well", 23));
		eps2.add(new Episode("Meanwhile", 22));
		Show s2 = new Show("Futurama", 1900, eps2);
		shows.add(s2);
		report1.primetime.add(s2);
		
		LinkedList<Episode> eps3 = new LinkedList<Episode>();
		eps3.add(new Episode("Yakko's World", 4));
		eps3.add(new Episode("Hello Nice Warners", 8));
		eps3.add(new Episode("Where Rodents Dare", 9));
		Show s3 = new Show("Animaniacs", 1630, eps3);
		shows.add(s3);
		report1.daytime.add(s3);
		
		LinkedList<Episode> eps4 = new LinkedList<Episode>();
		eps4.add(new Episode("The Letter W", 59));
		eps4.add(new Episode("The Letter P", 57));
		eps4.add(new Episode("The Letter I", 58));
		Show s4 = new Show("Sesame Street", 900, eps4);
		shows.add(s4);
		report1.daytime.add(s4);
	}
	
	  ShowManager1 smCartoon = new ShowManager1();

		LinkedList<Show> cartoons = new LinkedList<Show>();

		ShowSummary cartoonReport = new ShowSummary();
		
		
	
	@Before

	public void NewShowExamples()

	{

	LinkedList<Episode> mir = new LinkedList<Episode>();

	mir.add(new Episode("Stormy Weather", 22));
	mir.add(new Episode("Volpina", 11));
	mir.add(new Episode("The Collector", 11));
	mir.add(new Episode("Origins", 44));
	Show miraculous = new Show("Miraculous Ladybug", 1030, mir);

	cartoons.add(miraculous);

	cartoonReport.daytime.add(miraculous);

	LinkedList<Episode> lok = new LinkedList<Episode>();

	lok.add(new Episode("Air", 0));

	lok.add(new Episode("Balance", 0));

	lok.add(new Episode("Spirits", 0));

	Show korra = new Show("Legend of Korra", 2410, lok);

	cartoons.add(korra);

	LinkedList<Episode> ava = new LinkedList<Episode>();

	ava.add(new Episode("The Ember Island Players", 22));

	ava.add(new Episode("The Beach", 22));

	ava.add(new Episode("The Crossroads of Destiny", 22));

	ava.add(new Episode("The Blue Spirit", 22));

	ava.add(new Episode("Zuko Alone", 22));

	ava.add(new Episode("Avatar Day", 22));

	Show avatar = new Show("Avatar", 2000, ava);

	cartoons.add(avatar);

	cartoonReport.primetime.add(avatar);

	
	
	}
	
	@Test
	public void instructorTestOrganizeShows() 
	{
		ShowSummary report2 = sm1.organizeShows(shows);
		assertEquals(report1, report2);
	}
	
	
	
	@Test

	public void organizeCartoons()

	{

	ShowSummary cartoonReport2 = smCartoon.organizeShows(cartoons);

	assertEquals(cartoonReport, cartoonReport2);

	}
	
	@Test
	public void EmptyList() {
		ShowManager1 emptyshowManager = new ShowManager1();
		LinkedList<Show> emptyShow = new LinkedList<Show>();
		ShowSummary empty = new ShowSummary();
		ShowSummary help = emptyshowManager.organizeShows(emptyShow);
		  assertTrue(empty.equals(help));
		}


	
	
	/*
	 * cycle and check the time placement on each show, then add the
	 * show to daytime or prime-time lists respectively in MaxHzReport
	 */
}
