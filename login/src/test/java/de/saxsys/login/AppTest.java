package de.saxsys.login;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;

import javafx.scene.control.Button;

import static org.loadui.testfx.controls.Commons.hasText;
import static org.loadui.testfx.Assertions.assertNodeExists;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.isDisabled;


public class AppTest extends FxRobot {

	@BeforeClass
	public static void setupSpec() throws Exception {
		FxToolkit.registerPrimaryStage();
		FxToolkit.setupStage(stage -> stage.show());
	}

	@Before
	public void setup() throws Exception {
		FxToolkit.setupApplication(LoginApp.class);
	}

	@Test
	public void should_login_with_correct_credentials() {
		
		//given:
		assertNodeExists(hasText("Username"));
		assertNodeExists(hasText("Password"));
		assertNodeExists("#usernameField");
		verifyThat("#usernameField", hasText(""));
		assertNodeExists("#passwordField");
		verifyThat("#passwordField", hasText(""));
		assertNodeExists("#loginButton");
		verifyThat("#loginButton", hasText("Login"));
		verifyThat("#loginButton", isDisabled());
		
		// when:
		clickOn("#usernameField").write("Derek");
		clickOn("#passwordField").write("wolf");
		clickOn("#loginButton");

		// then:
		verifyThat("#usernameField", hasText("Derek"));
		verifyThat("#passwordField", hasText("wolf"));
		verifyThat("#loginButton", (Button b) -> !b.isDisabled());
		//verifyThat("#loginButton", NodeMatchers.isEnabled());
		
		
	}
}
