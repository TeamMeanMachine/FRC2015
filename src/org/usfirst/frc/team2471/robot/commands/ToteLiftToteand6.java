package org.usfirst.frc.team2471.robot.commands;

import org.usfirst.frc.team2471.robot.Robot;
import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ToteLiftToteand6 extends CommandGroup  {

	public ToteLiftToteand6() {
		// TODO Auto-generated constructor stub
		//requires(Robot.lifter);

		addSequential(new ToteLiftPickupPreset());
		addSequential(new ToteLiftDefault());
	}
}