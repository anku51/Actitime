package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Framework {

    public String property(String keys) throws IOException {
	FileInputStream fis = new FileInputStream(
		"D:\\NOTES\\JAVA\\SELENIUM\\Automation_Selenium\\TestData\\data.properties");
	Properties pro = new Properties();
	pro.load(fis);
	return pro.getProperty("url");

    }

}
