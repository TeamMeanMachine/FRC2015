package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class BinLifterCommand extends Command  {
	
	public BinLifterCommand() {
		requires(Robot.binLifter);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.binLifter.Lift(Robot.oi.coStick.getRawAxis(1));
		Robot.binLifter.Rotate(Robot.oi.coStick.getRawAxis(2));
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.binLifter.Lift(0);
		Robot.binLifter.Rotate(0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.binLifter.Lift(0);
		Robot.binLifter.Rotate(0);
	}

}
