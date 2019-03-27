package com.edu.appswbd.practica.cuatro.mysql.controllers;

import com.edu.appswbd.practica.cuatro.mysql.constant.ViewConstant;
import com.edu.appswbd.practica.cuatro.mysql.model.ContactDetailModel;
import com.edu.appswbd.practica.cuatro.mysql.services.ContactDetailService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contactDetails")
public class ContactDetailController {

    @Autowired
    @Qualifier("contactDetailServiceImpl")
    private ContactDetailService contactDetailService;

    private static final Log Log = LogFactory.getLog(ContactDetailController.class);

    @GetMapping("/cancel")
    public String cancel() { return "redirect:/contactDetails/showContactDetails"; }

    @GetMapping("/contactDetailForm")
    public String redirectContactDetailForm(Model model, @RequestParam(name = "id", required = false) int id) {
        ContactDetailModel contactDetailModel = new ContactDetailModel();
        if(id != 0)
            contactDetailModel = contactDetailService.findContactDetailByIdModel(id);
        model.addAttribute("contactDetailModel", contactDetailModel);
        return ViewConstant.CONTACTDETAIL_FORM;
    }

    @PostMapping("/addcontactdetail")
    public String addContactDetail(@ModelAttribute(name = "contactDetailModel") ContactDetailModel contactDetailModel, Model model) throws Exception {
        Log.info("Method:addContactDetail() -- Params: "+ contactDetailModel.toString());
        if(contactDetailService.addContactDetail(contactDetailModel) != null)
            model.addAttribute("result", 1);
        else
            model.addAttribute("result", 0);
        return "redirect:/contactDetails/showContactDetails";
    }

    @GetMapping("/showContactDetails")
    public ModelAndView showContactDetails() {
        ModelAndView mav = new ModelAndView(ViewConstant.CONTACTDETAILS);
        mav.addObject("contactDetails",contactDetailService.listAllContactDetails());
        return mav;
    }

    @GetMapping("/removeContactDetail")
    public ModelAndView removeContactDetail(@RequestParam(name = "id", required = true) int id) {
        contactDetailService.removeContactDetail(id);
        return showContactDetails();
    }
}
