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


public class MyPuddlesFragment extends Fragment {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private ArrayList<Puddle> puddlesList;
    private View rootview;
    private ListView puddlesListView;
    Puddle puddleItem;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.puddles_list_view, container, false);
        puddlesList = new ArrayList<>();
        puddlesListView = rootview.findViewById(R.id.list_of_puddles_listView);
        final PuddleAdapter puddleAdapter = new PuddleAdapter(getActivity(), puddlesList);
        puddlesListView.setAdapter(puddleAdapter);
        database.getReference().child("Puddles").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String keyofnewChild = dataSnapshot.getKey();
                puddleItem = new Puddle(-1,
                        dataSnapshot.child(getString(R.string.puddleNameKey)).getValue().toString(),
                        dataSnapshot.child(getString(R.string.initiatorKey)).getValue().toString(),
                        dataSnapshot.child(getString(R.string.questKey)).getValue().toString(),
                        dataSnapshot.child(getString(R.string.countryKey)).getValue().toString(),
                        dataSnapshot.child(getString(R.string.cityKey)).getValue().toString(),
                        dataSnapshot.child(getString(R.string.reqRipplesKey)).getValue().toString(),
                        dataSnapshot.child(getString(R.string.createdRipplesKey)).getValue().toString(),
                        dataSnapshot.child(getString(R.string.typeKey)).getValue().toString(),
                        dataSnapshot.child(getString(R.string.statusKey)).getValue().toString(),
                        dataSnapshot.child(getString(R.string.credibilityKey)).getValue().toString(),
                        dataSnapshot.child(getString(R.string.reportsKey)).getValue().toString(),
                        dataSnapshot.child(getString(R.string.detailsKey)).getValue().toString());
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
               Intent readQuestIntent = new Intent(getContext(), QuestReadActivity.class);
               readQuestIntent.putExtra(getString(R.string.puddleNameKey), puddle.getPuddleName());
               readQuestIntent.putExtra(getString(R.string.initiatorKey), puddle.getPuddleInitiator());
               readQuestIntent.putExtra(getString(R.string.questKey), puddle.getPuddleQuest());
               readQuestIntent.putExtra(getString(R.string.countryKey), puddle.getPuddleCountryLocation());
               readQuestIntent.putExtra(getString(R.string.cityKey), puddle.getPuddleCityLocation());
               readQuestIntent.putExtra(getString(R.string.reqRipplesKey), puddle.getPuddleRequiredRipples());
               readQuestIntent.putExtra(getString(R.string.ripples_created), puddle.getPuddleCreatedRipples());
               readQuestIntent.putExtra(getString(R.string.typeKey), puddle.getPuddleType());
               readQuestIntent.putExtra(getString(R.string.statusKey), puddle.getPuddleStatus());
               readQuestIntent.putExtra(getString(R.string.credibilityKey), puddle.getPuddleCredibilityBoostsNumber());
               readQuestIntent.putExtra(getString(R.string.reportsKey), puddle.getPuddleCredibilityReportsNumber());
               readQuestIntent.putExtra(getString(R.string.detailsKey), puddle.getPuddleDetails());


               readQuestIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               startActivity(readQuestIntent);
           }
       });
        return rootview;
    }
}
