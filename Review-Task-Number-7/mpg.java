class mpg implements Comparable<mpg>
{
  public double mpg = 0;
  public String name = "";

  public mpg(double a, String b)
  {
    mpg = a;
    name = b;
  }
  public int compareTo(mpg other)
  {
    return (int)this.mpg - (int)other.mpg;
  }
}