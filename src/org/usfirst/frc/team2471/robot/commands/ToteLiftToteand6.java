package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;
import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ToteLiftToteand6 extends CommandGroup  {

	public ToteLiftToteand6() {
		// TODO Auto-generated constructor stub
		requires(Robot.lifter);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
	//	Robot.lifter.CoopertitionDefault();
		addSequential(new ToteLiftPickupPreset());
		addSequential(new ToteLiftDefault());
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
