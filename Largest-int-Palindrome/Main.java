class Main 
{
  public static void main(String[] args) 
  {

    for(int i = Integer.MAX_VALUE; i>0; i--)
    {
      if(palindrome(i))
      {
          System.out.println(i);
          break;
      }
      
    }
  }

  public static boolean palindrome(int n)
  {
    int num = n, reversedNum = 0, remainder;

    int originalNum = num;

    while (num != 0) {
      remainder = num % 10;
      reversedNum = reversedNum * 10 + remainder;
      num /= 10;
    }

    if (originalNum == reversedNum) {
      return true;
    }
    else {
      return false;
    }
  }
}