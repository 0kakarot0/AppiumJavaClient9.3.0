package tests_utils.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestStep {
    @JsonProperty("stepId")
    private String stepId;

    @JsonProperty("testName")
    private String testName;

    @JsonProperty("testInfo")
    private String testInfo;

    @JsonProperty("testDescription")
    private String testDescription;

    @JsonProperty("expectedResult")
    private String expectedResult;

    @JsonProperty("passResult")
    private String passResult;

    @JsonProperty("failResult")
    private String failResult;

    // Getters and Setters
    public String getStepId() { return stepId; }
    public void setStepId(String stepId) { this.stepId = stepId; }

    public String getTestName() { return testName; }
    public void setTestName(String testName) { this.testName = testName; }

    public String getTestInfo() { return testInfo; }
    public void setTestInfo(String testInfo) { this.testInfo = testInfo; }

    public String getTestDescription() { return testDescription; }
    public void setTestDescription(String testDescription) { this.testDescription = testDescription; }

    public String getExpectedResult() { return expectedResult; }
    public void setExpectedResult(String expectedResult) { this.expectedResult = expectedResult; }

    public String getPassResult() { return passResult; }
    public void setPassResult(String passResult) { this.passResult = passResult; }

    public String getFailResult() { return failResult; }
    public void setFailResult(String failResult) { this.failResult = failResult; }
}
