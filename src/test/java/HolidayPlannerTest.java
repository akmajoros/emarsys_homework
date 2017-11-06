import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class HolidayPlannerTest {

  @Test
  public void testWithOneDestinationNoRule() throws Exception {
    HolidayPlanner p = new HolidayPlanner();
    List<DestinationInput> d = new ArrayList<>();
    d.add(new DestinationInput("X", ""));
    List<String> test = new ArrayList<>();
    test.add("X");
    assertEquals(test, p.journeyPlanner(d));
  }

  @Test
  public void testWithMultipleDestinationNoRules() throws Exception {
    HolidayPlanner p = new HolidayPlanner();
    List<DestinationInput> d = new ArrayList<>();
    d.add(new DestinationInput("X", ""));
    d.add(new DestinationInput("Y", ""));
    d.add(new DestinationInput("Z", ""));
    List<String> test = new ArrayList<>();
    test.add("X");
    test.add("Y");
    test.add("Z");
    assertEquals(test, p.journeyPlanner(d));
  }

  @Test
  public void testWithMultipleDestinationsOneRule() throws Exception {
    HolidayPlanner p = new HolidayPlanner();
    List<DestinationInput> d = new ArrayList<>();
    d.add(new DestinationInput("X", ""));
    d.add(new DestinationInput("Y", "Z"));
    d.add(new DestinationInput("Z", ""));
    List<String> test = new ArrayList<>();
    test.add("X");
    test.add("Z");
    test.add("Y");
    assertEquals(test, p.journeyPlanner(d));
  }

  @Test
  public void testCaseSensitivity() throws Exception {
    HolidayPlanner p = new HolidayPlanner();
    List<DestinationInput> d = new ArrayList<>();
    d.add(new DestinationInput("X", ""));
    d.add(new DestinationInput("Y", "z"));
    d.add(new DestinationInput("Z", ""));
    List<String> test = new ArrayList<>();
    test.add("X");
    test.add("Z");
    test.add("Y");
    assertEquals(test, p.journeyPlanner(d));
  }

  @Test
  public void testWithMultipleDestinationsMultipleRules() throws Exception {
    HolidayPlanner p = new HolidayPlanner();
    List<DestinationInput> d = new ArrayList<>();
    d.add(new DestinationInput("U", ""));
    d.add(new DestinationInput("V", "W"));
    d.add(new DestinationInput("W", "Z"));
    d.add(new DestinationInput("X", "U"));
    d.add(new DestinationInput("Y", "V"));
    d.add(new DestinationInput("Z", ""));
    List<String> test = new ArrayList<>();
    test.add("U");
    test.add("X");
    test.add("Z");
    test.add("W");
    test.add("V");
    test.add("Y");
    assertEquals(test, p.journeyPlanner(d));
  }

  @Test
  public void testWithMultipleRepeatedRule() throws Exception {
    HolidayPlanner p = new HolidayPlanner();
    List<DestinationInput> d = new ArrayList<>();
    d.add(new DestinationInput("W", "X"));
    d.add(new DestinationInput("X", ""));
    d.add(new DestinationInput("Y", "W"));
    d.add(new DestinationInput("Z", "X"));
    List<String> test = new ArrayList<>();
    test.add("X");
    test.add("Z");
    test.add("W");
    test.add("Y");
    assertEquals(test, p.journeyPlanner(d));
  }

  @Test(expected = Exception.class)
  public void testWithNoInputGiven() throws Exception {
    HolidayPlanner p = new HolidayPlanner();
    List<DestinationInput> d = new ArrayList<>();
    p.journeyPlanner(d);
  }

  @Test(expected = Exception.class)
  public void testWithNoDestinationNoRule() throws Exception {
    HolidayPlanner p = new HolidayPlanner();
    List<DestinationInput> d = new ArrayList<>();
    d.add(new DestinationInput("", ""));
    p.journeyPlanner(d);
  }

  @Test
  public void testWithMixedDestinationNoRule() throws Exception {
    HolidayPlanner p = new HolidayPlanner();
    List<DestinationInput> d = new ArrayList<>();
    d.add(new DestinationInput("", ""));
    d.add(new DestinationInput("X", ""));
    d.add(new DestinationInput("Y", ""));
    List<String> test = new ArrayList<>();
    test.add("X");
    test.add("Y");
    assertEquals(test, p.journeyPlanner(d));
  }

  @Test
  public void testWithMixedDestinationOneRule() throws Exception {
    HolidayPlanner p = new HolidayPlanner();
    List<DestinationInput> d = new ArrayList<>();
    d.add(new DestinationInput("X", ""));
    d.add(new DestinationInput("", ""));
    d.add(new DestinationInput("Z", "Y"));
    d.add(new DestinationInput("Y", ""));
    List<String> test = new ArrayList<>();
    test.add("X");
    test.add("Y");
    test.add("Z");
    assertEquals(test, p.journeyPlanner(d));
  }

  @Test
  public void testWithMoreOfSameDestinationNoRule() throws Exception {
    HolidayPlanner p = new HolidayPlanner();
    List<DestinationInput> d = new ArrayList<>();
    d.add(new DestinationInput("X", ""));
    d.add(new DestinationInput("Y", "X"));
    d.add(new DestinationInput("X", ""));
    List<String> test = new ArrayList<>();
    test.add("X");
    test.add("Y");
    assertEquals(test, p.journeyPlanner(d));
  }
}