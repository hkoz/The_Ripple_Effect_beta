package com.therippleeffect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PuddleAdapter extends ArrayAdapter<Puddle> {

        /**
         * Create a new {@link PuddleAdapter} object.
         *
         * @param context is the current context (i.e. Activity) that the adapter is being created in.
         * @param song is the list of {@link Puddle}s to be displayed.
         */
        public PuddleAdapter(Context context, ArrayList<Puddle> song) {
            super(context, 0, song);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Check if an existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.puddle_list_item, parent, false);
            }
            // Get the {@link Puddle} object located at this position in the list
            Puddle currentPuddle = getItem(position);
            // Find the TextView in the list_item.xml layout with the ID puddle_initiator_name.
            TextView initiatorName =  listItemView.findViewById(R.id.puddle_initiator_name);
            // Get the artist name from the currentPuddle object and set this text on
            // the initiator_name TextView.
            initiatorName.setText(currentPuddle.getPuddleInitiatorName());
            // Find the TextView in the list_item.xml layout with the ID puddle_name.
            TextView puddleName =  listItemView.findViewById(R.id.puddle_name);
            // Get the artist name from the currentPuddle object and set this text on
            // the puddle_name TextView.
            puddleName.setText(currentPuddle.getPuddleName());
            // Find the TextView in the list_item.xml layout with the ID puddle_short_description.
            TextView puddleShortDescription =  listItemView.findViewById(R.id.puddle_short_description);
            // Get the artist name from the currentPuddle object and set this text on
            // the puddle_name TextView.
            puddleShortDescription.setText(currentPuddle.getPuddleShortDiscription());
            // Find the ImageView in the list_item.xml layout with the ID puddle_image.
            ImageView puddleImage =  listItemView.findViewById(R.id.puddle_image);
            // Check if an image is provided for this word or not
            if (currentPuddle.puddleHasImage()) {
                // If an image is available, display the provided image based on the resource ID
                puddleImage.setImageResource(currentPuddle.getPuddleIamgeResource());
                // Make sure the view is visible
                puddleImage.setVisibility(View.VISIBLE);
            } else {
                // Otherwise hide the ImageView (set visibility to GONE)
                puddleImage.setVisibility(View.GONE);
            }
            // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
            // the ListView.
            return listItemView;
        }
    }

