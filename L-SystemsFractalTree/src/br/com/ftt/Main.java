package br.com.ftt;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Main {

	public static void createAndShowGUI() {
		JFrame mainFrame = new JFrame("L-System") {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Dimension getPreferredSize() {
				return new Dimension(1000,1000);
			}
		};
		JPanel mainPanel = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(800, 800);
			}
			// Need to redefine the paintComponent function from the JPanel class
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.red);
				LSystemPlant obj = new LSystemPlant();
				var string = obj.generate("", g);

				//obj.draw(g, string);	

			}
		};

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		mainPanel.setBackground(Color.white);

		mainFrame.add(mainPanel);
		mainFrame.pack();
		mainFrame.setVisible(true);		
	}	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}