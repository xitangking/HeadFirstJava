package Chapter16;

import java.util.*;
import java.io.*;

/********************************************************************************
 * using for:
 * 2017/02/04 13:23
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/
public class Jukebox1
{
    ArrayList<Song> songList = new ArrayList<>();

    public static void main(String[] args)
    {
        new Jukebox1().go();
    }

    class ArtistCompare implements Comparator<Song>
    {
        @Override
        public int compare(Song one,Song two)
        {
            return one.getArtlst().compareTo(two.getArtlst());
        }

    }

    public void go()
    {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);

        ArtistCompare artistCompare = new ArtistCompare();
        //Collections.sort(songList,artistCompare);
        System.out.println(songList);
        
        HashSet<Song> songSet = new HashSet<Song>();
        boolean b = songSet.addAll(songList);
        System.out.println(songSet);

    }

    void getSongs()
    {

        try
        {
            File file = new File("SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null)
            {
                addSong(line);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    void addSong(String lineToParse)
    {
        String[] tokens = lineToParse.split("/");
        songList.add(new Song(tokens[0],tokens[1],tokens[2],tokens[3]));
    }
}
