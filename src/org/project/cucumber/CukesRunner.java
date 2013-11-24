package org.project.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@Cucumber.Options(
		format = {"pretty", "html:target/cucumber"},
		features = "features"
		)
public class CukesRunner {

}
