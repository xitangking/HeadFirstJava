package Chapter12;

import javax.sound.midi.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer3
{
	static JFrame frame = new JFrame("My First Music Video");
	static MyDrawPanel ml;
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MiniMusicPlayer3 mini = new MiniMusicPlayer3();
		mini.go();
	}

	public void setUpGui()
	{
		ml = new MyDrawPanel();
		frame.setContentPane(ml);
		frame.setBounds(30,30,300,300);
		frame.setVisible(true);
	}
	
	public void go()
	{
		setUpGui();
		
		try
		{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addControllerEventListener(ml, new int[] {127});
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();
			
			int r = 0;
			for(int i = 0;i < 60;i += 4)
			{
				r = (int)((Math.random() * 50) + 1);
				track.add(makeEvent(144,1,r,100,i));
				track.add(makeEvent(176, 1, 127, 0, i));
				track.add(makeEvent(128, 1, r, 100, i + 2));
			}
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(120);
			sequencer.start();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
	public static MidiEvent makeEvent(int comd,int chan,int one,int two,int tick)
	{
		MidiEvent event = null;
		try
		{
			ShortMessage a = new ShortMessage();
			a.setMessage(comd,chan,one,two);
			event = new MidiEvent(a, tick);
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		return event;
	}
	
	class MyDrawPanel extends JPanel implements ControllerEventListener
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		boolean msg = false;

		@Override
		public void controlChange(ShortMessage event)
		{
			msg = true;
			repaint();
		}
		
		public void paintComponent(Graphics graphics)
		{
			if(msg)
			{
				int r = (int)(Math.random() * 250);
				int g = (int)(Math.random() * 250);
				int b = (int)(Math.random() * 250);
				
				graphics.setColor(new Color(r, g, b));
				
				int ht = (int)((Math.random() * 120) + 10);
				int width = (int)((Math.random() * 120) + 10);
				
				int x = (int)((Math.random() * 40) + 10);
				int y = (int)((Math.random() * 40) + 10);
				
				graphics.fillRect(x, y, ht, width);
				msg = false;
			}
		}
		
	}
	
}
