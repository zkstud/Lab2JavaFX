package com.example.lab2javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private XYChart.Series series;
    @FXML
    private Slider aplitudeSlider, frequencySlider, phaseSlider, offsetSlider;
    @FXML
    private LineChart lineChart;
    @FXML
    private Label aplitudeValueLabel, frequencyValueLabel, phaseValueLabel, offsetValueLabel;

    @FXML
    private void regenSin() {
        series.getData().clear();
        for (int i = 0; i < 200; i++) {
            series.getData().add(new XYChart.Data(i + "", offsetSlider.getValue() +
                    aplitudeSlider.getValue() * Math.sin((frequencySlider.getValue() * i) + phaseSlider.getValue())));
            aplitudeValueLabel.setText(Double.toString(aplitudeSlider.getValue()));
            frequencyValueLabel.setText(Double.toString(frequencySlider.getValue()));
            phaseValueLabel.setText(Double.toString(phaseSlider.getValue()));
            offsetValueLabel.setText(Double.toString(offsetSlider.getValue()));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        series = new XYChart.Series<>();
        series.setName("sin");
        lineChart.getData().add(series);

        // zrobiłem tak
        aplitudeSlider.setOnDragDetected(event -> regenSin());
        frequencySlider.setOnDragDetected(event -> regenSin());
        phaseSlider.setOnDragDetected(event -> regenSin());
        offsetSlider.setOnDragDetected(event -> regenSin());
    }


    //  tak nie zadziałało
//    private void suwakChanged(MouseEvent event) {
//        regenSin();
//
//    }

    @FXML
    private void enterButtonOnAction(ActionEvent event) {
        regenSin();
    }
}