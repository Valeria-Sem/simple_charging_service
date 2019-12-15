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

    @RequestMapping(value = "/replenishment",method = RequestMethod.POST)
    public ResponseEntity<WalletModel> balanceReplenishment (@RequestBody WalletModel wallet){
        if(wallet != null) {
            return ResponseEntity.ok(walletService.balanceReplenishment(wallet));
        }
        return null;
    }

    @RequestMapping(value = "/delete/{idDelete}", method = RequestMethod.DELETE)
    public void deleteWallet(@PathVariable String idDelete) {
        walletService.deleteWallet(Long.valueOf(idDelete));
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<WalletModel> getWalletById(@PathVariable String id) throws InterruptedException {
        Long walletId = Long.valueOf(id);
        return ResponseEntity.ok(walletService.getWalletById(walletId));
    }
}
