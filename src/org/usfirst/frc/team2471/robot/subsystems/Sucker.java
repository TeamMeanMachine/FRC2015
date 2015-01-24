package org.usfirst.frc.team2471.robot.subsystems;

import org.usfirst.frc.team2471.robot.RobotMap;

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
	
	public void Suck(){
		suckerB1.set(1.0);
		suckerB2.set(-1.0);
	}
	
	public void Spit(){
		suckerB1.set(-1.0);
		suckerB2.set(1.0);
	}
	
	public void Stop(){
		suckerB1.set(0);
		suckerB2.set(0);
	}
}