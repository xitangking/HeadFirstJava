package Chapter2;

public class DrumKitTestDrive
{

	public static void main(String[] args)
	{
		DrumKit drumKit = new DrumKit();
		drumKit.snare = false;
		if(drumKit.snare == true)
			drumKit.playSnare();
		drumKit.playSnare();
		drumKit.playTopHat();
	}

}
