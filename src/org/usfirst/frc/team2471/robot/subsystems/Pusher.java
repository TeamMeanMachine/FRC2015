package org.usfirst.frc.team2471.robot.subsystems;

import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pusher extends Subsystem {
	
	Solenoid bPusher1;
	Solenoid bPusher2;
	Solenoid bPusher3;
	Solenoid bPusher4;
	
	public Pusher(){
		bPusher1 = RobotMap.bPush1;
		bPusher2 = RobotMap.bPush2;
		bPusher3 = RobotMap.bPush3;
		bPusher4 = RobotMap.bPush4;
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	public void Push(){
		bPusher1.set(true);
		bPusher2.set(true);
		bPusher3.set(true);
		bPusher4.set(true);
	}
	
	public void ResetRaw(){
		bPusher1.set(false);
		bPusher2.set(false);
		bPusher3.set(false);
		bPusher4.set(false);
	}
}