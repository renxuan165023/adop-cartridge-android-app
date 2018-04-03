package com.accenture.pocproject.api;

import com.accenture.pocproject.customerDetail.CustomerDetail;
import com.accenture.pocproject.customerDetail.CustomerDetailEdit;
import com.accenture.pocproject.customers.Customer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by fjodors.pohodnevs on 8/26/2016.
 */
public interface PocApiService {
    @GET("readapp")
    Call<List<Customer>> getCustomers();

    @GET("readapp/{customerId}")
    Call<CustomerDetail> getCustomerDetail(@Path("customerId") String customerId);

    @POST("writeapp")
    Call<CustomerDetailEdit> editCustomerDetail(@Body CustomerDetailEdit customerDetailEdit);
}
