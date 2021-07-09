package com.domingoslatorre.springcucumberselenitethymeleaf.cucumber;

import com.domingoslatorre.springcucumberselenitethymeleaf.App;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@CucumberOptions(
  plugin = {"pretty"},
  tags = "",
  features = "src/test/resources/features"
)
@SpringBootTest(
  classes = {App.class, AppCucumberIntegrationTests.class},
  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class AppCucumberIntegrationTests {
}
