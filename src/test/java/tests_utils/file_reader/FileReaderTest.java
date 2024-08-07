package tests_utils.file_reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Properties;

public class FileReaderTest {
    private static final String FILE_PATHS = "src/test/resources/file_paths.properties";
    private  final Properties FILEPATHPROPERTIES;

    public FileReaderTest() {
        FILEPATHPROPERTIES = loadFile(FILE_PATHS);
    }

    private Properties loadFile(String filePath) {
        Properties tempProperty = new Properties();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            if (reader.readLine() != null) {
                 tempProperty.load(reader);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return tempProperty;
    }


    public String getLoginTestCaseFilePath(){
        return (String) FILEPATHPROPERTIES.get("login_test_case_file_path");
    }
}
