package org.usfirst.frc.team2471.robot;

import org.usfirst.frc.team2471.robot.commands.Grab;
import org.usfirst.frc.team2471.robot.commands.Push;
import org.usfirst.frc.team2471.robot.commands.Rotate;
import org.usfirst.frc.team2471.robot.commands.Rotate180;
import org.usfirst.frc.team2471.robot.commands.RotateBackwards;
import org.usfirst.frc.team2471.robot.commands.Spit;
import org.usfirst.frc.team2471.robot.commands.Suck;
import org.usfirst.frc.team2471.robot.commands.ToteLiftDefault;
import org.usfirst.frc.team2471.robot.commands.ToteLiftPickupPreset;
import org.usfirst.frc.team2471.robot.commands.ToteLiftToteand6;

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
    public JoystickButton presetTote;
    public JoystickButton presetTotePickup;
    public JoystickButton presetToteand6;
    public JoystickButton suck;
    public JoystickButton spit;
    public JoystickButton push;
    public JoystickButton grab;
    public JoystickButton rotate;
    public JoystickButton rotateBackwards;
    public JoystickButton rotate180;
    
    public OI(){
    	driverStick = new Joystick(0);
    	coStick = new Joystick(1);
    	presetTote = new JoystickButton(driverStick, 3);
    	presetToteand6 = new JoystickButton(driverStick, 1);
    	presetTotePickup = new JoystickButton(driverStick, 2);
    	suck = new JoystickButton(driverStick, 6);
    	spit = new JoystickButton(driverStick, 5);
    	push = new JoystickButton(driverStick, 8);
    	grab = new JoystickButton(coStick, 4);
    	rotate = new JoystickButton(coStick, 3);
    	rotate.whenPressed(new Rotate(90));
    	rotateBackwards = new JoystickButton(coStick, 1);
    	rotate180 = new JoystickButton(coStick, 2);
    	rotate180.whenPressed(new Rotate180());
    	rotateBackwards.whenPressed(new RotateBackwards());
//    	rotate.whenPressed(new Rotate());
    	suck.whileHeld(new Suck());
    	spit.whileHeld(new Spit());
    	push.whenPressed(new Push());
    	grab.whenPressed(new Grab());
    	presetTote.whenPressed(new ToteLiftDefault());
    	presetTotePickup.whenPressed(new ToteLiftPickupPreset());
    	presetToteand6.whenPressed(new ToteLiftToteand6());
    	
    }
}

