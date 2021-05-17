package ru.training.at.hw4.entity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class User {

    private String login = "";
    private String password = "";

    public User() {
        setLogin(login);
        setPassword(password);
    }

    String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    String testDataPath = rootPath + "testData.properties";

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {

        Properties testProps = new Properties();
        try {
            testProps.load(new FileInputStream(testDataPath));
            login = testProps.getProperty("login");
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        Properties testProps = new Properties();
        try {
            testProps.load(new FileInputStream(testDataPath));
            password = testProps.getProperty("password");
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        this.password = password;
    }
}
