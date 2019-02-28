package Collections.Statistic;

import java.util.Comparator;

public class TeamComparatorByScore implements Comparator<Team> {

    @Override
    public int compare(Team o1, Team o2) {
       if(o1.getScores() == o2.getScores()) return 0;
       if(o1.getScores() > o2.getScores()) return 1;
       else return -1;
    }
}
