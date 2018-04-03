package com.accenture.pocproject.customers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.accenture.pocproject.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fjodors.pohodnevs on 8/26/2016.
 */
public class CustomerRecyclerAdapter extends RecyclerView.Adapter<CustomerRecyclerAdapter.CustomerViewHolder> {
    private List<Customer> customers;
    private ItemClickListener itemClickListener;

    public CustomerRecyclerAdapter(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public CustomerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer, parent, false);
        return new CustomerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomerViewHolder holder, int position) {
        String customerFullName = customers.get(position).getFirstName().getS() + " " + customers.get(position).getLastName().getS();
        holder.customerName.setText(customerFullName);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String customerId = customers.get(holder.getAdapterPosition()).getID().getS();
                itemClickListener.onItemClick(customerId);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (customers != null) {
            return customers.size();
        } else {
            return 0;
        }
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public interface ItemClickListener {
        void onItemClick(String customerId);
    }

    public static class CustomerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.customer_name)
        TextView customerName;

        public CustomerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
