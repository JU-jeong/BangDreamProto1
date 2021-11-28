package bangdream4;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.MouseInputAdapter;

import org.w3c.dom.events.MouseEvent;

public class Bangdream extends JFrame {

	private Image image;
	private Graphics graphic;


	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("./images/menubar1.jpg")));
	private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("./images/exitbutton.png")));

	private JButton exitButtonEnteredImage = new JButton(
			new ImageIcon(Main.class.getResource("./images/exitbutton2.png")));
	private JButton exitButtonBasicImage = new JButton(
			new ImageIcon(Main.class.getResource("./images/exitbutton.png")));

	private int mouseX, mouseY;

	public Bangdream() {
		setUndecorated(true);
		setTitle("Bang dream");
		setSize(Main.width, Main.height);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0,0,0,0));
		setLayout(null);
		
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseInputAdapter() {
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon((Icon) exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon((Icon) exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(exitButton);
		
		menuBar.setBounds(0,0,1200,30);
		menuBar.addMouseListener((MouseListener) new MouseInputAdapter() {
			public void mousePressed(MouseEvent e) {
				mouseX = ((JComponent) e).getX();
				mouseY = ((JComponent) e).getY();
			}
		});
		menuBar.addMouseWheelListener(new MouseWheelListener() {
			public void mouseDragged(MouseEvent e) {
				int x = ((java.awt.event.MouseEvent) e).getXOnScreen();
				int y = ((java.awt.event.MouseEvent) e).getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(menuBar);
		
		Music introMusic = new Music(("music.mp3"), true);
		introMusic.start();
	}

	public void paint(Graphics g) {
		image = createImage(Main.width, Main.height);
		graphic = image.getGraphics();
		screenDraw(graphic);
		g.drawImage(image, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		
		paintComponents(g);
		this.repaint();
	}
}
