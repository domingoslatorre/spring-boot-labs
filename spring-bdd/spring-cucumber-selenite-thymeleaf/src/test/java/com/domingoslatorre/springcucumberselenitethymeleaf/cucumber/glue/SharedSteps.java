package com.domingoslatorre.springcucumberselenitethymeleaf.cucumber.glue;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;
import org.springframework.boot.web.server.LocalServerPort;

public class SharedSteps {
    @LocalServerPort
    private int port;

    @Before("@regression")
    public void setUp() {
        Configuration.baseUrl = String.format("http://127.0.0.1:%d", port);
        Configuration.reportsFolder = "test-result/reports";
        Configuration.headless = true;
    }
}
