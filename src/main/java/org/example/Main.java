package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ejercicio 16 - Validacion de formulario");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setStyle("-fx-padding: 20;");

        // Etiquetas y campos de texto
        Label nombreLabel = new Label("Nombre:");
        TextField nombreField = new TextField();

        Label apellidoLabel = new Label("Apellido:");
        TextField apellidoField = new TextField();

        // Boton de envio
        Button enviarButton = new Button("Enviar");

        // Evento del boton: valida que ningun campo este vacío
        enviarButton.setOnAction(event -> {
            String nombre = nombreField.getText().trim();
            String apellido = apellidoField.getText().trim();

            if (nombre.isEmpty() || apellido.isEmpty()) {
                // Hay campos vacios: mostrar error en consola
                System.out.println("ERROR: Hay campos vacios. Por favor, rellena todos los campos.");
                if (nombre.isEmpty()) {
                    System.out.println("  → El campo 'Nombre' está vacio.");
                }
                if (apellido.isEmpty()) {
                    System.out.println("  → El campo 'Apellido' está vacio.");
                }
            } else {
                // Todos los campos rellenos: mostrar datos
                System.out.println("Formulario enviado correctamente:");
                System.out.println("  Nombre: " + nombre);
                System.out.println("  Apellido: " + apellido);
            }
        });

        // Añadir elementos al grid
        grid.add(nombreLabel,   0, 0);
        grid.add(nombreField,   1, 0);
        grid.add(apellidoLabel, 0, 1);
        grid.add(apellidoField, 1, 1);
        grid.add(enviarButton,  1, 2);

        Scene scene = new Scene(grid, 350, 180);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}