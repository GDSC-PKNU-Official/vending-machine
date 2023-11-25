package domain;

public enum Temperature {
    COLD("차가운 음료"), HOT("따뜻한 음료");

    private String temperature;

    Temperature(String temperature) {
        this.temperature = temperature;
    }

    public String getTemperature() {
        return temperature;
    }
}
