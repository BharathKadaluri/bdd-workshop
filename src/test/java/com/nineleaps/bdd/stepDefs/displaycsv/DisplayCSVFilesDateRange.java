package com.nineleaps.bdd.stepDefs.displaycsv;

import cucumber.api.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DisplayCSVFilesDateRange {
    @Given("I enter a date range")
    public void iEnterADateRange() {
        throw new PendingException();
    }

    @When("I press List CSV file button")
    public void iPressListCSVFileButton() {
    }

    @Then("All CSV Files loaded during the selected period should be displayed")
    public void allCSVFilesLoadedDuringTheSelectedPeriodShouldBeDisplayed() {
    }

    @Given("I enter a date range \\(where no CSV files loaded)")
    public void iEnterADateRangeWhereNoCSVFilesLoaded() {
    }

    @Then("“No CSV files loaded for the selected range” to be displayed")
    public void noCSVFilesLoadedForTheSelectedRangeToBeDisplayed() {
    }

    @When("I press List Products button")
    public void iPressListProductsButton() {
    }

    @Then("All Products loaded during the selected period should be displayed")
    public void allProductsLoadedDuringTheSelectedPeriodShouldBeDisplayed() {
    }

    @Then("“No Products loaded for the selected range” to be displayed")
    public void noProductsLoadedForTheSelectedRangeToBeDisplayed() {
    }
}
