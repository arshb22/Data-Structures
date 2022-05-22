class Main 
{
  public static void main(String[] args) 
  {
      Integer when = 20;
      System.out.println(when.hashCode());

      String a = "200";
      String b = "200";

      System.out.println(a.hashCode() + "\n" + b.hashCode());

      String c = "10";
      String d = "50";

      System.out.println(c.hashCode() + "\n" + d.hashCode());

  }
}