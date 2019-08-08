package robot.utils;

/**
 * This is a class which maps out the hardware connected to the robot for use by
 * other classes. All port and hardware changes should be altered in this class
 * and any calls to motors or sensors should directly reference this class.
 * TODO: Replace existing variables with your own connections.
 * 
 * @author John & Wifi
 */
public class RobotMap {

	private static RobotMap instance;
	
	
	
	/**
	 * Method that returns the only instance of this class, or inits it.
	 * @return an instance of a robot structure
	 */
	public static RobotMap getInstance() {
		if (instance == null)
			init();
		return instance;
	}
	
	private static void init() {
		instance = new RobotMap();
	}
	
	//TODO: define your hardware below:
	
	//public final LargeMotor sampleLeftMotor, sampleRightMotor;
	//public final MediumMotor sampleLeftArm, sampleRightArm;
	//public final GyroSensor sampleGyro;
	//public final ColorSensor sampleColor;
	
	/**
	 * Constructor for a new robot map. 
	 * TODO: Init your hardware here.
	 */
	public RobotMap() {
		
		//sampleLeftMotor = new LargeMotor(MotorPort.B);
		//sampleRightMotor = new LargeMotor(MotorPort.C);
		//sampleLeftArm = new MediumMotor(MotorPort.A);
		//sampleRightArm = new MediumMotor(MotorPort.D);
		
		//sampleGyro = new GyroSensor(SensorPort.S2);
		//sampleColor = new ColorSensor(SensorPort.S3);
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
