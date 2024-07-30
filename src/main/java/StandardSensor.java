import java.util.Random;

public class StandardSensor implements Sensor {
    private int value;  // The value that the sensor returns

    // Constructor initializes the value of the sensor
    public StandardSensor(int value) {
        this.value = value;  // Initialize the value
    }

    // Always returns true since a standard sensor is always on
    @Override
    public boolean isOn() {
        return true;  // Standard sensor is always on
    }

    // These methods do nothing since the standard sensor is always on
    @Override
    public void setOn() {
        // Do nothing
    }

    @Override
    public void setOff() {
        // Do nothing
    }

    // Returns the value that was given to the constructor
    @Override
    public int read() {
        return this.value;  // Return the stored value
    }

    // Main method for testing
    public static void main(String[] args) {
        StandardSensor ten = new StandardSensor(10);  // Create a StandardSensor with value 10
        StandardSensor minusFive = new StandardSensor(-5);  // Create a StandardSensor with value -5

        System.out.println(ten.read());  // Output: 10
        System.out.println(minusFive.read());  // Output: -5

        System.out.println(ten.isOn());  // Output: true
        ten.setOff();
        System.out.println(ten.isOn());  // Output: true
    }
}
