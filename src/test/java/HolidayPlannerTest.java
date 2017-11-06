import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class HolidayPlannerTest {

  @Test
  public void testWithOneDestinationNoRule() {
    HolidayPlanner p = new HolidayPlanner();
    List<DestinationInput> d = new ArrayList<>();
    d.add(new DestinationInput("X", ""));
    List<String> test = new ArrayList<>();
    test.add("X");
    assertEquals(test, p.journeyPlanner(d));
  }

  @Test
  public void testWithMultipleDestinationNoRules() {
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
}