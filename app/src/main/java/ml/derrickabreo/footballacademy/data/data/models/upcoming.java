package ml.derrickabreo.footballacademy.data.data.models;

public class upcoming {

    private String mTeam1, mTeam2, mDate;

    upcoming() {

    }

    upcoming(String Team1, String Team2, String Date) {
        this.mTeam1 = Team1;
        this.mTeam2 = Team2;
        this.mDate = Date;
    }

    public String getTeam1() {
        return mTeam1;
    }

    public String getTeam2() {
        return mTeam2;
    }

    public String getDate() {
        return mDate;
    }

    public void setTeam1(String Team1) {
        this.mTeam1 = Team1;
    }

    public void setTeam2(String Team2) {
        this.mTeam2 = Team2;
    }

    public void setDate(String Date) {
        this.mDate = Date;
    }
}
