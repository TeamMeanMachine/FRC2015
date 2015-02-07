package org.usfirst.frc.team2471.robot;

import org.usfirst.frc.team2471.robot.commands.DriveLoop;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardInput {
	public static Preferences actually;
	
	public SmartDashboardInput(){
	}
	
	public static void DashSwerve(){
		actually = Preferences.getInstance();
		actually.putBoolean("fieldSteer", SmartDashboard.getBoolean("fieldSteer"));
		actually.putBoolean("fieldMove", SmartDashboard.getBoolean("fieldMove"));
		actually.putDouble("turnSpeed", SmartDashboard.getNumber("turnSpeed"));
	}
	
	public static void SaveDataDash(){
		actually = Preferences.getInstance();
	/*	SendableChooser hiceChooser = Robot.autoChooser.getSelected();
		String hice = hiceChooser.toString();
		actually.putString("autoCommand", hice);  */
		
	}

	public static void GetDash() {
		// TODO Auto-generated method stub
		actually = Preferences.getInstance();
		SmartDashboard.putBoolean("fieldSteer", actually.getBoolean("fieldSteer", false));
		SmartDashboard.putBoolean("fieldMove", actually.getBoolean("fieldMove", false));
		SmartDashboard.putNumber("turnSpeed", actually.getDouble("turnSpeed", DriveLoop.TurnSpeed()));
	}
	
	/*
	public static Class<? extends String> AutoChooser(){
		Class<? extends String> choose = actually.getString("autoCommand", "ExampleCommand").getClass();
		return choose;
	}
	*/
}
