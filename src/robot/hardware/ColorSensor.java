package robot.hardware;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.SampleProvider;

/**
 * Wrapper for LeJOS EV3ColorSensor for simplicity purposes
 * @author John
 *
 */
public class ColorSensor extends EV3ColorSensor{

	private SampleProvider colorIdSampler;
	private SampleProvider redSampler;
	private SampleProvider rgbSampler;
	private SampleProvider ambientSampler;
	
	public ColorSensor(Port port) {
		super(port);
		colorIdSampler = this.getColorIDMode();
		redSampler = this.getRedMode();
		rgbSampler = this.getRGBMode();
		ambientSampler = this.getAmbientMode();
	}
	
	/**
	 * @return The ID of the color detected by the color sensor
	 */
	public int getColor() {
		float[] sampleDump = new float[1];
		colorIdSampler.fetchSample(sampleDump, 0);
		return (int) sampleDump[0];
	}
	
	/**
	 * @return The light value from the color sensor, normalized 0-1
	 */
	public double getRedColor() {
		float[] sampleDump = new float[3];
		double sum = 0;
		for (int i = 0; i < sampleDump.length; i++) {
			redSampler.fetchSample(sampleDump, i);
			sum+=sampleDump[i];
		}
		return sum / 3;
	}
	
	/**
	 * @return The rgb value from the color sensor, normalized 0-1
	 */
	public double getRgbColor() {
		float[] sampleDump = new float[3];
		double sum = 0;
		for (int i = 0; i < sampleDump.length; i++) {
			rgbSampler.fetchSample(sampleDump, i);
			sum+=sampleDump[i];
		}
		return sum / 3;
	}
	
	/**
	 * @return The ambient light value from the color sensor, normalized 0-1
	 */
	public double getAnbientLight() {
		float[] sampleDump = new float[3];
		double sum = 0;
		for (int i = 0; i < sampleDump.length; i++) {
			ambientSampler.fetchSample(sampleDump, i);
			sum+=sampleDump[i];
		}
		return sum / 3;
	}
	
}
