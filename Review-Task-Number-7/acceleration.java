class acceleration implements Comparable<acceleration>
{
  public double acceleration = 0;
  public String name = "";
  
  public acceleration(double a, String b)
  {
    acceleration = a;
    name = b;
  }

  public int compareTo(acceleration other)
  {
    return (int)this.acceleration - (int)other.acceleration;
  }
}