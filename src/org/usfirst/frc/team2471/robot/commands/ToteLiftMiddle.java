package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;
import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ToteLiftMiddle extends Command  {

	public ToteLiftMiddle() {
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
		if(RobotMap.bToteMid.getVoltage() < 0.2  || RobotMap.bToteMax.getVoltage() >= 0.7 || RobotMap.bUpperlimit.get()){
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
