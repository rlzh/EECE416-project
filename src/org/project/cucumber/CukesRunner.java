package org.project.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@Cucumber.Options(
		format = {"pretty", "html:target/cucumber"},
		features = "src/org/project/cucumber"
		)
public class CukesRunner {

}
