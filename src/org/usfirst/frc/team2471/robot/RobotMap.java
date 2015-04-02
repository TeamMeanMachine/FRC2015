package org.usfirst.frc.team2471.robot;

import org.usfirst.frc.team2471.robot.subsystems.SwerveDrive;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	public static Encoder lEnc;
	public static AbsoluteEncoder lRotate;
	public static DigitalInput lRotateHome;
	
	//Bryce Lifter
	public static SpeedController bMotorlift;
	public static DigitalInput bUpperlimit;   //CHANGE TO ULTRASONIC OR SOMETHING OF THE SORT
	public static DigitalInput bTotelimit;
	public static DigitalInput bToteand6; // COOPERTITION PRESET
	public static DigitalInput bLowerLimit; // DEFAULT LIMIT ON INIT
	public static Solenoid bCatch;
	public static Solenoid bHolderThing;
	public static AnalogInput bToteMax;
	public static AnalogInput bToteMid;
	
	//Bryce Pusher
	public static Solenoid bPush1;
	
	//Bryce Sucker
	public static SpeedController bSucker1;
	public static SpeedController bSucker2;
	
	//Lucas Graber
	public static Solenoid lGrabber;
	
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
	 
	 public static PowerDistributionPanel pdp;
	 
	 public static Servo servo;
	 
	 
	public static void init(){
		//Basic Robot stuff
		gyro = new Gyro(1);
		
		//Lucas Lifter
		lMotor1 = new Talon(1);
		lMotor2 = new Talon(4);
		lSolenoid1 = new Solenoid(0);
		lEnc = new Encoder(5, 6);
		lUpperLimit = new DigitalInput(0);
		lLowerLimit = new DigitalInput(1);
		lRotate = new AbsoluteEncoder(5);
		lRotate.setSensitivity(18.0);
		lRotateHome = new DigitalInput(4);
		
		//Bryce Lifter
		bMotorlift = new Talon(0);
		bUpperlimit = new DigitalInput(2);
		bLowerLimit = new DigitalInput(3);
	//	bTotelimit = new DigitalInput(5);		TO DO Ultrasonic
	//	bToteand6 = new DigitalInput(7); //COOPERTITION PRESET
		bCatch = new Solenoid(2);
		bToteMax = new AnalogInput(6);
		bToteMid = new AnalogInput(7);
		bHolderThing = new Solenoid(3);
		
		
		//Bryce Pusher
		bPush1 = new Solenoid(1);
		
		//Bryce Sucker
		bSucker1 = new Talon(3);
		bSucker2 = new Talon(2);
		
		//Lucas Grabber
		lGrabber = new Solenoid(4);
		
		//Bryce Swerves of doom
		// **************************** LF ************************
        leftFrontTwist = new CANTalon(1);
        leftFrontTwistEnc = new MagnePot(3);
        //int aSlot, int aChannel, int bSlot, int bChannel, int indexSlot, int indexChannel
        leftFrontSpeedEnc = new Encoder(11, 12);
        leftFrontSpeed = new CANTalon(6);
        leftFrontSwerve = new SwerveModule("LF", leftFrontSpeed, leftFrontSpeedEnc, leftFrontTwist, leftFrontTwistEnc ); //SpeedController _speedController, Encoder _speedEnc, SpeedController _twistController, Encoder _twistEnc
        leftFrontSwerve.setTwistOffset(Math.PI);

        // **************************** LR ************************
        leftRearTwist = new CANTalon(3);
        leftRearTwistEnc = new MagnePot(0);
        //int aSlot, int aChannel, int bSlot, int bChannel, int indexSlot, int indexChannel
        leftRearSpeedEnc = new Encoder(7, 8);
        leftRearSpeedEnc.setDistancePerPulse(0.0208);
        leftRearSpeed = new CANTalon(4);
        leftRearSwerve = new SwerveModule("LR", leftRearSpeed, leftRearSpeedEnc, leftRearTwist, leftRearTwistEnc ); //SpeedController _speedController, Encoder _speedEnc, SpeedController _twistController, Encoder _twistEnc
        leftRearSwerve.setTwistOffset(0.0);

        // **************************** RF ************************
        rightFrontTwist = new CANTalon(5);
        rightFrontTwistEnc = new MagnePot(2);
        //int aSlot, int aChannel, int bSlot, int bChannel, int indexSlot, int indexChannel
        rightFrontSpeedEnc = new Encoder(13, 14);
        rightFrontSpeed = new CANTalon(2);
        rightFrontSwerve = new SwerveModule("RF", rightFrontSpeed, rightFrontSpeedEnc, rightFrontTwist, rightFrontTwistEnc ); //SpeedController _speedController, Encoder _speedEnc, SpeedController _twistController, Encoder _twistEnc
        rightFrontSwerve.setTwistOffset(Math.PI);

        // **************************** RR ************************
        rightRearTwist = new CANTalon(7);
        rightRearTwistEnc = new MagnePot(4);
        //int aSlot, int aChannel, int bSlot, int bChannel, int indexSlot, int indexChannel
        rightRearSpeedEnc = new Encoder(9, 10);
        rightRearSpeedEnc.setDistancePerPulse(0.0208);
        rightRearSpeedEnc.setReverseDirection(true);
        rightRearSpeed = new CANTalon(8);
        rightRearSwerve = new SwerveModule("RR", rightRearSpeed, rightRearSpeedEnc, rightRearTwist, rightRearTwistEnc ); //SpeedController _speedController, Encoder _speedEnc, SpeedController _twistController, Encoder _twistEnc
        rightRearSwerve.setTwistOffset(0.0);
        
		swerve = new SwerveDrive();
		swerve.ComputeAllHyp();
		
		pdp = new PowerDistributionPanel();
		
		SmartDashboard.putData(swerve);
		
		servo = new Servo(6);
	}
}