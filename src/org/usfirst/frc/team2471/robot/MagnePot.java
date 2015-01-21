/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc.team2471.robot;

import edu.wpi.first.wpilibj.AnalogInput;

/**
 *
 * @author FIRST
 */
public class MagnePot {
    AnalogInput input;
    
    public MagnePot(int channel) {
        input = new AnalogInput(channel);
    }
    
    public double getDistance() {
        double volts = input.getAverageVoltage();
        return ((volts - 0.2) / 4.6) * (2.0 * Math.PI); 
    }
}
