package org.usfirst.frc.team2471.robot;

import java.util.ArrayList;

import org.usfirst.frc.team2471.robot.commands.DriveLoop;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardInput {
	public static Preferences actually;
	public static double hiceNumber[];
	public static String hiceNameNumber[];
	public static String hiceNameBool[];
	public static boolean hiceBool[];
	
	public SmartDashboardInput(){
		hiceNumber = new double[100];
		hiceNameNumber = new String[100];
		hiceBool = new boolean[100];
		hiceNameBool = new String[100];
	}
	
	public static void SaveDash(){
		actually = Preferences.getInstance();
		for (int i = 0; i <= hiceNameBool.length; i++){
			if(hiceNameBool[i] != null){
				actually.putBoolean(hiceNameBool[i], hiceBool[i]);;
			}
		}
		for (int j = 0; j <= hiceNameNumber.length; j++){
			if(hiceNameNumber[j] != null){
				actually.putDouble(hiceNameNumber[j], hiceNumber[j]);
			}
		}
	}
	
	public static void DashSwerve(){
		actually = Preferences.getInstance();
		actually.putBoolean("fieldSteer", SmartDashboard.getBoolean("fieldSteer"));
		actually.putBoolean("fieldMove", SmartDashboard.getBoolean("fieldMove"));
		actually.putDouble("turnSpeed", SmartDashboard.getNumber("turnSpeed"));
	}
	
	public static void GetDash() {
		// TODO Auto-generated method stub
		actually = Preferences.getInstance();
		SmartDashboard.putBoolean("fieldSteer", actually.getBoolean("fieldSteer", false));
		SmartDashboard.putBoolean("fieldMove", actually.getBoolean("fieldMove", false));
		SmartDashboard.putNumber("turnSpeed", actually.getDouble("turnSpeed", DriveLoop.TurnSpeed()));
	}
	
	public static void SaveDataDash(){
		actually = Preferences.getInstance();
	/*	SendableChooser hiceChooser = Robot.autoChooser.getSelected();
		String hice = hiceChooser.toString();
		actually.putString("autoCommand", hice);  */
		
	}
	public static boolean HiceNumber(String name, double number){
		for (int i = 0; i <= hiceNameNumber.length; i++){
			if (name.equals(hiceNameNumber[i])){
				return false;
			}
			else if(name.equals(null)){
				hiceNameNumber[i] = name;
				hiceNumber[i] = number;
			}
		}
		return true;
	}
	
	public static boolean HiceBoolean(String name, boolean choice){
		for (int i = 0; i <= hiceNameBool.length; i++){
			if (name.equals(hiceNameBool[i])){
				return false;
			}
			else if(name.equals(null)){
				hiceNameBool[i] = name;
				hiceBool[i] = choice;
			}
		}
		return true;
	}
	/*
	public static Class<? extends String> AutoChooser(){
		Class<? extends String> choose = actually.getString("autoCommand", "ExampleCommand").getClass();
		return choose;
	}
	*/
}
