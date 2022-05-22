class displacement implements Comparable<displacement>
{
  public double displacement = 0;
  public String name = "";

  public displacement(double a, String b)
  {
    displacement = a;
    name = b;
  }
  public int compareTo(displacement other)
  {
    return (int)this.displacement - (int)other.displacement;
  }
}