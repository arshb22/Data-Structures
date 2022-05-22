class State
{
  String state = "";
  int population = 0;
  int numAppRep = 0;
  public State(String a, int b, int c)
  {
    state = a;
    population = b;
    numAppRep = c;
  }

  public String getState()
  {
    return state;
  }

  public int getPopulation()
  {
    return population;
  }

  public int getNumAppRep()
  {
    return numAppRep; 
  }
}