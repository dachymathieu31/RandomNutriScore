package impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.TimerTask;

import api.controller.IRandCaller;
import api.view.IRndNutriScoreView;
import view.RndNutriScoreView;

public class NutriScoreController extends TimerTask {

	private IRndNutriScoreView rndNutriView;
	private IRandCaller rndCaller;

	public NutriScoreController() throws IOException {
		this.rndNutriView = new RndNutriScoreView();
		Properties props = new Properties();
		String propFileName = "config.properties";
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propFileName);
		if (inputStream != null) {
			props.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}

		this.rndCaller = new RandCaller("https://api.random.org/json-rpc/2/invoke", props.getProperty("apikey"));
	}

	@Override
	public void run() {
		int rndInt = this.rndCaller.generateOneRndInt(0, 4, true);
		this.rndNutriView.updateView(rndInt);
	}
}
