package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTimeCommand extends Command {
	double time, stoptime;
    double x;
    double y;
    double r;
    double s;
    boolean started = false;
    
    public DriveTimeCommand( double _time, double _x, double _y, double _r, double _s ) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(RobotMap.swerve);
        
        x = _x;
        y = _y;
        r = _r;
        s = _s;
        time = _time;
        setTimeout(time);
    }

    public boolean isInterruptible() {
        return false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(time);
        RobotMap.swerve.resetDistance();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//        if(!started) {
//            boolean started = true;
//            setTimeout(time);
//        }
        double gyroAngle = -RobotMap.gyro.getAngle() * (Math.PI/180.0);
        RobotMap.swerve.drive(x, y, r, s, gyroAngle, 0.0, 0.0, false, 0.0, true, true, false);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        boolean rtn = isTimedOut();
        System.out.println("DTC execute: " + rtn);
        return rtn;
    }

    // Called once after isFinished returns true
    protected void end() {
        started = false;
        double gyroAngle = -RobotMap.gyro.getAngle() * (Math.PI/180.0);
        RobotMap.swerve.drive(0.0, 0.0, 0.0, 0.0, gyroAngle, 0.0, 0.0, false, 0.0, true, true, false);  // stop motors
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("DTC interrupted");
        end();
    }
}
