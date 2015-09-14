package com.incra.services;

import com.wepay.WePay;
import com.wepay.model.Account;
import com.wepay.model.Checkout;
import com.wepay.model.data.AccountFindData;
import com.wepay.model.data.CheckoutData;
import com.wepay.model.data.PMCreditCardData;
import com.wepay.model.data.PaymentMethodData;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;

/**
 * The <i>DonationService</i> handles the WePay integration
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
            // Get an instance of the API. It is threadsafe.
            WePay wepay = new WePay();
            wepay.initialize(87582L, "8f80d010ea", true);

            // get a token
            //OAuth2Data oData = new OAuth2Data();
            //oData.redirectUri = "http://www.justgive.org";
            //oData.code = "STAGE_8c1fdc7571ab99b7988a7c1bee71ee204147636d24227299e116c62e182d5342";
            String userAccessToken = "STAGE_8c1fdc7571ab99b7988a7c1bee71ee204147636d24227299e116c62e182d5342";
            //OAuth2.token(oData, null);

            AccountFindData afData = new AccountFindData();
            afData.name = "JustGive";
            Account[] foundList = Account.find(afData, userAccessToken);

            for (Account account : foundList) {
                System.out.println(account.getAccountId() + " " + account.getName());
            }

            Long accountId = 409908904L;
            Account foundAccount = Account.fetch(accountId, userAccessToken);
            System.out.println(foundAccount);
            if (foundAccount != null) System.out.println(foundAccount.getAccountId() + " " + foundAccount.getName());

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
            cData.autoCapture = Boolean.TRUE;
            PaymentMethodData paymentMethodData = new PaymentMethodData();
            paymentMethodData.type = "credit_card";
            paymentMethodData.creditCard = new PMCreditCardData();
            paymentMethodData.creditCard.id = creditCardId;
            cData.paymentMethod = paymentMethodData;
            Checkout myCheckout = Checkout.create(cData, userAccessToken);

            System.out.println("Got a checkout");
            System.out.println(myCheckout);
            System.out.println(myCheckout.getAmount());
            System.out.println(myCheckout.getPayerName());
            System.out.println(myCheckout.getState());
            System.out.println(myCheckout.getGross());
            System.out.println(myCheckout.getProcessingFee());
            System.out.println(myCheckout.isAutoCapture());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
