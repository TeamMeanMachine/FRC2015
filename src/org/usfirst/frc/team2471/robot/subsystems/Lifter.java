package org.usfirst.frc.team2471.robot.subsystems;

import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem {
	
	SpeedController lifter;
	DigitalInput upperLimit;
	DigitalInput lowerLimit;
	DigitalInput toteand6; // COOPERTITION DEFAULT
	DigitalInput toteLimit; //DEFAULT ON INIT
	
	public Lifter(){
		lifter = RobotMap.bMotorlift;
		upperLimit = RobotMap.bUpperlimit;
		lowerLimit = RobotMap.bLowerLimit; 
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	//DONT USE ONLY FOR DEBUG IF NEED BE
	public void SetRawLift(double power){
		if(!upperLimit.get() && !lowerLimit.get()){
			lifter.set(power);
		}
		else{
			lifter.set(0);
		}
	}
	
	public void Zero(boolean upperorlower){
		//upper is true && lower is false
		boolean side = false;
		//check both limit switched to see what side to set as default 
		do{
			if (side == false){
				lifter.set(1.0);
				if(toteand6.get() == true){
					side = true;
				}
			}
			else{
				lifter.set(-1.0);
				if(lowerLimit.get()){
					side = false;
				}
			}
		}while(toteLimit.get() == false);
	}
	
	public void BottomGoto(){
		do{
			lifter.set(-1.0);
		}while(lowerLimit.get() == false);
	}
}