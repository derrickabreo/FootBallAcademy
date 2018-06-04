package ml.derrickabreo.footballacademy.data.data.models;

public class finished {
    private String mTeam1, mTeam2, mTeam1Goal,mTeam2Goal, mDate;

    public  finished(){

    }


   public finished(String Team1, String Team2, String Team1goal, String Team2goal, String winnner, String date){
        this.mTeam1 = Team1;
        this.mTeam2 = Team2;
        this.mTeam1Goal = Team1goal;
        this.mTeam2Goal = Team2goal;
        this.mDate = date;
    }

    public String getTeam1() {
        return mTeam1;
    }

    public String getTeam2() {
        return mTeam2;
    }

    public String getTeam1Goal() {
        return mTeam1Goal;
    }

    public String getTeam2Goal() {
        return mTeam2Goal;
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

    public void setTeam1Goal(String Team1Goal) {
        this.mTeam1Goal = Team1Goal;
    }

    public void setTeam2Goal(String Team2Goal) {
        this.mTeam2Goal = Team2Goal;
    }

    public void setDate(String Date) {
        this.mDate = Date;
    }
}
