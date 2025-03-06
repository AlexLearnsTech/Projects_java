import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculadoraKmLitro extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Configuração da janela principal
        primaryStage.setTitle("Calculadora de Quilômetros por Litro");

        // Layout em grade para organizar os componentes
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        // Componentes da interface
        Label kmLabel = new Label("Quilômetros percorridos:");
        TextField kmField = new TextField();
        kmField.setPromptText("Digite os quilômetros");

        Label litrosLabel = new Label("Litros de combustível consumidos:");
        TextField litrosField = new TextField();
        litrosField.setPromptText("Digite os litros");

        Button calcularButton = new Button("Calcular");
        Label resultadoLabel = new Label();

        // Adiciona os componentes ao layout
        grid.add(kmLabel, 0, 0);
        grid.add(kmField, 1, 0);
        grid.add(litrosLabel, 0, 1);
        grid.add(litrosField, 1, 1);
        grid.add(calcularButton, 1, 2);
        grid.add(resultadoLabel, 1, 3);

        // Ação do botão "Calcular"
        calcularButton.setOnAction(e -> {
            try {
                // Obtém os valores dos campos de texto
                double km = Double.parseDouble(kmField.getText());
                double litros = Double.parseDouble(litrosField.getText());

                // Calcula os quilômetros por litro
                double kmPorLitro = km / litros;

                // Exibe o resultado
                resultadoLabel.setText(String.format("Quilômetros por litro: %.2f km/l", kmPorLitro));
            } catch (NumberFormatException ex) {
                // Trata erros de entrada inválida
                resultadoLabel.setText("Entrada inválida! Digite números válidos.");
            }
        });

        // Configuração da cena e exibição da janela
        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}