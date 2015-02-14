package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;
import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ToteLiftToteand6 extends Command  {

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
		Robot.lifter.Liften4days();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		if (RobotMap.bToteMax.getVoltage() >= .7){
			return true;
		}
		return true;
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
