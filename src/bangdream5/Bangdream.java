package bangdream5;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.w3c.dom.events.MouseEvent;

public class Bangdream extends JFrame {

	private Image image;
	private Graphics graphic;

	private Image introbackground = new ImageIcon(Main.class.getResource("./images/introBackground.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("./images/menubar1.jpg")).getImage());
	private JButton exitButton = new JButton(new ImageIcon(Main.class.getResource("./images/exitbutton.png")));
	
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
		
		menuBar.setBounds(0,0,1200,30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY():
			}
		});
		menubar1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x = mouseX, y = mouseY);
			}
		});
		add(menuBar);
		
		exitButton.setBounds(50,50,30,30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		add(exitButton);
		
		Music introMusic = new Music("music.mp3"), true);
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
		paintComponents(g);
		this.repaint();
	}
}
