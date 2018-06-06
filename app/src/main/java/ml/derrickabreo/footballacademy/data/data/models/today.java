package ml.derrickabreo.footballacademy.data.data.models;

public class today {

    private String Team1,Team2,Time;

    public today(){

    }

    public today(String Team1,String Team2,String Time) {
        this.Team1=Team1;
        this.Team2=Team2;
        this.Time=Time;
    }

    public String getTeam1() {
        return Team1;
    }

    public String getTeam2() {
        return Team2;
    }

    public String getTime() {
        return Time;
    }

    public void setTeam1(String Team1) {
        Team1 = Team1;
    }

    public void setTeam2(String Team2) {
        Team2 = Team2;
    }

    public void setTime(String Time) {
        Time = Time;
    }
}
