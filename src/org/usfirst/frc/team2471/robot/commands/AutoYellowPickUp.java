package org.usfirst.frc.team2471.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoYellowPickUp extends CommandGroup {
    
    public  AutoYellowPickUp() {
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
    	
        addParallel(new Suck());
    	addSequential(new DriveTimeCommand(1.5, -0.3, 0.0, -1.0, -0.6));
    	addParallel(new ToteLiftCycle());
    	addSequential(new DriveTimeCommand(1.50, 0.0, 0.0, -1.0, -0.2));
    	
    	
    }
}
