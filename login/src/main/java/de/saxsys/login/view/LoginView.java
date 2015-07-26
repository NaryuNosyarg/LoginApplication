package de.saxsys.login.view;

import java.net.URL;
import java.util.ResourceBundle;

import de.saxsys.login.viewmodel.LoginViewModel;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginView implements FxmlView<LoginViewModel>, Initializable {

	@InjectViewModel
	private LoginViewModel viewModel;

	@FXML
	TextField usernameField;
	@FXML
	PasswordField passwordField;
	@FXML
	Button loginButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		BooleanBinding booleanBinding = usernameField.textProperty().isEmpty()
				.or(passwordField.textProperty().isEqualTo(""));

		loginButton.disableProperty().bind(booleanBinding);

//		loginButton.disableProperty().bind(
//			    Bindings.isEmpty(usernameField.textProperty())
//			    .or(Bindings.isEmpty(passwordField.textProperty())
//			));
	}

}
