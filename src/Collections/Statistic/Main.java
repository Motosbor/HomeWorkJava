package Collections.Statistic;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class Main {


    public static void printTeam(LinkedList<Team> teams) {
        for (Team t : teams) {

            System.out.println("Name - " + t.getName() + " Country - " + t.getCountry() + " Season - " + t.getSeazon() + " Scores - " + t.getScores());

        }

    }

    public static void main(String[] args) {

        Team team = new Team("Eagle", "India", 3, 45);
        Team team1 = new Team("Lion", "France", 2, 34);
        Team team2 = new Team("Bulls", "USA", 1, 66);
        Team team3 = new Team("A", "D", 4, 3);
        Team team4 = new Team("B", "F", 6, 77);
        Team team5 = new Team("C", "G", 7, 111);

        LinkedList<Team> linkedList = new LinkedList<>();
        linkedList.add(team);
        linkedList.add(team1);
        linkedList.add(team2);
        linkedList.add(team3);
        linkedList.add(team4);
        linkedList.add(team5);

        printTeam(linkedList);

        System.out.println("--------------");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            int init = Integer.parseInt(reader.readLine());

            switch (init){
                case 0:
                    Collections.sort(linkedList);
                    break;
                case 1:
                    Collections.sort(linkedList,new TeamComparatorByCountry());
                case 2:
                    Collections.sort(linkedList,new TeamComparatorByScore());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        printTeam(linkedList);


    }
}
