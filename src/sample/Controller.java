package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Controller {

    @FXML
    private TextFlow outputPane;

    @FXML
    private Spinner<Integer> numberSelector;

    private SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory =
            new SpinnerValueFactory.IntegerSpinnerValueFactory(1,9);


    @FXML
    void initialize() {
        valueFactory.setValue(9);

        numberSelector.setValueFactory(valueFactory);

        numberSelector.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    outputPane.getChildren().clear();
                    outputPane.getChildren().add(getNumbers(newValue));
                });

        outputPane.getChildren().add(getNumbers(numberSelector.getValue()));
    }

    Text getNumbers(Integer number) {
        StringBuilder string = new StringBuilder();

        while(number >= 1){
            for(int j = 1; j <= number; j = j + 2) {
                string.append(5);
            }
            number = number - 2;
            string.append("\n");
        }
        return new Text(string.toString());
    }
}