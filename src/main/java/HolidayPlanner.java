import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HolidayPlanner {

  List<String> optimalJourneyPlan = new ArrayList<>();

  public HolidayPlanner() {
  }

  public List<String> journeyPlanner(List<DestinationInput> listOfDestinations) {
    while (listOfDestinations.size() > 0) {
      for (Iterator<DestinationInput> iterator = listOfDestinations.iterator();
          iterator.hasNext(); ) {

        DestinationInput destinationInput = iterator.next();
        String upperCaseLocation = destinationInput.location.toUpperCase();
        String upperCaseRule = destinationInput.rule.toUpperCase();

        if (destinationInput.rule.equals("")) {
          optimalJourneyPlan.add(upperCaseLocation);
          iterator.remove();
        }

        if (optimalJourneyPlan.contains(upperCaseRule)) {
          optimalJourneyPlan.add(upperCaseLocation);
          iterator.remove();
        }
      }
    }
      return optimalJourneyPlan;
  }
}
