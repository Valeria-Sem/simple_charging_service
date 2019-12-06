package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.CustomerRegistrationModel;
import com.netcracker.edu.fapi.models.UserModel;
import com.netcracker.edu.fapi.models.WalletModel;
import com.netcracker.edu.fapi.service.CustomerRegistrationService;
import com.netcracker.edu.fapi.service.CustomerService;
import com.netcracker.edu.fapi.service.UserService;
import com.netcracker.edu.fapi.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration")
public class CustomerRegistrationController {
    @Autowired
    private CustomerRegistrationService customerRegistrationService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CustomerRegistrationModel> registerCustomer (@RequestBody CustomerRegistrationModel newCustomer){
        if(newCustomer != null) {
            return ResponseEntity.ok(customerRegistrationService.registerCustomer(newCustomer));
        }
        return null;
    }

//    @Autowired
//    private CustomerService customerService;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private WalletService walletService;
//
//    @RequestMapping( method = RequestMethod.POST)
//    public ResponseEntity<CustomerRegistrationModel> saveCustomer(@RequestBody CustomerRegistrationModel information) {
//        WalletModel newWallet = new WalletModel();
//        newWallet.setBalance(information.getBalance());
//        newWallet.setWalletStatus(information.getWalletStatus());
//        WalletModel wallet = walletService.saveWallet(newWallet);
//
//        UserModel userModel = new UserModel();
//        userModel.setLogin(information.getLogin());
//        userModel.setPassword(information.getPassword());
//        userModel.setRole(information.getRole());
//        UserModel userDetails = userService.saveUser(userModel);
//
//        CustomerModel saveCustomer = new CustomerModel();
//        saveCustomer.setName(information.getName());
//        saveCustomer.setSurname(information.getSurname());
//        saveCustomer.setIdUser((int) userDetails.getIdUser());
//        saveCustomer.setIdWallet(wallet.getIdWallet());
//        CustomerModel customerViewModel = customerService.saveCustomer(saveCustomer);
//
//        return ResponseEntity.ok(customerRegistrationModel);
////        UserSignatureViewModel userSignatureViewModel = new UserSignatureViewModel();
////        userSignatureViewModel.setId(customerViewModel.getId());
////        userSignatureViewModel.setUserDetailsId(userDetails.getId());
////        userSignatureViewModel.setWalletId(wallet.getId());
////        userSignatureViewModel.setUserRole(userDetails.getUserRoleId());
////        return ResponseEntity.ok(userSignatureViewModel);
//    }
}
