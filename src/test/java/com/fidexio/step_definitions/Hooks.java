package com.fidexio.step_definitions;

import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {
        Driver.get().manage().window().maximize();
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @After
    public void tearDown(){
        BrowserUtils.waitFor(2);
        Driver.closeDriver();
    }
}
