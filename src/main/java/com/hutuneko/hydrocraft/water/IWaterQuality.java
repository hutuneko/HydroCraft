package com.hutuneko.hydrocraft.water;

import com.hutuneko.hydrocraft.water.quality.SoluteType;

import java.util.Map;

public interface IWaterQuality {
    double getTemperature();
    double getPressure();
    Map<SoluteType,Double> getSolute();

    void setTemperature(double temperature);
    void setPressure(double pressure);
    void setSolute(Map<SoluteType,Double> solute);
    IWaterQuality copy();
}
