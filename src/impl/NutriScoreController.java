package impl;

import java.util.TimerTask;

import api.controller.IRandCaller;
import api.view.IRndNutriScoreView;
import view.RndNutriScoreView;

public class NutriScoreController extends TimerTask {

	private IRndNutriScoreView rndNutriView;
	private IRandCaller rndCaller;

	public NutriScoreController() {
		this.rndNutriView = new RndNutriScoreView();
		this.rndCaller = new RandCaller("https://api.random.org/json-rpc/2/invoke",
				"1ddb11f7-ab2d-4cb8-a366-68c13d63951b");
	}

	@Override
	public void run() {
		int rndInt = this.rndCaller.generateOneRndInt(0, 4, true);
		this.rndNutriView.updateView(rndInt);
	}
}
