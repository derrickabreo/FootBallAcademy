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
import ml.derrickabreo.footballacademy.adapters.tabbedAdapters.FinishedViewHolder;
import ml.derrickabreo.footballacademy.data.data.models.finished;
import ml.derrickabreo.footballacademy.data.data.models.today;

/**
 * A simple {@link Fragment} subclass.
 */
public class FinishedTabbedFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private FirebaseFirestore mFirestore;
    private FirestoreRecyclerAdapter mAdapter;
    private Context mContext;

    public FinishedTabbedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_finished_tabbed, container, false);
        mContext = view.getContext();
        mRecyclerView = view.findViewById(R.id.finished_tabbed_recyclerview);
        init();
        getPlayerList();
        return view;
    }

    private void init() {
        LinearLayoutManager mLinearLayoutManager;
        mLinearLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mFirestore = FirebaseFirestore.getInstance();
    }

    private void getPlayerList() {
        Query query = mFirestore.collection("Finished");
        FirestoreRecyclerOptions<finished> response = new FirestoreRecyclerOptions.Builder<finished>()
                .setQuery(query,finished.class)
                .build();
        mAdapter = new FirestoreRecyclerAdapter<finished, FinishedViewHolder>(response) {

            @NonNull
            @Override
            public FinishedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.finished_fragment_recyclerview,parent,false);
                return new FinishedViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull FinishedViewHolder holder, int position, @NonNull final finished model) {
                holder.mTeam1.setText(model.getTeam1());
                holder.mTeam2.setText(model.getTeam2());
                holder.mDate.setText(getString(R.string.catch_the_game, model.getDate()));
                holder.mTeamGoal1.setText(model.getTeam1Goal());
                holder.mTeamGoal2.setText(model.getTeam2Goal());

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
