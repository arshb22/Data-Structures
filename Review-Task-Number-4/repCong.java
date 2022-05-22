class repCong
{
  String state = "";
  int numberOfPeoplePerReps;

  public repCong(String stateOf, int number)
  {
    state = stateOf;
    numberOfPeoplePerReps = number;
  }

  public String getState()
  {
      return state;
  }

  public int getNumberOfPeoplePerReps()
  {
    return numberOfPeoplePerReps;
  }
}