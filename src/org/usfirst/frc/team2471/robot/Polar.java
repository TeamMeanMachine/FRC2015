package org.usfirst.frc.team2471.robot;

public class Polar {
	public double r;
	public double theta;
	
    public Polar(double x, double y){
        r = Math.sqrt(x*x + y*y);
        theta = Math.atan2(-x, y); // we want 0 degrees to be in the Positive Y direction, which is towards the front of the robot
    }

    public double GetR()
    {
        return r;
    }

    public double GetAngle()
    {
        return theta;
    }

    public double GetX() {
        return -r*Math.sin(theta);
    }

    public double GetY() {
        return r*Math.cos(theta);
    }

    public void AddAngle( double angle ){
        theta = theta + angle;
    }
}