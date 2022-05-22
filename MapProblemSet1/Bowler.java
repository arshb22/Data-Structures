class Bowler implements Comparable<Bowler>
{
	String firstName, lastName;
	int score;

	public Bowler(String firstName, String lastName, int score)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.score = score;
	}

	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public int score() { return score; }

	public int compareTo(Bowler other)
	{
		if (lastName.compareTo(other.getLastName()) != 0)
			return lastName.compareTo(other.getLastName());
		return firstName.compareTo(other.getFirstName());
	}

	public String toString() { return firstName + " " + lastName; }
}
