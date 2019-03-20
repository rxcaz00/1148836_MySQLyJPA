package com.edu.appswbd.practica.cuatro.mysql.controllers;

import com.edu.appswbd.practica.cuatro.mysql.constant.ViewConstant;
import com.edu.appswbd.practica.cuatro.mysql.model.CompanyDetailModel;
import com.edu.appswbd.practica.cuatro.mysql.services.CompanyDetailService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/companyDetails")
public class CompanyDetailController {

    @Autowired
    @Qualifier("companyDetailServiceImpl")
    private CompanyDetailService companyDetailService;

    private static final Log Log = LogFactory.getLog(CompanyDetailController.class);

    @GetMapping("/cancel")
    public String cancel() { return "redirect:/companyDetails/showCompanyDetails"; }

    @GetMapping("/companyDetailForm")
    public String redirectCompanyDetailForm(Model model, @RequestParam(name = "id", required = false) int id) {
        CompanyDetailModel companyDetailModel = new CompanyDetailModel();
        if(id != 0)
            companyDetailModel = companyDetailService.findCompanyDetailByIdModel(id);
        model.addAttribute("companyDetailModel",companyDetailModel);
        return ViewConstant.COMPANYDETAIL_FORM;
    }

    @PostMapping("/addcompanydetail")
    public String addCompanyDetail(@ModelAttribute(name = "companyDetailModel")CompanyDetailModel companyDetailModel, Model model) {
        Log.info("Method: addCompanyDetail() -- Params: " + companyDetailModel.toString());
        if(companyDetailService.addCompanyDetail(companyDetailModel) != null)
            model.addAttribute("result",1);
        else
            model.addAttribute("result",0);
        return "redirect:/companyDetails/showCompanyDetails";
    }

    @GetMapping("/showCompanyDetails")
    public ModelAndView showCompanyDetails() {
        ModelAndView mav = new ModelAndView(ViewConstant.COMPANYDETAILS);
        mav.addObject("companyDetails",companyDetailService.listAllCompanyDetails());
        return mav;
    }

    @GetMapping("/removeCompanyDetail")
    public ModelAndView removeCompanyDetail(@RequestParam(name = "id", required = true) int id) {
        companyDetailService.removeCompanyDetail(id);
        return showCompanyDetails();
    }
}
