package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.WalletModel;
import com.netcracker.edu.fapi.service.WalletService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class WalletServiceImp implements WalletService {

    @Value("http://localhost:8080")
    private String backendServerUrl;

    @Override
    public List<WalletModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        WalletModel[] walletResponse = restTemplate.getForObject(backendServerUrl + "/api/wallet", WalletModel[].class);
        return walletResponse == null? Collections.emptyList() : Arrays.asList(walletResponse);
    }

    @Override
    public WalletModel getWalletById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/wallet/" + id, WalletModel.class);
    }

    @Override
    public WalletModel saveWallet(WalletModel wallet) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/wallet", wallet, WalletModel.class).getBody();
    }

    @Override
    public WalletModel payment(WalletModel wallet) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/wallet/payment", wallet, WalletModel.class).getBody();
    }

    @Override
    public WalletModel balanceReplenishment(WalletModel wallet) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/wallet/replenishment", wallet, WalletModel.class).getBody();
    }

    @Override
    public void deleteWallet(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/wallet/delete/" + id);
    }
}
