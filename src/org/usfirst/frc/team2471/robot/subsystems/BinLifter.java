package org.usfirst.frc.team2471.robot.subsystems;

import org.usfirst.frc.team2471.robot.RobotMap;
import org.usfirst.frc.team2471.robot.commands.BinLifterCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BinLifter extends Subsystem {
	
	SpeedController lift;
	SpeedController rotate;
	Solenoid clasp;
	DigitalInput upperLimit;
	DigitalInput lowerLimit;
	Encoder liftDistance;
	
	public BinLifter(){
		lift = RobotMap.lMotor1;
		rotate = RobotMap.lMotor2;
		clasp = RobotMap.lSolenoid1;
		lowerLimit = RobotMap.lLowerLimit;
		upperLimit = RobotMap.lUpperLimit;
		liftDistance = RobotMap.lEnc;
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new BinLifterCommand());
	}

	public void Lift(double power){				//FIX MEH 
//		System.out.println("Lift: " + power );
		power = power * -1.0;
		if(power < 0 && (lowerLimit.get() == false)){
			power = power * 0.5;
		}
		else if(power > 0 && (upperLimit.get() == false)){
			power = power * .75;
		}
		else{
			power = 0;
		}
		lift.set(power);
	}
	
	public void Zero(){
		while(lowerLimit.get() == false){
			lift.set(-1 * 0.5);
		}
		if(lowerLimit.get() == true){
			liftDistance.reset();
		}
	}
	public void Grab(){
		clasp.set(!clasp.get());
		System.out.println(clasp.get());
	}
	/*
	public void setRawDistance(double setDistance , double power){
		while(liftDistance.get() != setDistance){
			if(liftDistance.get() - setDistance <= 0){
				lift.set(power);
			}
		}
	}
	*/
	public void Rotate(double power){
		//  Make command to deal with the encoder for the preset rotations
		rotate.set(power * 1.0);
	}
}
