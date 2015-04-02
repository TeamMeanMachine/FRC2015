
package org.usfirst.frc.team2471.robot;

import org.usfirst.frc.team2471.robot.commands.AutoGrabCan;
import org.usfirst.frc.team2471.robot.commands.AutoStayThere;
import org.usfirst.frc.team2471.robot.commands.AutoStepCan;
import org.usfirst.frc.team2471.robot.commands.AutoYellowPickUp;
import org.usfirst.frc.team2471.robot.commands.HomeBin;
import org.usfirst.frc.team2471.robot.commands.HomeBinRotate;
import org.usfirst.frc.team2471.robot.commands.ShoulderShrug;
import org.usfirst.frc.team2471.robot.subsystems.BinLifter;
import org.usfirst.frc.team2471.robot.subsystems.Claw;
import org.usfirst.frc.team2471.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team2471.robot.subsystems.Grabber;
import org.usfirst.frc.team2471.robot.subsystems.Lifter;
import org.usfirst.frc.team2471.robot.subsystems.Pusher;
import org.usfirst.frc.team2471.robot.subsystems.Sucker;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static BinLifter binLifter;
	public static Claw claw;
	public static Lifter lifter;
	public static Pusher pusher;
	public static Sucker sucker;
//	public static SwerveDrive swerveDrive;
	public static DriverStation driverStation;
	public static SendableChooser autoChooser;
	public static Preferences prefinOnRobot;
	public static Grabber grabber;
    Command autonomousCommand;
    Command homeBinCommand;
    Command homeRotateCommand;
    boolean binHomed;
    double autoAngle;

    double maxLiftCurrent;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		RobotMap.init();
		lifter = new Lifter();
		claw = new Claw();
		binLifter = new BinLifter();
		grabber = new Grabber();
		pusher = new Pusher();
		sucker = new Sucker();
		driverStation = DriverStation.getInstance();
		oi = new OI();
		prefinOnRobot = Preferences.getInstance();
		//SmartDashboard.putNumber("AutoAngle", 0.0);
//		SmartDashboard.putData( Scheduler.getInstance());
		
	//	SmartDashboardInput.GetDash();
		autoChooser = new SendableChooser();
        //autoChooser.addDefault("3 Tote Pick Up", new AutoThreeTote());
        autoChooser.addDefault("Can Step", new AutoStepCan());
        autoChooser.addObject("Stay", new AutoStayThere());
        autoChooser.addObject("Grab Can", new AutoGrabCan());
        autoChooser.addObject("1 Tote Pick Up", new AutoYellowPickUp());
        
//        autoChooser.addObject("Name", new Command());
		
        SmartDashboard.putData("AutoChooser", autoChooser);
        // instantiate the command used for the autonomous period
        
        homeBinCommand = new HomeBin();
        homeRotateCommand = new HomeBinRotate();
        binHomed = false;
        RobotMap.gyro.initGyro();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		//System.out.println("Lower Limit: " + RobotMap.bLowerLimit.get() + " Upper Limit: " + RobotMap.bUpperlimit.get());
		//System.out.println("Enc: " + RobotMap.lEnc.get());
		//SmartDashboard.putNumber("Encoder_Bin", RobotMap.lEnc.get());
		//System.out.println("IR Sensor " + RobotMap.bToteMax.getVoltage());
		/*double x2 = Robot.oi.coStick.getAxis(Joystick.AxisType.kX);
        double y2 = -Robot.oi.coStick.getAxis(Joystick.AxisType.kY);  // odd, but up is negative
        double r2 =  Robot.oi.coStick.getRawAxis(4);
        System.out.println(" X : " + x2 + " Y: " + y2 + " R: " + r2);*/
		//System.out.println("Rotate Encoder:  " + RobotMap.lRotate.getTotalDegrees());
		//System.out.println("Bottom: " + RobotMap.bLowerLimit.get());
		SmartDashboard.putNumber("FL Twist Encoder", RobotMap.leftFrontTwistEnc.getDistance());
		SmartDashboard.putNumber("FR Twist Encoder", RobotMap.rightFrontTwistEnc.getDistance());
		SmartDashboard.putNumber("RL Twist Encoder", RobotMap.leftRearTwistEnc.getDistance());
		SmartDashboard.putNumber("RR Twist Encoder", RobotMap.rightRearTwistEnc.getDistance());
		//System.out.println("Speed: " + RobotMap.rightRearSpeedEnc.getDistance());
		//SmartDashboard.putNumber("Rotate enc", RobotMap.lRotate.getDegrees());
		//SmartDashboard.putNumber("Angle Auto", autoAngle);
		SmartDashboard.putNumber("IR V;", RobotMap.bToteMax.getVoltage());
		//System.out.println(RobotMap.bToteMax.getVoltage());
		//System.out.println("FL: " + RobotMap.leftFrontTwistEnc.getDistance() + " FR: " + RobotMap.rightFrontTwistEnc.getDistance());
		//System.out.println("this is workings");
		//System.out.println("Encoder Wrist: " + RobotMap.lRotate.getTotalDegrees());
		//System.out.println("RR: " + RobotMap.rightRearTwistEnc.getDistance());
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	RobotMap.gyro.reset(); 
        RobotMap.swerve.setGyroOffset(140.0*Math.PI/180.0);
    	//RobotMap.swerve.setGyroOffset(90.0*Math.PI/180.0); 
    	//RobotMap.swerve.setGyroOffset(0.0*Math.PI/180.0);
    	//double angle = SmartDashboard.getNumber("AutoAngle", 0.0);
    	//RobotMap.swerve.setGyroOffset(angle * Math.PI/180.0);
    	RobotMap.rightRearSpeedEnc.reset();
    	RobotMap.leftRearSpeedEnc.reset();
    	RobotMap.rightFrontSpeedEnc.reset();
    	RobotMap.leftFrontSpeedEnc.reset();
    	//autonomousCommand = new AutoThreeTote();
    	//autonomousCommand = new AutoOneTotePush();
    	//autonomousCommand = new AutoStayThere();
    	//autonomousCommand = new AutoYellowPickUp();
    	//autonomousCommand = new AutoGrabCan();
    	//autonomousCommand = new AutoGrabCanAndMove();
    	autonomousCommand = (Command)autoChooser.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
//        System.out.println(RobotMap.leftFrontTwistEnc.getDistance());
//        System.out.println(RobotMap.rightFrontTwistEnc.getDistance());
//        System.out.println(RobotMap.leftRearTwistEnc.getDistance());
//        System.out.println(RobotMap.rightRearTwistEnc.getDistance());
//        RobotMap.gyro.reset();
//        homeRotateCommand.start();
//        RobotMap.lRotate.reset();
        maxLiftCurrent = 0.0;
        Command upCommand = new ShoulderShrug(false);
        upCommand.start();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
   // 	SmartDashboardInput.SaveDataDash();
    	//TMMDashboard.saveAllValuesToPrefs();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        if(!binHomed) {
        	//homeBinCommand.start();
        	binHomed = true;
        }
        boolean trigger = false;
        if (RobotMap.bToteMax.getVoltage() >= .7){
        	trigger = true;
        }
        SmartDashboard.putBoolean("IR Sensor ", trigger);
        SmartDashboard.putData("Lift Access", lifter);
		SmartDashboard.putData("Swerve Access", RobotMap.swerve);
		SmartDashboard.putNumber("FL Drive Encoder", RobotMap.leftFrontSpeedEnc.getDistance());
		SmartDashboard.putNumber("FR Drive Encoder", RobotMap.rightFrontSpeedEnc.getDistance());
		SmartDashboard.putNumber("RL Drive Encoder", RobotMap.leftRearSpeedEnc.getDistance());
		SmartDashboard.putNumber("RR Drive Encoder", RobotMap.rightRearSpeedEnc.getDistance());
		SmartDashboard.putNumber("RL Twist Encoder post", RobotMap.leftRearTwistEnc.getDistance());
 //       System.out.println("Encoder Twists: " + RobotMap.leftFrontTwist.get() + " " + RobotMap.leftRearTwist.get() + " " + RobotMap.rightFrontTwist.get() + " " + RobotMap.rightRearTwist.get());
		//System.out.println("RL: " + RobotMap.leftRearSpeedEnc.getDistance() +  " RR: " + RobotMap.rightRearSpeedEnc.getDistance());
		
		//System.out.println("Distance L: " + RobotMap.leftRearSpeedEnc.getDistance() + "\tDistance R: " + RobotMap.rightRearSpeedEnc.getDistance());
		//System.out.println("ToteMid: " + RobotMap.bToteMid.getVoltage());
//		System.out.println(RobotMap.leftRearSpeedEnc.getDistance());
		double liftCurrent = RobotMap.pdp.getCurrent(1);
		if(liftCurrent > maxLiftCurrent)
			maxLiftCurrent = liftCurrent;
		System.out.println("Current lifter current: " + liftCurrent + "Max: " + maxLiftCurrent);
		
		if(oi.coStick.getRawButton(6)) {
			RobotMap.servo.set(90);
		}
		else {
			RobotMap.servo.set(0);
		}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}