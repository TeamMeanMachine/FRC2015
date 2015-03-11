package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SuckRaw extends Command{

	static double powerLeft;
	static double powerRight;
	
	public SuckRaw(double left, double right){
		requires(Robot.sucker);
		powerLeft = left;
		powerRight = right;
	}
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		
		Robot.sucker.suckLeft(powerLeft);
		Robot.sucker.suckRight(-powerRight);
	}

	@Override
	protected boolean isFinished() {
		
		return false;
	}

	@Override
	protected void end() {
		
		Robot.sucker.suckLeft(0);
		Robot.sucker.suckRight(0);
	}

	@Override
	protected void interrupted() {
		Robot.sucker.suckLeft(0);
		Robot.sucker.suckRight(0);
	}

}
