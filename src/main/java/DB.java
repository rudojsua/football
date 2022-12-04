import java.util.ArrayList;
import java.util.List;

public class DB {
    private List<Gaim> dataBase;

    protected DB() {
        this.dataBase = new ArrayList<>();
    }

    public List<Gaim> getDataBase() {
        return dataBase;
    }

    protected void addGame(Gaim gaim) {
        dataBase.add(gaim);
    }


}
