import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.BigInteger;

class Main 
{
  public static void main(String[] args) 
  {
    BufferedReader br = null;
    String line;
    int numRow = 0;
    int numCol = 0;
    int lengthOfSide = 0;
    int rowTop = 0;
    int columnTopPoint = 0;

    try
    {
        br = new BufferedReader(new FileReader("input.txt"));

        while((line = br.readLine()) != null)
        {
            String[] numbers = line.split(" ");
            numRow = Integer.parseInt(numbers[0]);
            numCol = Integer.parseInt(numbers[1]);
            lengthOfSide = Integer.parseInt(numbers[2]);
            rowTop = Integer.parseInt(numbers[3]);
            columnTopPoint = Integer.parseInt(numbers[4]);
        }

    } catch(IOException e)
    {
      e.printStackTrace();
    }

    int count = lengthOfSide;

    String[][] arrayDiamond = new String[numRow][numCol];
    for(int a = 0; a <numRow; a++)
    {
      for(int b = 0; b<numCol; b++)
      {
        if(a==rowTop && b==columnTopPoint)
        {
          arrayDiamond[rowTop][columnTopPoint] = "x";
          arrayDiamond[rowTop+1][columnTopPoint] = "x";
          arrayDiamond[rowTop+1][columnTopPoint-1] = "x";
          arrayDiamond[rowTop+1][columnTopPoint+1] = "x";
        }
        if(arrayDiamond[a][b]=="x" && count>1)
        {
          arrayDiamond[a+1][b]="x";
          arrayDiamond[a+1][b-1] = "x";
          arrayDiamond[a+1][b+1]= "x";
        }
        if(arrayDiamond[a][b]=="x" && count==1)
        {
          if(arrayDiamond[a][b+1] == "x" && arrayDiamond[a][b-1]=="x")
          {
            arrayDiamond[a+1][b] = "x";
          }
          if(arrayDiamond[a][b+1] == null)
          {
              arrayDiamond[a+1][b] = null;
          }
          if(arrayDiamond[a][b-1] == null)
          {
            arrayDiamond[a+1][b] = null;
          }
          if(arrayDiamond[a][b+1]==null && arrayDiamond[a][b-1]==null)
          {
            arrayDiamond[a+1][b] = null;
          }
          
        }
        if(arrayDiamond[a][b] == "x")
        {
          System.out.print("x");
        }
        if(arrayDiamond[a][b]==null)
        {
          System.out.print("o");
        }
      }
      if(count>1)
      {
        count--;
      }
      System.out.println();
    }
  }
}