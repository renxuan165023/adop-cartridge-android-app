package com.accenture.pocproject.customerDetail;

/**
 * Created by fjodors.pohodnevs on 8/29/2016.
 */
public interface CustomerDetailContract {
    interface View {
        void showCustomerDetail(CustomerDetail customerDetail);

        void showError(Throwable e);

        void hideProgress();

        void showSuccess();
    }

    interface Presenter {
        void fetchCustomerDetail();

        void editCustomerData(CustomerDetailEdit customerDetailEdit);
    }
}
