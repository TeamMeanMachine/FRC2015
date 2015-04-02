package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;
import org.usfirst.frc.team2471.robot.RobotMap;

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
//		double powerLeft = 0.0;
//		if(Robot.oi.coStick.getRawButton(4)){
//			powerLeft = 1.0;
//		}
//		double powerRight = 0.0;
//		if(Robot.oi.coStick.getRawButton(1)){
//			powerRight = 1.0;
//		}
//		double minPower = 0.25;
//		double multiplier = -0.5*(1.0-minPower) * Math.cos(RobotMap.lRotate.getTotalDegrees()*2 * Math.PI / 180.0) + (1.0-0.5*(1.0-minPower));
//		if(powerLeft > 0.1) {
//			Robot.binLifter.rotateUp(1.0);
//		}
//		else if(powerRight > 0.1) {
//			Robot.binLifter.rotateDown(1.0);   
//		}
//		else {
//			Robot.binLifter.rotate(0.0);
//		}
//		
		
//		double powerUp = Robot.oi.coStick.getRawAxis(2);
//		double powerDown = Robot.oi.coStick.getRawAxis(3);
		if(Robot.oi.coStick.getRawButton(6)) {  // up
			Robot.binLifter.Lift(-1.0);
		}
		else if(Robot.oi.coStick.getRawButton(5)) {  // down
			Robot.binLifter.Lift(0.75);
		}
		else {
			Robot.binLifter.Lift(0.0);
		}
		//Robot.binLifter.Rotate(Robot.oi.coStick.getRawAxis(3));
		//Robot.binLifter.Lift();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.binLifter.rotate(0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		Robot.binLifter.rotate(0);
	}

}
