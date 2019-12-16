package com.netcracker.edu.fapi.controller;

        import com.netcracker.edu.fapi.models.CustomerRegistrationModel;
        import com.netcracker.edu.fapi.models.OrganisationRegistrationModel;
        import com.netcracker.edu.fapi.service.CustomerRegistrationService;
        import com.netcracker.edu.fapi.service.OrganisationRegistrationService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reg/customer")
public class CustomerRegistrationController {
    private CustomerRegistrationService customerRegistrationService;

    @Autowired
    public CustomerRegistrationController(CustomerRegistrationService customerRegistrationService) {
        this.customerRegistrationService = customerRegistrationService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CustomerRegistrationModel> registerCustomer (@RequestBody CustomerRegistrationModel newCustomer){
        if(newCustomer != null) {
            return ResponseEntity.ok(customerRegistrationService.registerCustomer(newCustomer));
        }
        return null;
    }

    @GetMapping("login/{log}/password/{pass}")
    public CustomerRegistrationModel getCustomerProfile(@PathVariable String log, @PathVariable String pass) {
        return customerRegistrationService.getCustomerProfile(log, pass);
    }

}
