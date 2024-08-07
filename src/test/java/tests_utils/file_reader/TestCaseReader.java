package tests_utils.file_reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import tests_utils.model.Scenario;
import tests_utils.model.TestStep;
import tests_utils.model.TestStepKey;
import tests_utils.model.UseCase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCaseReader {
    private final ObjectMapper objectMapper = new ObjectMapper();


    public UseCase readJsonFromFile(String FILE_PATH) throws IOException {
        return objectMapper.readValue(new File(FILE_PATH), UseCase.class);

    }

    public void printUseCaseDetails(UseCase useCase, String scenarios) {
        System.out.println("Use Case Name: " + useCase.getUseCaseName());
//        for (Scenario scenario : useCase.getScenarios()) {
//            if (scenario.getScenarioName().equalsIgnoreCase(scenarios)) {
//                System.out.println("Scenario Name: " + scenario.getScenarioName());
//                for (TestStep step : scenario.getTestSteps()) {
//                    System.out.println("Step ID: " + step.getStepId());
//                    System.out.println("Test Name: " + step.getTestName());
//                    System.out.println("Test Description: " + step.getTestDescription());
//                    // Print other fields as needed
//                }
//            } else {
//                System.out.println("Scenario not found");
//            }
//        }
    }

    public List<Map<TestStepKey, String>> getTestStepsForScenario(UseCase useCase, String scenarioName) {
        for (Scenario scenario : useCase.getScenarios()) {
            if (scenario.getScenarioName().equalsIgnoreCase(scenarioName)) {
                List<Map<TestStepKey, String>> stepDetailsList = new ArrayList<>();
                for (TestStep step : scenario.getTestSteps()) {
                    Map<TestStepKey, String> stepDetails = new HashMap<>();
                    stepDetails.put(TestStepKey.STEP_ID, step.getStepId());
                    stepDetails.put(TestStepKey.TEST_NAME, step.getTestName());
                    stepDetails.put(TestStepKey.TEST_INFO, step.getTestInfo());
                    stepDetails.put(TestStepKey.TEST_DESCRIPTION, step.getTestDescription());
                    stepDetails.put(TestStepKey.EXPECTED_RESULT, step.getExpectedResult());
                    stepDetails.put(TestStepKey.PASS_RESULT, step.getPassResult());
                    stepDetails.put(TestStepKey.FAIL_RESULT, step.getFailResult());
                    stepDetailsList.add(stepDetails);
                }
                return stepDetailsList;
            }
        }
        return null; // or throw an exception if the scenario is not found
    }
}