package org.usfirst.frc.team2471.robot;


import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDSource;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FIRST
 */
public class AbsoluteEncoder implements PIDSource {
    private AnalogInput encoder;
    private double offset;
    private double sensitivity;
    private double maxDegrees, lastDegrees;
    private int rollovers;
        
    boolean invert = false;

    public AbsoluteEncoder(int chanEncoder){
        encoder = new AnalogInput(chanEncoder);
        offset = 0;
        sensitivity = 72;
        maxDegrees = 360;
        lastDegrees = getDegrees();
        rollovers = 0;
        encoder.setAverageBits(4);
    }

    public double getTotalDegrees() {  // dont use
        double degrees = getDegrees();
        if(degrees > 60 && lastDegrees < 20) {
            rollovers--;
        }
        if(degrees < 20 && lastDegrees > 60) {
            rollovers++;
        }
        lastDegrees = degrees;
        return degrees + rollovers * (360 / 4.0);
    }

    public double pidGet() {
        return getDegrees();
    }
    
    public double getDegrees(){
        double degrees;
        double getVolt = encoder.getAverageVoltage();
        degrees = getVolt * sensitivity + offset;
        if(invert == true) {
            degrees = degrees * -1;
        }
        if(degrees < -180) {
            degrees = degrees + 360;
        }
        if(degrees > 180) {
            degrees = degrees - 360;
        }
        return degrees;
    }
    public double getVoltage() {
        return encoder.getVoltage();
    }
    public void setOffset(double _offset){
        offset = _offset;
    }
    public void setSensitivity(double _sensitivity){
        sensitivity = _sensitivity;
    }
    public void setMaxDegrees(double _maxDegrees) {
        maxDegrees = _maxDegrees;
    }
    public void setInvert(boolean _invert){
        invert = _invert;
    }
    
    public void reset() {
    	lastDegrees = 0;
    	rollovers = 0;
//    	offset = getDegrees();
    }
}
