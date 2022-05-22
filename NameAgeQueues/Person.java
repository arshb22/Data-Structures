public class Person implements Comparable<Person>
{
  private String name;
  private int age;

  public Person(String name, int age)
  {
    this.name = name;
    this.age = age;
  }

  public String getName() { return name; }

  public int getAge() { return age; }

  public String toString()
  {
    return name+", "+ age+" years old";
  }

  public int compareTo(Person a)
  {
    if(name.compareTo(a.getName()) == 0)
      return age - a.getAge();
    return name.compareTo(a.getName());
  }

}
