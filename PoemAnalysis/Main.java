import java.io.*;
import java.lang.*;
import java.util.*;

class Main 
{
  public static void main(String[] args) 
  {
    BufferedReader br = null;
    String line;
    int s = 0;
    int a = 0;
    int n = 0;
    int t = 0;

    try
    {
        br = new BufferedReader(new FileReader("input.txt"));

        while((line = br.readLine()) != null)
        {
          for(int i = 0; i<line.length();i++)
          {
            if(line.charAt(i)=='s')
            {
              s++;
            }
            if(line.charAt(i)=='a')
            {
              a++;
            }
            if(line.charAt(i)=='n')
            {
              n++;
            }
            if(line.charAt(i)=='t')
            {
              t++;
            }
          }
        }

    }catch(IOException e)
    {
      e.printStackTrace();
    }

    int actualA = a/2;

    ArrayList<Integer> charactersAmount = new ArrayList<Integer>();
    charactersAmount.add(s);
    charactersAmount.add(actualA);
    charactersAmount.add(n);
    charactersAmount.add(t);

  Collections.sort(charactersAmount);

  System.out.println(charactersAmount.get(0));

  }
}