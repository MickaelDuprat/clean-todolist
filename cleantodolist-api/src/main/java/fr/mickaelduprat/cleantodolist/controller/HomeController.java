package fr.mickaelduprat.cleantodolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@RestController
public class HomeController {

    private final BuildProperties buildProperties;

    @Autowired
    public HomeController(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    @GetMapping(value = "/", produces = "text/plain")
    public String home() {
        Date buildTime = new Date();
        return "API Todolist en version : " + buildProperties.getVersion() +
                "\nDate du dernier build : " + new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.FRENCH).format(buildTime);
    }
}