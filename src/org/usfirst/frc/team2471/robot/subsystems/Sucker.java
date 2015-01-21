package org.usfirst.frc.team2471.robot.subsystems;

import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Sucker extends Subsystem {
	
	SpeedController suckerB1;
	SpeedController suckerB2;
	
	public Sucker(){
		suckerB1 = RobotMap.bSucker1;
		suckerB2 = RobotMap.bSucker2;
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}

	public static void Lift(){
		
	}
}