import java.util.Random; // Import the Random class to generate random numbers

public class TemperatureSensor implements Sensor {
    // Private field to store whether the sensor is on or off
    private boolean isOn;  // Stores whether the sensor is on or off

    // Constructor initializes the sensor to be off
    public TemperatureSensor() {
        this.isOn = false;  // Sensor is initially off
    }

    // Returns true if the sensor is on
    @Override
    public boolean isOn() {
        return this.isOn;  // Return the current state of the sensor (on or off)
    }

    // Sets the sensor on
    @Override
    public void setOn() {
        this.isOn = true;  // Change the state of the sensor to on
    }

    // Sets the sensor off
    @Override
    public void setOff() {
        this.isOn = false;  // Change the state of the sensor to off
    }

    // Returns a random temperature value if the sensor is on
    @Override
    public int read() {
        if (!this.isOn) {  // Check if the sensor is off
            throw new IllegalStateException("Sensor is off");  // Throw an exception if the sensor is off
        }
        Random random = new Random();  // Create a Random object to generate random numbers
        return random.nextInt(61) - 30;  // Return a random temperature between -30 and 30 degrees Celsius
    }

    // Main method for testing the TemperatureSensor class
    public static void main(String[] args) {
        TemperatureSensor tempSensor = new TemperatureSensor();  // Create a TemperatureSensor instance
        tempSensor.setOn();  // Turn the sensor on
        // Read and print the temperature, simulating a temperature reading in Kumpula
        System.out.println("temperature in Kumpula " + tempSensor.read() + " degrees Celsius");
    }
}

/*
 * Summary:
 * The TemperatureSensor class implements the Sensor interface and simulates a temperature sensor. 
 * The sensor can be turned on or off, and when it's on, it generates a random temperature reading 
 * between -30 and 30 degrees Celsius. If an attempt is made to read the temperature while the sensor 
 * is off, an exception is thrown. The main method demonstrates how to create a TemperatureSensor, 
 * turn it on, and read a random temperature value.
 */
