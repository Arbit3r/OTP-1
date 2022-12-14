package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.Controller;
import controller.V2M;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Asiakas;
import model.Asiakastiedot;
import model.LangPackage;


public class CreateUser {

	V2M postcontroller = new Controller();

	/** Text Fields. */
	@FXML
	private TextField luoEtunimi;
	/* Text Field luoKaupunki */
	@FXML
	private TextField luoKaupunki;

	/*Text Field luoOsoite */
	@FXML
	private TextField luoOsoite;
	/*Text Field luoPNumero */
	@FXML
	private TextField luoPNumero;
	/*Text Field luoPuheNumero */
	@FXML
	private TextField luoPuheNumero;
	/*Text Field luoSPosti */
	@FXML
	private TextField luoSPosti;
	/*Text Field luoSukunimi */
	@FXML
	private TextField luoSukunimi;

	/** buttons. */
	@FXML
	private Button luoBtn;
	@FXML
	private Button peruuttaa;

	/**
	 * Luo kayttajaa - method that add new user to system.
	 *
	 *@author Fatlum Gerguri
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	private void luoKayttajaa(ActionEvent event) throws IOException {
		String etunimi = luoEtunimi.getText();
		String sukunimi = luoSukunimi.getText();

		if (etunimi.isEmpty() || sukunimi.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please fill the data!");
			return;
		}

		postcontroller.addAsiakas(new Asiakas(luoEtunimi.getText(), luoSukunimi.getText(), luoPuheNumero.getText(),
				new Asiakastiedot(luoKaupunki.getText(), luoSPosti.getText(), luoPNumero.getText(), luoOsoite.getText(),
						luoPuheNumero.getText())));

		JOptionPane.showMessageDialog(null, "New User is added!");

		changeScene();
	}

	/**
	 * Peruuttaa - cancel the adding the new user.
	 *
	 *@author Fatlum Gerguri
	 * @param event the event
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@FXML
	private void peruuttaa(ActionEvent event) throws IOException {

		changeScene();
	}

	/**
	 * Change scene - after canceled then change the screen to main screen.
	 *
	 *@author Fatlum Gerguri
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void changeScene() throws IOException {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(EngineUI.class.getResource("AdminManagement.fxml"),LangPackage.rBundle);
			Scene scene = new Scene(fxmlLoader.load()); // scene

			Stage stage = EngineUI.getPrimaryStage();
			stage.hide();
			stage.setTitle("Kirjaston lainausj??rjestelm?? ");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
