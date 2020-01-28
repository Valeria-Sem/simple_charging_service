package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.CustProdModel;
import com.netcracker.edu.fapi.service.CustProdService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CustProdServiceImpl implements CustProdService {

    @Value("http://localhost:8080")
    private String backendServerUrl;

    @Override
    public List<CustProdModel> getCustomerSub(int idCust) {
        RestTemplate restTemplate = new RestTemplate();
        CustProdModel[] response = restTemplate.getForObject(backendServerUrl + "api/customerSub/customer/" + idCust, CustProdModel[].class);
        return response == null? Collections.emptyList() : Arrays.asList(response);
    }
}
