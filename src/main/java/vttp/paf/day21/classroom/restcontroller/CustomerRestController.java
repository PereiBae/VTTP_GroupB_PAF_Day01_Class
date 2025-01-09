package vttp.paf.day21.classroom.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vttp.paf.day21.classroom.model.Customer;
import vttp.paf.day21.classroom.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{limit}+{offset}")
    public ResponseEntity<List<Customer>> getCustomers(@PathVariable int limit, @PathVariable int offset) {
        List<Customer> customers = customerService.getAllCustomers(limit,offset);
        return ResponseEntity.ok().body(customers);
    }

}
