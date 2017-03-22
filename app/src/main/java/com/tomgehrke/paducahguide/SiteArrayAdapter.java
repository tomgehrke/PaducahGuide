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

        // Inflate our Site Item layout
        View siteListItemView = convertView;
        if (siteListItemView == null) {
            siteListItemView = LayoutInflater.from(getContext()).inflate(R.layout.site_list_item, parent, false);
        }

        // Get the current Site
        Site currentSite = getItem(position);

        // Find and update layout views if we got one
        if (currentSite != null) {

            // We always have to have a Name and Street Address
            TextView nameTextView = (TextView) siteListItemView.findViewById(R.id.name);
            nameTextView.setText(currentSite.getName());

            TextView streetAddressTextView = (TextView) siteListItemView.findViewById(R.id.street_address);
            streetAddressTextView.setText(currentSite.getStreetAddress());

            // Other properties are optional and views should be hidden if the contain no information

            TextView descriptionTextView = (TextView) siteListItemView.findViewById(R.id.description);
            if (currentSite.getDescription().equals("")) {
                descriptionTextView.setVisibility(View.GONE);
            } else {
                descriptionTextView.setText(currentSite.getDescription());
            }

            TextView phoneNumberTextView = (TextView) siteListItemView.findViewById(R.id.phone_number);
            if (currentSite.getPhoneNumber().equals("")) {
                LinearLayout phoneNumberLinearLayout = (LinearLayout) siteListItemView.findViewById(R.id.phone_number_linearlayout);
                phoneNumberLinearLayout.setVisibility(View.GONE);
            } else {
                phoneNumberTextView.setText(currentSite.getPhoneNumber());
            }

            TextView hoursOfOperation = (TextView) siteListItemView.findViewById(R.id.hours_of_operation);
            if (currentSite.getHoursOfOperation().equals("")) {
                LinearLayout hoursOfOperationLinearLayout = (LinearLayout) siteListItemView.findViewById(R.id.hours_of_operation_linearlayout);
                hoursOfOperationLinearLayout.setVisibility(View.GONE);
            } else {
                hoursOfOperation.setText(currentSite.getHoursOfOperation());
            }

            ImageView thumbnail = (ImageView) siteListItemView.findViewById(R.id.thumbnail);
            if (currentSite.hasImage()) {
                thumbnail.setImageResource(currentSite.getImageResourceId());
            } else {
                thumbnail.setVisibility(View.GONE);
            }
        }

        return siteListItemView;
    }


}
