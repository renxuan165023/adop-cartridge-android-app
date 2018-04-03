package com.accenture.pocproject.customers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by fjodors.pohodnevs on 8/26/2016.
 */
public class Customer {

    @SerializedName("ID")
    @Expose
    private ID iD;
    @SerializedName("lastName")
    @Expose
    private LastName lastName;
    @SerializedName("firstName")
    @Expose
    private FirstName firstName;

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
}
