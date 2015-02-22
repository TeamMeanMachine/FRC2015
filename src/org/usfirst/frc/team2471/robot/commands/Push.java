package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;
import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Push extends Command{

	public Push(){
		requires(Robot.pusher);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		RobotMap.bCatch.set(false);
		Robot.pusher.Push(true);
		Robot.sucker.Spit();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
//		Robot.pusher.ResetRaw();
		Robot.sucker.Stop();
		Robot.pusher.Push(false);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
//		Robot.pusher.ResetRaw();
		Robot.sucker.Stop();
		Robot.pusher.Push(false);
	}

}
