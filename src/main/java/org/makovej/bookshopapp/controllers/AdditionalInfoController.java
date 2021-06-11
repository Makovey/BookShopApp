package org.makovej.bookshopapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdditionalInfoController {

    @GetMapping("/documents")
    public String getDocumentPage() {
        return "/additional/documents";
    }

    @GetMapping("/about")
    public String getAboutPage() {
        return "/additional/about";
    }

    @GetMapping("/contacts")
    public String getContactsPage() {
        return "/additional/contacts";
    }

    @GetMapping("/faq")
    public String getFaqPage() {
        return "/additional/faq";
    }

}
