import java.io.IOException;
import java.util.Timer;

import impl.NutriScoreController;

public class RandomNutriScoreMain {
	public static void main(String[] args) {
		NutriScoreController nutriController;
		try {
			nutriController = new NutriScoreController();
			Timer timer = new Timer();
			timer.schedule(nutriController, 0, 10000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
