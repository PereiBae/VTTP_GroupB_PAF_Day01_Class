package vttp.paf.day21.classroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vttp.paf.day21.classroom.model.Customer;
import vttp.paf.day21.classroom.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    public List<Customer> getCustomers(int limit, int offset) {
        return customerRepo.getCustomers(limit,offset);
    }

}
