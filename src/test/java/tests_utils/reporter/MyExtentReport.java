package tests_utils.reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.HashMap;
import java.util.Map;

public class MyExtentReport {
    private final ExtentReports extentReports;
    private ExtentSparkReporter extentSparkReporter;
    private ExtentTest extentTest;

    private Map<String, ExtentTest> parentTest = new HashMap<>();
    private Map<String, ExtentTest> childTest = new HashMap<>();
    private Map<String, ExtentTest> grandChildTest = new HashMap<>();

    public MyExtentReport() {
        extentReports = new ExtentReports();
    }

    public void initializeReporter() {
        extentSparkReporter = new ExtentSparkReporter("");
        extentReports.attachReporter(extentSparkReporter);
    }

    public void createParentTest(String parentTestName, String parentTestDescription) {
        ExtentTest parent = extentReports.createTest(parentTestName, parentTestDescription);
        parentTest.putIfAbsent(parentTestName, parent);
    }

    public void createChildTest(String parentTestName, String childTestName, String childTestDescription) {
        ExtentTest parent = parentTest.get(parentTestName);

        if (parent != null) {
            ExtentTest child = parent.createNode(childTestName, childTestDescription).assignDevice();
            childTest.putIfAbsent(childTestName, child);
        }
    }

    public void createGrandChildTest(String childTestName, String grandChildTestName, String grandChildTestDescription) {
        ExtentTest child = childTest.get(childTestName);
        if (child != null) {
            ExtentTest grandChild = child.createNode(grandChildTestName, grandChildTestDescription).assignCategory(childTestName);
            grandChildTest.putIfAbsent(grandChildTestName, grandChild);
        }
    }

    public void logStepResult(String actualResult) {
        if (actualResult.equalsIgnoreCase("Pass")) {
            extentTest.pass(actualResult);
        } else if (actualResult.equalsIgnoreCase("Fail")) {
            extentTest.fail(actualResult);
        } else if (actualResult.equalsIgnoreCase("Skip")) {
            extentTest.fail(actualResult);
        } else {
            extentTest.info(actualResult);
        }
    }

    public void flush() {
        extentReports.flush();
    }
}
