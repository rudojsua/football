import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class Team {
    @Getter
    @Setter
    String title;
    @Getter
    @Setter
    int score=0;

    public Team() {
    }

    public Team(String title, int score) {
        this.title = title;
        this.score = score;
    }
}
