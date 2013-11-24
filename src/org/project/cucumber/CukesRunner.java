package org.project.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
		format = {"pretty", "html:target/cucumber"},
		features = "org/project/cucumber"
		)
public class CukesRunner {

}
