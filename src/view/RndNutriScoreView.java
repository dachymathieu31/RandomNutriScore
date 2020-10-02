package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import api.view.IRndNutriScoreView;

public class RndNutriScoreView extends JFrame implements IRndNutriScoreView {
	private ImageIcon images[];
	private JLabel imageLabel;

	public RndNutriScoreView() {
		SwingUtilities.invokeLater(() -> {
			this.setLayout(new BorderLayout());
			this.setTitle("NutriScore");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(new Dimension(750, 450));
			this.setVisible(true);
			this.imageLabel = new JLabel("", JLabel.CENTER);
			this.add(this.imageLabel, BorderLayout.CENTER);

			images = new ImageIcon[5];

			images[0] = new ImageIcon("images/a.jpg");
			images[1] = new ImageIcon("images/b.jpg");
			images[2] = new ImageIcon("images/c.jpg");
			images[3] = new ImageIcon("images/d.jpg");
			images[4] = new ImageIcon("images/e.jpg");
		});
	}

	@Override
	public void updateView(int imageIndex) {
		this.imageLabel.setIcon(images[imageIndex]);
	}
}
