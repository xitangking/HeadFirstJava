package Chapter12;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class SunDry
{
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
}
