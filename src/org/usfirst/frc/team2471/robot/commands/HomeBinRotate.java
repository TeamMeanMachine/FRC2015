package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;
import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HomeBinRotate extends Command {

    public HomeBinRotate() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.claw.rotate(0.25);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.lRotateHome.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.lRotate.reset();
    	Robot.claw.rotate(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.claw.rotate(0.0);
    }
}
