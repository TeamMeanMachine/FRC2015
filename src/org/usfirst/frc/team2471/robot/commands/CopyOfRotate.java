package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;
import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class CopyOfRotate extends PIDCommand{

	
	public CopyOfRotate(double degrees) {
		super(0.5, 0, 0);
		setInputRange(0.0, 180.0);
		setSetpoint(degrees);
	}

	@Override
	protected double returnPIDInput() {
		return RobotMap.lRotate.getTotalDegrees();
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.binLifter.rotate(output);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return getPIDController().onTarget();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
