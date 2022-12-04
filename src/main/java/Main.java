import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static DB db = new DB();

    public static void main(String[] args) {

//        try {
//            Runtime.getRuntime().exec("cls");
//        } catch (IOException e) {
//            throw new RuntimeException("environment doesn't support CLS");
//        }
        System.out.println(" -----------");


        while (true) {
            System.out.println("To Start game please enter \"s\", to exit print \"e\", " +
                    "to show the account of all previous games \"p\"");
            String s = scanner.nextLine().trim();
            System.out.println(s);
            if (s.equals("s")) {
                System.out.println("Please provide title of team 1");
                String team1 = scanner.nextLine().trim();
                System.out.println("Please provide title of team 2");
                String team2 = scanner.nextLine().trim();
                play(team1, team2);
            }
            if (s.equals("e"))    //exits
                break;
            if (s.equals("p")) {   //print all games
                final int[] counterTeams = {0};
                db.getDataBase().forEach(t -> System.out.println(
                        ++counterTeams[0] +") "+ t.team1.title + " " + t.team1.score + " - " + t.team2.title + " " + t.team2.score));
            }
        }
    }


    private static void play(String nameOfTeam1, String nameOfTeam2) {
        Gaim gaim = new Gaim();

        gaim.startGame(nameOfTeam1, nameOfTeam2);
        System.out.println("enter the name of the team that scored the goal, press \"space\" and \"+\" to score a goal or \"-\" to subtract a goal.");
        System.out.println("To finish the match please press \"n\" to subtract a goal.");
        while (true) {
            String[] action = scanner.nextLine().trim().toLowerCase().split(" ");

            if (action[0].equals("n")) {        //new game
                db.addGame(gaim);
                gaim.finishGame();
                break;
            }

            while (true) {
                if (action[0].equals(nameOfTeam1)) {
                    gaim.updateScore(action[0], action[1]);
                    System.out.println(gaim.team1.getTitle() + "-" + gaim.team2.getTitle() +
                            ": " + gaim.team1.score + " - " + gaim.team2.score);
                    break;

                } else if (action[0].equals(nameOfTeam2)) {
                    gaim.updateScore(action[0], action[1]);
                    System.out.println(gaim.team1.getTitle() + "-" + gaim.team2.getTitle() +
                            ": " + gaim.team1.score + " - " + gaim.team2.score);
                    break;
                } else {
                    System.out.println("Wrong name of team");
                    break;
                }
            }
        }
    }
}
