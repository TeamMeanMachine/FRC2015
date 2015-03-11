package org.usfirst.frc.team2471.robot;


import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TMMDashboard extends SmartDashboard
{
	public static Preferences prefs;
	public static String namesToSave[];

	// just call putNumber once, in RobotInit, or a constructor to add the values to dashboard and prefs
	public static void putNumber( String strName, double defaultValue )
	{
		prefs = Preferences.getInstance();
		namesToSave = new String[100];
		// see if its already in prefs, get the value, or use the default
		double number = prefs.getDouble( strName, defaultValue );
		// add the number to the dashboard
		SmartDashboard.putNumber( strName, number );
		// add this name to a list to save at disable time
		int nextint = namesToSave.length;
		namesToSave[nextint] = strName;
	}

	/*
	// Just use this to access your value during robot operation
	public double getNumber( String key)
	{
		return SmartDashboard.getNumber(key);
	}
	*/
	// call this function in OnDisabled() or some other shutdown routine to save everything to prefs
	public static void saveAllValuesToPrefs()
	{
		for (int i=0; i<namesToSave.length; i++)
		{
			prefs = Preferences.getInstance();
			String strName = namesToSave[i];
			// grab the latest dashboard value
			double number = SmartDashboard.getNumber( strName, 0 );
			// save it to the prefs file (burned in eprom)
			prefs.putDouble( strName, number );
		}
	}
}
