//package com.netcracker.edu.backend.timetable;
//
//import com.netcracker.edu.backend.entity.SubscriptionEntity;
//import com.netcracker.edu.backend.service.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import java.util.List;
//
//@Configuration
//@EnableScheduling
//public class ScheduledPayment {
//    private WalletEntityService walletEntityService;
//    private OrganisationEntityService organisationEntityService;
//    private ProductEntityService productEntityService;
//    private CustomerEntityService customerEntityService;
//    private SubscriptionEntityService subscriptionEntityService;
//
//    @Autowired
//    public ScheduledPayment(WalletEntityService walletEntityService, OrganisationEntityService organisationEntityService,
//                            ProductEntityService productEntityService, CustomerEntityService customerEntityService,
//                            SubscriptionEntityService subscriptionEntityService) {
//        this.walletEntityService = walletEntityService;
//        this.organisationEntityService = organisationEntityService;
//        this.productEntityService = productEntityService;
//        this.customerEntityService = customerEntityService;
//        this.subscriptionEntityService = subscriptionEntityService;
//    }
//
//    @Scheduled(cron = "0 15 10 15 * ?")
//    @Scheduled(fixedRate = 1000)
//    public void scheduledDebiting() {
//        List<SubscriptionEntity> subscription = subscriptionEntityService.
//
//
//    }
//}
