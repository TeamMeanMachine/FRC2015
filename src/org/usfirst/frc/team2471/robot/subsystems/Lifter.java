package org.usfirst.frc.team2471.robot.subsystems;

import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem {
	
	SpeedController lifterB1;
	
	public Lifter(){
		lifterB1 = RobotMap.bMotorlift;
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}

	public static void Lift(){
		
	}
}