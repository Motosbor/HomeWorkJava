package Collections.Statistic;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {


    public static void printTeam(ArrayList<Team> teams) {
        for (Team t : teams) {

            System.out.println("Name - " + t.getName() + " Country - " + t.getCountry() + " Season - " + t.getSeazon() + " Scores - " + t.getScores());

        }

    }

    public static void main(String[] args) {

        Team team = new Team("Eagle", "India", 3, 45);
        Team team1 = new Team("Lion", "France", 2, 34);
        Team team2 = new Team("Bulls", "USA", 1, 66);
        Team team3 = new Team("Ara", "Austria", 4, 3);
        Team team4 = new Team("Bara", "Belgium", 6, 77);
        Team team5 = new Team("Cara", "Germany", 7, 111);
        Team team6 = new Team("Coro", "Java", 7, 111);

        ArrayList<Team> teamArrayList = new ArrayList<>();
        teamArrayList.add(team);
        teamArrayList.add(team1);
        teamArrayList.add(team2);
        teamArrayList.add(team3);
        teamArrayList.add(team4);
        teamArrayList.add(team5);

        System.out.println(team5.equals(team6));

        printTeam(teamArrayList);

        System.out.println("--------------");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            int init = Integer.parseInt(reader.readLine());

            switch (init){
                case 0:
                    Collections.sort(teamArrayList);
                    break;
                case 1:
                    Collections.sort(teamArrayList,new TeamComparatorByCountry());
                    break;
                case 2:
                    Collections.sort(teamArrayList,new TeamComparatorByScore());
                    break;
            }
            printTeam(teamArrayList);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
