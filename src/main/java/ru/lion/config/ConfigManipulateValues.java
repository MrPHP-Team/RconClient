package ru.lion.config;

import ru.lion.color.Color;

import java.io.*;
import java.util.Date;
import java.util.Properties;

public class ConfigManipulateValues {

    private Properties prop;
    private InputStream inputStream;
    private String ip;
    private String port;
    private String password;
    private String path = System.getProperty("user.home");
    private PrintWriter writer = new PrintWriter("config.properties", "UTF-8");

    public ConfigManipulateValues() throws IOException {

        try {
            prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {

                prop.load(inputStream);

            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            Date time = new Date(System.currentTimeMillis());

            // get the property value and print it out
            ip = prop.getProperty("ip");
            port = prop.getProperty("port");
            password = prop.getProperty("password");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return Integer.parseInt(port);
    }

    public String getPassword() {
        return password;
    }

    public void createConfig() throws IOException {
    }

}
