import java.util.*;

public class OlympicTeamE implements Comparable<OlympicTeam>{
	//Private fields - meaning that they can only be accessed by get methods - each object has 4 fields 
	// These four fields are country name, number of gold medals won, number of silver medals won, number of bronze medals won
	private String country;
	private int numGold;
	private int numSilver;
	private int numBronze;

	//Constructors that sets paramaters that are parsed in to the fields
	public OlympicTeam(String countryName, int gold, int silver, int bronze){
		country = countryName;
		numGold = gold;
		numSilver = silver;
		numBronze = bronze;
	}

	//Accesor Methods
	
	//Returns country name
	public String getCountry() { return country; }

	//Returns number of gold medals won
	public int getNumGold() { return numGold; }

	//Returns number of silver medals won
	public int getNumSilver() { return numSilver; }

	//Returns number of bronze medals won
	public int getNumBronze() { return numBronze; }

	public String toString(){
		return country + " => G = "+numGold+", S = "+numSilver+", B = "+numBronze;
	}

	//this refers to a and other refers to b of a.equals(b); first checks if names are equal
	//thenit checks if gold, silver, and bronze are equal; if they are it returns true; if not then it returns false
  public boolean equals(OlympicTeam other){
      if (this.getCountry() == other.getCountry())
        if (this.getNumGold() == other.getNumGold())
            if (this.getNumSilver() == other.getNumSilver())
              if (this.getNumBronze() == other.getNumBronze())
                return true;
    
        return false;
  }

//Adds together all medals and returns it as in integer
  public int getTotalMedals(){
    int sum = 0;
    if (numGold > 0 )
      sum += numGold;
    if (numSilver > 0)
      sum += numSilver;
    if (numBronze > 0)
      sum += numBronze;
    return sum;
  }

  public int sumLeastTwo(){
    int sum = 0;
    //if most of their medals are gold,sum bronze and silver
    if (numGold > numBronze && numGold > numSilver)
      return numBronze + numSilver;
   
   //if most of their medals are silver,sum bronze and gold
    if (numSilver > numBronze && numSilver > numGold)
      return numBronze + numGold;

    // if (numSilver > sumBronze && numSilver > numGold)
   
   //if silver equals gold, it first checks if silver is less than bronze and returns twice its value if true
   //else it returns bronze and silver
   if (numSilver == numGold)
      if (numSilver < numBronze)
          return 2 * numSilver;
      else
          return numSilver + numBronze;
   
    //if silver equals bronze, it first checks if silver is less than gold and returns twice its value if true
   //else it returns gold and silver
    if (numSilver == numBronze)
      if (numSilver < numGold)
          return 2 * numSilver;
      else
          return numSilver + numGold;

    //if gold equals bronze, it first checks if gold is less than silver and returns twice its value if true
   //else it returns gold and silver
	if (numGold == numBronze)
		if (numGold < numSilver)
			return 2*numGold;
    return numGold + numSilver;
  }



//class implements the Comparable and override the method and returns value based on number of gold
  public int compareTo(OlympicTeam other){
    return this.getNumGold() - other.getNumGold();
  }
  
  public static void main(String[]args){
	  OlympicTeam t1 = new OlympicTeam("team 1",2,2,1);
	  System.out.println(t1.sumLeastTwo());
  }



}