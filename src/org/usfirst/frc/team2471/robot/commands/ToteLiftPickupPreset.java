package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;
import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ToteLiftPickupPreset extends Command  {

	public ToteLiftPickupPreset() {
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
		Robot.lifter.BottomGoto();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		if(RobotMap.bLowerLimit.get()){
			return true;
		}
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.lifter.SetRawLift(0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.lifter.SetRawLift(0);
	}

}
