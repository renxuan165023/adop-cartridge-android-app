package com.accenture.pocproject.customerDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by fjodors.pohodnevs on 8/26/2016.
 */
public class CustomerDetail {
    @SerializedName("channelsList")
    @Expose
    private ChannelsList channelsList;
    @SerializedName("channelsGroup")
    @Expose
    private ChannelsGroup channelsGroup;
    @SerializedName("lastName")
    @Expose
    private LastName lastName;
    @SerializedName("ID")
    @Expose
    private ID iD;
    @SerializedName("accountNumber")
    @Expose
    private AccountNumber accountNumber;
    @SerializedName("subscriptionStatus")
    @Expose
    private SubscriptionStatus subscriptionStatus;
    @SerializedName("firstName")
    @Expose
    private FirstName firstName;

    /**
     * @return The channelsList
     */
    public ChannelsList getChannelsList() {
        return channelsList;
    }

    /**
     * @param channelsList The channelsList
     */
    public void setChannelsList(ChannelsList channelsList) {
        this.channelsList = channelsList;
    }

    /**
     * @return The channelsGroup
     */
    public ChannelsGroup getChannelsGroup() {
        return channelsGroup;
    }

    /**
     * @param channelsGroup The channelsGroup
     */
    public void setChannelsGroup(ChannelsGroup channelsGroup) {
        this.channelsGroup = channelsGroup;
    }

    /**
     * @return The lastName
     */
    public LastName getLastName() {
        return lastName;
    }

    /**
     * @param lastName The lastName
     */
    public void setLastName(LastName lastName) {
        this.lastName = lastName;
    }

    /**
     * @return The iD
     */
    public ID getID() {
        return iD;
    }

    /**
     * @param iD The ID
     */
    public void setID(ID iD) {
        this.iD = iD;
    }

    /**
     * @return The accountNumber
     */
    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber The accountNumber
     */
    public void setAccountNumber(AccountNumber accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return The subscriptionStatus
     */
    public SubscriptionStatus getSubscriptionStatus() {
        return subscriptionStatus;
    }

    /**
     * @param subscriptionStatus The subscriptionStatus
     */
    public void setSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    /**
     * @return The firstName
     */
    public FirstName getFirstName() {
        return firstName;
    }

    /**
     * @param firstName The firstName
     */
    public void setFirstName(FirstName firstName) {
        this.firstName = firstName;
    }

    public static class FirstName {

        @SerializedName("S")
        @Expose
        private String s;

        /**
         * @return The s
         */
        public String getS() {
            return s;
        }

        /**
         * @param s The S
         */
        public void setS(String s) {
            this.s = s;
        }

    }

    public static class ID {

        @SerializedName("S")
        @Expose
        private String s;

        /**
         * @return The s
         */
        public String getS() {
            return s;
        }

        /**
         * @param s The S
         */
        public void setS(String s) {
            this.s = s;
        }

    }

    public static class LastName {

        @SerializedName("S")
        @Expose
        private String s;

        /**
         * @return The s
         */
        public String getS() {
            return s;
        }

        /**
         * @param s The S
         */
        public void setS(String s) {
            this.s = s;
        }

    }

    public static class SubscriptionStatus {

        @SerializedName("S")
        @Expose
        private String s;

        /**
         * @return The s
         */
        public String getS() {
            return s;
        }

        /**
         * @param s The S
         */
        public void setS(String s) {
            this.s = s;
        }
    }

    public static class ChannelsList {

        @SerializedName("S")
        @Expose
        private String s;

        /**
         * @return The s
         */
        public String getS() {
            return s;
        }

        /**
         * @param s The S
         */
        public void setS(String s) {
            this.s = s;
        }

    }

    public static class ChannelsGroup {

        @SerializedName("S")
        @Expose
        private String s;

        /**
         * @return The s
         */
        public String getS() {
            return s;
        }

        /**
         * @param s The S
         */
        public void setS(String s) {
            this.s = s;
        }

    }

    public static class AccountNumber {

        @SerializedName("S")
        @Expose
        private String s;

        /**
         * @return The s
         */
        public String getS() {
            return s;
        }

        /**
         * @param s The S
         */
        public void setS(String s) {
            this.s = s;
        }

    }
}