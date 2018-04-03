package com.accenture.pocproject;

import com.accenture.pocproject.customers.Customer;
import com.accenture.pocproject.customers.CustomerRecyclerAdapter;

import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

//import static org.junit.Assert.*;

/**
 * Created by fjodors.pohodnevs on 8/29/2016.
 */
public class CustomersAdapterTest {

    @Mock
    CustomerRecyclerAdapter.ItemClickListener itemClickListener;

    @Test
    public void testEmptyCustomerRecyclerAdapter() {
        CustomerRecyclerAdapter customerRecyclerAdapter = new CustomerRecyclerAdapter(itemClickListener);
        assertEquals(customerRecyclerAdapter.getItemCount(), 0);
    }

    @Test
    public void testAddCustomerRecyclerAdapter() {
        CustomerRecyclerAdapter customerRecyclerAdapter = new CustomerRecyclerAdapter(itemClickListener);
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer());
        customerRecyclerAdapter.setCustomers(customers);
        assertEquals(customerRecyclerAdapter.getItemCount(), 1);
    }

    @Test
    public void testAddRemoveCustomerRecyclerAdapter() {
        CustomerRecyclerAdapter customerRecyclerAdapter = new CustomerRecyclerAdapter(itemClickListener);
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer());
        customers.remove(0);
        customerRecyclerAdapter.setCustomers(customers);
        assertEquals(customerRecyclerAdapter.getItemCount(), 0);
    }

}
