import java.util.Scanner;
class Grades
{

    String sub1;
    String sub2;
    String sub3;
    String sub4;
    String sub5;
    int m1;
    int m2;
    int m3;
    int m4;
    int m5;
    public Grades(String sub1,String sub2, String sub3, String sub4, String sub5, int m1, int m2,int m3, int m4,int m5)
    {

        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.sub4 = sub4;
        this.sub5 = sub5;

        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.m5 = m5;

    }
    public void total()
    {
        System.out.println("Marks in "+sub1+ " are "+m1);
        System.out.println("Marks in "+sub2+ " are "+m2);
        System.out.println("Marks in "+sub3+ " are "+m3);
        System.out.println("Marks in "+sub4+ " are "+m4);
        System.out.println("Marks in "+sub5+ " are "+m5);
    }
    public int percentage()
    {
        int per =(m1+m2+m3+m4+m5)/5;

        if(per<60)
        {
            System.out.println("F Grade");
        }
        else if(60<=per && per<70)
        {
            System.out.println("D Grade ");
        }
        else if(70<=per && per<80)
        {
            System.out.println("C Grade");
        }
        else if(80<=per && per<90)
        {
            System.out.println("B Grade");
        }
        else if(90<=per && per<=100)
        {
            System.out.println("A Grade");
        }
        return per;
    }

}
public class Student_Grade
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter subject 1 name");
        String sub1 = in.nextLine();

        System.out.println("Enter marks in sub1");
        int m1 = in.nextInt();

        System.out.println("Enter subject 2 name");
        in.nextLine();
        String sub2 = in.nextLine();
        

        System.out.println("Enter marks in sub2");
        int m2 = in.nextInt();

        System.out.println("Enter subject 3 name");
        in.nextLine();
        String sub3 = in.nextLine();

        System.out.println("Enter marks in sub3");
        int m3 = in.nextInt();

        System.out.println("Enter subject 4 name");
        in.nextLine();
        String sub4 = in.nextLine();

        System.out.println("Enter marks in sub4 ");
        int m4 = in.nextInt();

        System.out.println("Enter subject 5 name");
        in.nextLine();
        String sub5 = in.nextLine();

        System.out.println("Enter marks in sub5");
        int m5 = in.nextInt();


        Grades obj = new Grades(sub1, sub2, sub3 , sub4, sub5, m1, m2, m3, m4, m5);

        obj.total();

        System.out.println("The overall percentage is "+obj.percentage());
    
        in.close();

        
    }
}