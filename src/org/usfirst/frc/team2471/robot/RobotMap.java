package org.usfirst.frc.team2471.robot;

import org.usfirst.frc.team2471.robot.subsystems.SwerveDrive;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following  to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	//Lucas Lifter
	public static SpeedController lMotor1;
	public static SpeedController lMotor2;
	public static Solenoid lSolenoid1;
	public static DigitalInput lUpperLimit;
	public static DigitalInput lLowerLimit;
	
	//Bryce Lifter
	public static SpeedController bMotorlift;
	public static DigitalInput bUpperlimit;
	public static DigitalInput bLowerLimit;
	
	//Bryce Pusher
	public static Solenoid bPush1;
	public static Solenoid bPush2;
	public static Solenoid bPush3;
	public static Solenoid bPush4;
	
	//Bryce Sucker
	public static SpeedController bSucker1;
	public static SpeedController bSucker2;
	
	//AHAM..... SWERVES
	//LEFT
	 public static SpeedController
	 leftFrontTwist,
	 leftRearTwist,
	 rightRearTwist,
	 rightFrontTwist;
	 
	 //RIGHT
	 public static SpeedController
	 leftFrontSpeed,
	 leftRearSpeed,
	 rightRearSpeed,
	 rightFrontSpeed;
	
	 //MODULE STUFF

	 public static MagnePot leftFrontTwistEnc, leftRearTwistEnc, rightRearTwistEnc, rightFrontTwistEnc;
	 public static Encoder leftFrontSpeedEnc, leftRearSpeedEnc, rightRearSpeedEnc, rightFrontSpeedEnc;
	 public static SwerveModule leftFrontSwerve, leftRearSwerve, rightRearSwerve, rightFrontSwerve;
	 public static SwerveDrive swerve;
	 public static Gyro gyro;
	 
	 
	public static void init(){
		//Basic Robot stuff
		gyro = new Gyro(1);
		
		//Lucas Lifter
		lMotor1 = new Talon(1);
		lMotor2 = new Talon(2);
		lSolenoid1 = new Solenoid(0);
		
		//Bryce Lifter
		bMotorlift = new Talon(3);
		
		//Bryce Sucker
		bSucker1 = new Talon(4);
		bSucker2 = new Talon(5);
	}
	
	
}
