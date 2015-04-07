package org.usfirst.frc.team2471.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoThreeTote extends CommandGroup {
    
    public  AutoThreeTote() {
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
        // arm.
    	
    	//DriveDistanceCommand( double _distance, double _x, double _y, double _r, double _s )
    	
    	//addSequential(new DriveTimeCommand(.5, 0.0, 0.0, -1.0, -0.5));
    	addParallel(new SuckRaw(0.4, 0.7));
    	addSequential(new DriveDistanceCommand(27.0, -0.3, 0.0, -1.0, -0.5, 3.0));
    	addSequential(new ResetDriveEncoders());
    	addSequential(new DriveTimeCommand(.75, 0.0, 0.0, -1.0, -0.5));
    	addParallel(new ToteLiftCycle());
    	addSequential(new DriveTimeCommand(1.0, 0.0, 0.0, -1.0, -0.5));
    	addParallel(new VariableSpit(1.0 , 1.0));
    	addSequential(new DriveDistanceCommand(36.0, -0.45, 0.0, -1.0, -0.0, 3.0));
    	addSequential(new ResetDriveEncoders());
    	addParallel(new SuckRaw(0.4, 1.0));
    	addSequential(new DriveDistanceCommand(41.0, -0.3, 0.0, -1.0, -0.5));
    	addSequential(new ResetDriveEncoders());
    	addParallel(new ToteLiftCycle());
    	addSequential(new DriveTimeCommand(1.2, 0.0, 0.0, -1.0, -0.5));
    	addParallel(new VariableSpit(1.0, 1.0));
    	addSequential(new DriveDistanceCommand(42.0, -0.45, 0.0, -1.0, -0.0, 3.0));
    	addSequential(new ResetDriveEncoders());
    	addParallel(new SuckRaw(0.4, 0.7));
    	addSequential(new DriveDistanceCommand(45.0, -0.3, 0.0, -1.0, -0.5, 3.0));
    	addSequential(new ResetDriveEncoders());
    	addParallel(new ToteLiftPickupPreset());
    	addSequential(new DriveTimeCommand(1.25, 0.0, 0.0, -1.0, -0.5));
    	addSequential(new DriveDistanceCommand(90.0, -0.5 , 0.5, -1.0, 0.0));
    	//addSequential(new DriveDistanceCommand(30.0, 0.0, 0.75, 0.0, 0.75));
    	addSequential(new ResetDriveEncoders());
    	addParallel(new Push());
    	addParallel(new VariableSpit(1.0, 1.0));
    	addSequential(new GyroReset());
    	
    	
    	//addSequential(new DriveDistanceCommand(12.0, -0.3, 0.0, -0.5, -0.5));
//    	addParallel(new Suck());
//    	addSequential(new DriveDistanceCommand(24.0, -0.5, 0.0, -0.5, -0.5));
//    	addParallel(new Spit());
//    	addSequential(new DriveDistanceCommand(12.0, -0.5, 0.0, -0.5, -0.5));
//    	addParallel(new Suck());
//    	addSequential(new DriveDistanceCommand(24.0, -0.5, 0.0, -0.5, -0.5));
//    	addParallel(new Spit());
//    	addSequential(new DriveDistanceCommand(54.0, 0.0, 0.5, -0.5, -0.5));
//    	addSequential(new Push());
    	
    }
}
