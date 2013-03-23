import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public class Display extends Canvas {
	private static final long serialVersionUID = 8274011568777903027L;
	private Spiel spiel;
	
	private Image bufImage;
	private Graphics bufG;
	
	public Display(Spiel spiel) {
		this.spiel = spiel;
	}
	
	
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		for(Teil teil : spiel.teile) {
			g.setColor(teil.farbe);
			g.fillOval(teil.x, teil.y, 100, 60);
		}
		
		g.setColor(Color.GRAY);
		g.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
	}
	
	public void update(Graphics g) { // Double-Buffering
		int w = this.getSize().width;
		int h = this.getSize().height;

		if(bufImage == null) {
			bufImage = this.createImage(w, h);
			bufG = bufImage.getGraphics();
		}

		bufG.setColor(this.getBackground());
		bufG.fillRect(0, 0, w, h);

		bufG.setColor(this.getForeground());

		paint(bufG);

		g.drawImage(bufImage, 0, 0, this);
	}
}
