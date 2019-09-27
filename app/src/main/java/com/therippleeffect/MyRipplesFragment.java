package com.therippleeffect;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class MyRipplesFragment extends Fragment {
    String initiatorName = "";
    String PuddlesName = "";
    String PuddlesShortDescription = "";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.puddles_list_view, container, false);
        ArrayList<Puddle> puddlesList = new ArrayList<>();
        puddlesList.add(new Puddle(R.drawable.ic_launcher_foreground, "Mozart", "symphony no.21","123456789123456789"));
        puddlesList.add(new Puddle(R.drawable.ic_launcher_foreground, "Beethoven", "symphony no.7","No description"));
        puddlesList.add(new Puddle(R.drawable.ic_launcher_foreground, "handel", "sarabande","No description"));
        puddlesList.add(new Puddle(R.drawable.ic_launcher_foreground, "Bach", "symphony no.1","No description"));
        puddlesList.add(new Puddle(R.drawable.ic_launcher_foreground, "tchaikovsky", "the nutcracker","No description"));
        puddlesList.add(new Puddle(R.drawable.ic_launcher_foreground, "vivaldi", "the four seasons","No description"));
        ListView puddlesListView = rootview.findViewById(R.id.list_of_puddles_listView);
        puddlesListView.setAdapter(new PuddleAdapter(getActivity(), puddlesList));
        return rootview;
    }
}
