package dad.javafx.buscarYReemplazar.app;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscarYReemplazarApp extends Application {
	
	private TextField buscarText,reemplazarText;
	private Button buscarButton,reemplazarButton,reemplazarTodoButton,cerrarButton,ayudaButton;
	private CheckBox mayusCheckBox,expresionCheckBox,buscarCheckBox,resaltarCheckBox; 
	
	
	
	public void start(Stage primaryStage) throws Exception {
		
		
		
		
		
		
		//botones
		buscarButton = new Button("Buscar");
		reemplazarButton = new Button("Reemplazar");
		reemplazarTodoButton = new Button("Reemplazar todo");
		cerrarButton = new Button("Cerrar");
		ayudaButton = new Button("Ayuda");
		
		VBox botonesVBox = new VBox();
		botonesVBox.getChildren().addAll(buscarButton,reemplazarButton,reemplazarTodoButton,cerrarButton,ayudaButton);
		botonesVBox.setAlignment(Pos.TOP_CENTER);
		for (int i = 0; i < 5; i++) {
			VBox.setMargin(botonesVBox.getChildren().get(i), new Insets(5, 0, 0, 0));
		}
		//checkboxes
		mayusCheckBox = new CheckBox("Mayusculas y minusculas");
		expresionCheckBox = new CheckBox("Expresion regular");
		buscarCheckBox = new CheckBox("Buscar hacia atras");
		resaltarCheckBox = new CheckBox("Resaltar resultados");
		
		GridPane checkBoxesGridpane = new GridPane();
		checkBoxesGridpane.addRow(0,mayusCheckBox,expresionCheckBox);
		checkBoxesGridpane.addRow(1,buscarCheckBox,resaltarCheckBox);
		
		//TextField
				buscarText = new TextField();
				reemplazarText = new TextField();
				
				GridPane textGridpane = new GridPane();
				textGridpane.addRow(0, new Label("Buscar:"),buscarText);
				textGridpane.addRow(1, new Label("Reemplazar con:"),reemplazarText);
				textGridpane.add(checkBoxesGridpane,1,2 );
				
				
				ColumnConstraints[] cols = {
						new ColumnConstraints(),
						new ColumnConstraints()
						
				};
				cols[0].setHalignment(HPos.LEFT);
				cols[1].setHgrow(Priority.ALWAYS);
				textGridpane.getColumnConstraints().setAll(cols);
				checkBoxesGridpane.getColumnConstraints().setAll(cols);

		
		//general
		VBox textCheckVBox = new VBox(textGridpane);
		HBox root = new HBox();
		root.getChildren().addAll(textCheckVBox,botonesVBox);
		HBox.setHgrow(textCheckVBox, Priority.ALWAYS);
		root.setPadding(new Insets(5,5,5,5));
		
		Scene scene = new Scene(root, 600, 300);

		primaryStage.setTitle("Buscar y Reemplazar");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
