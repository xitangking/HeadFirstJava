package Chapter3;

public class Triangle
{
	double area;
	int height;
	int length;
	public static void main(String[] args)
	{
		Triangle[] triangles = new Triangle[4];
		int x = 0;
		while(x < 4)
		{
			triangles[x] = new Triangle();
			triangles[x].height = (x + 1) * 2;
			triangles[x].length = x + 4;
			triangles[x].setArea();
			System.out.print( "triangle " + x + ", area");
			System.out.println( " = " + triangles[x].area );
			++x;
		}
		int y = x;
		x = 27;
		Triangle t5 = triangles[2];
		triangles[2].area = 343;
		System.out.print("y = " + y );
		System.out.println( ", t5 area = " + t5.area);
	}

	void setArea()
	{
		area = (height * length) / 2;
	}
}
