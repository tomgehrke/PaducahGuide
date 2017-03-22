package com.tomgehrke.paducahguide;


import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ParksFragment extends Fragment {

    public ParksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View siteListLayout = inflater.inflate(R.layout.site_list, container, false);

        // Create an ArrayList of Sites
        final ArrayList<Site> siteArrayList = new ArrayList<Site>();

        // Get values as arrays from restaurants.xml
        Resources resources = getResources();
        TypedArray siteNames = resources.obtainTypedArray(R.array.park_name);
        TypedArray siteStreetAddresses = resources.obtainTypedArray(R.array.park_street_address);
        TypedArray siteDescription = resources.obtainTypedArray(R.array.park_description);
        TypedArray sitePhoneNumber = resources.obtainTypedArray(R.array.park_phone_number);
        TypedArray siteHoursOfOperation = resources.obtainTypedArray(R.array.park_hours_of_operations);
        TypedArray siteThumbnail = resources.obtainTypedArray(R.array.park_thumbnail);

        // Add sites to the ArrayList by iterating through the XML-stored arrays
        for(int site=0; site < siteNames.length(); site++) {
            siteArrayList.add(new Site(
                    siteNames.getString(site),
                    siteStreetAddresses.getString(site),
                    siteDescription.getString(site),
                    siteHoursOfOperation.getString(site),
                    sitePhoneNumber.getString(site),
                    siteThumbnail.getResourceId(site, -1)
            ));
        }

        // Create the SiteArrayAdapter and pass it the ArrayList of Sites
        SiteArrayAdapter siteArrayAdapter = new SiteArrayAdapter(getActivity(), siteArrayList);

        // Get the ListView from the site list Layout
        ListView siteListView = (ListView) siteListLayout.findViewById(R.id.site_listview);

        // Attach the Site ArrayAdapter to the ListView
        siteListView.setAdapter(siteArrayAdapter);

        // Create listener for clicks on ListView items
        siteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Grab site based on our position in the ArrayList
                Site site = siteArrayList.get(position);

                // Create intent to send the Street Address as a destination to a Google Maps (or other)
                Intent navigationIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?daddr=" + site.getStreetAddress()));
                startActivity(navigationIntent);
            }
        });

        return siteListLayout;
    }

}
