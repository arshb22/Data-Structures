class Passenger implements Comparable<Passenger>
{
  public String lastName;
  public String firstName;
  public String flightCity;
  public String flightTime;

  public Passenger(String a, String b, String c, String d)
  {
      lastName = b;
      firstName = a;
      flightCity = c;
      flightTime = d;
  }

  public String getLastName()
  {
    return lastName;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getFlightCity()
  {
    return flightCity;
  }

  public String getFlightTime()
  {
    return flightTime;
  }

  public String toString()
  {
    return lastName + ", " + firstName + " - " + flightCity + " - " + flightTime + " - " + etdCalc();
  }

  public String etdCalc()
  {
    //current time 9:03 AM
    String[] firstDivide = flightTime.split(" ");
    String[] secondDivide = firstDivide[0].split(":");
    if(firstDivide[1].equalsIgnoreCase("AM") || (firstDivide[1].equalsIgnoreCase("PM") && secondDivide[0].equalsIgnoreCase("12")) )
    {
      int totalTimeAM = (Integer.parseInt(secondDivide[0])*60) + (Integer.parseInt(secondDivide[1]));
      int timeLeftAM = (totalTimeAM-543);
      int hoursAM = timeLeftAM/60;
      int minutesAM = timeLeftAM%60;
      return hoursAM + " hours and " + minutesAM + " minutes";
    }
    if(firstDivide[1].equalsIgnoreCase("PM") && !(secondDivide[0].equalsIgnoreCase("12")) )
    {
      int totalTimePM = ((Integer.parseInt(secondDivide[0])*60)+720) + (Integer.parseInt(secondDivide[1]));
      int timeLeftPM = (totalTimePM-543);
      int hoursPM = timeLeftPM/60;
      int minutesPM = timeLeftPM%60;
      return hoursPM + " hours and " + minutesPM + " minutes";
    }
    return "error";
  }

  public int compareTo(Passenger other)
  {
    String otherGuy = other.etdCalc();
    String[] firstDivideOther = otherGuy.split(" ");
    int totalTimeOther = (Integer.parseInt(firstDivideOther[0])*60) + Integer.parseInt(firstDivideOther[3]);

    String secondGuy = this.etdCalc();
    String[] firstDivideNotOther = secondGuy.split(" ");
    int totalTimeThis = (Integer.parseInt(firstDivideNotOther[0])*60) + Integer.parseInt(firstDivideNotOther[3]);

    if(totalTimeThis > totalTimeOther)
    {
      return 1;
    }
    else if(totalTimeThis < totalTimeOther)
    {
      return -1;
    }
    else
    {
      return 0;
    }
  }
}