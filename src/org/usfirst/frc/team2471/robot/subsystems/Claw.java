package org.usfirst.frc.team2471.robot.subsystems;

import org.usfirst.frc.team2471.robot.AbsoluteEncoder;
import org.usfirst.frc.team2471.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem{
	
	SpeedController lift;
	SpeedController rotate;
	Solenoid clasp;
	DigitalInput upperLimit;
	DigitalInput lowerLimit;
	Encoder liftDistance;
	AbsoluteEncoder rotateStop;

	public Claw(){
		lift = RobotMap.lMotor1;
		rotate = RobotMap.lMotor2;
		clasp = RobotMap.lSolenoid1;
		lowerLimit = RobotMap.lLowerLimit;
		upperLimit = RobotMap.lUpperLimit;
		liftDistance = RobotMap.lEnc;
		rotateStop = RobotMap.lRotate;
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	//	setDeafualtCommand(new );
	}
	
	public void rotateUp(double power){
		if(RobotMap.pdp.getCurrent(15) < 12.0){
			rotate.set(power * 0.425);
		}
		else{
			rotate.set(0.0);
		}
	}
	public void rotateDown(double power){
		//  Make command to deal with the encoder for the preset rotations
		if(RobotMap.pdp.getCurrent(15) < 10.0){
			rotate.set(power * -0.425);
		}
		else{
			rotate.set(0.0);
		}
	}
	public void rotate(double power) {
		// TODO Auto-generated method stub
		rotate.set(power);
		
	}

}
