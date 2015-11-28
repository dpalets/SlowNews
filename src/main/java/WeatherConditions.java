import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Dmytro.Palets on 23.11.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class WeatherConditions {

    public enum WindDirection {N, NE, E, SE, S, SW, W, NW}

    private String generalConditions;
    private double temperature;
    private double pressure;
    private double humidity;
    private double windSpeed;
    private WindDirection windDirection;

    public String getGeneralConditions() {
        return generalConditions;
    }

    public void setGeneralConditions(String generalConditions) {
        this.generalConditions = generalConditions;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setWindDirection(double direction) {
        if (direction > 350 && direction < 10) {this.windDirection = WindDirection.S;}
        else if (direction >= 10 && direction < 80) {this.windDirection = WindDirection.SW;}
        else if (direction >= 80 && direction < 100) {this.windDirection = WindDirection.W;}
        else if (direction >= 100 && direction < 170) {this.windDirection = WindDirection.NW;}
        else if (direction >= 170 && direction < 190) {this.windDirection = WindDirection.N;}
        else if (direction >= 190 && direction < 260) {this.windDirection = WindDirection.NE;}
        else if (direction >= 260 && direction < 280) {this.windDirection = WindDirection.E;}
        else if (direction >= 280 && direction < 350) {this.windDirection = WindDirection.SE;}
    }

    public WindDirection getWindDirection() {return windDirection;}
}
