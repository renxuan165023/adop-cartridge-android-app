package com.accenture.pocproject.customers;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.accenture.pocproject.R;
import com.accenture.pocproject.customerDetail.CustomerDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomersActivity extends AppCompatActivity implements CustomerContract.View {

    public static final String CUSTOMER_ID = "CUSTOMER_ID";

    @BindView(R.id.toolbar)
    Toolbar myToolbar;
    @BindView(R.id.costumer_recycler_view)
    RecyclerView customerRecyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;


    private CustomerRecyclerAdapter customerRecyclerAdapter;
    private CustomerContract.Presenter customerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);

        ButterKnife.bind(this);

        setSupportActionBar(myToolbar);

        refreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                customerPresenter.fetchCostumers();
            }
        });

        initRecyclerView();

        customerPresenter = new CustomersPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        customerPresenter.fetchCostumers();
    }

    public void initRecyclerView() {
        customerRecyclerView.setHasFixedSize(true);
        customerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        customerRecyclerAdapter = new CustomerRecyclerAdapter(itemClickListener);
        customerRecyclerView.setAdapter(customerRecyclerAdapter);
    }

    @Override
    public void showCustomers(List<Customer> customers) {
        customerRecyclerAdapter.setCustomers(customers);
        customerRecyclerAdapter.notifyDataSetChanged();
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(CustomersActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    private CustomerRecyclerAdapter.ItemClickListener itemClickListener = new CustomerRecyclerAdapter.ItemClickListener() {
        @Override
        public void onItemClick(String customerId) {
            Intent intent = new Intent();
            intent.putExtra(CUSTOMER_ID, customerId);
            intent.setClass(CustomersActivity.this, CustomerDetailActivity.class);
            startActivity(intent);
        }
    };
}
