package tests_utils.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Scenario {
    @JsonProperty("scenarioName")
    private String scenarioName;

    @JsonProperty("scenarioDescription")
    private String scenarioDescription;

    @JsonProperty("testSteps")
    private List<TestStep> testSteps;

    // Getters and Setters
    public String getScenarioName() { return scenarioName; }
    public void setScenarioName(String scenarioName) { this.scenarioName = scenarioName; }

    public String getScenarioDescription() { return scenarioDescription; }
    public void setScenarioDescription(String scenarioDescription) { this.scenarioDescription = scenarioDescription; }

    public List<TestStep> getTestSteps() { return testSteps; }
    public void setTestSteps(List<TestStep> testSteps) { this.testSteps = testSteps; }
}

