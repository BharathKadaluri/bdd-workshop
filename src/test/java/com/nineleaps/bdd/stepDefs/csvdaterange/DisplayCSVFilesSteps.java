package com.nineleaps.bdd.stepDefs.csvdaterange;

import com.nineleaps.bdd.controllers.ProductCsvUploadController;
import com.nineleaps.bdd.exceptions.InvalidFileException;
import com.nineleaps.bdd.exceptions.InvalidPathException;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import java.util.List;

@SpringBootTest
public class DisplayCSVFilesSteps {
    private static final String file_name = "products.csv";
    @Autowired
    ProductCsvUploadController csvUploadController;

    @Before
    public void init(){

    }

    @When("I enter the path for CSV files")
    public void iEnterThePathForCSVFiles() {
        MockMultipartFile file1 = new MockMultipartFile("file", "product.csv",
                "txt/plain", "abcedef".getBytes());
        csvUploadController.uploadCSVFile(file1);
    }

    @Then("I should able to see all the CSV files in the path")
    public void iShouldAbleToSeeAllTheCSVFilesInThePath() {
        List<String> files = csvUploadController.getFiles().getFiles();
        Assertions.assertThat(files.size()).isEqualTo(1);
        Assertions.assertThat(files.get(0)).isEqualTo("product.csv");
    }

    @When("I enter the path for CSV files which doesn’t contain any CSV files")
    public void iEnterThePathForCSVFilesWhichDoesnTContainAnyCSVFiles() {
        csvUploadController.deleteFiles();
        List<String> files = csvUploadController.getFiles().getFiles();
        Assertions.assertThat(files.size()).isEqualTo(0);
    }

    @Then("I should get a message that the entered path has no CSV files")
    public void iShouldGetAMessageThatTheEnteredPathHasNoCSVFiles() {

        Assertions.assertThatExceptionOfType(InvalidFileException.class).isThrownBy(() -> {
            MockMultipartFile file1 = new MockMultipartFile("file", "product.pdf",
                    "txt/plain", "abcedef".getBytes());
            csvUploadController.uploadCSVFile(file1);
        }).withMessage("the entered path has no CSV files");
    }

    @When("I enter wrong path")
    public void iEnterWrongPath() {
        MockMultipartFile file1 = new MockMultipartFile("file", "WRONG_PATH",
                "txt/plain", "abcedef".getBytes());
    }

    @Then("I should get a message that the entered path is wrong")
    public void iShouldGetAMessageThatTheEnteredPathIsWrong() {
        Assertions.assertThatExceptionOfType(InvalidPathException.class).isThrownBy(() -> {
            MockMultipartFile file1 = new MockMultipartFile("file", "WRONG_PATH",
                    "txt/plain", "abcedef".getBytes());
            csvUploadController.uploadCSVFile(file1);
        }).withMessage("the entered path is invalid");
    }
}
