package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.transferOfObjects.CustomerProductModel;

public interface CustomerProductService {
    CustomerProductModel getProductsByCustomer(int id);
}
