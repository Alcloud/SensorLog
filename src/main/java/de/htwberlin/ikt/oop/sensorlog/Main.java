/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.htwberlin.ikt.oop.sensorlog;

import de.htwberlin.ikt.oop.sensorlog.data.SensorLog;
import de.htwberlin.ikt.oop.sensorlog.ui.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import de.htwberlin.ikt.oop.sensorlog.ui.ManualInputTab;
import de.htwberlin.ikt.oop.sensorlog.ui.PrintoutTab;
import de.htwberlin.ikt.oop.sensorlog.ui.VisualDefaults;


/**
 * Main class to create the UI of the program.
 * @author Kay Otto
 */
public class Main extends Application
{
  /*
   List of sensor values.
  */
  private final SensorLog sensorLog = new SensorLog();
  
  public static void main(String[] args) 
  {
    launch(args);
  }
  
  /**
   * Build and configure the UI of the program. This method is called
   * automatically in a JavaFX application.
   * @param stage the stage to show
   * @throws Exception if an error occurs
   */
  @Override
  public void start(Stage stage) throws Exception 
  {
    //TabPane is a container for tabs.
    TabPane tabPane = new TabPane();
    
    /*
     * Create and add the tab for manual input of sensor values and for the
     * printout of sensor values.
     */
    final ManualInputTab manualInputTab = new ManualInputTab(sensorLog);
    final PrintoutTab printoutTab = new PrintoutTab(sensorLog);
    final PlotTab plotTab = new PlotTab(sensorLog);
    final DownloadTab downloadTab = new DownloadTab(sensorLog);

    tabPane.getTabs().add(manualInputTab);
    tabPane.getTabs().add(printoutTab);
    tabPane.getTabs().add(plotTab);
    tabPane.getTabs().add(downloadTab);

    //if a tab is selected, refresh its contents
    tabPane.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>()
    {
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
      {
        switch (newValue.intValue())
        {
          case 0:
            manualInputTab.refresh();
            break;
          case 1:
            printoutTab.refresh();
            break;
          case 2:
            plotTab.refresh();
            break;
          case 3:
            downloadTab.refresh();
            break;
        }
      }
    });
    
    BorderPane root = new BorderPane();
    root.setPadding(new Insets(VisualDefaults.SPACING));

    //add tab pane to fill the center of the window
    root.setCenter(tabPane);
    
    Scene scene = new Scene(root, 800, 500);
    stage.setTitle("Sensor-Logbuch");
    stage.setScene(scene);
    stage.show();
  }
}
