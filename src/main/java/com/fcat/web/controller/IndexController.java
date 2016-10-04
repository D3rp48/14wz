package com.fcat.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    @RequestMapping("/editor")
    public String getPage() {
        return "editor";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String index(Model model) {
        return "fragments/_imgupload";
    }
}
