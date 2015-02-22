package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class VariableSuck extends Command{

	@Override
	protected void initialize() {
		// TODO Auto-generated method uire
		requires(Robot.sucker);
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Robot.sucker.suckRight(Robot.oi.coStick.getRawAxis(2));
		Robot.sucker.suckLeft(Robot.oi.coStick.getRawAxis(3));
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.sucker.suckRight(0);
		Robot.sucker.suckLeft(0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.sucker.suckRight(0);
		Robot.sucker.suckLeft(0);
	}

}
