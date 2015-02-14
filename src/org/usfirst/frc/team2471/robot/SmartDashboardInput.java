package org.usfirst.frc.team2471.robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardInput {
	public static Preferences actually;
	public static double hiceNumber[] = new double[100];
	public static String hiceNameNumber[] = new String[100];
	public static String hiceNameBool[] = new String[100];
	public static boolean hiceBool[] = new boolean[100];
	
	public SmartDashboardInput(){
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
	/*
	public static void DashSwerve(){
		actually = Preferences.getInstance();
		actually.putBoolean("fieldSteer", SmartDashboard.getBoolean("fieldSteer"));
		actually.putBoolean("fieldMove", SmartDashboard.getBoolean("fieldMove"));
		actually.putDouble("turnSpeed", SmartDashboard.getNumber("turnSpeed"));
	}
	*/
	/*
	public static void GetDash() {
		// TODO Auto-generated method stub
		actually = Preferences.getInstance();
		for (int i = 0; i <= hiceNameNumber.length; i++){
			if (hiceNameNumber[i] != null){
				SmartDashboard.putNumber(hiceNameNumber[i], hiceNumber[i]);
			}
		}
		for (int i = 0; i <= hiceNameBool.length; i++){
			if (hiceNameBool != null){
				SmartDashboard.putBoolean(hiceNameBool[i], hiceBool[i]);
			}
		}
	}
	*/
	public static void SaveDataDash(){
		actually = Preferences.getInstance();
	/*	SendableChooser hiceChooser = Robot.autoChooser.getSelected();
		String hice = hiceChooser.toString();
		actually.putString("autoCommand", hice);  */
		
	}
	public static boolean HiceSetNumber(String name, double number){
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
	
	public static boolean HiceSetBoolean(String name, boolean choice){
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

	public static double HiceGetNumber(String name){
		double justincase = 0.0;
		for (int i = 0; i <= hiceNameNumber.length; i++){
			if (name.equals(hiceNameNumber[i])){
				justincase = hiceNumber[i];
			}
		}
		actually = Preferences.getInstance();
		return actually.getDouble(name, justincase);
	}
	
	public static boolean HiceGetBoolean(String name){
		boolean justincase = false;
		for (int i = 0; i <= hiceNameBool.length; i++){
			if (name.equals(hiceNameBool[i])){
				justincase = hiceBool[i];
			}
		}
		actually = Preferences.getInstance();
		return actually.getBoolean(name, justincase);
	}
	/*
	public static Class<? extends String> AutoChooser(){
		Class<? extends String> choose = actually.getString("autoCommand", "ExampleCommand").getClass();
		return choose;
	}
	*/
}
