package org.usfirst.frc.team2471.robot.subsystems;

import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BinLifter extends Subsystem {
	
	SpeedController lift;
	SpeedController grab;
	Solenoid clasp;
	
	public BinLifter(){
		lift = RobotMap.lMotor1;
		grab = RobotMap.lMotor2;
		clasp = RobotMap.lSolenoid1;
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}

	public static void Lift(){
		
	}
}
