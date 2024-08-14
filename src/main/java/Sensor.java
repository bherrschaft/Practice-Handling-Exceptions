public interface Sensor {
    // Method to check if the sensor is on
    boolean isOn();    // Returns true if the sensor is currently on

    // Method to turn the sensor on
    void setOn();      // Sets the sensor to the "on" state

    // Method to turn the sensor off
    void setOff();     // Sets the sensor to the "off" state

    // Method to read the sensor's value
    int read();        // Returns the current value of the sensor if it's on
    // If the sensor is not on, an IllegalStateException should be thrown
}

/*
 * Summary:
 * The Sensor interface defines the basic contract for any sensor implementation. It includes methods to check 
 * if the sensor is on, turn it on, turn it off, and read its current value. The read method requires the sensor 
 * to be on; otherwise, it should throw an IllegalStateException. This interface is useful for creating various 
 * types of sensors that follow a standard set of operations in an application.
 */
