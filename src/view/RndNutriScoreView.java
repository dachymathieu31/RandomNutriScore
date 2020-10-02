package view;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import api.view.IRndNutriScoreView;

public class RndNutriScoreView implements IRndNutriScoreView {
	private JFrame frame;
	private JSlider slider;
	private GroupLayout layout;

	public RndNutriScoreView() {
		SwingUtilities.invokeLater(() -> {
			this.frame = new JFrame("NutriScore");
			this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Dimension dim = new Dimension(200, 100);
			this.frame.setPreferredSize(dim);
			this.frame.setVisible(true);

			this.slider = new JSlider(SwingConstants.HORIZONTAL, 0, 4, 0);
			this.layout = new GroupLayout(this.frame.getContentPane());
			this.layout.setAutoCreateGaps(true);
			this.layout.setAutoCreateContainerGaps(true);
			this.layout.setVerticalGroup(this.layout.createSequentialGroup().addGroup(
					this.layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.slider)));

			this.frame.pack();
			this.frame.setVisible(true);
		});
	}

	@Override
	public void updateView(int rndInt) {
		if (this.slider.isEnabled()) {
			this.slider.setValue(rndInt);
		}
	}
}
