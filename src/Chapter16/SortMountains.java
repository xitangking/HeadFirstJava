package Chapter16;

import java.util.*;

/********************************************************************************
 * using for:
 * 丁酉鸡年正月初八 2017/02/04 18:10
 * @author 西唐王, xtwyzh@gmail.com,xtwroot.com
 * xtwroot Copyrights (c) 2017. All rights reserved.
 ********************************************************************************/
public class SortMountains
{
    LinkedList<Mountain> mtn = new LinkedList<Mountain>();

    class NameCompare implements Comparator<Mountain>
    {
        @Override
        public int compare(Mountain left,Mountain right)
        {
            return left.name.compareTo(right.name);
        }
    }

    class HeightCompare implements Comparator<Mountain>
    {
        @Override
        public int compare(Mountain left,Mountain right)
        {
            return right.height - left.height;
        }
    }

    public static void main(String[] args)
    {
        new SortMountains().go();
    }

    public void go()
    {
        mtn.add(new Mountain("Longs",14255));
        mtn.add(new Mountain("Elbert",14433));
        mtn.add(new Mountain("Maroon",14156));
        mtn.add(new Mountain("Castle",14256));

        System.out.println("as entered:\n" + mtn);
        NameCompare nc = new NameCompare();
        Collections.sort(mtn,nc);
        System.out.println("by name:\n" + mtn);
        HeightCompare hc = new HeightCompare();
        Collections.sort(mtn,hc);
        System.out.println("by height:\n" + mtn);
    }

}

class Mountain
{
    String name;
    int height;

    Mountain(String n,int h)
    {
        name = n;
        height = h;
    }

    @Override
    public String toString() {
        return name + " " + height;
    }

}

