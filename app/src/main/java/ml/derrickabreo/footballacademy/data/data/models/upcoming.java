package ml.derrickabreo.footballacademy.data.data.models;

public class upcoming {

    private String Team1, Team2, Date;

    upcoming() {

    }

    upcoming(String Team1, String Team2, String Date) {
        this.Team1 = Team1;
        this.Team2 = Team2;
        this.Date = Date;
    }

    public String getTeam1() {
        return Team1;
    }

    public String getTeam2() {
        return Team2;
    }

    public String getDate() {
        return Date;
    }

    public void setTeam1(String Team1) {
        this.Team1 = Team1;
    }

    public void setTeam2(String Team2) {
        this.Team2 = Team2;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
}
