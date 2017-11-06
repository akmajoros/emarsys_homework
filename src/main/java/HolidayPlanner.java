import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HolidayPlanner {

  List<String> optimalJourneyPlan = new ArrayList<>();

  public HolidayPlanner() {
  }

  public List<String> journeyPlanner(List<DestinationInput> listOfDestinations) {
    for (Iterator<DestinationInput> iterator = listOfDestinations.iterator(); iterator.hasNext();) {
      DestinationInput destinationInput = iterator.next();
      if (destinationInput.rule.equals("")) {
        optimalJourneyPlan.add(destinationInput.location);
      }
    }
    return optimalJourneyPlan;
  }
}
