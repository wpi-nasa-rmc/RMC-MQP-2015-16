
package org.usfirst.frc.team45.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	String autoSelected;
	SendableChooser chooser;
	CANTalon talon;
	CANTalon talon2;
	CANTalon talon3;
	CANTalon talon4;
	CANTalon talon5;
	Joystick stick;
	RobotDrive drive;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		chooser = new SendableChooser();
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		SmartDashboard.putData("Auto choices", chooser);
		talon = new CANTalon(1);
		talon2 = new CANTalon(2);
		talon3 = new CANTalon(3);
		talon4 = new CANTalon(4);
		talon5 = new CANTalon(5);
		stick = new Joystick(0);
		drive = new RobotDrive(talon, talon2);
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	public void autonomousInit() {
		
		autoSelected = (String) chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + autoSelected);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		switch (autoSelected) {
		case customAuto:
			// Put custom auto code here
			break;
		case defaultAuto:
		default:
			// Put default auto code here
			break;
		}
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		double trig = stick.getThrottle();
		int but1 = stick.getRawButton(1)? 1:0;
		int but2 = stick.getRawButton(2)? 1:0;
		int but3 = stick.getRawButton(3)? 1:0;
		int but4 = stick.getRawButton(4)? 1:0;
		int drive4 = but2-but1;
		int drive5 = but4-but3;
		drive.arcadeDrive(stick);
		talon3.set(trig);
		talon4.set(drive4);
		talon5.set(drive5);
		Timer.delay(0.02);
//		if (Math.abs(stick.getY()) > Math.abs(stick.getX())) {
//			talon.set(0.5 * stick.getY());
//			talon2.set(-0.5 * stick.getY());
//		} else {
//			talon.set(0.5 * stick.getY());
//			talon2.set(0.5 * stick.getY());
//		}

	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

	}

}
