package org.usfirst.frc.team2471.robot.subsystems;

import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem {
	
	SpeedController lifter;
	DigitalInput upperLimit;
	DigitalInput lowerLimit;
	
	public Lifter(){
		lifter = RobotMap.bMotorlift;
		upperLimit = RobotMap.bUpperlimit;
		lowerLimit = RobotMap.bLowerLimit; 
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	public void SetRawLift(double power){
		if(!upperLimit.get() && !lowerLimit.get()){
			lifter.set(power);
		}
		else{
			lifter.set(0);
		}
	}
	
	public void LiftHigh(){
		
	}
}