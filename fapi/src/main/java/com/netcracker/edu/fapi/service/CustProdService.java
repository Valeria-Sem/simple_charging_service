package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.CustProdModel;
import com.netcracker.edu.fapi.models.SubscriptionModel;

import java.util.List;

public interface CustProdService {
    List<CustProdModel> getCustomerSub(int idCust);
}
