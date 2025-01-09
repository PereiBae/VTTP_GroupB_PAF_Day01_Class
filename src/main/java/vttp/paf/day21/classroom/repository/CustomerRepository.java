package vttp.paf.day21.classroom.repository;

import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        SqlRowSet rs = template.queryForRowSet(sql.sql_getAllCustomers);
        while (rs.next()) {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setName(rs.getString("customer_name"));
            customer.setEmail(rs.getString("email"));
            customers.add(customer);
        }
        return customers;
    }

}
