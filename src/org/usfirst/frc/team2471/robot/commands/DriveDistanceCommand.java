package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
/**
 *
 * @author FIRST
 */
public class DriveDistanceCommand extends Command {
    double distance;
    double x;
    double y;
    double r;
    double s;
    boolean started = false;
    double startDistance;
    
    public DriveDistanceCommand( double _distance, double _x, double _y, double _r, double _s, double _timeout ) {
    	this(_distance, _x, _y, _r, _s);
    	setTimeout(_timeout);
    }
    public DriveDistanceCommand( double _distance, double _x, double _y, double _r, double _s ) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(RobotMap.swerve);
        
        x = _x;
        y = _y;
        r = _r;
        s = _s;
        distance = _distance;
        System.out.println("drive distance constructed.");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(!started) {
            //startDistance = (Math.abs(RobotMap.leftRearSpeedEnc.getDistance()) + Math.abs(RobotMap.rightRearSpeedEnc.getDistance()) + Math.abs(RobotMap.leftFrontSpeedEnc.getDistance()) + Math.abs(RobotMap.rightFrontSpeedEnc.getDistance()))/4;
            startDistance = (Math.abs(RobotMap.leftRearSpeedEnc.getDistance()) + Math.abs(RobotMap.rightRearSpeedEnc.getDistance()))/2;
            //startDistance = (Math.abs(RobotMap.leftRearSpeedEnc.getDistance()));
            started = true;
        }
        double gyroAngle = -RobotMap.gyro.getAngle() * (Math.PI/180.0);
        RobotMap.swerve.drive(x, y, r, s, gyroAngle, 0.0, 0.0, false, 0.0, true, true, false);
        //System.out.println("Encoder Thing: " + (Math.abs(RobotMap.leftRearSpeedEnc.getDistance())));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        System.out.println("SD: " + startDistance);
//        System.out.println("Sonar: " + RobotMap.sonar.getDistance());
//        System.out.println("Distance: " + distance);
        //return ((Math.abs(RobotMap.leftRearSpeedEnc.getDistance()) + Math.abs(RobotMap.rightRearSpeedEnc.getDistance()) + Math.abs(RobotMap.leftFrontSpeedEnc.getDistance()) + Math.abs(RobotMap.rightFrontSpeedEnc.getDistance()))/4 ) - startDistance > distance || isTimedOut();
    	//System.out.println((Math.abs(RobotMap.leftRearSpeedEnc.getDistance()) + Math.abs(RobotMap.rightRearSpeedEnc.getDistance()))/2);
        return (((Math.abs(RobotMap.leftRearSpeedEnc.getDistance()) + Math.abs(RobotMap.rightRearSpeedEnc.getDistance()))/2) - startDistance > distance) || isTimedOut();
        //return ((Math.abs(RobotMap.leftRearSpeedEnc.getDistance()) - startDistance > distance) || isTimedOut());
        //return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        double gyroAngle = -RobotMap.gyro.getAngle() * (Math.PI/180.0);
        RobotMap.swerve.drive(0.0, 0.0, 0.0, 0.0, gyroAngle, 0.0, 0.0, false, 0.0, true, true, false);  // stop motors
        started = false;
        //new ResetDriveEncoders();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
