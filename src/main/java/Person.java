public class Person {
    // Private variables to store the name and age of the person
    private String name;  // Store the person's name
    private int age;  // Store the person's age

    // Constructor to initialize the name and age with validations
    public Person(String name, int age) {
        // Validate that the name is not null, not empty, and does not exceed 40 characters
        if (name == null || name.isEmpty() || name.length() > 40) {
            throw new IllegalArgumentException("Name must not be null, empty, or over 40 characters in length.");
            // Throw an exception if the name is invalid
        }
        // Validate that the age is between 0 and 120
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120.");
            // Throw an exception if the age is out of bounds
        }
        this.name = name;  // Initialize the name variable with the provided value
        this.age = age;  // Initialize the age variable with the provided value
    }

    // Getter method to retrieve the person's name
    public String getName() {
        return name;  // Return the name
    }

    // Getter method to retrieve the person's age
    public int getAge() {
        return age;  // Return the age
    }
}

/*
 * Summary:
 * The Person class models a person with a name and age, ensuring that both fields are valid when an object is created. 
 * The constructor enforces that the name is neither null, empty, nor too long (over 40 characters), and that the age 
 * is within a realistic human range (0 to 120 years). The class provides getter methods to access the name and age 
 * after the object has been instantiated. This implementation demonstrates input validation and basic encapsulation 
 * principles in object-oriented programming.
 */
