// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc.team2471.robot.commands;
import org.usfirst.frc.team2471.robot.Robot;
import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class  DriveLoop extends Command {
    double prevAngle = 0.0;
    double prevTime = 0.0;
    public DriveLoop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(RobotMap.swerve);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double x =  Robot.oi.driverStick.getAxis(Joystick.AxisType.kX);
        double y = -Robot.oi.driverStick.getAxis(Joystick.AxisType.kY);  // odd, but up is negative
        double r =  Robot.oi.driverStick.getAxis(Joystick.AxisType.kZ);
        double r2 = Robot.oi.coStick.getRawAxis(4);
        if (Math.abs(r2) < 0.25) {
            r2 = 0.0;
        }
        
        double s = -Robot.oi.driverStick.getAxis(Joystick.AxisType.kThrottle);  // kThrottle is the y of the right stick
        double gyroAngle = -RobotMap.gyro.getAngle() * (Math.PI/180.0);
//        double gyroAngle = -RobotMap.compass.getAngle() * (Math.PI/180.0);
        double accelX = 0;//RobotMap.accel.getAcceleration(ADXL345_I2C.Axes.kX);
        double accelY = 0;//RobotMap.accel.getAcceleration(ADXL345_I2C.Axes.kY);
        double accelZ = 0;//RobotMap.accel.getAcceleration(ADXL345_I2C.Axes.kZ);
        double time = Timer.getFPGATimestamp();
        double turnSpeed = (gyroAngle - prevAngle)/(time - prevTime);
        prevTime = time;
        prevAngle = gyroAngle;
//        SmartDashboard.putNumber("Turn Speed", turnSpeed);
//        boolean autoSteer = false;
//        boolean trackBall = RobotTemplate.oi.autoSteerButton.get();
        boolean fieldMove = SmartDashboard.getBoolean("FieldMove", true);
        boolean fieldSteer = SmartDashboard.getBoolean("FieldSteer", false);
        
       RobotMap.swerve.drive(x,y,r+0.7*r2,s,gyroAngle,accelX,accelY, fieldSteer, fieldMove);

//System.out.println( "AccelX: " + accelX + " AccelY: " + accelY + " AccelZ: " + accelZ);
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    // Called once after isFinished returns true
    protected void end() {
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
