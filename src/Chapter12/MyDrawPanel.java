package Chapter12;

import java.awt.*;
import javax.swing.*;

class MyDrawPanel extends JPanel
{
	/*
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.orange);
		
		g.fillRect(20, 50, 100, 100);
	}
	*/
	/*
	public void paintComponent(Graphics graphics)
	{
		Image image = new ImageIcon("catzilla.jpg").getImage();
		
		graphics.drawImage(image, 3, 4, this);
	}
	*/
	/*
	public void paintComponent(Graphics graphics)
	{
		graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		int red = (int)(Math.random() * 255);
		int green = (int)(Math.random() * 255);
		int blue = (int)(Math.random() * 255);
		
		Color randomColor = new Color(red, green, blue);
		graphics.setColor(randomColor);
		graphics.fillOval(70, 70, 100, 100);
	}
	*/
	/*
	public void paintComponent(Graphics graphics)
	{
		Graphics2D graphics2d = (Graphics2D)graphics;
		
		GradientPaint gradientPaint = new GradientPaint(70, 70, Color.blue, 150, 150, Color.orange);
		
		graphics2d.setPaint(gradientPaint);
		graphics2d.fillOval(70, 70, 100, 100);
	}
	*/
	
	public void paintComponent(Graphics g)
	{
		Graphics2D graphics2d = (Graphics2D)g;
		
		int red = (int)(Math.random() * 255);
		int green = (int)(Math.random() * 255);
		int blue = (int)(Math.random() * 255);
		Color starColor = new Color(red, green, blue);
		
		red = (int)(Math.random() * 255);
		green = (int)(Math.random() * 255);
		blue = (int)(Math.random() * 255);
		Color endColor = new Color(red, green, blue);
		
		GradientPaint gradientPaint = new GradientPaint(70, 70, starColor, 150, 150, endColor);
		graphics2d.setPaint(gradientPaint);
		graphics2d.fillOval(70, 70, 100, 100);
	}
	
}
