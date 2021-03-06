package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class VariableSuck extends Command{
	
	public VariableSuck(){
		requires(Robot.sucker);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method uire
		
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		double rightAxis  = Robot.oi.coStick.getRawAxis(2);
		double leftAxis = Robot.oi.coStick.getRawAxis(3);
		
		if (rightAxis - leftAxis < 0){
			rightAxis = rightAxis - (0.25 * Math.abs(rightAxis - leftAxis));
		}
		else if(leftAxis - rightAxis < 0){
			leftAxis = leftAxis - (0.25 * Math.abs(leftAxis - rightAxis));
		}
		
		Robot.sucker.suckRight(-rightAxis);
		Robot.sucker.suckLeft(leftAxis);
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
