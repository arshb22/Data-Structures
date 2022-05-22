class horsepower implements Comparable<horsepower>
{
  public double horsepower = 0;
  public String name = "";

  public horsepower(double a, String b)
  {
    horsepower = a;
    name = b;
  }
  public int compareTo(horsepower other)
  {
    return (int)this.horsepower - (int)other.horsepower;
  }
}