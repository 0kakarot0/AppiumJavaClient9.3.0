package tests_utils.file_reader;

import tests_utils.model.TestStepKey;
import tests_utils.model.UseCase;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String scenarioToFind = "Login into App using valid credentials";
        TestCaseReader testCaseReader = new TestCaseReader();
        try {
            FileReaderTest fileReaderTest = new FileReaderTest();
            UseCase useCase = testCaseReader.readJsonFromFile(fileReaderTest.getLoginTestCaseFilePath());

            // Example: Getting test steps for further processing
            List<Map<TestStepKey, String>> testSteps = testCaseReader.getTestStepsForScenario(useCase, scenarioToFind);
            if (testSteps != null) {
                for (Map<TestStepKey, String> stepDetails : testSteps) {
                    System.out.println(stepDetails.get(TestStepKey.STEP_ID));
                    System.out.println(stepDetails.get(TestStepKey.TEST_NAME));
                    System.out.println(stepDetails.get(TestStepKey.TEST_DESCRIPTION));
                    System.out.println(stepDetails.get(TestStepKey.TEST_INFO));
                    System.out.println(stepDetails.get(TestStepKey.EXPECTED_RESULT));
                    System.out.println(stepDetails.get(TestStepKey.PASS_RESULT));
                    System.out.println(stepDetails.get(TestStepKey.FAIL_RESULT));

//                    for (Map.Entry<TestStepKey, String> entry : stepDetails.entrySet()) {
//                        System.out.println(entry.getKey() + ": " + entry.getValue());
//                    }
                    System.out.println("----");
                }
            } else {
                System.out.println("Scenario not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
