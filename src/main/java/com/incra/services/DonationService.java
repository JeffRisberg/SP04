package com.incra.services;

import com.wepay.WePay;
import com.wepay.model.Account;
import com.wepay.model.Checkout;
import com.wepay.model.OAuth2;
import com.wepay.model.data.AccountFindData;
import com.wepay.model.data.CheckoutData;
import com.wepay.model.data.OAuth2Data;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;

/**
 * The <i>DonationService</i> handles the JPA-based updating of Site entities.
 *
 * @author Jeffrey Risberg
 * @since September 2015
 */
@Transactional
@Repository
public class DonationService {

    @PersistenceContext
    private EntityManager em;

    public void initialize() {

    }

    public void makeDonation(Long creditCardId, Float amount) {
        System.out.println("making a donation of " + amount + " on credit card " + creditCardId);

        try {
            // initialize the connection

            // Get an instance of the API. It is threadsafe.
            WePay wepay = new WePay();
            wepay.initialize(87582L, "8f80d010ea", true);

            // authorize us
            //OAuth2.authorize()

            // get a token
            //OAuth2Data oData = new OAuth2Data();
            //oData.redirectUri = "http://www.justgive.org";
            //oData.code = "STAGE_8c1fdc7571ab99b7988a7c1bee71ee204147636d24227299e116c62e182d5342";
            String userAccessToken = "STAGE_8c1fdc7571ab99b7988a7c1bee71ee204147636d24227299e116c62e182d5342";
            //OAuth2.token(oData, null);

            AccountFindData afData = new AccountFindData();
            afData.name = "JustGive";
            Account[] foundList = Account.find(afData, userAccessToken);

            System.out.println(foundList);
            for (Account account : foundList) {
                System.out.println(account.getAccountId() + " " + account.getName());
            }

            Long accountId = 409908904L;
            Account foundAccount = Account.fetch(accountId, userAccessToken);
            System.out.println(foundAccount);
            System.out.println(foundAccount.getName());


            AccountFindData afData2 = new AccountFindData();
            afData2.name = "Andrea Lloyd";
            Account[] foundList2 = Account.find(afData2, userAccessToken);
            for (Account account : foundList2) {
                System.out.println(account.getAccountId() + " " + account.getName());
            }

            CheckoutData cData = new CheckoutData();
            cData.accountId = 409908904L;
            cData.shortDescription = "National Wildlife Federation";
            cData.type = "donation";
            cData.amount = new BigDecimal(amount);
            cData.currency = "USD";
            cData.fundingSources = "cc";
            cData.paymentMethodType = "credit_card";
            cData.paymentMethodId = creditCardId;
            Checkout myCheckout = Checkout.create(cData, userAccessToken);

            System.out.println(myCheckout);
            System.out.println(myCheckout.getAmount());
            System.out.println(myCheckout.getPayerName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
