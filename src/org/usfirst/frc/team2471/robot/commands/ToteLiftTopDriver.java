package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;
import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ToteLiftTopDriver extends Command{

	public ToteLiftTopDriver() {
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
		Robot.lifter.TopGoto();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		if(RobotMap.bToteMax.getVoltage() >= 2.3 || RobotMap.bUpperlimit.get() || RobotMap.pdp.getCurrent(11) > 70.0 ){
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
