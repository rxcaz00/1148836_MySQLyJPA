package com.edu.appswbd.practica.cuatro.mysql.controllers;

import com.edu.appswbd.practica.cuatro.mysql.constant.ViewConstant;
import com.edu.appswbd.practica.cuatro.mysql.entity.Company;
import com.edu.appswbd.practica.cuatro.mysql.model.CompanyStatusModel;
import com.edu.appswbd.practica.cuatro.mysql.services.CompanyStatusService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/companyStatus")
public class CompanyStatusController {

    @Autowired
    @Qualifier("companyStatusImpl")
    private CompanyStatusService companyStatusService;

    private static final Log Log = LogFactory.getLog(CompanyStatusController.class);

    @GetMapping("/cancel")
    public String cancel() { return "redirect:/companyStatus/showCompanyStatus"; }

    @GetMapping("/companyStatusForm")
    public String redirectCompanyStatusForm(Model model, @RequestParam(name = "id", required = false) int id) {
        CompanyStatusModel companyStatusModel = new CompanyStatusModel();
        if(id != 0)
            companyStatusModel = companyStatusService.findCompanyStatusByIdModel(id);
        model.addAttribute("companyStatusModel", companyStatusModel);
        return ViewConstant.COMPANYSTATUS_FORM;
    }

    @PostMapping("/addcompanystatus")
    public String addCompanyStatus(@ModelAttribute(name = "companyStatusModel")CompanyStatusModel companyStatusModel, Model model) {
        Log.info("Method: addCompanyStatus() -- Params: " + companyStatusModel.toString());
        if(companyStatusService.addCompanyStatus(companyStatusModel) != null)
            model.addAttribute("result",1);
        else
            model.addAttribute("result",0);
        return "redirect:/companyStatus/showCompanyStatus";
    }

    @GetMapping("/showCompanyStatus")
    public ModelAndView showCompanyStatus() {
        ModelAndView mav = new ModelAndView(ViewConstant.COMPANYSTATUS);
        mav.addObject("companyStatus",companyStatusService.listAllCompanyStatus());
        return mav;
    }

    @GetMapping("/removeCompanyStatus")
    public ModelAndView removeCompanyStatus(@RequestParam(name = "id", required = true) int id) {
        companyStatusService.removeCompanyStatus(id);
        return showCompanyStatus();
    }
}
