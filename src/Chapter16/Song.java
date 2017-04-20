package Chapter16;

/********************************************************************************
 * using for:
 * 2017/02/04 13:41
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/
public class Song implements Comparable<Song>
{
    String title;
    String artlst;
    String rating;
    String bpm;

    @Override
    public boolean equals(Object aSong)
    {
        Song s = (Song)aSong;
        return getTitle().equals(s.getTitle());
    }

    @Override
    public int hashCode()
    {
        return title.hashCode();
    }

    public int compareTo(Song s)
    {
        return title.compareTo(s.getTitle());
    }

    Song(String t,String a,String r,String b)
    {
        title = t;
        artlst = a;
        rating = r;
        bpm = b;
    }

    public String getTitle() {
        return title;
    }

    public String getArtlst() {
        return artlst;
    }

    public String getRating() {
        return rating;
    }

    public String getBpm() {
        return bpm;
    }


}
