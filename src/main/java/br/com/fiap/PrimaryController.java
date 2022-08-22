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
        try {
            double precoGas = Double.valueOf(precoGasolina.getText());
            double precoAlc = Double.valueOf(precoAlcool.getText());
            
            if (precoAlc <= 0 || precoGas <= 0) {
                throw new IllegalArgumentException("Número negativo");
            }
            
            double resultado = precoAlc / precoGas;
            
            if (resultado <= 0.7) {
            lblResposta.setText("Sim");
            } else {
                lblResposta.setText("Não");
            }

        } catch (NumberFormatException erro) {
            mostraMensagem("Entrada de dados inválida. O dado deve ser um número inteiro ou decimal!");
        } catch (IllegalArgumentException erro) {
            mostraMensagem("Entrada de dados inválida. O número deve ser positivo!")
        }
    }

    private void mostraMensagem(String texto) {
        Alert mensagem = new Alert(AlertType.ERROR);
        mensagem.setContentText(texto);
        mensagem.setTitle("Erro");
        mensagem.show();
    }
}
