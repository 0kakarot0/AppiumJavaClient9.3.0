package utilities;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.NoSuchElementException;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class LocatorStore {
    private ObjectMapper mapper;
    private JsonNode root;
    private String LOCATOR_OBJECT_REPO;

    public LocatorStore() {
        readJsonFile();
    }

    public String getLocator(String platform, String screen, String element, LocatorType locatorType) {
        JsonNode platformNode = root.get(getPlatformName(platform));
        if (platformNode == null) {
            throw new NoSuchElementException("No locators for platform " + platform);
        }
        JsonNode screenNode = platformNode.get(screen);
        if (screenNode == null) {
            throw new NoSuchElementException("No locators for screen " + screen + " on " + platform);
        }
        JsonNode elementNode = screenNode.get(element);
        if (elementNode == null) {
            throw new NoSuchElementException("No locator for " + element + " on " + screen + " on " + platform);
        }
        String locatorKey = getLocatorKey(locatorType);
        JsonNode locatorValue = elementNode.get(locatorKey);
        return Optional.ofNullable(locatorValue).filter(JsonNode::isTextual).map(JsonNode::asText).orElseThrow(() -> new NoSuchElementException("No locator value for " + element + " with type " + locatorType));
    }

    private String getPlatformName(String platformName) {
        if (platformName.equalsIgnoreCase("Android")) {
            return Platform.ANDROID.name().toLowerCase();
        } else if (platformName.equalsIgnoreCase("iOS")) {
            return Platform.IOS.name().toLowerCase();
        } else {
            return null;
        }

    }

    private String getLocatorKey(LocatorType type) {
        return type.name().toLowerCase();
    }

    private void readJsonFile() {
        LOCATOR_OBJECT_REPO = System.getProperty("user.dir") + "/src/main/resources/LocatorObjectRepo.json";
        try {
            mapper = new ObjectMapper();
            mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true); // Enable comments
            root = mapper.readTree(new File(LOCATOR_OBJECT_REPO));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public enum Platform {
        ANDROID, IOS
    }

    public enum LocatorType {
        ACCESSIBILITYID, XPATH
    }
}
