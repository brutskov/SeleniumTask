package com.mlb.seleniumtask.ui;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class TextInput {

    private static final Logger LOG = Logger.getLogger(TextInput.class);

    private WebElement webElement;
    private String inputName;

    public TextInput(WebElement webElement) {
        this.webElement = webElement;
        this.inputName = webElement.getTagName();
    }

    public TextInput(WebElement webElement, String inputName) {
        this.webElement = webElement;
        this.inputName = inputName;
    }

    public void sendKeys(String message) {
        if (webElement.isEnabled() && webElement.isDisplayed()) {
            webElement.sendKeys(message);
            LOG.debug("Send text: '" + message + "' to text input field " + inputName);
        } else {
            LOG.error("Text '" + message + "' to text input field " + inputName + " not sends");
        }
    }

    public void submit() {
        LOG.debug("Submit '" + inputName + "' text input field");
        if(webElement.isEnabled() && webElement.isDisplayed())
            webElement.submit();
    }
}
