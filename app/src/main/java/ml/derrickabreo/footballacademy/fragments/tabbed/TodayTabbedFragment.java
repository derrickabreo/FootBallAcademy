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
import ml.derrickabreo.footballacademy.data.data.models.today;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodayTabbedFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private FirebaseFirestore mFirestore;
    private LinearLayoutManager mLinearLayoutManager;
    private FirestoreRecyclerAdapter mAdapter;
    private Context mContext;

    public TodayTabbedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_today_tabbed, container, false);
        mContext = view.getContext();
        mRecyclerView = view.findViewById(R.id.today_tabbed_recyclerview);
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

    private void getPlayerList(){

        Query query = mFirestore.collection("Today");
        FirestoreRecyclerOptions<today> response = new FirestoreRecyclerOptions.Builder<today>()
                .setQuery(query,today.class)
                .build();
        mAdapter = new FirestoreRecyclerAdapter<today, TodayViewHolder>(response) {

            @NonNull
            @Override
            public TodayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.today_fragment_recyclerview,parent,false);
                return new TodayViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull TodayViewHolder holder, int position, @NonNull final today model) {
                holder.Team1.setText(model.getTeam1());
                holder.Team2.setText(model.getTeam2());
                holder.Time.setText(getString(R.string.catch_the_game, model.getTime()));

            }
        };
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

}
