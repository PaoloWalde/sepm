import java.util.Scanner;

public class RemoveLocation
{
  public static void main(String[] args)
  {
    int array[] = new int[5];
    int location = 0;
    int max = 4;
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("\nEnter 5 integer values : "); {
    }
    for(int i=0;i<=max;i++)
    {
      array[i]=sc.nextInt();
    }
    
    System.out.println("\nValues in array are following : ");
    for(int i=0;i<max;i++)
    {
      System.out.println(array[i]);
    }
    
    System.out.print("\nEnter the location from where you want to delete the value(index begins with 0) :");
    location = sc.nextInt();
    
    for(int i=location;i<max;i++)
    {
      array[i]=array[i+1];
    }
    System.out.println("\nValues in array after deleting the value from the location "+location+" are following :");
    for(int i=0;i<max;i++)
    {
      System.out.println(array[i]);
    }
  }
}
    
