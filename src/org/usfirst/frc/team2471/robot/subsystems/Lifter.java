package org.usfirst.frc.team2471.robot.subsystems;

import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem {
	
	SpeedController lifter;
	DigitalInput upperLimit;
	DigitalInput lowerLimit;
	DigitalInput toteAnd6; // COOPERTITION DEFAULT
	DigitalInput toteLimit; //DEFAULT ON INIT
	Solenoid catcher;
	AnalogInput toteMax;
	
	public Lifter(){
		lifter = RobotMap.bMotorlift;
		upperLimit = RobotMap.bUpperlimit;
		lowerLimit = RobotMap.bLowerLimit; 
		toteLimit = RobotMap.bTotelimit;
		toteAnd6 = RobotMap.bToteand6;
		catcher = RobotMap.bCatch;
		toteMax = RobotMap.bToteMax;
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	//DONT USE ONLY FOR DEBUG IF NEED BE (LOL)
	public void SetRawLift(double power){
		if(!upperLimit.get() && !lowerLimit.get()){
			lifter.set(power * 0.5);
		}
		else{
			lifter.set(0);
		}
	}
	
	public void Liften4days(){
		catcher.set(false);
		while(lowerLimit.get() == false){
			lifter.set(-1.0 * 1.0);
		}
		catcher.set(true);
		while(upperLimit.get() == false && (RobotMap.bToteMax.getVoltage() < .65)){
			lifter.set(1.0);
		}
	}
	
	public void Zero(){
	/*	//upper is true && lower is false
		boolean side = false;
		//check both limit switched to see what side to set as default 
		while(toteLimit.get() == false){
			if (side == false){
				lifter.set(1.0);
				if(toteAnd6.get() == true){
					side = true;
					lifter.set(0);
				}
			}
			else{
				lifter.set(-1.0);
				if(lowerLimit.get()){
					side = false;
					lifter.set(0);
				}
			}
		}
		*/
		if(lowerLimit.get() == false){
			lifter.set(-1.0);
		}
		lifter.set(0);
	}
	
	public void BottomGoto(){
		catcher.set(false);
		lifter.set(-1.0 * 1.0);
	}
	
	public void TopGoto(){
		catcher.set(true);
		lifter.set(1.0);
	}
	
	public void CoopertitionDefault(){
		while(toteAnd6.get() ==  false);{
			lifter.set(1.0);
		}
		lifter.set(0);
	}
}