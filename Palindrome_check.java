import java.util.Scanner;
class Palindrome
{
    String input;
    public Palindrome(String input)
    {
        this.input = input;
    }

    public boolean check(String input)
    {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int length = clean.length();

        for(int i = 0; i<length/2; i++)
        {
            if(clean.charAt(i)!=clean.charAt(length-i-1))
            {
                return false;
            }
        }
        return true;
    }
}
public class Palindrome_check
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);

        while(true)
        {
            System.out.println("1.check palindrome 2.exit");
            int op = in.nextInt();
            in.nextLine();
            switch(op)
            {
                case 1:
                System.out.println("Enter the word to check");
                String word = in.nextLine();

                Palindrome obj = new Palindrome(word);
                System.out.println(obj.check(word));
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