package Collections.Statistic;

import java.util.Comparator;

public class TeamComparatorByCountry implements Comparator<Team> {
    @Override
    public int compare(Team o1, Team o2) {
        return (o1.getCountry().compareTo(o2.getCountry()));
    }
}
