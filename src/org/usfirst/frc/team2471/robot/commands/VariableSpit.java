package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class VariableSpit extends Command{

	static double powerLeft;
	static double powerRight;
	
	public VariableSpit(double left, double right){
		requires(Robot.sucker);
		powerLeft = left;
		powerRight = right;
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.sucker.suckLeft(-powerLeft);
		Robot.sucker.suckRight(powerRight);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.sucker.suckLeft(0);
		Robot.sucker.suckRight(0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.sucker.suckLeft(0);
		Robot.sucker.suckRight(0);
	}
}
