package user.utils;

public class Accelerator {
	
	public Accelerator(double start, double target) {
		this.start = start;
		this.target = target;
	}
	
	private double start;
	private double target;
	
	public double getStartSpeed() {
		return this.start;
	}
	
	public double getTargetSpeed() {
		return this.target;
	}
}
