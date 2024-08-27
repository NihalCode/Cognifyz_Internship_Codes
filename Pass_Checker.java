import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Checker
{
    String input;
    public Checker(String input)
    {
        this.input = input;
    }

    String numbers = "0123456789";
    String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerCase = "abcdefghijklmnopqrstuvxyz";
    String specialChar = "!@#$%^&*()_+";

    public boolean any(String str, String chars)
    {
        char[] carr = chars.toCharArray();
        for(int i=0; i<carr.length; i++)
        {
            char c = carr[i];
            if(str.indexOf(c)>=0)
            {
                return true;
            }
        }
        return false;
    }

    public List<Integer> contain()
    {
        List<Integer> result = new ArrayList<>();
        if(any(input,lowerCase))
        {
            result.add(0);
        }
        if(any(input,upperCase))
        {
            result.add(1);
        }
        if(any(input,numbers))
        {
            result.add(2);
        }
        if(any(input,specialChar))
        {
            result.add(3);
        }
        if(result.size()==1&&input.length()<5)
        {
            System.out.println("Password is weak");
        }
        if(result.size()==2&&input.length()>5&&input.length()<8)
        {
            System.out.println("Password is moderately strong");
        }
        if(result.size()==3&&input.length()>=8&&input.length()<11)
        {
            System.out.println("Password is Strong");
        }
        if(result.size()==3&&input.length()<8)
        {
            System.out.println("Password is moderately strong, try increasing length of password");
        }
        if(result.size()==4&&input.length()>=11)
        {
            System.out.println("Password is very Strong");
        }
        if(result.size()==1&&input.length()>5)
        {
            System.out.println("Passworrd is weak because it contains only one type of character");
        }
        if(result.size()==2&&input.length()>8)
        {
            System.out.println("Password is moderately strong, add more types of characters");
        }
        if(result.size()==3&&input.length()>11)
        {
            System.out.println("Password is Strong, try adding one more type of character");
        }
        if(result.size()==4&&input.length()>8&&input.length()<11)
        {
            System.out.println("Password is very Strong,try increasing length of password");
        }
        if(input.length()<=5)
        {
            System.out.println("Password is weak because it is too small");
        }

        return result;
    }
}
public class Pass_Checker
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        while(true)
        {
            System.out.println("1.Check password 2.Exit");
            int op = in.nextInt();
            in.nextLine();

            switch(op)
            {
                case 1:
                System.out.println("Enter your password");
                String input = in.nextLine();

                Checker obj = new Checker(input);

                obj.contain();
                break;

                case 2:
                in.close();
                System.exit(0);

                default:
                System.out.println("Invalid token");
                break;
            }
        }
    }
}