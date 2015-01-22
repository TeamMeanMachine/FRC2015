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
}