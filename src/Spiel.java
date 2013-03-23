import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Spiel extends JFrame {
	private static final long serialVersionUID = 290407224061845329L;

	private JTextField eingabe;
	private JButton hilfe;
	private Display display;

	public String[] wörter = {"lol", "rofl", "xd"};
	
	private long lastTick;
	private long tick;

	public boolean running;
	public ArrayList<Teil> teile;

	public static void main(String[] args) {
		new Spiel();
	}

	public Spiel() {
		super("Spiel");

		this.running = true;
		this.lastTick = System.currentTimeMillis();
		this.tick = 1000;
		this.teile = new ArrayList<Teil>();

		this.setSize(400, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);

		eingabe = new JTextField();
		eingabe.setBounds(5, 600, 310, 70);
		this.add(eingabe);

		hilfe = new JButton("HILFE");
		hilfe.setBounds(320, 600, 70, 70);
		this.add(hilfe);

		display = new Display(this);
		display.setBounds(5, 5, 385, 590);
		this.add(display);

		this.setVisible(true);

		for (int i = 0; i < 10; i++) {
			int r = (int) (Math.random() * 256);
			int g = (int) (Math.random() * 256);
			int b = (int) (Math.random() * 256);
			Color farbe = new Color(r, g, b);
			String wort = "lol";
			int x = (int) (Math.random() * display.getWidth());
			int y = 0;

			Teil teil = new Teil(farbe, wort, x, y);
			teile.add(teil);
		}

		while (running) {
			if (this.lastTick - System.currentTimeMillis() > this.tick) {
				this.lastTick = System.currentTimeMillis();
			}

			display.repaint();
		}
	}
}
