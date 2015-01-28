package org.usfirst.frc.team2471.robot.subsystems;

import org.usfirst.frc.team2471.robot.RobotMap;
import org.usfirst.frc.team2471.robot.commands.BinLifterCommand;

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
		setDefaultCommand(new BinLifterCommand());
	}

	public void Lift(double power){
		if (!lowerLimit.get() && !upperLimit.get()){
			lift.set(power * 0.5);
		}
		else if(lowerLimit.get() || upperLimit.get()){
			lift.set(0);
		}
		else{
			lift.set(0);
		}
	}
	
	public void Grab(){
		clasp.set(!clasp.get());
		System.out.println(clasp.get());
	}
	
	public void Rotate(double power){
		//  Make command to deal with the encoder for the preset rotations
		rotate.set(power * 0.2);
	}
}
