package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.OI;
import org.usfirst.frc.team2471.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class BinLifterX extends Command  {

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
	//	Robot.binLifter.Lift(Joystick.AxisType.);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.lifter.SetRawLift(0);
	}

}
