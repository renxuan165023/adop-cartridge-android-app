package com.accenture.pocproject.customerDetail;

import android.app.Activity;

import com.accenture.pocproject.api.PocApiClient;
import com.accenture.pocproject.api.PocApiService;
import com.accenture.pocproject.customers.CustomersActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fjodors.pohodnevs on 8/29/2016.
 */
public class CustomerDetailPresenter implements CustomerDetailContract.Presenter {

    CustomerDetailContract.View customerDetailView;

    public CustomerDetailPresenter(CustomerDetailContract.View customerDetailView) {
        this.customerDetailView = customerDetailView;
    }

    @Override
    public void fetchCustomerDetail() {
        String customerId = ((Activity) customerDetailView).getIntent().getStringExtra(CustomersActivity.CUSTOMER_ID);
        PocApiService apiService = PocApiClient.getGetClient().create(PocApiService.class);
        Call<CustomerDetail> call = apiService.getCustomerDetail(customerId);
        call.enqueue(new Callback<CustomerDetail>() {
            @Override
            public void onResponse(Call<CustomerDetail> call, Response<CustomerDetail> response) {
                customerDetailView.hideProgress();
                customerDetailView.showCustomerDetail(response.body());
            }

            @Override
            public void onFailure(Call<CustomerDetail> call, Throwable t) {
                customerDetailView.hideProgress();
                customerDetailView.showError(t);
            }
        });
    }

    @Override
    public void editCustomerData(CustomerDetailEdit customerDetailEdit) {
        PocApiService apiService = PocApiClient.getPostClient().create(PocApiService.class);
        Call<CustomerDetailEdit> call = apiService.editCustomerDetail(customerDetailEdit);
        call.enqueue(new Callback<CustomerDetailEdit>() {
            @Override
            public void onResponse(Call<CustomerDetailEdit> call, Response<CustomerDetailEdit> response) {
                customerDetailView.showSuccess();
            }

            @Override
            public void onFailure(Call<CustomerDetailEdit> call, Throwable t) {
                customerDetailView.showError(t);
            }
        });
    }
}
