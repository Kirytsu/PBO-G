
/**
 * Class Operation to calculate the number in calculator.
 *
 * @author Nathanael Valen Susilo - 5025231099
 * @version 0.1
 */
public class Operation {
    // Reference to calculator
    private Calculator calculator;  
    
    // Constructor takes a Calculator object
    public Operation(Calculator calculator) {
        this.calculator = calculator;
    }

    // Add
    public void add(double value) {
        double currentValue = calculator.getResult();
        System.out.println("+ " + value);
        calculator.setResult(currentValue + value);
    }

    // Subtract
    public void subtract(double value) {
        double currentValue = calculator.getResult();
        System.out.println("- " + value);
        calculator.setResult(currentValue - value);
    }

    // Multiply
    public void multiply(double value) {
        double currentValue = calculator.getResult();
        System.out.println("x " + value);
        calculator.setResult(currentValue * value);
    }

    // Divide
    public void divide(double value) {
        double currentValue = calculator.getResult();
        if (value != 0) {
             System.out.println("/ " + value);
            calculator.setResult(currentValue / value);
        } else {
            System.out.println("Error: Cannot divide by zero!");
        }
    }
}

