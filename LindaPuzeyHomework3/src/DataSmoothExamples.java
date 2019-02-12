import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.LinkedList;

/**
 * This class deals with datasmoothing tests
 * @author Linda Puzey, Sarah Love
 */

public class DataSmoothExamples 
{  
  LinkedList<Show> shows = new LinkedList<Show>();
  LinkedList<Double> showResults = new LinkedList<Double>();
  DataSmooth1 D1 = new DataSmooth1();
  
  public DataSmoothExamples() 
  {
		LinkedList<Episode> eps1 = new LinkedList<Episode>();
		eps1.add(new Episode("Best of Both Worlds", 88));
		eps1.add(new Episode("The Ultimate Computer", 49));
		eps1.add(new Episode("Trials and Tribble-ations", 43));		
		shows.add(new Show("Star Trek", 1800, eps1));
		
		LinkedList<Episode> eps2 = new LinkedList<Episode>();
		eps2.add(new Episode("Fear of a Bot Planet", 23));
		eps2.add(new Episode("The Why of Fry", 21));
		eps2.add(new Episode("Roswell that Ends Well", 23));
		eps2.add(new Episode("Meanwhile", 22));
		shows.add(new Show("Futurama", 1900, eps2));
		
		LinkedList<Episode> eps3 = new LinkedList<Episode>();
		eps3.add(new Episode("Yakko's World", 4));
		eps3.add(new Episode("Hello Nice Warners", 8));
		eps3.add(new Episode("Where Rodents Dare", 9));
		shows.add(new Show("Animaniacs", 1630, eps3));
		
		LinkedList<Episode> eps4 = new LinkedList<Episode>();
		eps4.add(new Episode("The Letter W", 59));
		eps4.add(new Episode("The Letter P", 57));
		eps4.add(new Episode("The Letter I", 58));
		shows.add(new Show("Sesame Street", 900, eps4));

	    showResults.add(60.0);
	    showResults.add(29.75);
	    showResults.add(29.08333);
	    showResults.add(58.0);
  }
  
  @Test
  public void instructorTestDS() 
  {
	  LinkedList<Double> runtimes = D1.dataSmooth(shows);
	  
	  for(int i = 0; i < runtimes.size(); i++)
	  {
		  assertEquals(runtimes.get(i), showResults.get(i), .01);
	  }
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


LinkedList<Double> scList = new LinkedList<Double>();

@Before
public void scBuild() {

	  scList.add(22.0);

	  scList.add((22.0+22.0)/3.0);

	  scList.add(22.0);
}

@Test 
public void smoothCartoon() {

LinkedList<Double> scSmooth = D1.dataSmooth(cartoons);

for(int i = 0; i < scSmooth.size(); i++) {
	  assertEquals(scSmooth.get(i), scList.get(i), .01);
	}

}

LinkedList<Show> emptyS = new LinkedList<Show>();
LinkedList<Double> emptyD = new LinkedList<Double>();
LinkedList<Double> emptySmooth = D1.dataSmooth(emptyS);

@Test
public void smoothEmpty() {
	  assertTrue(emptyD.equals(emptySmooth));
}

LinkedList<Show> oneShow = new LinkedList<Show>();
LinkedList<Episode> oneEpisode = new LinkedList<Episode>();
LinkedList<Double> oneAvg = new LinkedList<Double>();
LinkedList<Double> oneSmooth = D1.dataSmooth(oneShow);
public void constructOne() {
	  oneEpisode.add(new Episode("The Vanishing of Will Byers", 60));
	  oneShow.add(new Show("Stranger Things", 1400, oneEpisode));
	  oneAvg.add(60.0);
}

  
}

/* check for null and one-element list; loop through shows; find average of episode lengths; 
 * smooth values; add new values to list */