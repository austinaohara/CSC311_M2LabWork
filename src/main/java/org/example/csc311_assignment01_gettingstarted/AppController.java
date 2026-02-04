package org.example.csc311_assignment01_gettingstarted;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AppController {
    @FXML private Label labelMain;
    @FXML private TextField textFieldLeft;
    @FXML private TextField textFieldRight;
    @FXML private Button buttonAdd;

    // ToDo 01: add two text fields to the GUI so that the user can find the sum

    // ToDo 02: when the button is clicked show the output on the screen

    // ToDo 03: you should accept only the numeric values

    // ToDo 04: modify the CSS file to make the background of the application Lightblue and the button color red

    // ToDo 05: commit changes and push back to the same repo

    @FXML
    protected void initialize() {
        applyIntegerOnly(textFieldLeft);
        applyIntegerOnly(textFieldRight);
    }

    private void applyIntegerOnly(TextField textField) {
        textField.textProperty().addListener((obs, oldVal, newVal) -> {
            // allow empty (so backspace works)
            if (newVal.isEmpty()) return;

            // digits only (integers)
            if (!newVal.matches("-?\\d*(\\.\\d*)?")) {
                textField.setText(oldVal);
            }
        });
    }

    @FXML
    protected void onCalculateButtonClick() {
        double a = Double.parseDouble(textFieldLeft.getText());
        double b = Double.parseDouble(textFieldRight.getText());
        double sum  = a + b;

        labelMain.setText(String.format("%s + %s = %s",
                formatDouble(a),
                formatDouble(b),
                formatDouble(sum)));
    }

    // Format a double to max of 6 decimals, trimming zeros
    private String formatDouble(double num) {
        String s = String.format("%.6f", num);
        s = s.replaceAll("0+$", "").replaceAll("\\.$", "");
        return s;
    }
}