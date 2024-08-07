package tests_utils;

import tests_utils.file_reader.FileReaderTest;
import tests_utils.file_reader.TestCaseReader;
import tests_utils.model.UseCase;
import tests_utils.reporter.MyExtentReport;

import java.io.IOException;

public class LogTestResults {

    public void setParentTestName(String filePath){

    }

    public static void main(String[] args) throws IOException {
        String scenarioToFind = "Login into App using valid credentials";
        TestCaseReader testCaseReader = new TestCaseReader();
        FileReaderTest fileReaderTest = new FileReaderTest();
        UseCase useCase = testCaseReader.readJsonFromFile(fileReaderTest.getLoginTestCaseFilePath());
        System.out.println(useCase.getUseCaseName());
        System.out.println(useCase.getUseCaseDescription());
        MyExtentReport extentReport = new MyExtentReport();
        extentReport.initializeReporter();
        extentReport.createParentTest(useCase.getUseCaseName(), useCase.getUseCaseDescription());
        extentReport.flush();
    }
}
