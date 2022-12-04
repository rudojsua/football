public class Gaim {
    Team team1;
    Team team2;

    public Gaim() {
    }

    public Gaim(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    void startGame(String t1, String t2) {
        team1 = Team.builder().title(t1).build();
        team2 = Team.builder().title(t2).build();
        System.out.println(team1.getTitle() + "-" + team2.getTitle() + ": " + team1.score + " - " + team2.score);
    }

    void updateScore(String titleTeam, String addOrMin) {
        if (titleTeam.equals(team1.getTitle())) {
            if (addOrMin.trim().equals("+"))
                team1.setScore(team1.getScore() + 1);
            if (addOrMin.trim().equals("-") && team1.getScore() > 0)
                team1.setScore(team1.getScore() - 1);
        }
        if (titleTeam.equals(team2.getTitle())) {
            if (addOrMin.trim().equals("+"))
                team2.setScore(team2.getScore() + 1);
            if (addOrMin.trim().equals("-") && team2.getScore() > 0)
                team2.setScore(team2.getScore() - 1);
        }
    }

    void finishGame() {
        System.out.println(" The game is over");
        System.out.println(team1.getTitle() + "-" + team2.getTitle() + ": " + team1.score + " - " + team2.score);
    }
}