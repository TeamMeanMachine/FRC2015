package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;
import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class RotateBrake extends PIDCommand {

	public RotateBrake() {
		super(0.005, 0.0, 0.0);
		requires(Robot.binLifter);
		getPIDController().setPercentTolerance(0.1);
		setInputRange(0.0, 360.0);
		getPIDController().setOutputRange(-1.0, 1.0);
		setSetpoint(RobotMap.lRotate.getTotalDegrees());
		// TODO Auto-generated constructor stub
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return RobotMap.lRotate.getTotalDegrees();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		Robot.binLifter.rotate(-output);
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
		Robot.binLifter.rotate(0.0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}
}
