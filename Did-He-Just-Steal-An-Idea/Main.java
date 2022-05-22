import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    BufferedReader br = null;

    String line;

    String input = "";

    ArrayList<BigInteger> list = new ArrayList<BigInteger>();


    try{
      br = new BufferedReader(new FileReader("lucas.txt"));
      while((line = br.readLine()) != null){
        Integer x = Integer.parseInt(line);
        list.add(lucasNumber(x));
      }
    }catch(IOException e){
        System.out.println("File does not exist");
    }

for (int i=0; i<list.size(); i++) 
{ 
    BigInteger x = list.get(i);;
    System.out.println(x);
}

  }
  public static BigInteger lucasNumber(Integer i)
  {
    BigInteger a = BigInteger.valueOf(2);
    BigInteger b = BigInteger.valueOf(1);
    BigInteger c = null;
    Integer x = null;

    if(i==0)
    {
      return a;
    }
    if(i==1){
      return b;
    }
    else{
      for(x = 2; x<=i; i++){
        c = a.add(b);
        a = b;
        b = c;
      }
      return b;
    }
  }

}