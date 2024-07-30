public class Calculator {

    // Method to calculate the factorial of a number with validation
    public int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is only defined for non-negative numbers.");
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;  // Calculate the factorial
        }
        return result;  // Return the result
    }

    // Method to calculate the binomial coefficient with validation
    public int binomialCoefficient(int n, int k) {
        if (n < 0 || k < 0) {
            throw new IllegalArgumentException("Parameters must be non-negative.");
        }
        if (k > n) {
            throw new IllegalArgumentException("Subset size k cannot exceed set size n.");
        }
        return factorial(n) / (factorial(k) * factorial(n - k));  // Calculate and return the binomial coefficient
    }

    // Main method for testing
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Test factorial method
        try {
            System.out.println(calculator.factorial(5));  // Output: 120
            System.out.println(calculator.factorial(-1));  // Should throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Test binomialCoefficient method
        try {
            System.out.println(calculator.binomialCoefficient(5, 3));  // Output: 10
            System.out.println(calculator.binomialCoefficient(5, 6));  // Should throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
