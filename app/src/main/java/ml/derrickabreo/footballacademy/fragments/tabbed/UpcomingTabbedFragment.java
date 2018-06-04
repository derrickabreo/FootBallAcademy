package ml.derrickabreo.footballacademy.fragments.tabbed;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import ml.derrickabreo.footballacademy.R;
import ml.derrickabreo.footballacademy.adapters.tabbedAdapters.TodayViewHolder;
import ml.derrickabreo.footballacademy.adapters.tabbedAdapters.UpcomingViewHolder;
import ml.derrickabreo.footballacademy.data.data.models.today;
import ml.derrickabreo.footballacademy.data.data.models.upcoming;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingTabbedFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private FirebaseFirestore mFirestore;
    private LinearLayoutManager mLinearLayoutManager;
    private FirestoreRecyclerAdapter mAdapter;
    private Context mContext;

    public UpcomingTabbedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_upcomming_tabbed, container, false);
        mContext = view.getContext();
        mRecyclerView = view.findViewById(R.id.upcoming_tabbed_recyclerview);
        init();
        getPlayerList();
        return view;
    }

    private void init() {
        mLinearLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mFirestore = FirebaseFirestore.getInstance();
    }

    private void getPlayerList() {

        Query query = mFirestore.collection("Upcoming");
        FirestoreRecyclerOptions<upcoming> response = new FirestoreRecyclerOptions.Builder<upcoming>()
                .setQuery(query,upcoming.class)
                .build();
        mAdapter = new FirestoreRecyclerAdapter<upcoming, UpcomingViewHolder>(response) {

            @NonNull
            @Override
            public UpcomingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_fragment_recyclerview,parent,false);
                return new UpcomingViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull UpcomingViewHolder holder, int position, @NonNull final upcoming model) {
                holder.Team1.setText(model.getTeam1());
                holder.Team2.setText(model.getTeam2());
                holder.Time.setText(getString(R.string.catch_the_game, model.getDate()));

            }
        };
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onStop() {
        super.onStop();
        mAdapter.stopListening();
    }

    @Override
    public void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

}
