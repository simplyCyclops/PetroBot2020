package robot.hardware;

import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;

/**
 * Wrapper for LeJOS EV3TouchSensor for simplicity purposes
 * @author John
 *
 */
public class TouchSensor extends EV3TouchSensor {

	private SampleProvider touchSampler;

	public TouchSensor(Port port) {
		super(port);
		touchSampler = this.getTouchMode();
	}

	public boolean isPressed() {
		float[] sampleDump = new float[1];
		touchSampler.fetchSample(sampleDump, 0);
		if (sampleDump[0] == 1) {
			return true;
		} else {
			return false;
		}
	}
}
