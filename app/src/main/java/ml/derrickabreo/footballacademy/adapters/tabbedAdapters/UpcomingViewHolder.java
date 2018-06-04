package ml.derrickabreo.footballacademy.adapters.tabbedAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ml.derrickabreo.footballacademy.R;

public class UpcomingViewHolder extends RecyclerView.ViewHolder {

    public TextView Team1;
    public TextView Team2;
    public TextView Time;

    public UpcomingViewHolder(View itemView) {
        super(itemView);

        Team1 = itemView.findViewById(R.id.upcoming_fragment_team1_tv);
        Team2 = itemView.findViewById(R.id.upcoming_fragment_team2_tv);
        Time = itemView.findViewById(R.id.upcoming_fragment_date_tv);
    }


}
