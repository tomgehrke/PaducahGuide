package com.tomgehrke.paducahguide;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SiteArrayAdapter extends ArrayAdapter<Site> {

    // Constructor

    public SiteArrayAdapter(Activity context, ArrayList<Site> SiteList) {
        super(context, 0, SiteList);
    }

    // Overrides

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        // Inflate our Site Item layout if there wasn't one already
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.site_list_item, parent, false);

            // Set up ViewHolder
            viewHolder = new ViewHolder();
            viewHolder.nameTextView = (TextView) convertView.findViewById(R.id.name);
            viewHolder.streetAddressTextView = (TextView) convertView.findViewById(R.id.street_address);
            viewHolder.descriptionTextView = (TextView) convertView.findViewById(R.id.description);
            viewHolder.phoneNumberTextView = (TextView) convertView.findViewById(R.id.phone_number);
            viewHolder.hoursOfOperation = (TextView) convertView.findViewById(R.id.hours_of_operation);
            viewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.thumbnail);

            // Store holder with the view
            convertView.setTag(viewHolder);
        } else {
            // Just use the saved ViewHolder. No need to do all the findViewById stuff.
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Get the current Site
        Site currentSite = getItem(position);

        // Find and update layout views if we got one
        if (currentSite != null) {

            // We always have to have a Name and Street Address
            viewHolder.nameTextView.setText(currentSite.getName());
            viewHolder.streetAddressTextView.setText(currentSite.getStreetAddress());

            // Other properties are optional and views should be hidden if the contain no information

            if (currentSite.getDescription().isEmpty()) {
                viewHolder.descriptionTextView.setVisibility(View.GONE);
            } else {
                viewHolder.descriptionTextView.setText(currentSite.getDescription());
            }

            if (currentSite.getPhoneNumber().isEmpty()) {
                // Phone number is contained in parent view that needs to be hidden
                ((LinearLayout) viewHolder.phoneNumberTextView.getParent()).setVisibility(View.GONE);
            } else {
                viewHolder.phoneNumberTextView.setText(currentSite.getPhoneNumber());
            }

            if (currentSite.getHoursOfOperation().isEmpty()) {
                // Hours of operation is contained in parent view that needs to be hidden
                ((LinearLayout) viewHolder.hoursOfOperation.getParent()).setVisibility(View.GONE);
            } else {
                viewHolder.hoursOfOperation.setText(currentSite.getHoursOfOperation());
            }

            if (currentSite.hasImage()) {
                viewHolder.thumbnail.setImageResource(currentSite.getImageResourceId());
            } else {
                viewHolder.thumbnail.setVisibility(View.GONE);
            }
        }

        return convertView;
    }

}

class ViewHolder {
    TextView nameTextView;
    TextView streetAddressTextView;
    TextView descriptionTextView;
    TextView phoneNumberTextView;
    TextView hoursOfOperation;
    ImageView thumbnail;
}