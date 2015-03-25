package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;
import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ShoulderShrug extends Command{

	boolean boolie;
	public ShoulderShrug (boolean bool){
		requires(Robot.grabber);
		boolie = bool;
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.grabber.grab(boolie);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.grabber.grab(false);
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.grabber.grab(false);
	}

}
