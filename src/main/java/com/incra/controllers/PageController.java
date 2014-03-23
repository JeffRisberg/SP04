package com.incra.controllers;

import com.incra.models.Site;
import com.incra.services.SiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * The <i>PageController</i> controller
 *
 * @author Jeffrey Risberg
 * @since February 214
 */
@Controller
public class PageController {
    protected static Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private SiteService siteService;

    public PageController() {
    }

    /**
     * custom page
     */
    @RequestMapping(value = "/page/**")
    public ModelAndView index(@PathVariable("siteId") int siteId) {

        Site site = siteService.findEntityById(siteId);

        ModelAndView modelAndView = new ModelAndView("page/index");
        modelAndView.addObject("site", site);

        return modelAndView;
    }
}