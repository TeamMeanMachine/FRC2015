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
		suckerB1.set(.85);
		suckerB2.set(-.85);
	}
	
	public void Spit(){
		suckerB1.set(-0.4);
		suckerB2.set(0.4);
	}
	
	public void Stop(){
		suckerB1.set(0);
		suckerB2.set(0);
	}
	
	public void suckRight( double power){
		suckerB1.set(power);
	}
	
	public void suckLeft( double power){
		suckerB2.set(power);
	}
}