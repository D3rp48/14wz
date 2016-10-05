package com.fcat.web.controller;

import com.fcat.service.TestOnlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    @Autowired
    TestOnlyService service;

    @RequestMapping("/editor")
    public String getPage() {
        return "editor";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String index(Model model) {
        return "fragments/_imgupload";
    }

    @RequestMapping(value = "/types", method = RequestMethod.GET)
    public String groups(Model model) {
        return "fragments/_groupsedit";
    }

    @RequestMapping(value = "/generate", method = RequestMethod.GET)
    public String generate(Model model) {
        service.generate();
        return "fragments/_groupsedit";
    }


}
