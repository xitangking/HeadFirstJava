package Chapter3;

public class Dog
{
	String name;
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Dog dog1 = new Dog();
		dog1.bark();
		dog1.name = "Bart";
		//  ??Dog??
		Dog[] myDogs = new Dog[3];
		//  ????
		myDogs[0] = new Dog();
		myDogs[1] = new Dog();
		myDogs[2] = dog1;
		//  ???????? Dog
		myDogs[0].name = "Fred";
		myDogs[1].name = "Marge";
		// myDog[2] ?????
		System.out.print("last dog¡¯s name is ");
		System.out.println(myDogs[2].name);
		//  ???Dog?? bark()
		int x = 0;
		while(x < myDogs.length) {
		myDogs[x].bark();
		x = x + 1;
		}
	}

	public void bark()
	{
		System.out.println(name + " says Ruff!");
	}
	public void eat()
	{
		
	}
	public void chaseCat()
	{
		// TODO Auto-generated method stub

	}
}
