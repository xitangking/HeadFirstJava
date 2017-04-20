package Chapter11;

import javax.sound.midi.*;

/**
 * Created by xtw on 2017/1/31.
 */
public class MinMusicApp
{
    public static void main(String[] args)
    {
        MinMusicApp mini = new MinMusicApp();
        mini.play();
    }

    public void play()
    {
        try
        {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ,4);

            Track track = seq.createTrack();

            ShortMessage a = new ShortMessage();
            a.setMessage(144,1,102,100);
            MidiEvent noteOn = new MidiEvent(a,1);
            track.add(noteOn);
            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,102,100);
            MidiEvent noteOff = new MidiEvent(b,20);
            track.add(noteOff);

            player.setSequence(seq);

            player.start();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
