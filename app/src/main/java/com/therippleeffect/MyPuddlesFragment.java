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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
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
        puddlesListView.setAdapter(new PuddleAdapter(getActivity(), puddlesList));
       DatabaseReference ref = (DatabaseReference) database.getReference().child("Puddles").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                puddleItem = new Puddle(-1,
                        dataSnapshot.child("PNK").getValue().toString(),
                        dataSnapshot.child("PNK").getValue().toString(),
                        dataSnapshot.child("PNK").getValue().toString(),
                        dataSnapshot.child("PNK").getValue().toString(),
                        dataSnapshot.child("PNK").getValue().toString(),
                        dataSnapshot.child("PNK").getValue().toString(),
                        dataSnapshot.child("PNK").getValue().toString(),
                        dataSnapshot.child("PNK").getValue().toString(),
                        dataSnapshot.child("PNK").getValue().toString(),
                        dataSnapshot.child("PNK").getValue().toString(),
                        dataSnapshot.child("PNK").getValue().toString(),
                        dataSnapshot.child("PNK").getValue().toString());
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
               Puddle puddle = puddlesList.get(1);
               Intent readQuestIntent = new Intent(getContext(), QuestReadActivity.class);
               readQuestIntent.putExtra("puddle", (Serializable) puddle);
               readQuestIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               startActivity(readQuestIntent);
           }
       });
        return rootview;
    }
}
