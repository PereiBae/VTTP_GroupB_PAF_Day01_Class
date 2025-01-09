package vttp.paf.day21.classroom.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vttp.paf.day21.classroom.model.Customer;
import vttp.paf.day21.classroom.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/limit")
    public ResponseEntity<List<Customer>> getCustomers(@RequestParam ("limit") int limit, @RequestParam ("offset") int offset) {
        List<Customer> customers = customerService.getCustomers(limit,offset);
        return ResponseEntity.ok().body(customers);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok().body(customers);
    }

    @GetMapping("/{customer-id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customer-id") int id) {
        Customer customer = customerService.getCustomer(id);
        return ResponseEntity.ok().body(customer);
    }

    @DeleteMapping("/{customer-id}")
    public ResponseEntity<Boolean> deleteCustomerById(@PathVariable("customer-id") int id) {
        boolean customerDeleted = customerService.deleteCustomerById(id);
        return ResponseEntity.ok().body(customerDeleted);
    }

    @PutMapping("/{customer-id}")
    public ResponseEntity<Boolean> updateCustomerById(@PathVariable("customer-id") int id, @RequestBody Customer customer) {
        Customer c = customerService.getCustomer(id);
        boolean customerUpdated = customerService.updateCustomerById(id, customer);
        if (c != null) {
            return ResponseEntity.ok().body(customerUpdated);
        }
        return ResponseEntity.ok().body(customerUpdated);
    }

}
