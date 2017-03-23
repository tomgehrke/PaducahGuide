package com.tomgehrke.paducahguide;

// CLASS: Site
//
// Used to manage information used to describe a place.

import android.content.res.Resources;

public class Site {

    // Constants

    private static final int NO_IMAGE = -1;

    // Properties

    private String mName;
    private String mDescription;
    private String mStreetAddress;
    private String mHoursOfOperation;
    private String mPhoneNumber;
    private int mImageResourceId = NO_IMAGE;


    // Class Constructor(s)

    // USAGE: Site mySite = new Site("My Site", "1234 Somestreet, Somecity, Somestate");
    public Site(String name, String streetAddress) {
        mName = name;
        mStreetAddress = streetAddress;
    }

    public Site(String name, String streetAddress, String description,
                String hoursOfOperation, String phoneNumber) {
        mName = name;
        mStreetAddress = streetAddress;
        mDescription = description;
        mHoursOfOperation = hoursOfOperation;
        mPhoneNumber = phoneNumber;
    }

    public Site(String name, String streetAddress, String description,
                String hoursOfOperation, String phoneNumber, int imageResourceId) {
        mName = name;
        mStreetAddress = streetAddress;
        mDescription = description;
        mHoursOfOperation = hoursOfOperation;
        mPhoneNumber = phoneNumber;
        mImageResourceId = imageResourceId;
    }

    // Getter/Setter Methods

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getStreetAddress() {
        return mStreetAddress;
    }

    public String getHoursOfOperation() {
        return mHoursOfOperation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    // Utility Methods

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE;
    }

    @Override
    public String toString() {
        return Resources.getSystem().getString(R.string.siteClassToString,
                getClass().getName(),
                mName,
                mStreetAddress,
                mDescription,
                mHoursOfOperation,
                mPhoneNumber,
                mImageResourceId);
    }

}
