import java.util.Scanner;
import java.util.Random;
public class Password
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        Random r = new Random();

        System.out.println("Enter the length of the password");
        int length = in.nextInt();

        System.out.println("Answer following questions with true or false");

        System.out.println("Numbers?");
        boolean innum = in.nextBoolean();

        System.out.println("Uppercase?");
        boolean upper = in.nextBoolean();

        System.out.println("Lowercase");
        boolean lower = in.nextBoolean();

        System.out.println("Special character?");
        boolean special = in.nextBoolean();

        String numbers = "0123456789";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = "abcdefghijklmnopqrstuvxyz";
        String specialChar = "!@#$%^&*()_+";

        StringBuilder pool = new StringBuilder();

        if(innum)
        {
            pool.append(numbers);
        }
        if(upper)
        {
            pool.append(upperCase);
        }
        if(lower)
        {
            pool.append(lowerCase);
        }
        if(special)
        {
            pool.append(specialChar);
        }

        if(pool.length()==0)
        {
            System.out.println("Choose at least one set of characters");
            return;
        }

        StringBuilder password = new StringBuilder(length);

        for(int i =0; i<length; i++)
        {
            int pos = r.nextInt(pool.length());
            password.append(pool.charAt(pos));
        }

        System.out.println("Password is "+ password.toString());

        in.close();
        
    }

}