package com.therippleeffect;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Objects;

public class MyRipplesFragment extends Fragment {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private ArrayList<Puddle> puddlesList;
    private View rootview;
    private ListView puddlesListView;
    Puddle puddleItem;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.puddles_list_view, container, false);
        puddlesList = new ArrayList<>();
        puddlesListView = rootview.findViewById(R.id.list_of_puddles_listView);
        final PuddleAdapter puddleAdapter = new PuddleAdapter(getActivity(), puddlesList);
        puddlesListView.setAdapter(puddleAdapter);
        database.getReference().child("Puddles").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String keyofnewChild = dataSnapshot.getKey();
                puddleItem = new Puddle(-1,
                        dataSnapshot.child(Objects.requireNonNull(getActivity()).getResources().getString(R.string.puddleNameKey)).getValue().toString(),
                        dataSnapshot.child(getActivity().getResources().getString(R.string.initiatorKey)).getValue().toString(),
                        dataSnapshot.child(getActivity().getResources().getString(R.string.questKey)).getValue().toString(),
                        dataSnapshot.child(getActivity().getResources().getString(R.string.countryKey)).getValue().toString(),
                        dataSnapshot.child(getActivity().getResources().getString(R.string.cityKey)).getValue().toString(),
                        dataSnapshot.child(getActivity().getResources().getString(R.string.reqRipplesKey)).getValue().toString(),
                        dataSnapshot.child(getActivity().getResources().getString(R.string.createdRipplesKey)).getValue().toString(),
                        dataSnapshot.child(getActivity().getResources().getString(R.string.typeKey)).getValue().toString(),
                        dataSnapshot.child(getActivity().getResources().getString(R.string.statusKey)).getValue().toString(),
                        dataSnapshot.child(getActivity().getResources().getString(R.string.credibilityKey)).getValue().toString(),
                        dataSnapshot.child(getActivity().getResources().getString(R.string.reportsKey)).getValue().toString(),
                        dataSnapshot.child(getActivity().getResources().getString(R.string.detailsKey)).getValue().toString(),
                        dataSnapshot.child(getActivity().getResources().getString(R.string.dateKey)).getValue().toString());
                puddlesList.add(puddleItem);
                puddleAdapter.notifyDataSetChanged();
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) { }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) { }
            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) { }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });

        puddlesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Puddle puddle = puddlesList.get(i);
                Intent readQuestIntent = new Intent(getContext(), AcceptQuestActivity.class);
                readQuestIntent.putExtra(Objects.requireNonNull(getActivity()).getResources().getString(R.string.puddleNameKey), puddle.getPuddleName());
                readQuestIntent.putExtra(getActivity().getResources().getString(R.string.initiatorKey), puddle.getPuddleInitiator());
                readQuestIntent.putExtra(getActivity().getResources().getString(R.string.questKey), puddle.getPuddleQuest());
                readQuestIntent.putExtra(getActivity().getResources().getString(R.string.countryKey), puddle.getPuddleCountryLocation());
                readQuestIntent.putExtra(getActivity().getResources().getString(R.string.cityKey), puddle.getPuddleCityLocation());
                readQuestIntent.putExtra(getActivity().getResources().getString(R.string.reqRipplesKey), puddle.getPuddleRequiredRipples());
                readQuestIntent.putExtra(getActivity().getResources().getString(R.string.createdRipplesKey), puddle.getPuddleCreatedRipples());
                readQuestIntent.putExtra(getActivity().getResources().getString(R.string.typeKey), puddle.getPuddleType());
                readQuestIntent.putExtra(getActivity().getResources().getString(R.string.statusKey), puddle.getPuddleStatus());
                readQuestIntent.putExtra(getActivity().getResources().getString(R.string.credibilityKey), puddle.getPuddleCredibilityBoostsNumber());
                readQuestIntent.putExtra(getActivity().getResources().getString(R.string.reportsKey), puddle.getPuddleCredibilityReportsNumber());
                readQuestIntent.putExtra(getActivity().getResources().getString(R.string.detailsKey), puddle.getPuddleDetails());
                readQuestIntent.putExtra(getActivity().getResources().getString(R.string.dateKey),puddle.getPuddleDateCreated());

                startActivity(readQuestIntent);
            }
        });
        return rootview;
    }
}
