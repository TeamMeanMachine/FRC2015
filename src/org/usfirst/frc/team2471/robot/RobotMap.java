package org.usfirst.frc.team2471.robot;

import org.usfirst.frc.team2471.robot.subsystems.SwerveDrive;

import edu.wpi.first.wpilibj.CANTalon;
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
	public static Encoder lRotation;
	
	//Bryce Lifter
	public static SpeedController bMotorlift;
	public static DigitalInput bUpperlimit;   //CHANGE TO ULTRASONIC OR SOMETHING OF THE SORT
	public static DigitalInput bTotelimit;
	public static DigitalInput bToteand6; // COOPERTITION PRESET
	public static DigitalInput bLowerLimit; // DEFAULT LIMIT ON INIT
	
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
		lMotor1 = new Talon(13);
		lMotor2 = new Talon(12);
		lSolenoid1 = new Solenoid(0);
		lRotation = new Encoder(1, 0);
		lUpperLimit = new DigitalInput(7);
		lLowerLimit = new DigitalInput(2);
		
		//Bryce Lifter
		bMotorlift = new Talon(11);
		bUpperlimit = new DigitalInput(3);
		bLowerLimit = new DigitalInput(4);
		bTotelimit = new DigitalInput(5);
		bToteand6 = new DigitalInput(6); //COOPERTITION PRESET
		
		//Bryce Pusher
		bPush1 = new Solenoid(1);
		bPush2 = new Solenoid(2);
		bPush3 = new Solenoid(3);
		bPush4 = new Solenoid(4);
		
		//Bryce Sucker
		bSucker1 = new Talon(10);
		bSucker2 = new Talon(9);
		
		//Bryce Swerves of doom
		// **************************** LF ************************
        leftFrontTwist = new CANTalon(1);
        leftFrontTwistEnc = new MagnePot(3);
        //int aSlot, int aChannel, int bSlot, int bChannel, int indexSlot, int indexChannel
        //leftFrontSpeedEnc = new Encoder(1,5, 1,4);
        leftFrontSpeed = new CANTalon(2);
        leftFrontSwerve = new SwerveModule("LF", leftFrontSpeed, leftFrontSpeedEnc, leftFrontTwist, leftFrontTwistEnc ); //SpeedController _speedController, Encoder _speedEnc, SpeedController _twistController, Encoder _twistEnc
        leftFrontSwerve.setTwistOffset(-Math.PI/4.0 + Math.PI/180);

        // **************************** LR ************************
        leftRearTwist = new CANTalon(3);
        leftRearTwistEnc = new MagnePot(4);
        //int aSlot, int aChannel, int bSlot, int bChannel, int indexSlot, int indexChannel
        //leftRearSpeedEnc = new Encoder(1,11, 1,10);
        leftRearSpeed = new CANTalon(4);
        leftRearSwerve = new SwerveModule("LR", leftRearSpeed, leftRearSpeedEnc, leftRearTwist, leftRearTwistEnc ); //SpeedController _speedController, Encoder _speedEnc, SpeedController _twistController, Encoder _twistEnc
        leftRearSwerve.setTwistOffset(Math.PI/4.0 + Math.PI*5.0/180);

        // **************************** RF ************************
        rightFrontTwist = new CANTalon(5);
        rightFrontTwistEnc = new MagnePot(5);
        //int aSlot, int aChannel, int bSlot, int bChannel, int indexSlot, int indexChannel
        //rightFrontSpeedEnc = new Encoder(2,8, 2,7);
        rightFrontSpeed = new CANTalon(6);
        rightFrontSwerve = new SwerveModule("RF", rightFrontSpeed, rightFrontSpeedEnc, rightFrontTwist, rightFrontTwistEnc ); //SpeedController _speedController, Encoder _speedEnc, SpeedController _twistController, Encoder _twistEnc
        rightFrontSwerve.setTwistOffset(-3.0*Math.PI/4.0);

        // **************************** RR ************************
        rightRearTwist = new CANTalon(7);
        rightRearTwistEnc = new MagnePot(6);
        //int aSlot, int aChannel, int bSlot, int bChannel, int indexSlot, int indexChannel
        //rightRearSpeedEnc = new Encoder(2,5, 2,6);
        rightRearSpeed = new CANTalon(8);
        rightRearSwerve = new SwerveModule("RR", rightRearSpeed, rightRearSpeedEnc, rightRearTwist, rightRearTwistEnc ); //SpeedController _speedController, Encoder _speedEnc, SpeedController _twistController, Encoder _twistEnc
        rightRearSwerve.setTwistOffset(3.0*Math.PI/4.0 + Math.PI*7.0/180);
        
		swerve = new SwerveDrive();
	}
	
	
}
