class weight implements Comparable<weight>
{
  public double weight = 0;
  public String name = "";

  public weight(double a, String b)
  {
    weight = a;
    name = b;
  }
  public int compareTo(weight other)
  {
    return (int)this.weight - (int)other.weight;
  }
}