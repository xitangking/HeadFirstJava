package Chapter12;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class SimpleAnimation
{
	int x,y;
	JFrame frame;
	
	public static void main(String[] args)
	{
		SimpleAnimation animation = new SimpleAnimation();
		animation.go();
	}
	
	public void go()
	{
		frame = new JFrame("Animation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		x = 20;
		y = 20;
		
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.getContentPane().add(drawPanel);
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		
		while( x < 800 )
		{
			x = y += 1;
			drawPanel.repaint();
			try
			{
				Thread.sleep(5);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	class MyDrawPanel extends JPanel
	{
		public void paintComponent(Graphics graphics)
		{
			graphics.setColor(Color.white);
			graphics.fillRect(0, 0, getWidth(), getHeight());
			
			graphics.setColor(Color.orange);
			graphics.fillOval(x, y, 100, 100);
		}
	}
}
