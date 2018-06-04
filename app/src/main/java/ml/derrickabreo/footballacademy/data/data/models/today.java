package ml.derrickabreo.footballacademy.data.data.models;

public class today {

    private String mTeam1,mTeam2,mTime;

    public today(){

    }

    public today(String Team1,String Team2,String Time) {
        this.mTeam1=Team1;
        this.mTeam2=Team2;
        this.mTime=Time;
    }

    public String getTeam1() {
        return mTeam1;
    }

    public String getTeam2() {
        return mTeam2;
    }

    public String getTime() {
        return mTime;
    }

    public void setTeam1(String team1) {
        mTeam1 = team1;
    }

    public void setTeam2(String team2) {
        mTeam2 = team2;
    }

    public void setTime(String time) {
        mTime = time;
    }
}
