package org.usfirst.frc.team2471.robot.subsystems;

import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BinLifter extends Subsystem {
	
	SpeedController lift;
	SpeedController rotate;
	Solenoid clasp;
	DigitalInput upperLimit;
	DigitalInput lowerLimit;
	
	public BinLifter(){
		lift = RobotMap.lMotor1;
		rotate = RobotMap.lMotor2;
		clasp = RobotMap.lSolenoid1;
		lowerLimit = RobotMap.lLowerLimit;
		upperLimit = RobotMap.bUpperlimit;
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}

	public void Lift(double power){
		if (!lowerLimit.get() && !upperLimit.get()){
			lift.set(power);
		}
		else if(lowerLimit.get() || upperLimit.get()){
			lift.set(0);
		}
		else{
			lift.set(0);
		}
	}
	
	public void Grab(Boolean attach){
		if(attach){
			clasp.set(true);
		}
		else if(!attach){
			clasp.set(false);
		}
	}
	
	
}
