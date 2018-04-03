package com.accenture.pocproject.customerDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by fjodors.pohodnevs on 8/29/2016.
 */

/**
 * Customer Object which is used for POST HTTP method to edit costumer data
 */
public class CustomerDetailEdit {
    @SerializedName("ID")
    @Expose
    public String iD;
    @SerializedName("accountNumber")
    @Expose
    public String accountNumber;
    @SerializedName("channelsGroup")
    @Expose
    public String channelsGroup;
    @SerializedName("channelsList")
    @Expose
    public String channelsList;
    @SerializedName("firstName")
    @Expose
    public String firstName;
    @SerializedName("lastName")
    @Expose
    public String lastName;
    @SerializedName("subscriptionStatus")
    @Expose
    public String subscriptionStatus;

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getChannelsGroup() {
        return channelsGroup;
    }

    public void setChannelsGroup(String channelsGroup) {
        this.channelsGroup = channelsGroup;
    }

    public String getChannelsList() {
        return channelsList;
    }

    public void setChannelsList(String channelsList) {
        this.channelsList = channelsList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(String subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }
}
