package vttp.paf.day21.classroom.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import vttp.paf.day21.classroom.model.Customer;
import vttp.paf.day21.classroom.utils.sql;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate template;

    public List<Customer> getCustomers(final int limit, final int offset) {
        List<Customer> customers = new ArrayList<>();
        SqlRowSet rs = template.queryForRowSet(sql.sql_getAllCustomers_LimitOffset,limit,offset);
        while (rs.next()) {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setCustomer_name(rs.getString("customer_name"));
            customer.setEmail(rs.getString("email"));
            customers.add(customer);
        }
        return customers;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        SqlRowSet rowSet = template.queryForRowSet(sql.sql_getAllCustomers);
        while (rowSet.next()) {
            Customer customer = new Customer();
            customer.setId(rowSet.getInt("id"));
            customer.setCustomer_name(rowSet.getString("customer_name"));
            customer.setEmail(rowSet.getString("email"));
            customers.add(customer);
        }
        return customers;
    }

    public Customer getCustomerById(final int id) {
        return template.queryForObject(sql.sql_getCustomers_ById, BeanPropertyRowMapper.newInstance(Customer.class), id);
    }

    public boolean deleteCustomerById(final int id) {
        int customerDeleted = template.update(sql.sql_deleteCustomerById, id);

        return customerDeleted > 0;
    }

    public boolean updateCustomerById(final int id, final Customer customer) {
        int customerUpdated = template.update(sql.sql_updateCustomerById, customer.getCustomer_name(), customer.getEmail(), id);
        if (customerUpdated > 0) {
            return true;
        }
        return false;
    }
}
