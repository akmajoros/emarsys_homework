import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HolidayPlanner {

  List<String> journey = new ArrayList<>();

  public HolidayPlanner() {
  }

  public List<String> journeyPlanner(List<DestinationInput> listOfDestinations) throws Exception {
    while (listOfDestinations.size() > 0) {
      for (Iterator<DestinationInput> iterator = listOfDestinations.iterator();
          iterator.hasNext(); ) {
        DestinationInput destination = iterator.next();

        String upperCaseLocation = destination.location.toUpperCase();
        String upperCaseRule = destination.rule.toUpperCase();

        if (destination.location.equals("")) {
          iterator.remove();
        } else if(journey.contains(upperCaseLocation) && destination.rule.equals("")) {
          iterator.remove();
        } else if (!destination.location.equals("") && destination.rule.equals("")) {
          journey.add(upperCaseLocation);
          iterator.remove();
        } else if (!journey.contains(upperCaseLocation) && journey.contains(upperCaseRule)) {
          journey.add(upperCaseLocation);
          iterator.remove();
        } else if (journey.contains(upperCaseRule) && journey.contains(upperCaseLocation)) {
          if (journey.indexOf(upperCaseRule) > journey.indexOf(upperCaseLocation)) {
            journey.remove(upperCaseLocation);
            journey.add(upperCaseLocation);
            iterator.remove();
          } else {
            iterator.remove();
          }
        }
      }
    }
    if (journey.size() <= 0){
      throw new Exception("Journey can't be created with no locations given");
    } else {
      return journey;
    }
  }
}
