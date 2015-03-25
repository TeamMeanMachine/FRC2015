package org.usfirst.frc.team2471.robot;

import org.usfirst.frc.team2471.robot.commands.Grab;
import org.usfirst.frc.team2471.robot.commands.GyroReset;
import org.usfirst.frc.team2471.robot.commands.Push;
import org.usfirst.frc.team2471.robot.commands.ShoulderShrug;
import org.usfirst.frc.team2471.robot.commands.Spit;
import org.usfirst.frc.team2471.robot.commands.Suck;
import org.usfirst.frc.team2471.robot.commands.ToteHoldToggle;
import org.usfirst.frc.team2471.robot.commands.ToteLiftCycle;
import org.usfirst.frc.team2471.robot.commands.ToteLiftMiddle;
import org.usfirst.frc.team2471.robot.commands.ToteLiftPickupPreset;
import org.usfirst.frc.team2471.robot.commands.ToteLiftSkipOverride;
import org.usfirst.frc.team2471.robot.commands.ToteLiftTop;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	public Joystick driverStick;
    public Joystick coStick;
    public JoystickButton totePresetMiddle;
    public JoystickButton totePresetBottom;
    public JoystickButton totePresetTop;
    public JoystickButton toteCycle, toteCycle2;
    public JoystickButton suck;
    public JoystickButton spit;
    public JoystickButton push;
    public JoystickButton grab;
    public JoystickButton rotate;
   // public JoystickButton rotateBackwards;
    public JoystickButton rotateHome;
    public JoystickButton rotateRight; 
    public JoystickButton rotateLeft;
    public JoystickButton gyroReset;
    public JoystickButton wristBrake;
    public JoystickButton toggleHold;
    public JoystickButton liftOverride;
    public JoystickButton thiefOfCansAndDignity;
    
    public OI(){
    	driverStick = new Joystick(0);
    	coStick = new Joystick(1);
    	totePresetMiddle = new JoystickButton(driverStick, 3);
    	thiefOfCansAndDignity = new JoystickButton(driverStick, 9);
    	toteCycle = new JoystickButton(driverStick, 1);
    	toteCycle2 = new JoystickButton(coStick, 1);
    	totePresetBottom = new JoystickButton(driverStick, 2);
    	totePresetTop = new JoystickButton(driverStick, 8);
    	//wristBrake = new JoystickButton(coStick, 2);
    	//wristBrake.whileHeld(new RotateBrake());
//    	rotateRight = new  JoystickButton(coStick, 5);
//    	rotateLeft = new  JoystickButton(coStick, 6);
//        rotateRight.whileHeld(new RotateNeew());
        gyroReset = new JoystickButton(driverStick, 10);
//        rotateLeft.whileHeld(new Rotateleft());
        gyroReset.whenPressed(new GyroReset());
    	suck = new JoystickButton(driverStick, 6);
    	spit = new JoystickButton(driverStick, 5);
    	push = new JoystickButton(driverStick, 4);
    	grab = new JoystickButton(coStick, 4);
    	toggleHold = new JoystickButton(coStick, 2);
    	liftOverride = new JoystickButton(coStick, 3);
    	//rotate = new JoystickButton(coStick, 3);
    	//rotate.whenPressed(new Rotate(180));
    	//rotateBackwards = new JoystickButton(coStick, 1);
    	//rotateHome = new JoystickButton(coStick, 8);
    	//rotateHome.whenPressed(new Rotate(0));
   // 	rotate180.whenPressed(new Rotate(0));
    	//rotateBackwards.whenPressed(new RotateBackwards());
//    	rotate.whenPressed(new Rotate());
    	suck.whileHeld(new Suck());
    	spit.whileHeld(new Spit());
    	push.whileHeld(new Push());
    	thiefOfCansAndDignity.whenPressed(new ShoulderShrug(true));
    	thiefOfCansAndDignity.whenReleased(new ShoulderShrug(false));
    	grab.whenPressed(new Grab());
    	totePresetMiddle.whenPressed(new ToteLiftMiddle());
    	totePresetBottom.whenPressed(new ToteLiftPickupPreset());
    	totePresetTop.whenPressed(new ToteLiftTop());
    	toteCycle.whenPressed(new ToteLiftCycle());
    	toteCycle2.whenPressed(new ToteLiftCycle());
    	toggleHold.whenPressed(new ToteHoldToggle());
    	liftOverride.whileHeld(new ToteLiftSkipOverride());
    	
    	
    }
}

