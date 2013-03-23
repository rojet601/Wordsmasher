import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;


public class Display extends Canvas {
	private static final long serialVersionUID = 8274011568777903027L;
	private Spiel spiel;
	
	public Display(Spiel spiel) {
		this.spiel = spiel;
	}
	
	
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		for(Teil teil : spiel.teile) {
			g.setColor(teil.farbe);
			g.fillOval(teil.x, teil.y, 50, 30);
		}
		
		g.setColor(Color.GRAY);
		g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
	}
}
