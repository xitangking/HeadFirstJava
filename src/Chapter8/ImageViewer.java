package Chapter8;

import java.awt.*;
import java.io.*;
import javax.swing.*;

/*
 * A program for viewing images
 * @version 1.0 2017-1-29
 * @author Î÷ÌÆÍõ
 */

public class ImageViewer
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(() -> {
			JFrame frame = new ImageViewerFrame();
			frame.setTitle("ImageViewer");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}

/*
 * A frame with a label to show an image
 */
class ImageViewerFrame extends JFrame
{
	private JLabel label;
	private JFileChooser chooser;
	private static final int DEFAULT_WIDTH = 30;
	private static final int DEFAULT_HEIGHT = 400;
	
	public ImageViewerFrame()
	{
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		//use a label to dispaly the image
		label = new JLabel();
		add(label);
		
		//set up the file chooser
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		
		//set up the menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(event->
		{
			//show file chooser dialog
			int result = chooser.showOpenDialog(null);
			//if file selected,set it as icon of the label
			if(result == JFileChooser.APPROVE_OPTION)
			{
				String name = chooser.getSelectedFile().getPath();
				label.setIcon(new ImageIcon(name));
			}
		});
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(Event -> System.exit(0));
		
		
	}
}
