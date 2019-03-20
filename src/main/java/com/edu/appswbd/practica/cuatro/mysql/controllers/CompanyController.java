package com.edu.appswbd.practica.cuatro.mysql.controllers;

import com.edu.appswbd.practica.cuatro.mysql.constant.ViewConstant;
import com.edu.appswbd.practica.cuatro.mysql.model.CompanyModel;
import com.edu.appswbd.practica.cuatro.mysql.services.CompanyService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    @Qualifier("companyServiceImpl")
    private CompanyService companyService;

    private static final Log Log = LogFactory.getLog(CompanyController.class);

    @GetMapping("/cancel")
    public String cancel() { return "redirect:/companies/showCompanies"; }

    @GetMapping("/companyForm")
    public String redirectCompanyForm(Model model, @RequestParam(name = "id", required = false) int id) {
        CompanyModel companyModel = new CompanyModel();
        if(id != 0)
            companyModel = companyService.findCompanyByIdModel(id);
        model.addAttribute("companyModel",companyModel);
        return ViewConstant.COMPANY_FORM;
    }

    @PostMapping("/addcompany")
    public String addCompany(@ModelAttribute(name = "companyModel")CompanyModel companyModel, Model model) {
        Log.info("Method: addCompany() -- Params: " + companyModel.toString());
        if(companyService.addCompany(companyModel) != null)
            model.addAttribute("result",1);
        else
            model.addAttribute("result",0);
        return "redirect:/companies/showCompanies";
    }

    @GetMapping("/showCompanies")
    public ModelAndView showCompanies() {
        ModelAndView mav = new ModelAndView(ViewConstant.COMPANIES);
        mav.addObject("companies",companyService.listAllCompanies());
        return mav;
    }

    @GetMapping("/removeCompany")
    public ModelAndView removeCompany(@RequestParam(name = "id", required = true) int id) {
        companyService.removeCompany(id);
        return showCompanies();
    }
}
