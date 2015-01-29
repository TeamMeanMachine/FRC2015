package org.usfirst.frc.team2471.robot;

import org.usfirst.frc.team2471.robot.commands.DriveLoop;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardInput {
	
	public SmartDashboard sDash;
	public static Preferences actually;
	
	public SmartDashboardInput(){
		sDash = new SmartDashboard();
		actually = Preferences.getInstance();
	}
	
	public static void DashSwerve(){
		actually.putBoolean("fieldSteer", SmartDashboard.getBoolean("fieldSteer"));
		actually.putBoolean("fieldMove", SmartDashboard.getBoolean("fieldMove"));
		actually.putDouble("Turn Speed", SmartDashboard.getNumber("Turn Speed"));
	}
	
	public static void SaveDataDash(){
		Object hiceChooser = Robot.autoChooser.getSelected();
		String hice = hiceChooser.toString();
		actually.putString("autoCommand", hice);
	}

	public static void GetDash() {
		// TODO Auto-generated method stub
		SmartDashboard.putBoolean("fieldSteer", actually.getBoolean("fieldSteer", false));
		SmartDashboard.putBoolean("fieldMove", actually.getBoolean("fieldMove", false));
		SmartDashboard.putNumber("Turn Speed", actually.getDouble("Turn Speed", DriveLoop.TurnSpeed()));
	}
	
	public static Class AutoChooser(){
		Class<? extends String> choose = actually.getString("autoCommand", "ExampleCommand").getClass();
		return choose;
	}
}
