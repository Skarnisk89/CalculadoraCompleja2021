package dad.calCom;

import dad.calCom.Complejo;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class CalculadoraCompleja2021 extends Application {

	private TextField textNum1;
	private TextField textNum2;
	private TextField textNum3;
	private TextField textNum4;
	private TextField textNumResul1;
	private TextField textNumResul2;
	private ComboBox<String> botones1;
	private Separator separador;
	
	Complejo comple1;
	Complejo comple2;
	Complejo comple3;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		comple1 = new Complejo();
		comple2 = new Complejo();
		comple3 = new Complejo();
		
		textNum1 = new TextField();
		textNum1.setMaxWidth(50);
		textNum1.setAlignment(Pos.CENTER);
		textNum2 = new TextField();
		textNum2.setMaxWidth(50);
		textNum2.setAlignment(Pos.CENTER);
		textNum3 = new TextField();
		textNum3.setMaxWidth(50);
		textNum3.setAlignment(Pos.CENTER);
		textNum4 = new TextField();
		textNum4.setMaxWidth(50);
		textNum4.setAlignment(Pos.CENTER);
		textNumResul1 = new TextField();
		textNumResul1.setMaxWidth(50);
		textNumResul1.setDisable(true);
		textNumResul2 = new TextField();
		textNumResul2.setMaxWidth(50);
		textNumResul2.setDisable(true);
		
		botones1 = new ComboBox<>();
		botones1.getItems().addAll("+", "-", "*", "/");
        botones1.getSelectionModel().select(0);
        
        VBox Ope = new VBox();
        Ope.getChildren().addAll(botones1);
		Ope.setAlignment(Pos.CENTER);
		Ope.setPadding(new Insets(5));
		
		HBox caja1 = new HBox();
		caja1.getChildren().addAll(textNum1, new Label("+"), textNum2, new Label("i"));
		caja1.setAlignment(Pos.CENTER);
		caja1.setSpacing(5);
		
		HBox caja2 = new HBox();
		caja2.getChildren().addAll(textNum3, new Label("+"), textNum4, new Label("i"));
		caja2.setAlignment(Pos.CENTER);
		caja2.setSpacing(5);
		
		separador = new Separator();
		separador.setOrientation(Orientation.HORIZONTAL);
		
		HBox cajaResul = new HBox();
		cajaResul.getChildren().addAll(textNumResul1, new Label("+"), textNumResul2, new Label("i"));
		cajaResul.setAlignment(Pos.CENTER);
		cajaResul.setSpacing(5);
		
		VBox Contenido = new VBox();
		Contenido.getChildren().addAll(caja1, caja2, separador, cajaResul);
		Contenido.setAlignment(Pos.CENTER);
		Contenido.setSpacing(5);
		
		HBox root = new HBox();
		root.getChildren().addAll(Ope, Contenido);
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root, 480, 320); 

		primaryStage.setTitle("Calculadora"); 
		primaryStage.setScene(scene); 
		primaryStage.show();
		
		Bindings.bindBidirectional(textNum1.textProperty(), comple1.realProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(textNum2.textProperty(), comple1.imaginarioProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(textNum3.textProperty(), comple2.realProperty(), new NumberStringConverter());
		Bindings.bindBidirectional(textNum4.textProperty(), comple2.imaginarioProperty(), new NumberStringConverter());
		
		
		
		botones1.getSelectionModel().selectedItemProperty().addListener((o, ov, nv)->{
			if (botones1.getSelectionModel().getSelectedItem().equals("+")){
				
				comple3 = comple1.add(comple2);
				textNumResul1.textProperty().bind(comple3.realProperty().asString("%.2f"));
				textNumResul2.textProperty().bind(comple3.imaginarioProperty().asString("%.2f"));
				
			}else if (botones1.getSelectionModel().getSelectedItem().equals("-")) {
				
				comple3 = comple1.substract(comple2);
				textNumResul1.textProperty().bind(comple3.realProperty().asString("%.2f"));
				textNumResul2.textProperty().bind(comple3.imaginarioProperty().asString("%.2f"));
				
			}else if (botones1.getSelectionModel().getSelectedItem().equals("*")) {
				
				comple3 = comple1.multiply(comple2);
				textNumResul1.textProperty().bind(comple3.realProperty().asString("%.2f"));
				textNumResul2.textProperty().bind(comple3.imaginarioProperty().asString("%.2f"));
				
			}else if (botones1.getSelectionModel().getSelectedItem().equals("/")) {
				
				comple3 = comple1.divide(comple2);
				textNumResul1.textProperty().bind(comple3.realProperty().asString("%.2f"));
				textNumResul2.textProperty().bind(comple3.imaginarioProperty().asString("%.2f"));
				
				
			}
		});
	}
	
	
	
	public static void main(String[] args) {
		launch(args);

	}

}
