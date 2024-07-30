import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean isOn;  // Stores whether the sensor is on or off

    // Constructor initializes the sensor to be off
    public TemperatureSensor() {
        this.isOn = false;  // Sensor is initially off
    }

    // Returns true if the sensor is on
    @Override
    public boolean isOn() {
        return this.isOn;  // Return the state of the sensor
    }

    // Sets the sensor on
    @Override
    public void setOn() {
        this.isOn = true;  // Set the sensor to on
    }

    // Sets the sensor off
    @Override
    public void setOff() {
        this.isOn = false;  // Set the sensor to off
    }

    // Returns a random temperature value if the sensor is on
    @Override
    public int read() {
        if (!this.isOn) {
            throw new IllegalStateException("Sensor is off");  // Throw an exception if the sensor is off
        }
        Random random = new Random();
        return random.nextInt(61) - 30;  // Return a random value between -30 and 30
    }

    // Main method for testing
    public static void main(String[] args) {
        TemperatureSensor tempSensor = new TemperatureSensor();  // Create a TemperatureSensor
        tempSensor.setOn();  // Turn the sensor on
        System.out.println("temperature in Kumpula " + tempSensor.read() + " degrees Celsius");
    }
}
