package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;
import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class HomeBin extends Command {

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.binLifter.Lift(-0.5);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return !RobotMap.lLowerLimit.get();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		RobotMap.lEnc.reset();
		Robot.binLifter.Lift(0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.binLifter.Lift(0);
	}

}
