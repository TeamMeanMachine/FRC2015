// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc.team2471.robot.subsystems;
import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;
import org.usfirst.frc.team2471.robot.RobotMap;;
import org.usfirst.frc.team2471.robot.commands.*;
import org.usfirst.frc.team2471.robot.Filter;
import org.usfirst.frc.team2471.robot.SwerveVector;
/**
 *
 */
public class SwerveDrive extends Subsystem  {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public SwerveVector rfVect, lfVect, rrVect, lrVect;
    double turnPower;
    double gyroAngle;
    double gyroOffset;
    double accelerometerAngle;
    double turnJoystickAngle;
    Filter accelFilterX;
    Filter accelFilterY;
    boolean autoSteer;
    boolean fieldSteer, fieldMove;
    double prevXVelocity, prevYVelocity;
    boolean handsOffStarted = false;
    double timeHandsOffStarted = 0.0;
    PIDController turnPositionPID;
    PIDController turnSpeedPID;
    double turnSpeedFeed;
    double turnSpeedSum;
    double turnSpeed;
    static final double TURN_DEAD_BAND = 0.05;
    double totalDistance;
    double prevLF, prevRF, prevLR, prevRR;
    double turnPIDOutput = 0.0;
    
    public SwerveDrive() {
        turnPositionPID = new PIDController(-1.5, -0.0, -6.0, new PidTurnPositionSourceOutput(), new PidTurnPositionSourceOutput());
        turnPositionPID.setInputRange( -Math.PI, Math.PI );
        turnPositionPID.setContinuous( true );
        turnPositionPID.setAbsoluteTolerance( Math.PI/180.0*5.0 );
        turnPositionPID.setOutputRange(-1.0, 1.0);
        turnPositionPID.enable();
        SmartDashboard.putData("Turn Position PID", turnPositionPID);

        accelerometerAngle = 0.0;
        autoSteer = false;
        fieldSteer = false;
        fieldMove = true;
        prevXVelocity = 0;
        prevYVelocity = 0;
        handsOffStarted = false;
        timeHandsOffStarted = 0.0;
        gyroAngle = 0.0;
        gyroOffset = 0.0;
        totalDistance = 0.0;
//        prevRR = RobotMap.rightRearSpeedEnc.getDistance();
        
        turnSpeed = 0;
        turnSpeedPID = new PIDController(-0.05, -0.0, -0.0, new PidTurnSpeedSourceOutput(), new PidTurnSpeedSourceOutput());
        turnSpeedPID.setInputRange( -6.0, 6.0 );
        turnSpeedPID.setOutputRange(-1.0, 1.0);
        turnSpeedPID.setAbsoluteTolerance( 0.01 );
        turnSpeedFeed = 0.0;
        turnSpeedSum = 0.0;
        SmartDashboard.putData("Turn Speed PID", turnSpeedPID);

        lrVect= new SwerveVector(RobotMap.leftRearSwerve, -11.0,-11.0, Math.PI/4.0); 
        lfVect= new SwerveVector(RobotMap.leftFrontSwerve, -11.0,11.0, -Math.PI/4.0);  
        rrVect= new SwerveVector(RobotMap.rightRearSwerve, 11.0,-11.0, -Math.PI/4.0); 
        rfVect= new SwerveVector(RobotMap.rightFrontSwerve, 11.0,11.0, Math.PI/4.0);
        
        SmartDashboard.putData("Swerve Drive Subsystem", this);
    }

    class PidTurnPositionSourceOutput implements PIDSource, PIDOutput {
        public PidTurnPositionSourceOutput() {
        }
        public double pidGet() {
            return gyroAngle;
        }
        public void pidWrite(double output) {
            if (fieldSteer || autoSteer){
                turnPower = output;
            }
        }
    }

    class PidTurnSpeedSourceOutput implements PIDSource, PIDOutput {
        public PidTurnSpeedSourceOutput() {
        }
        public double pidGet() {
            return RobotMap.gyro.getRate();
        }
        public void pidWrite(double out) {  // commented out to disable speed control for rotation of robot, still winds up when moving.
            turnPIDOutput = out;
//            if (!fieldSteer && !autoSteer) {
//                turnSpeedSum = turnSpeedSum + out;
//                turnPower = turnSpeedFeed + turnSpeedSum;
//                if (turnPower>1) {
//                    turnSpeedSum = turnSpeedSum - (turnPower-1);  // cap the turnSpeedSum too, to prevent wind up
//                    turnPower = 1;
//                }
//                else if (turnPower<-1) {
//                    turnSpeedSum = turnSpeedSum - (turnPower-(-1));  // cap the turnSpeedSum too
//                    turnPower = -1;
//                }
//            }
        }
    }
    
    public void drive( double x, double y, double r, double s, double _gyroAngle,
            double accelX, double accelY, boolean _autoSteer, double _turnSpeed,
            boolean _fieldMove, boolean _fieldSteer, boolean trackBall )
    {
        turnSpeed = _turnSpeed;
        autoSteer = _autoSteer;
        gyroAngle = _gyroAngle + gyroOffset;
        fieldMove = _fieldMove;
        fieldSteer = _fieldSteer;
        SmartDashboard.putNumber("gyroAngle", -gyroAngle);
        GetAccelerationFromJoyStick(x, y);
        accumulateDistanceTraveled();
        
        if (trackBall) {
            double visionR = 0.0;
            try {
                visionR = 2.0 * NetworkTable.getTable("SmartDashboard").getNumber("COG_X", 0.0) / 480.0 - 1.0;
            }
            catch(TableKeyNotDefinedException e) { 
                System.out.println(e);
            }
            r = r + visionR * 0.5;
        }
        
//System.out.println("x: " + x + " y: " + y + " r: " + r + " s: " + s);
        if (Math.abs(x)<0.1) {
            x = 0.0;
        }

        if (Math.abs(y)<0.1) {
            y = 0.0;
        }

        if (Math.abs(r)<0.1) {
            r = 0.0;
        }

        if (Math.abs(s)<0.1) {
            s = 0.0;
        }
        
        double magnitude = Math.sqrt( x*x + y*y );
        double turnMag = Math.sqrt( r*r + s*s );
        
        if (!autoSteer) {
            if (magnitude < 0.1 && turnMag < TURN_DEAD_BAND ) {    // check for HandsOff
                turnSpeedSum = 0.0;
                lrVect.SetPower(0.0);
                lfVect.SetPower(0.0);
                rrVect.SetPower(0.0);
                rfVect.SetPower(0.0);
                return;
            }
        }
        
        if (fieldSteer && turnMag>TURN_DEAD_BAND) {
            turnJoystickAngle = MathUtils.atan2( -r, s );  // convert the right stick to a goal angle for robot orientation
            SmartDashboard.putNumber("joyStickAngle", -turnJoystickAngle);
            if (!autoSteer) {
                turnPositionPID.setSetpoint( turnJoystickAngle );
                turnPositionPID.enable();
            }
        }
        if (autoSteer) {
            turnPositionPID.setSetpoint( accelerometerAngle );
            turnPositionPID.enable();
        }

        if (!fieldSteer && !autoSteer) {  // this code allows non-field turning to pid for speed of turning
//            turnSpeedPID.setSetpoint(r*r*r*-5.0);  // top speed at 70%, is 6 radians / sec, but it seems to fast
//            turnSpeedPID.enable();
//            turnSpeedFeed = r*r*r * 5/6; // 1.0 turnPower is too fast.
            turnPower = r; //*r*r;  // Simple mapping of joystick to turnPower
        }
        else {
            turnSpeedPID.disable();            
        }
        
        double tempGyro;
        if (fieldMove) {
            tempGyro = gyroAngle;
        }
        else {
            tempGyro = 0;
        }
        
        SmartDashboard.putNumber("TurnPower", turnPower);
        
        // find requested power from each wheel module
        double lrPower = lrVect.drive(x, y, turnPower, tempGyro);
        double lfPower = lfVect.drive(x, y, turnPower, tempGyro);
        double rrPower = rrVect.drive(x, y, turnPower, tempGyro);
        double rfPower = rfVect.drive(x, y, turnPower, tempGyro);
        
        // take the largest power or 1.0 max
        double maxPower = Math.max( 1.0, Math.max( lrPower, Math.max( lfPower, Math.max( rrPower, rfPower) ) ) );
        
        // have each module scale their request down accordingly
        lrVect.SetMaxPower( maxPower );
        lfVect.SetMaxPower( maxPower );
        rrVect.SetMaxPower( maxPower );
        rfVect.SetMaxPower( maxPower );
    }
    
    public void setGyroOffset(double _gyroOffset) {
        gyroOffset = _gyroOffset;
    }
       
    void accumulateDistanceTraveled() {
//        double currentLF = RobotMap.leftFrontSpeedEnc.getDistance();
//        double currentRF = RobotMap.rightFrontSpeedEnc.getDistance();
//        double currentLR = RobotMap.leftRearSpeedEnc.getDistance();
//        double currentRR = RobotMap.rightRearSpeedEnc.getDistance();
//        
//        totalDistance = totalDistance + 
//                (Math.abs(currentLF-prevLF) +
//                  Math.abs(currentRF-prevRF) +
//                  Math.abs(currentLR-prevLR) +
//                  Math.abs(currentRR-prevRR)) / 4.0;
////        totalDistance = totalDistance + 
////                Math.abs(currentRR-prevRR);
//        
//        SmartDashboard.putNumber( "graph", totalDistance );
//        prevLF = currentLF;
//        prevRF = currentRF;
//        prevLR = currentLR;
//        prevRR = currentRR;
    }
    
    public double getTotalDistance() {
        return totalDistance;
    }
    
    public void resetDistance() {
        totalDistance = 0.0;
//        prevLF = RobotMap.leftFrontSpeedEnc.getDistance();
//        prevRF = RobotMap.rightFrontSpeedEnc.getDistance();
//        prevLR = RobotMap.leftRearSpeedEnc.getDistance();
//        prevRR = RobotMap.rightRearSpeedEnc.getDistance();
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new DriveLoop());
    }
    
    private void GetAccelerationFromJoyStick(double x, double y) {
        // use particle simulation to estimate acceleration from left joystick input
        double xVelocity = prevXVelocity + x;  // update velocity with accel from joystick
        double yVelocity = prevYVelocity + y;
        xVelocity = xVelocity * 0.995;  // viscous drag
        yVelocity = yVelocity * 0.995;
        double xAccel = xVelocity - prevXVelocity;  // compute new accel
        double yAccel = yVelocity - prevYVelocity;
        if (Math.abs(xAccel)>0.05 || Math.abs(yAccel)>0.05) {
           accelerometerAngle = MathUtils.atan2(-xAccel, yAccel);
           SmartDashboard.putNumber("accel angle", -accelerometerAngle);
        }
        prevXVelocity = xVelocity;
        prevYVelocity = yVelocity;
    }
}
