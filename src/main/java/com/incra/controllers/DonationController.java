package com.incra.controllers;

import com.incra.models.Box;
import com.incra.models.DonationValue;
import com.incra.models.Rubric;
import com.incra.models.Site;
import com.incra.services.BoxService;
import com.incra.services.DonationService;
import com.incra.services.RubricService;
import com.incra.services.SiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The <i>PageController</i> controller
 *
 * @author Jeffrey Risberg
 * @since February 214
 */
@Controller
public class DonationController {
    protected static Logger logger = LoggerFactory.getLogger(DonationController.class);

    @Autowired
    private DonationService donationService;

    public DonationController() {
    }

    /**
     * Ask for donation
     */
    @RequestMapping(value = "/donation", method = RequestMethod.GET)
    public ModelAndView index() {

        ModelAndView modelAndView = new ModelAndView("donation/index");
        //modelAndView.addObject("site", site);
        //modelAndView.addObject("rowList", rowList);

        return modelAndView;
    }

    /**
     * process donation
     */
    @RequestMapping(value = "/donation", method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    public ModelAndView process(@RequestBody DonationValue donation) {
        ModelAndView modelAndView = new ModelAndView("donation/index");

        System.out.println("process starting");

        Long creditCardId = donation.getCreditCardId();
        Float amount = donation.getAmount();

        System.out.println(" about to process " + amount + " on " + creditCardId);

        donationService.makeDonation(creditCardId, amount);

        return modelAndView;
    }
}