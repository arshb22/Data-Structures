import java.util.*;

class Main 
{
  public static void main(String[] args) 
  {
    //TaskSet 1
		HashSet<Character> digit = new HashSet<Character>();
		String num = "1562836047588678243489701526384857673";

		int i = 0;
		while(digit.size() <= 9)
		{
			char c = num.charAt(i);
			digit.add(c);
			i++;
		}
		System.out.println("Index of digit when the set is completed: " + (i-1));
		System.out.println();

		////TaskSet 2
		int trialSum = 0;
		for(int b = 1; b <= 100; b++)
		{
			trialSum += task2();
		}

		System.out.println("Average Total People in 100 trials: " +(int)trialSum/100);
		System.out.println();




		////TaskSet 3
		String str = "From the reef-fringed coast of New Caledonia, the Coral Sea stretches into the South Pacific. Slender native pines, listing like whimsical Christmas trees, punctuate the shoreline. The landscape, one of the most biodiverse on the planet, is astonishingly beautiful until the crest of a hill where a different vista unfolds: a gouged red earth pierced by belching smokestacks and giant trucks rumbling across the lunar-like terrain. This is Goro, the largest nickel mine on a tiny French territory suspended between Australia and Fiji that may hold up to a quarter of the world's nickel reserves. It also poses a critical test for Tesla, the world's largest electric vehicle maker, which wants to take control of its supply chain and ensure that the minerals used for its car batteries are mined in an environmentally and socially responsible fashion.";
		str = str.toLowerCase();
		str = str.replaceAll("[,.:]", "");
		str = str.replaceAll("[-]", " ");

		TreeSet<String> treeSet = new TreeSet<String>();
		for(String words: str.split(" "))
		{
			treeSet.add(words);
		}
		//System.out.println("TreeSet: "+ treeSet);
		for(int k = 0; k < 13; k++)
		{
			treeSet.pollFirst();
		}
		System.out.println("14th alphabetical word: " + treeSet.pollFirst());
		System.out.println();
  }

  	public static int task2()
	{
		HashSet<Integer> ppl = new HashSet<Integer>();
		int totalPeople = 0;
		int randomBirthday = 0;

		boolean f = false;

		while(f == false)
		{
			totalPeople++;
			randomBirthday = (int)(Math.random() * 365 + 1);
			ppl.add(randomBirthday);

			if(ppl.size() == 365)
			{
				f = true;
			}
		}
		return totalPeople;
	}
}