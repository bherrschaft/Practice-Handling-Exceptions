public class Calculator {

    // Method to calculate the factorial of a number with validation
    public int factorial(int n) {
        if (n < 0) {  // Check if the input is negative
            throw new IllegalArgumentException("Factorial is only defined for non-negative numbers.");
            // Throw an exception if the input is negative
        }
        int result = 1;  // Initialize the result to 1
        for (int i = 1; i <= n; i++) {  // Loop from 1 to n
            result *= i;  // Multiply result by the current value of i (result = result * i)
        }
        return result;  // Return the calculated factorial
    }

    // Method to calculate the binomial coefficient with validation
    public int binomialCoefficient(int n, int k) {
        if (n < 0 || k < 0) {  // Check if either n or k is negative
            throw new IllegalArgumentException("Parameters must be non-negative.");
            // Throw an exception if any of the parameters are negative
        }
        if (k > n) {  // Check if k is greater than n
            throw new IllegalArgumentException("Subset size k cannot exceed set size n.");
            // Throw an exception if k is greater than n
        }
        // Calculate and return the binomial coefficient using the factorial method
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    // Main method for testing the Calculator class
    public static void main(String[] args) {
        Calculator calculator = new Calculator();  // Create a new instance of Calculator

        // Test factorial method
        try {
            System.out.println(calculator.factorial(5));  // Output: 120 (5!)
            System.out.println(calculator.factorial(-1));  // Should throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // Output the exception message
        }

        // Test binomialCoefficient method
        try {
            System.out.println(calculator.binomialCoefficient(5, 3));  // Output: 10 (5 choose 3)
            System.out.println(calculator.binomialCoefficient(5, 6));  // Should throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // Output the exception message
        }
    }
}

/*
 * Summary:
 * The Calculator class provides methods to calculate the factorial of a number and the binomial coefficient 
 * (n choose k) with input validation. The factorial method throws an exception for negative inputs, while the 
 * binomialCoefficient method validates that k is not greater than n and that both n and k are non-negative. 
 * The main method tests these methods, including cases that should trigger exceptions. This class illustrates 
 * the use of basic loops, factorial calculation, binomial coefficients, and exception handling in Java.
 */
