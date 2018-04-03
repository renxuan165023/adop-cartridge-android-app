package com.accenture.pocproject.customers;

import com.accenture.pocproject.api.PocApiClient;
import com.accenture.pocproject.api.PocApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fjodors.pohodnevs on 8/29/2016.
 */
public class CustomersPresenter implements CustomerContract.Presenter {

    CustomerContract.View customerView;

    public CustomersPresenter(CustomerContract.View customerView) {
        this.customerView = customerView;
    }

    @Override
    public void fetchCostumers() {
        PocApiService apiService = PocApiClient.getGetClient().create(PocApiService.class);

        Call<List<Customer>> call = apiService.getCustomers();
        call.enqueue(new Callback<List<Customer>>() {
            @Override
            public void onResponse(Call<List<Customer>> call, Response<List<Customer>> response) {
                customerView.showCustomers(response.body());
                customerView.hideProgress();
            }

            @Override
            public void onFailure(Call<List<Customer>> call, Throwable t) {
                customerView.hideProgress();
                customerView.showError(t);
            }
        });
    }
}
