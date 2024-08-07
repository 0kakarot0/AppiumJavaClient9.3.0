package tests_utils.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UseCase {
    @JsonProperty("useCaseName")
    private String useCaseName;

    @JsonProperty("useCaseDescription")
    private String useCaseDescription;

    @JsonProperty("scenarios")
    private List<Scenario> scenarios;

    // Getters and Setters
    public String getUseCaseName() {
        return useCaseName;
    }

    public void setUseCaseName(String useCaseName) {
        this.useCaseName = useCaseName;
    }

    public String getUseCaseDescription() {
        return useCaseDescription;
    }

    public void setUseCaseDescription(String useCaseDescription) {
        this.useCaseDescription = useCaseDescription;
    }

    public List<Scenario> getScenarios() {
        return scenarios;
    }

    public void setScenarios(List<Scenario> scenarios) {
        this.scenarios = scenarios;
    }
}