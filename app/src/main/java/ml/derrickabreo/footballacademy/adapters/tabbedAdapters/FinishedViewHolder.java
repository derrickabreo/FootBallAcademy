package ml.derrickabreo.footballacademy.adapters.tabbedAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ml.derrickabreo.footballacademy.R;

public class FinishedViewHolder extends RecyclerView.ViewHolder {

    public TextView mTeam1;
    public TextView mTeam2;
    public TextView mDate;
    public TextView mTeamGoal1;
    public TextView mTeamGoal2;


    public FinishedViewHolder(View itemView) {
        super(itemView);

        mTeam1 = itemView.findViewById(R.id.finished_fragment_team1_tv);
        mTeam2 = itemView.findViewById(R.id.finished_fragment_team2_tv);
        mDate = itemView.findViewById(R.id.finished_fragment_date_tv);
        mTeamGoal1 = itemView.findViewById(R.id.finished_fragment_goals1_tv);
        mTeamGoal2 = itemView.findViewById(R.id.finished_fragment_goals2_tv);
    }
}
