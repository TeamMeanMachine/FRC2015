package org.usfirst.frc.team2471.robot.subsystems;

import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pusher extends Subsystem {
	
	Solenoid bPusher1;
	public Pusher(){
		bPusher1 = RobotMap.bPush1;
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
	public void Push(boolean state){
		bPusher1.set(state);
	}
	
	public void ResetRaw(){
		bPusher1.set(false);
	}
}