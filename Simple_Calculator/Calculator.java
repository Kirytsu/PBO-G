
/**
 * @author Nathanael Valen Susilo - 5025231099
 * @version 0.1
 */
public class Calculator {
    private double result;  // Holds the result
    
    // Constructor initializes result to 0
    public Calculator() {
        this.result = 0;
        updateDisplay();
    }

    // Get the current result
    public double getResult() {
        return result;
    }

    // Update the display
    private void updateDisplay() {
        System.out.println("= " + result);
    }

    // Set the result after an operation
    public void setResult(double result) {
        this.result = result;
        updateDisplay();
    }

    // Reset the calculator
    public void reset() {
        this.result = 0;
        updateDisplay();
    }
}

