package com.nineleaps.bdd.stepDefs.displaycsv;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", glue = "classpath:com.nineleaps.bdd.stepDefs.displaycsv")
public class BddRunnerTest {
}
