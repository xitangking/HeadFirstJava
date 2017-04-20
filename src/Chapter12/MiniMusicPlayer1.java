package Chapter12;

import javax.sound.midi.*;

public class MiniMusicPlayer1 implements ControllerEventListener
{
	public static void main(String[] args)
	{
		MiniMusicPlayer1 player1 = new MiniMusicPlayer1();
		player1.go();
	}
	
	public void go()
	{
		try
		{
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();
			
			int[] eventsIWant = {127};
			sequencer.addControllerEventListener(this, eventsIWant);
			
			Sequence sequence = new Sequence(Sequence.PPQ, 4);
			Track track = sequence.createTrack();
			
			for(int i = 5;i < 61;i += 4)
			{
				track.add(makeEvent(144,1,i,100,i));
				
				track.add(makeEvent(176,1,127,0,i));
				
				track.add(makeEvent(128,1,i,100,i + 2));
			}
			
			sequencer.setSequence(sequence);
			sequencer.setTempoInBPM(220);
			sequencer.start();
		} catch (Exception e)
		{
			e.printStackTrace();
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

	@Override
	public void controlChange(ShortMessage arg0)
	{
		System.out.println(arg0.getData1());
	}
}
