package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.WalletModel;
import com.netcracker.edu.fapi.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @RequestMapping
    public ResponseEntity<List<WalletModel>> getAllProduct(){
        return ResponseEntity.ok(walletService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<WalletModel> saveWallet (@RequestBody WalletModel wallet){
        if(wallet != null) {
            return ResponseEntity.ok(walletService.saveWallet(wallet));
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteWallet(@PathVariable String id) {
        walletService.deleteWallet(Long.valueOf(id));
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<WalletModel> getWalletById(@PathVariable String id) throws InterruptedException {
        Long walletId = Long.valueOf(id);
        return ResponseEntity.ok(walletService.getWalletById(walletId));
    }
}
