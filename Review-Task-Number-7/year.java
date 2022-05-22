class year implements Comparable<year>
{
  public double year = 0;
  public String name = "";

  public year(double a, String b)
  {
    year = a;
    name = b; 
  }
  public int compareTo(year other)
  {
    return (int)this.year - (int)other.year;
  }
}