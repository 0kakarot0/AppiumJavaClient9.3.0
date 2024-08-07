package tests_base;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.options.BaseOptions;
import tests_utils.file_reader.DeviceConfig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class DeviceCapabilitiesManager {
    private static final String PROJECT_DIR = System.getProperty("user.dir");
    private static final String DEVICE_JSON = PROJECT_DIR + "/src/test/resources/DevicesData.json";

    public static BaseOptions getDeviceCapabilitiesOptions(String platform, String deviceName) throws FileNotFoundException {
        BaseOptions baseOptions = new BaseOptions<>();
        List<DeviceConfig.DeviceWrapper> deviceDataList = null;
        try {
            deviceDataList = getDeviceData(DEVICE_JSON);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DeviceConfig.Device device = null;

        for (DeviceConfig.DeviceWrapper deviceWrapper : deviceDataList) {
            if (deviceWrapper.getDevice().getDeviceName().equals(deviceName)) {
                device = deviceWrapper.getDevice();
                break;
            }
        }

        if (device == null) {
            throw new FileNotFoundException("Device not found: " + deviceName);
        }


        if (platform.equalsIgnoreCase("android")) {
            return getUiAutomator2Options(device);
        } else if (platform.equalsIgnoreCase("ios")) {
            return getXCUITestOptions(device);
        } else {
            return null;
        }
    }

    public static List<DeviceConfig.DeviceWrapper> getDeviceData(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filePath), new TypeReference<>() {
        });
    }

    private static UiAutomator2Options getUiAutomator2Options(DeviceConfig.Device device) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(device.getPlatformName());
        options.setPlatformVersion(device.getPlatformVersion());
        options.setAutomationName(device.getAutomationName());
        options.setUdid(device.getUdid());
        options.setApp(PROJECT_DIR + device.getApp());
        options.setDeviceName(device.getDeviceName());
        return options;
    }

    private static XCUITestOptions getXCUITestOptions(DeviceConfig.Device device) {
        XCUITestOptions options = new XCUITestOptions();
        options.setPlatformName(device.getPlatformName());
        options.setPlatformVersion(device.getPlatformVersion());
        options.setAutomationName(device.getAutomationName());
        options.setUdid(device.getUdid());
        options.setApp(PROJECT_DIR + device.getApp());
        options.setDeviceName(device.getDeviceName());
        options.noReset();
        options.setShouldTerminateApp(true);
        return options;
    }

//    private static UiAutomator2Options getAndroidOptions() {
//        UiAutomator2Options options = new UiAutomator2Options();
//        options.setPlatformName("Android");
//        options.setPlatformVersion("11");
//        options.setAutomationName("UiAutomator2");
//        options.setUdid("emulator-5554");
//        options.setApp(System.getProperty("user.home") + "/IdeaProjects/AppiumJavaClient9.3.0/app/app-release.apk");
//        options.setDeviceName("emulator");
//        return options;
//    }
//
//    private static XCUITestOptions getiOSOptions() {
//        XCUITestOptions options = new XCUITestOptions();
//        options.setPlatformName("iOS");
//        options.setPlatformVersion("17.2");
//        options.setAutomationName("XCUITest");
//        options.setApp(System.getProperty("user.home") + "/IdeaProjects/AppiumJavaClient9.3.0/app/Runner.app");
//        options.setDeviceName("iPhone 14");
//        options.noReset();
//        options.setShouldTerminateApp(true);
//        return options;
//    }
}
