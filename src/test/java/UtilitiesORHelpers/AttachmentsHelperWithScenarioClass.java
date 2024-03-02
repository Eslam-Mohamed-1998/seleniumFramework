package UtilitiesORHelpers;

import io.cucumber.java.Scenario;

public class AttachmentsHelperWithScenarioClass {
	private static Scenario scenario;

    public static void setScenario(Scenario scenario) {
    	
    	AttachmentsHelperWithScenarioClass.scenario = scenario ;
    }
}
