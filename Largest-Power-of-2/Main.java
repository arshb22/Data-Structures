class Main 
{
  public static void main(String[] args) 
  {
    boolean stuff = false;
    int b = 0;
    do
    {
      double thing = Math.pow(2,b);
      b++;
      if(thing >= Double.MAX_VALUE)
      {
        System.out.println((double)Math.pow(2,b-2));
        stuff = true;
      }
    }while(!stuff);
  
  }
}