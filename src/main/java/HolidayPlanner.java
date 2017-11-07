import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HolidayPlanner {

  List<String> optimalJourneyPlan = new ArrayList<>();

  public HolidayPlanner() {
  }

  public List<String> journeyPlanner(List<DestinationInput> listOfDestinations) throws Exception {
    while (listOfDestinations.size() > 0) {
      for (Iterator<DestinationInput> iterator = listOfDestinations.iterator();
          iterator.hasNext(); ) {

        DestinationInput destinationInput = iterator.next();
        String upperCaseLocation = destinationInput.location.toUpperCase();
        String upperCaseRule = destinationInput.rule.toUpperCase();

        if (destinationInput.location.equals("")) {
          iterator.remove();
        } else if(optimalJourneyPlan.contains(upperCaseLocation) && destinationInput.rule.equals("")) {
          iterator.remove();
        } else if (!destinationInput.location.equals("") && destinationInput.rule.equals("")) {
          optimalJourneyPlan.add(upperCaseLocation);
          iterator.remove();
        } else if (!optimalJourneyPlan.contains(upperCaseLocation) && optimalJourneyPlan.contains(upperCaseRule)) {
          optimalJourneyPlan.add(upperCaseLocation);
          iterator.remove();
        } else if (optimalJourneyPlan.contains(upperCaseRule) && optimalJourneyPlan.contains(upperCaseLocation)) {
          if (optimalJourneyPlan.indexOf(upperCaseRule) > optimalJourneyPlan.indexOf(upperCaseLocation)) {
            optimalJourneyPlan.remove(upperCaseLocation);
            optimalJourneyPlan.add(upperCaseLocation);
            iterator.remove();
          } else {
            iterator.remove();
          }
        }
      }
    }

    if (optimalJourneyPlan.size() <= 0){
      throw new Exception("Journey can't be created with no locations given");
    } else {
      return optimalJourneyPlan;
    }
  }
}
