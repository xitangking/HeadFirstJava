package Chapter11;

import javax.sound.midi.*;

public class MusicTest1
{

	public void play()
	{

		try
		{
			Sequencer sequencer = MidiSystem.getSequencer();
		} catch (MidiUnavailableException e)
		{
			System.out.println( "Bummer" );
		}

		System.out.println( "We got a sequencer" );
	}
	
	public static void main(String[] args)
	{
		MusicTest1 mt = new MusicTest1();
		mt.play();
	}

}
