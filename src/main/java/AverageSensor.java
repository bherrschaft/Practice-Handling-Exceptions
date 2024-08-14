import java.util.ArrayList; // Import the ArrayList class for storing a dynamic list of objects
import java.util.List; // Import the List interface for working with lists

public class AverageSensor implements Sensor {
    // Private fields to store multiple sensors and their readings
    private List<Sensor> sensors;  // List to store the individual sensors
    private List<Integer> readings;  // List to store the readings from the sensors
    private boolean isOn;  // Boolean to store whether the average sensor is on or off

    // Constructor initializes the lists and sets the sensor to off
    public AverageSensor() {
        this.sensors = new ArrayList<>();  // Initialize the list of sensors
        this.readings = new ArrayList<>();  // Initialize the list of readings
        this.isOn = false;  // The average sensor is initially off
    }

    // Adds a new sensor to the list of sensors
    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);  // Add the provided sensor to the sensors list
    }

    // Returns true if all sensors in the list are on
    @Override
    public boolean isOn() {
        for (Sensor sensor : sensors) {  // Iterate through the list of sensors
            if (!sensor.isOn()) {  // If any sensor is off
                return false;  // Return false
            }
        }
        return true;  // Return true if all sensors are on
    }

    // Sets all sensors in the list to on
    @Override
    public void setOn() {
        for (Sensor sensor : sensors) {  // Iterate through the list of sensors
            sensor.setOn();  // Set each sensor to on
        }
        this.isOn = true;  // Set the average sensor to on
    }

    // Sets all sensors in the list to off
    @Override
    public void setOff() {
        for (Sensor sensor : sensors) {  // Iterate through the list of sensors
            sensor.setOff();  // Set each sensor to off
        }
        this.isOn = false;  // Set the average sensor to off
    }

    // Returns the average of the readings from all sensors
    @Override
    public int read() {
        if (!this.isOn || sensors.isEmpty()) {  // Check if the average sensor is off or no sensors are added
            throw new IllegalStateException("Sensor is off or no sensors added");  // Throw an exception if the sensor is off or no sensors are added
        }
        int sum = 0;  // Initialize the sum of readings
        for (Sensor sensor : sensors) {  // Iterate through the list of sensors
            sum += sensor.read();  // Sum the readings from all sensors
        }
        int average = sum / sensors.size();  // Calculate the average of the readings
        readings.add(average);  // Store the calculated average in the readings list
        return average;  // Return the average reading
    }

    // Returns the list of all readings
    public List<Integer> readings() {
        return this.readings;  // Return the list of readings collected so far
    }

    // Main method for testing the AverageSensor class
    public static void main(String[] args) {
        Sensor kumpula = new TemperatureSensor();  // Create a TemperatureSensor for Kumpula
        kumpula.setOn();  // Turn the Kumpula sensor on
        System.out.println("temperature in Kumpula " + kumpula.read() + " degrees Celsius");  // Print the temperature reading for Kumpula

        Sensor kaisaniemi = new TemperatureSensor();  // Create another TemperatureSensor for Kaisaniemi
        Sensor helsinkiVantaaAirport = new TemperatureSensor();  // Create another TemperatureSensor for Helsinki Vantaa Airport

        AverageSensor helsinkiRegion = new AverageSensor();  // Create an AverageSensor for the Helsinki region
        helsinkiRegion.addSensor(kumpula);  // Add the Kumpula sensor to the Helsinki region sensor
        helsinkiRegion.addSensor(kaisaniemi);  // Add the Kaisaniemi sensor to the Helsinki region sensor
        helsinkiRegion.addSensor(helsinkiVantaaAirport);  // Add the Helsinki Vantaa Airport sensor to the Helsinki region sensor

        helsinkiRegion.setOn();  // Turn the Helsinki region sensor on
        System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degrees Celsius");  // Print the average temperature in the Helsinki region
        System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degrees Celsius");  // Print the average temperature again
        System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degrees Celsius");  // Print the average temperature again

        System.out.println("readings: " + helsinkiRegion.readings());  // Output all readings taken by the Helsinki region sensor
    }
}

/*
 * Summary:
 * The AverageSensor class is an implementation of a sensor that averages readings from multiple individual sensors. 
 * The class manages a list of sensors and provides methods to turn them on or off, check their status, and read the 
 * average of their readings. The class also stores all readings taken and allows access to these readings. The main 
 * method demonstrates how to use the AverageSensor with multiple TemperatureSensor instances, showing how to calculate 
 * and display the average temperature in a region.
 */
