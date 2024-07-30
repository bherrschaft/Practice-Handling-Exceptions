import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private List<Sensor> sensors;  // List to store multiple sensors
    private List<Integer> readings;  // List to store readings
    private boolean isOn;  // Stores whether the average sensor is on or off

    // Constructor initializes the lists and sets the sensor to off
    public AverageSensor() {
        this.sensors = new ArrayList<>();  // Initialize the list of sensors
        this.readings = new ArrayList<>();  // Initialize the list of readings
        this.isOn = false;  // Sensor is initially off
    }

    // Adds a new sensor to the list of sensors
    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);  // Add the sensor to the list
    }

    // Returns true if all sensors are on
    @Override
    public boolean isOn() {
        for (Sensor sensor : sensors) {
            if (!sensor.isOn()) {
                return false;  // Return false if any sensor is off
            }
        }
        return true;  // Return true if all sensors are on
    }

    // Sets all sensors on
    @Override
    public void setOn() {
        for (Sensor sensor : sensors) {
            sensor.setOn();  // Set each sensor to on
        }
        this.isOn = true;  // Set the average sensor to on
    }

    // Sets all sensors off
    @Override
    public void setOff() {
        for (Sensor sensor : sensors) {
            sensor.setOff();  // Set each sensor to off
        }
        this.isOn = false;  // Set the average sensor to off
    }

    // Returns the average of the readings from all sensors
    @Override
    public int read() {
        if (!this.isOn || sensors.isEmpty()) {
            throw new IllegalStateException("Sensor is off or no sensors added");  // Throw an exception if the sensor is off or no sensors are added
        }
        int sum = 0;
        for (Sensor sensor : sensors) {
            sum += sensor.read();  // Sum the readings from all sensors
        }
        int average = sum / sensors.size();  // Calculate the average
        readings.add(average);  // Store the reading
        return average;  // Return the average
    }

    // Returns the list of all readings
    public List<Integer> readings() {
        return this.readings;  // Return the list of readings
    }

    // Main method for testing
    public static void main(String[] args) {
        Sensor kumpula = new TemperatureSensor();  // Create a TemperatureSensor
        kumpula.setOn();  // Turn the sensor on
        System.out.println("temperature in Kumpula " + kumpula.read() + " degrees Celsius");

        Sensor kaisaniemi = new TemperatureSensor();  // Create another TemperatureSensor
        Sensor helsinkiVantaaAirport = new TemperatureSensor();  // Create another TemperatureSensor

        AverageSensor helsinkiRegion = new AverageSensor();  // Create an AverageSensor
        helsinkiRegion.addSensor(kumpula);  // Add the sensors to the AverageSensor
        helsinkiRegion.addSensor(kaisaniemi);
        helsinkiRegion.addSensor(helsinkiVantaaAirport);

        helsinkiRegion.setOn();  // Turn the AverageSensor on
        System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degrees Celsius");
        System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degrees Celsius");
        System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degrees Celsius");

        System.out.println("readings: " + helsinkiRegion.readings());  // Output the readings
    }
}
