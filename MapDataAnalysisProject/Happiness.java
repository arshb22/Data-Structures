class Happiness implements Comparable<Happiness>
{
  String countryName;
  Double happinessLevel;
  
  public Happiness(String a, double b)
  {
    countryName = a;
    happinessLevel = b;
  }

  public String toString()
  {
      return (countryName + " " + happinessLevel);
  }

  public int compareTo(Happiness other)
  {
      return this.happinessLevel.compareTo(other.getHappiness());
  }

  public double getHappiness()
  {
    return happinessLevel;
  }
}