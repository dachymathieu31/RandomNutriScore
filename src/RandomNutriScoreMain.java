import java.util.Timer;

import impl.NutriScoreController;

public class RandomNutriScoreMain {
	public static void main(String[] args) {
		NutriScoreController nutriController = new NutriScoreController();
		Timer timer = new Timer();
		timer.schedule(nutriController, 0, 10000);
	}
}
