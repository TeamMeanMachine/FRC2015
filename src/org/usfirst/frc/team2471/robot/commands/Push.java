package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;

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
		Robot.pusher.Push();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		Robot.pusher.ResetRaw();
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.pusher.ResetRaw();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.pusher.ResetRaw();
	}

}
