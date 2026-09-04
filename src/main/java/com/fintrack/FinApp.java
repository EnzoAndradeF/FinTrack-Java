package com.fintrack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class FinApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // 1. Carrega o arquivo FXML da pasta de recursos (resources)
        URL fxmlLocation = getClass().getResource("/com/fintrack/views/primary.fxml");

        if (fxmlLocation == null) {
            throw new RuntimeException(
                    "Não foi possível encontrar o FXML em /com/fintrack/views/primary.fxml");
        }

        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        Parent root = loader.load();

        // 2. Cria a Cena (Scene) contendo a árvore de elementos visuais do FXML
        Scene scene = new Scene(root, 800, 600); // Definindo largura (800) e altura (600) iniciais

        // 3. Aplica o arquivo de estilos CSS (se existir)
        URL cssLocation = getClass().getResource("/com/fintrack/style.css");
        if (cssLocation != null) {
            scene.getStylesheets().add(cssLocation.toExternalForm());
        }

        // 4. Configura o Palco (Stage) e exibe a janela
        stage.setTitle("FinTrack - Gerenciador Financeiro");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // O método launch inicializa o ambiente JavaFX e chama o método start()
        launch(args);
    }
}
