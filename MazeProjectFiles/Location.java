public class Location
{
	int r = 0;
	int c = 0;

//Constructor that sets a(row paramter) to r private field and b(col paramater) to c private field
	public Location(int a, int b)
	{
		r = a;
		c = b;
	}

//get rows
	public int getR()
	{
		return r;
	}

//get columns
	public int getC()
	{
		return c;
	}

	public String toString()
	{
		return r + " " + c;
	}

//equal method that finds if row and col are same in form of a.equals(b); a refers to r and c; while other is getC and getR
	public boolean equals(Location other)
	{
		if((r == other.getR()) && (c == other.getC()))
			return true;
		return false;
	}

	//another equal method that accepts ints as opposed to a location
	public boolean equals(int a, int b)
	{
		if(r==a && c==b)
			return true;
		return false;
	}

	//adds a value to rows and sets it
	public void setR(int a)
	{
		r+=a;
	}
	//adds a value to col and sets it
	public void setC(int b)
	{
		c+=b;
	}

	public void putR(int j)
	{
		r = j;
	}

	public void putC(int k)
	{
		c = k;
	}
}