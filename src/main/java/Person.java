public class Person {
    private String name;  // Declare a private variable to store the name
    private int age;  // Declare a private variable to store the age

    // Constructor to initialize the name and age with validations
    public Person(String name, int age) {
        if (name == null || name.isEmpty() || name.length() > 40) {
            throw new IllegalArgumentException("Name must not be null, empty, or over 40 characters in length.");
        }
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120.");
        }
        this.name = name;  // Initialize the name
        this.age = age;  // Initialize the age
    }

    // Getters for name and age
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
