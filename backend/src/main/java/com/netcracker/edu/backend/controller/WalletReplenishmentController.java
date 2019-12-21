package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.OrganisationEntity;
import com.netcracker.edu.backend.entity.WalletEntity;
import com.netcracker.edu.backend.service.WalletEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallet/")
public class WalletReplenishmentController {

    @Autowired
    private WalletEntityService walletEntityService;

    @RequestMapping(value = "replenishment", method = RequestMethod.POST)
    public WalletEntity balanceReplenishment(@RequestBody WalletEntity walletEntity){
        return walletEntityService.balanceReplenishment(walletEntity);
    }

    @RequestMapping(value = "replenishment/organisation/{idOrg}/balance/{balance}", method = RequestMethod.POST)
    public OrganisationEntity balanceReplenishmentByOrg(@PathVariable(name = "idOrg") int idOrg,
                                                        @PathVariable(name = "balance") int balance){
        return walletEntityService.balanceReplenishmentByIdOrg(idOrg, balance);
    }

}
