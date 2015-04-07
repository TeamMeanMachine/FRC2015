package org.usfirst.frc.team2471.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoStepCan extends CommandGroup {
    
    public  AutoStepCan() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // a
    	addSequential(new ResetGyroCommand(-Math.PI / 2));
    	addSequential(new DriveTimeCommand(0.15, 0.0,0.1, 1.0, 0.0));
    	addSequential(new DriveTimeCommand(0.35, 0.0, 0.75, 1.0, 0.0));
    	//addSequential(new DriveTimeCommand(5.0, 0.0, 0.0, 1.0, 0.0));
    	addSequential(new ShoulderShrug(true));
    	//addSequential(new DriveTimeCommand(5.0, 0.0, 0.0, 1.0, 0.0));
    	addSequential(new DriveTimeCommand(1.25, 0.0, 0.0, 1.0, 0.0));
    	addSequential(new DriveDistanceCommand(60.0, 0.0, -1.0, 1.0, 0.0));
    	addParallel(new ShoulderShrug(false));
    	addSequential(new DriveTimeCommand(0.5, 0.0, 0.0, 1.0, 0.0));
    }
}
