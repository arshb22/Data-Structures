class MedianIncome implements Comparable<MedianIncome>
{
  String countryName;
  Double medianIncome;
  
  public MedianIncome(String a, double b)
  {
    countryName = a;
    medianIncome = b;
  }

  public String toString()
  {
      return (countryName + " " + medianIncome);
  }

  public int compareTo(MedianIncome other)
  {
      return this.medianIncome.compareTo(other.getMedianIncome());
  }

  public double getMedianIncome()
  {
    return medianIncome;
  }
}