package com.netcracker.edu.backend.timetable;

import com.netcracker.edu.backend.entity.*;
import com.netcracker.edu.backend.entity.enums.SubStatus;
import com.netcracker.edu.backend.entity.enums.WalletStatus;
import com.netcracker.edu.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
@EnableScheduling
public class ScheduledPayment {
    private WalletEntityService walletEntityService;
    private OrganisationEntityService organisationEntityService;
    private ProductEntityService productEntityService;
    private CustomerEntityService customerEntityService;
    private SubscriptionEntityService subscriptionEntityService;

    @Autowired
    public ScheduledPayment(WalletEntityService walletEntityService, OrganisationEntityService organisationEntityService,
                            ProductEntityService productEntityService, CustomerEntityService customerEntityService,
                            SubscriptionEntityService subscriptionEntityService) {
        this.walletEntityService = walletEntityService;
        this.organisationEntityService = organisationEntityService;
        this.productEntityService = productEntityService;
        this.customerEntityService = customerEntityService;
        this.subscriptionEntityService = subscriptionEntityService;
    }

    @Scheduled(cron = "0 15 10 ? * *")
//    @Scheduled(fixedRate = 10000)
    public void scheduledDebiting() {
        List<SubscriptionEntity> subscription = subscriptionEntityService.getAllSubs();
        for (SubscriptionEntity sub: subscription){
            CustomerEntity customer = customerEntityService.getCustomerById(
                    sub.getCustomerByIdCustomers().getIdCustomer());
            ProductEntity product = productEntityService.getProductById(
                    sub.getProductByIdProduct().getIdProduct());
            OrganisationEntity organisation = organisationEntityService.getOrganisationByIdOrganisation(
                    product.getIdOrganisation());
            WalletEntity customerWallet = walletEntityService.getWalletById(
                    customer.getWalletByIdWallet().getIdWallet()).get();
            WalletEntity organisationWallet = walletEntityService.getWalletById(
                    organisation.getWalletByIdWallet().getIdWallet()).get();

            if(customerWallet.getBalance() - product.getMonthPrise() > 0) {
                customerWallet.setBalance(customerWallet.getBalance() - product.getMonthPrise());
                customerWallet.setWalletStatus(WalletStatus.ACTIVE);
                walletEntityService.payment(customerWallet);

                organisationWallet.setBalance(organisationWallet.getBalance() + product.getMonthPrise());
                organisationWallet.setWalletStatus(WalletStatus.ACTIVE);
                walletEntityService.balanceReplenishment(organisationWallet);

                sub.setSubscriptionStatus(SubStatus.ACTIVE);
                subscriptionEntityService.saveSub(sub);

//                System.out.println("sub active! " + customer.getName() +
//                        "buy sub " + product.getName() + " and pay " +
//                        product.getMonthPrise() + " to " + organisation.getName());


            } else {
                customerWallet.setWalletStatus(WalletStatus.FROZEN);
                walletEntityService.saveWallet(customerWallet);

                sub.setSubscriptionStatus(SubStatus.FROZEN);
                subscriptionEntityService.saveSub(sub);

//                System.out.println("sub FROZEN!");
            }
        }

    }
}
