package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.AbstractRegModel;
import com.netcracker.edu.fapi.models.CustomerRegistrationModel;
import com.netcracker.edu.fapi.models.OrganisationRegistrationModel;
import com.netcracker.edu.fapi.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @RequestMapping(value = "/organisation",method = RequestMethod.POST)
    public ResponseEntity<AbstractRegModel> registerOrganisation (@RequestBody OrganisationRegistrationModel newOrganisation) throws InterruptedException{
        if(newOrganisation != null) {
            return ResponseEntity.ok(registrationService.registerOrganisation(newOrganisation));
        }
        return null;
    }

    @RequestMapping(value = "/customer",method = RequestMethod.POST)
    public ResponseEntity<AbstractRegModel> registerCustomer (@RequestBody CustomerRegistrationModel newCustomer) throws InterruptedException{
        if(newCustomer != null) {
            return ResponseEntity.ok(registrationService.registerCustomer(newCustomer));
        }
        return null;
    }

    @RequestMapping(value = "/login/{log}/password/{pass}",method = RequestMethod.GET)
    public ResponseEntity<AbstractRegModel> getUserProfile(@PathVariable String log, @PathVariable String pass) throws InterruptedException {
        AbstractRegModel information =  registrationService.getUserProfile(log, pass);
        return ResponseEntity.ok(information);
       // return registrationService.getUserProfile(log, pass);
    }
//
//    @GetMapping("/cust/login/{log}/password/{pass}")
//    public AbstractRegModel getCustProfile(@PathVariable String log, @PathVariable String pass) {
//        return registrationService.getCustProfile(log, pass);
//    }

    @RequestMapping(value = "/user/delete/{idUser}/{idWallet}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer idUser,
                           @PathVariable Integer idWallet) {
        registrationService.deleteUserProfile(idUser, idWallet);
    }
}
