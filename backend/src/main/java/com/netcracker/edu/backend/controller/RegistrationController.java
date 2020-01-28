package com.netcracker.edu.backend.controller;


import com.netcracker.edu.backend.service.RegistrationService;
import com.netcracker.edu.backend.transferOfObjects.AbstractRegistrationModel;
import com.netcracker.edu.backend.transferOfObjects.CustomerRegistration;
import com.netcracker.edu.backend.transferOfObjects.OrganisationRegistration;
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

    @RequestMapping(value = "/login/{login}/password/{password}", method = RequestMethod.GET)
    public ResponseEntity<AbstractRegistrationModel> getUserInfo(
            @PathVariable(name = "login") String login,
            @PathVariable(name = "password") String password) {
        AbstractRegistrationModel information =  registrationService.getUserInfo(login, password);
        return ResponseEntity.ok(information);
    }

    @RequestMapping(value = "/customer",method = RequestMethod.POST)
    public AbstractRegistrationModel registerCust(@RequestBody CustomerRegistration customerRegistration){
        return registrationService.registerUser(customerRegistration);
    }

    @RequestMapping(value = "/organisation",method = RequestMethod.POST)
    public AbstractRegistrationModel registerOrg(@RequestBody OrganisationRegistration organisationRegistration){
        return registrationService.registerUser(organisationRegistration);
    }

    @RequestMapping(value = "/user/delete/{idUser}/{idWallet}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(name = "idUser") Integer idUser,
                           @PathVariable(name = "idWallet") Integer idWallet) {
        registrationService.deleteUserProfile(idUser, idWallet);
    }
}
