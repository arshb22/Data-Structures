interface leibnizPi 
{
	public double leibniz(int n);
}

class Main 
{
  public static void main(String[] args) 
  {
    leibnizPi lP = (n) ->{
			double count = 1.0;
			double piApproximation = 0.0;
			
			for(int i = 0; i<n;i++)
			{
				if(i%2==0)
        {
        piApproximation = piApproximation + (4.0/count);
        }
        if(i%2==1)
        {
        piApproximation = piApproximation - (4.0/count); 
        }
        count = count + 2.0;
			}
			return piApproximation;
			
		};
		System.out.println(lP.leibniz(1000));
  }
}