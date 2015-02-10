
package org.usfirst.frc.team2471.robot;

import org.usfirst.frc.team2471.robot.commands.ExampleCommand;
import org.usfirst.frc.team2471.robot.commands.HomeBin;
import org.usfirst.frc.team2471.robot.subsystems.BinLifter;
import org.usfirst.frc.team2471.robot.subsystems.ExampleSubsystem;
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
	public static Lifter lifter;
	public static Pusher pusher;
	public static Sucker sucker;
//	public static SwerveDrive swerveDrive;
	public static DriverStation driverStation;
	public static SendableChooser autoChooser;
	public static Preferences prefinOnRobot;
    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	SmartDashboard.putNumber("yPivot", 10);
		RobotMap.init();
		lifter = new Lifter();
		binLifter = new BinLifter();
		pusher = new Pusher();
		sucker = new Sucker();
		driverStation = DriverStation.getInstance();
		oi = new OI();
		prefinOnRobot = Preferences.getInstance();
		SmartDashboardInput.GetDash();
		autoChooser = new SendableChooser();
  //      autoChooser.addDefault("Name", new (SmartDashboardInput.AutoChooser()));
//        autoChooser.addObject("Name", new Command());
		
        SmartDashboard.putData("AutoChooser", autoChooser);
        // instantiate the command used for the autonomous period
        autonomousCommand = new ExampleCommand();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		//System.out.println("Lower Limit: " + RobotMap.bLowerLimit.get() + " Upper Limit: " + RobotMap.bUpperlimit.get());
		System.out.println("Enc: " + RobotMap.lEnc.get());
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
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
        new HomeBin();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	SmartDashboardInput.DashSwerve();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
 //       System.out.println("Encoder Twists: " + RobotMap.leftFrontTwist.get() + " " + RobotMap.leftRearTwist.get() + " " + RobotMap.rightFrontTwist.get() + " " + RobotMap.rightRearTwist.get());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
}
