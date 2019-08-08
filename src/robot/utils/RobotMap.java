package robotUtils;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.robotics.SampleProvider;

/**
 * This is a class which maps out the hardware connected to the robot for use by
 * other classes. All port and hardware changes should be altered in this class
 * and any calls to motors or sensors should directly reference this class.
 * TODO: Replace existing variables with your own connections.
 * ***MAKE SURE TO CREATE SAMPLEPROVIDERS HERE AS WELL***
 * 
 * @author John & Wifi
 */
public class RobotStructure {

	private static RobotStructure instance;
	
	
	
	/**
	 * Method that returns the only instance of this class, or inits it.
	 * @return an instance of a robot structure
	 */
	public static RobotStructure getInstance() {
		if (instance == null)
			init();
		return instance;
	}
	
	private static void init() {
		instance = new RobotStructure();
	}
	
	//TODO: define your hardware below:
	
	//public final EV3LargeRegulatedMotor sampleLeftMotor, sampleRightMotor;
	//public final EV3MediumRegulatedMotor sampleLeftArm, sampleRightArm;
	//public final EV3GyroSensor sampleGyro;
	//public final EV3ColorSensor sampleColor;
	//public final SampleProvider gyroAngleSampler, colorRedSampler;
	
	/**
	 * Constructor for a new robot map. 
	 * TODO: Init your hardware here.
	 */
	public RobotStructure() {
		
		//sampleLeftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
		//sampleRightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
		//sampleLeftArm = new EV3MediumRegulatedMotor(MotorPort.A);
		//sampleRightArm = new EV3MediumRegulatedMotor(MotorPort.D);
		
		//sampleGyro = new EV3GyroSensor(SensorPort.S2);
		//sampleColor = new EV3ColorSensor(SensorPort.S3);
		
		
		//gyroAngleSampler = gyro.getAngleMode();
		//color1RedSampler = colorLeft.getRedMode();
		
	}
	
	
	/**
	 * Stops all robot motors
	 * TODO: Input your own connections
	 */
	public void stopAllMotors() {
	/*	sampleLeftMotor.stop(true);
		sampleRightMotor.stop(true);
		sampleLeftArm.stop(true);
		sampleRightArm.stop(true);*/
	}
}
