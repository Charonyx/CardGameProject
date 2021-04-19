
package loan;


import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class LoanCalculator extends Application {

    private TextField tfAnnualInterestRate = new TextField();
    private TextField tfNumberOfYears = new TextField();
    private TextField tfLoanAmount = new TextField();
    private TextField tfMonthlyPayment = new TextField();
    private TextField tfTotalPayment = new TextField();
    private Button btCalculate = new Button("Calculate");
    
    //add
    private Button clearButton = new Button("Clear");
    private Button saveButton = new Button("Save");
    private Button loadButton = new Button("Load");
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Annual Interest Rate:"), 0, 0);
        gridPane.add(tfAnnualInterestRate, 1, 0);
        gridPane.add(new Label("Number of Years:"), 0, 1);
        gridPane.add(tfNumberOfYears, 1, 1);
        gridPane.add(new Label("Loan Amount:"), 0, 2);
        gridPane.add(tfLoanAmount, 1, 2);
        gridPane.add(new Label("Monthly Payment:"), 0, 3);
        gridPane.add(tfMonthlyPayment, 1, 3);
        gridPane.add(new Label("Total Payment:"), 0, 4);
        gridPane.add(tfTotalPayment, 1, 4);
        gridPane.add(btCalculate, 1, 5);
        
        //add
        gridPane.add(clearButton, 1, 5);
        gridPane.add(saveButton,0,5);
        gridPane.add(loadButton,0,5);
        
        // Set properties for UI
        gridPane.setAlignment(Pos.CENTER);
        tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
        tfLoanAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfMonthlyPayment.setAlignment(Pos.BOTTOM_RIGHT);
        tfTotalPayment.setAlignment(Pos.BOTTOM_RIGHT);
        tfMonthlyPayment.setEditable(false);
        tfTotalPayment.setEditable(false);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);
        GridPane.setHalignment(loadButton, HPos.RIGHT);
        // Process events
        btCalculate.setOnAction(e -> calculateLoanPayment());
        
        //add
        clearButton.setOnAction(e -> clearLoanPayment());
        saveButton.setOnAction(e -> {
            try {
                savePayment();
            } catch (IOException ex) {
                
            }
        });
        loadButton.setOnAction(e -> {
            try {
                loadPayment();
            } catch (IOException ex) {
                
            }
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setTitle("LoanCalculator"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    private void calculateLoanPayment() {
        // Get values from text fields
        double interest
                = Double.parseDouble(tfAnnualInterestRate.getText());
        double year = Double.parseDouble(tfNumberOfYears.getText());
        double loanAmount
                = Double.parseDouble(tfLoanAmount.getText());
        
        // Create a loan object. Loan defined in Listing 10.2
        Loan loan = new Loan(interest, year, loanAmount);
       
        // Display monthly payment and total payment
        tfMonthlyPayment.setText(String.format("$%.2f",
                loan.getMonthlyPayment()));
        tfTotalPayment.setText(String.format("$%.2f",
                loan.getTotalPayment()));
    }
    
    private void clearLoanPayment(){
        tfAnnualInterestRate.clear();
        tfNumberOfYears.clear();
        tfLoanAmount.clear();
        tfMonthlyPayment.clear();
        tfTotalPayment.clear();
    }
    
    private void savePayment() throws IOException
    {
        FileOutputStream outputFileStream = new FileOutputStream(new File("Loan.dat"));
        DataOutputStream loanData = new DataOutputStream(outputFileStream);
        loanData.writeDouble(Double.parseDouble(tfAnnualInterestRate.getText()));
        loanData.writeDouble(Double.parseDouble(tfNumberOfYears.getText()));
        loanData.writeDouble(Double.parseDouble(tfLoanAmount.getText()));
        loanData.close();
        
    }
    private void loadPayment() throws IOException{
        FileInputStream outputFileStream = new FileInputStream(new File("Loan.dat"));
        DataInputStream loadReadData = new DataInputStream(outputFileStream);
        
        tfAnnualInterestRate.setText(String.valueOf(loadReadData.readDouble()));
        tfNumberOfYears.setText(String.valueOf(loadReadData.readDouble()));
        tfLoanAmount.setText(String.valueOf(loadReadData.readDouble()));
        
        //tfAnnualInterestRate.setText(loadReadData.toString());
        
        System.out.println(loadReadData.readDouble());
        System.out.println(loadReadData.readDouble());
        System.out.println(loadReadData.readDouble());
    }
}
