package de.htwberlin.ikt.oop.sensorlog.values;

import de.htwberlin.ikt.oop.sensorlog.data.SensorLocation;
import de.htwberlin.ikt.oop.sensorlog.data.SensorTimeStamp;
import de.htwberlin.ikt.oop.sensorlog.data.SensorValue;

/**
 * Created by Aleksei Piatkin on 13.12.2016.
 */
public class TemperatureValue extends SensorValue {
    /**
     * Constructs a new object of this type.
     *
     * @param location  the location of the sensor value
     * @param timeStamp the timestamp of the sensor value
     * @param value     the sensor value
     * @throws IllegalArgumentException if one of the parameters is null or out of range
     */
    public TemperatureValue(SensorLocation location, SensorTimeStamp timeStamp, double value) {
        super(location, timeStamp, value);
    }

    @Override
    public String getValueAsString() {
        double sensorValue = getValue();
        sensorValue = (Math.round(sensorValue * 100))/100;
        return String.valueOf(sensorValue);
    }

    @Override
    public String getUnit() {
        return "°C";
    }

    @Override
    public double getMaxValue() {
        return 58;
    }

    @Override
    public double getMinValue() {
        return -89;
    }

    @Override
    public String getSensorTitle() {
        return "Temperatur";
    }

}
