class cylinders implements Comparable<cylinders>
{
  public double cylinders = 0;
  public String name = "";
  
  public cylinders(double a, String b)
  {
    cylinders = a;
    name = b;
  }
  public int compareTo(cylinders other)
  {
    return (int)this.cylinders - (int)other.cylinders;
  }
}