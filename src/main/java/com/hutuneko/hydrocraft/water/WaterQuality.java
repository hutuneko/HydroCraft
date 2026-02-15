package com.hutuneko.hydrocraft.water;

import com.hutuneko.hydrocraft.water.quality.SoluteType;

import java.util.HashMap;
import java.util.Map;

public class WaterQuality implements IWaterQuality {
    private double temperature;
    private double pressure;
    private final Map<SoluteType, Double> solute = new HashMap<>();

    @Override
    public double getTemperature() {
        return temperature;
    }

    @Override
    public double getPressure() {
        return pressure;
    }

    @Override
    public Map<SoluteType, Double> getSolute() {
        return solute;
    }

    @Override
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    @Override
    public void setSolute(Map<SoluteType, Double> solute) {
        this.solute.putAll(solute);
    }

    @Override
    public IWaterQuality copy() {
        IWaterQuality copy = new WaterQuality();
        copy.setTemperature(this.temperature);
        copy.setPressure(this.pressure);
        copy.setSolute(this.solute);
        return copy;
    }
}
