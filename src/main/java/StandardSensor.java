import java.util.Random;

public class StandardSensor implements Sensor {
    // Private field to store the value that the sensor returns
    private int value;  // The value that the sensor returns

    // Constructor initializes the value of the sensor
    public StandardSensor(int value) {
        this.value = value;  // Initialize the value with the provided argument
    }

    // Always returns true since a standard sensor is always on
    @Override
    public boolean isOn() {
        return true;  // Standard sensor is always on, so this method always returns true
    }

    // These methods do nothing since the standard sensor is always on
    @Override
    public void setOn() {
        // Do nothing because the standard sensor is always on
    }

    @Override
    public void setOff() {
        // Do nothing because the standard sensor cannot be turned off
    }

    // Returns the value that was given to the constructor
    @Override
    public int read() {
        return this.value;  // Return the fixed value stored in the sensor
    }

    // Main method for testing the StandardSensor class
    public static void main(String[] args) {
        StandardSensor ten = new StandardSensor(10);  // Create a StandardSensor with a value of 10
        StandardSensor minusFive = new StandardSensor(-5);  // Create a StandardSensor with a value of -5

        System.out.println(ten.read());  // Output: 10, reading the value from the first sensor
        System.out.println(minusFive.read());  // Output: -5, reading the value from the second sensor

        System.out.println(ten.isOn());  // Output: true, the sensor is always on
        ten.setOff();  // Attempt to turn off the sensor (has no effect)
        System.out.println(ten.isOn());  // Output: true, the sensor remains on
    }
}

/*
 * Summary:
 * The StandardSensor class implements the Sensor interface and represents a sensor that always stays on. 
 * It stores a fixed value, which it returns whenever the read method is called. The methods setOn and setOff 
 * have no effect, as the sensor is always on. This class is useful when you need a sensor with a constant, 
 * unchanging value. The main method demonstrates creating StandardSensor instances and using their methods 
 * to confirm that they behave as expected.
 */
