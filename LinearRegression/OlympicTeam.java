public class OlympicTeam implements Comparable<OlympicTeam>
{
		private String countryName;
		private int goldAmount;
		private int silverAmount;
		private int bronzeAmount;

		public OlympicTeam(String a, int b, int c, int d)
		{
			countryName = a;
			goldAmount = b;
			silverAmount = c;
			bronzeAmount = d;
		}

		public int compareTo(OlympicTeam other)
		{
			return this.getNumGold() - other.getNumGold();
		}

		public String getCountry()
		{
			return countryName;
		}

		public int getNumGold()
		{
			return goldAmount;
		}

		public int getNumSilver()
		{
			return silverAmount;
		}

		public int getNumBronze()
		{
			return bronzeAmount;
		}

		public String toString()
		{
			return countryName + " => G = " + goldAmount + ", S = " + silverAmount + ", B = " + bronzeAmount;
		}
}