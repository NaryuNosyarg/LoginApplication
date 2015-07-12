package de.saxsys.login;

import de.saxsys.login.view.LoginView;
import de.saxsys.login.viewmodel.LoginViewModel;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LoginApp extends Application {

    public static void main(String[] args) {
        launch(LoginApp.class, args);
    }

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Login Form");

        ViewTuple<LoginView, LoginViewModel> viewTuple = FluentViewLoader.fxmlView(LoginView.class).load();

        Parent root = viewTuple.getView();
        stage.setScene(new Scene(root));
        stage.show();
		
	}
}

