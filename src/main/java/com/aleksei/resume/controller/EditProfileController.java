package com.aleksei.resume.controller;

import com.aleksei.resume.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EditProfileController {

    @Autowired
    private NameService nameService;

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getError() {
        return "edit";
    }
}
