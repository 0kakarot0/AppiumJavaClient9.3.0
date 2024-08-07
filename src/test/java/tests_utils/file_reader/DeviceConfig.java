package tests_utils.file_reader;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DeviceConfig {

    public static class Device {
        private String udid;
        private String deviceName;
        private String platformName;
        private String automationName;
        private String platformVersion;
        private String autoGrantPermissions;
        private String app;

        // Getters and setters
        public String getUdid() {
            return udid;
        }

        public void setUdid(String udid) {
            this.udid = udid;
        }

        public String getDeviceName() {
            return deviceName;
        }

        public void setDeviceName(String deviceName) {
            this.deviceName = deviceName;
        }

        public String getPlatformName() {
            return platformName;
        }

        public void setPlatformName(String platformName) {
            this.platformName = platformName;
        }

        public String getAutomationName() {
            return automationName;
        }

        public void setAutomationName(String automationName) {
            this.automationName = automationName;
        }

        public String getPlatformVersion() {
            return platformVersion;
        }

        public void setPlatformVersion(String platformVersion) {
            this.platformVersion = platformVersion;
        }

        public String getAutoGrantPermissions() {
            return autoGrantPermissions;
        }

        public void setAutoGrantPermissions(String autoGrantPermissions) {
            this.autoGrantPermissions = autoGrantPermissions;
        }

        public String getApp() {
            return app;
        }

        public void setApp(String app) {
            this.app = app;
        }
    }

    public static class DeviceWrapper {
        @JsonProperty("device")
        private Device device;

        public Device getDevice() {
            return device;
        }

        public void setDevice(Device device) {
            this.device = device;
        }
    }

    private List<DeviceWrapper> devices;

    public List<DeviceWrapper> getDevices() {
        return devices;
    }

    public void setDevices(List<DeviceWrapper> devices) {
        this.devices = devices;
    }
}