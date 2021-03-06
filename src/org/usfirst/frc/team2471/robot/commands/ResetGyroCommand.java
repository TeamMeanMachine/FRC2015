package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetGyroCommand extends Command {
	double startOffset; 
    
    public ResetGyroCommand(double _startOffset) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	startOffset = _startOffset; 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        RobotMap.swerve.setGyroOffset(startOffset);
        RobotMap.gyro.reset();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
