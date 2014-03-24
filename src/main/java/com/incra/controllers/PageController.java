package com.incra.controllers;

import com.incra.models.Box;
import com.incra.models.Rubric;
import com.incra.models.Site;
import com.incra.services.BoxService;
import com.incra.services.RubricService;
import com.incra.services.SiteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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
public class PageController {
    protected static Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private SiteService siteService;
    @Autowired
    private BoxService boxService;
    @Autowired
    private RubricService rubricService;

    public PageController() {
    }

    /**
     * custom page
     */
    @RequestMapping(value = "/page/{id}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable int id, Model model, HttpSession session) {

        Site site = siteService.findEntityById(id);
        List<Box> boxes = boxService.findEntityListBySite(site);

        Map<Integer, List<Rubric>> pageData = new HashMap<Integer, List<Rubric>>();

        for (Box box : boxes) {
            List<Rubric> rubrics = rubricService.findEntityListByBox(box);
            pageData.put(box.getSeqNum(), rubrics);
        }
        ModelAndView modelAndView = new ModelAndView("page/index");
        modelAndView.addObject("site", site);
        modelAndView.addObject("box1", pageData.get(1));
        modelAndView.addObject("box2", pageData.get(2));
        modelAndView.addObject("box3", pageData.get(3));

        return modelAndView;
    }
}