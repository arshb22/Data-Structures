class Main 
{
  public static void main(String[] args) 
  {

  }

  public static int multiply(int a, int b) 
  {
    int returnValue = a*b;
    
    //bool true (neg) and false (pos)
    boolean negPos = true;
    
    //knows that the return value should be false (pos)
    if(a > 0 && b > 0)
      negPos = false;
    if(a < 0 && b < 0)
      negPos = false;
    
    if(returnValue < 0 && negPos == false)
    {
      throw new ArithmeticException();
    }
    return returnValue;
  }
}