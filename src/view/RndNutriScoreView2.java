package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import api.view.IRndNutriScoreView;

public class RndNutriScoreView2 extends JFrame implements IRndNutriScoreView {

	private JLabel a;
	private JLabel b;
	private JLabel c;
	private JLabel d;
	private JLabel e;

	public RndNutriScoreView2() {
		SwingUtilities.invokeLater(() -> {
			JLabel nutriLabel = new JLabel("Nutri-Score");
			nutriLabel.setHorizontalAlignment(JLabel.CENTER);
			JPanel nutriSlider = new JPanel();
			this.add(nutriLabel, BorderLayout.NORTH);
			this.add(nutriSlider, BorderLayout.CENTER);
			this.a = createLabel("A", new Color(9.0f / 255f, 139.0f / 255f, 49.0f / 255f));
			this.b = createLabel("B", new Color(153.0f / 255f, 196.0f / 255f, 46.0f / 255f));
			this.c = createLabel("C", new Color(251.0f / 255f, 186.0f / 255f, 0.0f / 255f));
			this.d = createLabel("D", new Color(233.0f / 255f, 90.0f / 255f, 11.0f / 255f));
			this.e = createLabel("E", new Color(206.0f / 255f, 23.0f / 255f, 25.0f / 255f));
			nutriSlider.add(a);
			nutriSlider.add(b);
			nutriSlider.add(c);
			nutriSlider.add(d);
			nutriSlider.add(e);

			this.setSize(400, 200);
			this.setVisible(true);
		});
	}

	private JLabel createLabel(String text, Color color) {
		JLabel label = new JLabel(text);
		label.setForeground(Color.WHITE);
		label.setBackground(color);
		label.setOpaque(true);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setPreferredSize(new Dimension(50, 50));
		return label;
	}

	@Override
	public void updateView(int rndInt) {

	}
}
