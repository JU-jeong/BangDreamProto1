package bangdream3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Bangdream extends JFrame {
	
	private Image image;
	private Graphics graphic;
	
	private Image introbackground;

	public Bangdream() {
		setTitle("Bang dream");
		setSize(Main.width, Main.height);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		introbackground = new ImageIcon(Main.class.getResource("./images/introBackground.jpg"));
		
		Music introMusic = new Music("introMusic.mp3"), true);
		introMusic.start();
	}
	
	public void paint(Graphics g) {
		image = createImage(Main.width, Main.height);
		graphic = image.getGraphics();
		screenDraw(graphic);
		g.drawImage(image, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
	}
}
