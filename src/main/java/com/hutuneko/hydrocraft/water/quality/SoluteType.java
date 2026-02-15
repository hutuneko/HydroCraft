package com.hutuneko.hydrocraft.water.quality;

public interface SoluteType {
    double getTemperature();
    double getPressure();

    void setTemperature(double temperature);
    void setPressure(double pressure);
}
