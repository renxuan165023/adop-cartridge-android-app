package com.accenture.pocproject.customerDetail;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.accenture.pocproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by fjodors.pohodnevs on 8/26/2016.
 */
public class CustomerDetailActivity extends AppCompatActivity implements CustomerDetailContract.View {

    private static final String SUBSCRIPTION_STATUS_ACTIVE = "Active";
    private static final String SUBSCRIPTION_STATUS_IN_ACTIVE = "InActive";
    private static final String SUBSCRIPTION_STATUS_TERMINATED = "Terminated";

    @BindView(R.id.toolbar)
    Toolbar myToolbar;
    @BindView(R.id.customerLayout)
    RelativeLayout customerLayout;
    @BindView(R.id.id)
    TextView idTV;
    @BindView(R.id.first_name)
    EditText firstNameET;
    @BindView(R.id.last_name)
    EditText lastNameET;
    @BindView(R.id.account_number)
    EditText accountNumberET;
    @BindView(R.id.channel_group)
    Spinner channelGroupSpinner;
    @BindView(R.id.channel_list)
    Spinner channelListSpinner;
    @BindView(R.id.subscription_status_active)
    RadioButton activeRB;
    @BindView(R.id.subscription_status_inactive)
    RadioButton inActiveRB;
    @BindView(R.id.subscription_status_terminated)
    RadioButton terminatedRB;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private CustomerDetailContract.Presenter customerDetailPresenter;
    private CustomerDetailEdit customerDetailEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_detail);
        ButterKnife.bind(this);

        setSupportActionBar(myToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        customerDetailPresenter = new CustomerDetailPresenter(this);
        customerDetailPresenter.fetchCustomerDetail();
    }

    /**
     * Returns customer object with data from input fields
     */
    private CustomerDetailEdit getCustomerEditData() {

        CustomerDetailEdit customerDetailEdit = new CustomerDetailEdit();

        customerDetailEdit.setiD(idTV.getText().toString());
        customerDetailEdit.setFirstName(firstNameET.getText().toString());
        customerDetailEdit.setLastName(lastNameET.getText().toString());
        customerDetailEdit.setAccountNumber(accountNumberET.getText().toString());
        customerDetailEdit.setChannelsGroup(channelGroupSpinner.getSelectedItem().toString());
        customerDetailEdit.setChannelsList(channelListSpinner.getSelectedItem().toString());
        String subscriptionStatus;
        if (activeRB.isChecked()) {
            subscriptionStatus = SUBSCRIPTION_STATUS_ACTIVE;
        } else if (inActiveRB.isChecked()) {
            subscriptionStatus = SUBSCRIPTION_STATUS_IN_ACTIVE;
        } else {
            subscriptionStatus = SUBSCRIPTION_STATUS_TERMINATED;
        }
        customerDetailEdit.setSubscriptionStatus(subscriptionStatus);

        return customerDetailEdit;
    }

    @OnClick(R.id.edit_data)
    public void editCustomerData() {
        customerDetailPresenter.editCustomerData(getCustomerEditData());
    }

    @Override
    public void showCustomerDetail(CustomerDetail customerDetail) {
        idTV.setText(customerDetail.getID().getS());
        firstNameET.setText(customerDetail.getFirstName().getS());
        lastNameET.setText(customerDetail.getLastName().getS());
        accountNumberET.setText(customerDetail.getAccountNumber().getS());

        ArrayAdapter<CharSequence> channelGroupSpinnerAdapter = ArrayAdapter.createFromResource(CustomerDetailActivity.this,
                R.array.channel_group_array, android.R.layout.simple_spinner_item);
        channelGroupSpinner.setAdapter(channelGroupSpinnerAdapter);
        String channelGroup = customerDetail.getChannelsGroup().getS();
        int channelGroupSpinnerPosition = channelGroupSpinnerAdapter.getPosition(channelGroup);
        channelGroupSpinner.setSelection(channelGroupSpinnerPosition);


        ArrayAdapter<CharSequence> channelListSpinnerAdapter = ArrayAdapter.createFromResource(CustomerDetailActivity.this,
                R.array.channel_list_array, android.R.layout.simple_spinner_item);
        channelListSpinner.setAdapter(channelListSpinnerAdapter);
        String channelList = customerDetail.getChannelsList().getS();
        int channelListSpinnerPosition = channelListSpinnerAdapter.getPosition(channelList);
        channelGroupSpinner.setSelection(channelListSpinnerPosition);

        String subscriptionStatus = customerDetail.getSubscriptionStatus().getS();
        switch (subscriptionStatus) {
            case SUBSCRIPTION_STATUS_ACTIVE:
                activeRB.setChecked(true);
                break;
            case SUBSCRIPTION_STATUS_IN_ACTIVE:
                inActiveRB.setChecked(true);
                break;
            case SUBSCRIPTION_STATUS_TERMINATED:
                terminatedRB.setChecked(true);
                break;
        }
        customerLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(CustomerDetailActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showSuccess() {
        Toast.makeText(CustomerDetailActivity.this, R.string.update_success, Toast.LENGTH_SHORT).show();
    }
}
