import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.ArrayList;
import java.math.BigInteger;
import java.lang.reflect.Array;

class Main 
{
  public static void main(String[] args) 
  {
    BufferedReader br = null;
    String line;
    ArrayList<String> codes = new ArrayList<String>();

    try
    {
        br = new BufferedReader(new FileReader("input.txt"));

        while((line = br.readLine()) != null)
        {
          codes.add(line);
          //System.out.println(line);
        }

    } catch(IOException e)
    {
      e.printStackTrace();
    }

  //int iterations = codes.size()/2;

  //figure out the for loop for This

  for(int a = 0; a < codes.size();a +=2)
  {
  ArrayList<Character> code = new ArrayList<Character>();
  for(char c : codes.get(a).toCharArray())
  {
    code.add(c);
  }

  ArrayList<Character> guess = new ArrayList<Character>();
  for(char c : codes.get(a+1).toCharArray())
  {
    guess.add(c);
  }

  int correctCorrect = 0;
  int correctIncorrect = 0;

    //This finds how many are the same letter and at the same space
    for(int i = 0; i<code.size(); i++)
    {
      if(code.get(i) == guess.get(i))
      {
        correctCorrect++;
        code.remove(i);
        guess.remove(i);
      }
    }

    for(int i =0; i<code.size(); i++)
    {
      for(int z = 0; z<guess.size();z++)
      {
        if(code.get(i) == guess.get(z))
        {
          guess.remove(z);
          correctIncorrect++;
        }
      }
    }
    System.out.println("Code: " + codes.get(a));
    System.out.println("Guess: " + codes.get(a+1));
    System.out.println("Color Correct - Correctly Placed: " + correctCorrect);
    System.out.println("Color Correct - Incorrectly Placed: " + correctIncorrect);
    System.out.println();
  }
  }
}