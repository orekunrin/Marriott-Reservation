package application;
	

// Written by John Orekunrin & Trevor Mayo
// COMP 360 Project 2
// Marriott Hotel in JavaFX


import java.time.LocalDate;
import java.util.Date;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	// this is where we will create the javafx types
	Button submit;
	CheckBox safe;
	DatePicker checkIn;
	DatePicker checkOut;
	Label nameField;
	Label roomField;
	Stage window;
	TextField enterName;
	Label labelResponse = new Label();
	ObservableList<String> roomOptions = 
		    FXCollections.observableArrayList(
		    	"----------",
		        "Stand Room",	// has one queen bed ($100 per night)
		        "Deluxe Room",	// has one queen and twin bed ($160 per night)
		        "Junior Suite"	// has one queen and twin bed and one sofa ($200 per night)
		    );
		ComboBox roomType;
	static String selectedItem = "";
	boolean[] isStandardAvailable = new boolean[15];
	boolean[] isDeluxeAvailable = new boolean[15];
	boolean[] isJuniorAvailable = new boolean[15];
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
	// end of main method
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
		StandRoom standard = new StandRoom();
		DeluxeRoom deluxe = new DeluxeRoom();
		JuniorSuite junior = new JuniorSuite();
		
		
		// creates the GUI and names it "The Marriott"
		window = primaryStage;
		primaryStage.setTitle("The Marriott");
		
		
		// Text telling the end user to input their name
		nameField = new Label("Enter Your Name: ");
		
		// Text prompting the user to choose a room
		roomField = new Label("Choose A Room: ");
		
		
		// allows the user to enter their name
		enterName = new TextField();
		enterName.setMaxWidth(200);	// sets the width of the textbox
		
		
		// This will show the user their options for rooms they can reserve
		// for the ability to choose from a list of rooms
		roomType = new ComboBox(roomOptions);
		
		
		// for the option to add a safe in your reservation
		safe = new CheckBox("Safe");
		
		
		// this will handle arrival and departure date times
		checkIn = new DatePicker();
		checkIn.setValue(LocalDate.now());
		
		checkOut = new DatePicker();
		checkOut.setValue(LocalDate.now());
		
		
		// for the ability to submit your reservation details
		submit = new Button();
		submit.setText("Submit");
		// lambda function to print a string to the console.
		submit.setOnAction(e -> {
			if(safe.isSelected()) {
				selectedItem += "safe";
			}
			if(enterName.getText().isEmpty() || roomType.getValue() == null) {
				labelResponse.setText("You must finish completing the form.");
			}
			else {
				labelResponse.setText("Your form has been submitted");
				labelResponse.setText("The name you've entered is " + enterName.getText() +
						"\nYou will arrive on " + checkIn.getValue() + " and depart on " +
						checkOut.getValue() + ".\nYou have chosen to include a " +
						selectedItem + ".\nThe room type chosen is a " + 
						roomType.getValue());
				//labelResponse.setText(standard.Display());
			}
		});
		
		
		standard.Cost(10);
		deluxe.Cost(10);
		junior.Cost(10);
		
		
		VBox vertBox = new VBox(15);
		vertBox.getChildren().addAll(nameField, enterName, roomField, roomType, safe,
				checkIn, checkOut, submit, labelResponse);
		
		
		Scene scene = new Scene(vertBox, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	// end of start(void) function
}
// end of main class