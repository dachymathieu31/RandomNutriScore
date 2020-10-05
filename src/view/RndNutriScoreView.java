package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import api.view.IRndNutriScoreView;

public class RndNutriScoreView extends JFrame implements IRndNutriScoreView {

	private static Dimension DEFAULT_DIM = new Dimension(50, 50); // Default dimension for each Letter label
	private static Dimension FOCUS_DIM = new Dimension(60, 60); // Dimension for the focused letter

	private JLabel a;
	private JLabel b;
	private JLabel c;
	private JLabel d;
	private JLabel e;

	private int selectedLetter;

	public RndNutriScoreView() {
		this.selectedLetter = Integer.MAX_VALUE;
		SwingUtilities.invokeLater(() -> {
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			FlowLayout nutriFlow = new FlowLayout();
			nutriFlow.setVgap(15);
			JPanel panelLabel = new JPanel();
			JLabel nutriLabel = new JLabel("Nutri-Score");
			nutriLabel.setFont(new Font("Serif", Font.PLAIN, 28));
			panelLabel.add(nutriLabel);
			panelLabel.setLayout(nutriFlow);
			nutriLabel.setHorizontalAlignment(JLabel.CENTER);

			JPanel nutriSlider = new JPanel();
			FlowLayout sliderFlow = new FlowLayout();
			sliderFlow.setVgap(40);
			nutriSlider.setLayout(sliderFlow);

			this.add(panelLabel, BorderLayout.NORTH);
			this.add(nutriSlider, BorderLayout.SOUTH);

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
			this.setResizable(false);
			this.setVisible(true);
		});
	}

	private JLabel createLabel(String text, Color color) {
		JLabel label = new JLabel(text);
		Border whiteLine = BorderFactory.createLineBorder(Color.WHITE, 5);
		label.setBorder(whiteLine);
		label.setForeground(Color.WHITE);
		label.setBackground(color);
		label.setOpaque(true);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setPreferredSize(DEFAULT_DIM);
		return label;
	}

	@Override
	public void updateView(int rndInt) {
		if (selectedLetter != rndInt) {
			selectedLetter = rndInt;

			SwingUtilities.invokeLater(() -> {
				// Reset all nutriSlider
				a.setSize(DEFAULT_DIM);
				b.setSize(DEFAULT_DIM);
				c.setSize(DEFAULT_DIM);
				d.setSize(DEFAULT_DIM);
				e.setSize(DEFAULT_DIM);

				// Choose the letter to focus
				switch (selectedLetter) {
				case 0: {
					a.setSize(FOCUS_DIM);
					break;
				}
				case 1: {
					b.setSize(FOCUS_DIM);
					break;
				}
				case 2: {
					c.setSize(FOCUS_DIM);
					break;
				}
				case 3: {
					d.setSize(FOCUS_DIM);
					break;
				}
				case 4: {
					e.setSize(FOCUS_DIM);
					break;
				}
				default: {
					throw new IllegalArgumentException("Unexpected value: " + selectedLetter);
				}
				}
			});
		}
	}
}
