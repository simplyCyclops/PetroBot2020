package robot.runs.parallel;

public class Parallel {

	public static void doAction(Action a) {
		new ParallelAction(a).start();
	}
	
}
