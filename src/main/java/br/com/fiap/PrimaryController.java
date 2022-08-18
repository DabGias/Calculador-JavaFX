package br.com.fiap;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML
    private TextField precoGasolina;
    @FXML
    private TextField precoAlcool;
    @FXML
    private Label lblResposta;
    @FXML
    private Button btnCalcular;

    @FXML
    private void calculaVantagem() {
        double precoGas = Double.valueOf(precoGasolina.getText());
        double precoAlc = Double.valueOf(precoAlcool.getText());
        double resultado = precoAlc / precoGas;

        if (resultado <= 0.7) {
            lblResposta.setText("Sim");
        } else {
            lblResposta.setText("Não");
        }

    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
