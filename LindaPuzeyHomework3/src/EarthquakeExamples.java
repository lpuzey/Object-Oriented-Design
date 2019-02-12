import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.LinkedList;

/**
 * This class deals with testing the Earthquake classes and methods
 * @author Linda Puzey, Sarah Love
 */

public class EarthquakeExamples {
  Earthquake1 E1 = new Earthquake1();
  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>();  
  LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
  
  public EarthquakeExamples() {
    threeDates.add(20151013.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(20151020.0);
    threeDates.add(40.0);
    threeDates.add(50.0);
    threeDates.add(45.0);
    threeDates.add(20151101.0);
    threeDates.add(6.0);
    NovReports.add(new MaxHzReport(20151101.0,6.0));
  }

  @Test
  public void instructorTestEQ() { 
    assertEquals(NovReports, 
                 E1.dailyMaxForMonth(threeDates, 11));
  }
  
  LinkedList<Double> set1 = new LinkedList<Double>();
  LinkedList<Double> set2 = new LinkedList<Double>();
  LinkedList<MaxHzReport> mar1 = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> apr1 = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> jun1 = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> nov1 = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> dec1 = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> jan2 = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> feb2 = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> mar2 = new LinkedList<MaxHzReport>();
  
  @Before 
  public void createLists() {
  //set1 data
  set1.add(20180309.0);
  set1.add(5.5);
  set1.add(20180619.0);
  set1.add(0.0);
  set1.add(0.0);
  set1.add(20181114.0);
  set1.add(65.0);
  set1.add(100.0);
  set1.add(0.0);
  set1.add(20181118.0);
  set1.add(0.0);
  set1.add(29.0);
  set1.add(24.3);
  set1.add(20181224.0);
  set1.add(1.0);
  set1.add(2.0);
  set1.add(1.5);
  set1.add(0.5);
  set1.add(20181225.0);
  set1.add(12.0);
  //set2 data
  set2.add(20010101.0);
  set2.add(6.1);
  set2.add(5.2);
  set2.add(4.3);
  set2.add(3.4);
  set2.add(20010202.0);
  set2.add(14.2);
  set2.add(0.0);
  set2.add(50.0);
  set2.add(20010203.0);
  set2.add(1.1);
  set2.add(3.3);
  set2.add(2.2);
  set2.add(20010204.0);
  set2.add(7.8);
  set2.add(77.8);
  //mar1 data
  mar1.add(new MaxHzReport(20180309.0,5.5));
  //apr1 is empty
  //jun1 data
  jun1.add(new MaxHzReport(20180619.0,0.0));
  //nov1 data
  nov1.add(new MaxHzReport(20181114.0,100.0));
  nov1.add(new MaxHzReport(20181118.0,29.0));
  //dec1 data
  dec1.add(new MaxHzReport(20181224.0,2.0));
  dec1.add(new MaxHzReport(20181225.0,12.0));
  //jan2 data
  jan2.add(new MaxHzReport(20010101.0,6.1));
  //feb2 data
  feb2.add(new MaxHzReport(20010202.0,50.0));
  feb2.add(new MaxHzReport(20010203.0,3.3));
  feb2.add(new MaxHzReport(20010204.0,77.8));
  //mar2 is empty
  }

  @Test
  public void quakeMar1() {
  assertEquals(mar1, E1.dailyMaxForMonth(set1, 03));
  }
   
  @Test
  public void quakeApr1() {
  assertEquals(apr1, E1.dailyMaxForMonth(set1, 04));
  }
   
  @Test
  public void quakeJun1() {
  assertEquals(jun1, E1.dailyMaxForMonth(set1, 06));
  }
   
  @Test
  public void quakeNov1() {
  assertEquals(nov1, E1.dailyMaxForMonth(set1, 11));
  }
   
  @Test
  public void quakeDec1() {
  assertEquals(dec1, E1.dailyMaxForMonth(set1, 12));
  }
   
  @Test
  public void quakeJan2() {
  assertEquals(jan2, E1.dailyMaxForMonth(set2, 01));
  }
   
  @Test
  public void quakeFeb2() {
  assertEquals(feb2, E1.dailyMaxForMonth(set2, 02));
  }
   
  @Test
  public void quakeMar2() {
  assertEquals(mar2, E1.dailyMaxForMonth(set2, 03));
  }
   
  LinkedList<MaxHzReport> noReport = new LinkedList<MaxHzReport>();
   
  @Test
  public void emptySet() {
  assertEquals(noReport, E1.dailyMaxForMonth(noData, 5));
  }

}
/* see if the date is the inputed month, then find all the readings for that day, 
 * determine the max reading for the that day, create a MaxHzReport,
 * put into a list */
