package com.accenture.pocproject.customers;

import java.util.List;

/**
 * Created by fjodors.pohodnevs on 8/29/2016.
 */
public interface CustomerContract {
    interface View {
        void showCustomers(List<Customer> customers);

        void showError(Throwable e);

        void hideProgress();
    }

    interface Presenter {
        void fetchCostumers();
    }
}
