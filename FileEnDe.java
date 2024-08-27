import java.io.*;
import java.util.Scanner;

class File
{
    public final int SHIFT =3;

    public void encrypt(String input, String output) throws IOException
    {
        process(input,output,SHIFT);
    }
    public void decrypt(String input, String output) throws IOException
    {
        process(input,output,-SHIFT);
    }

    public void process(String input, String output, int SHIFT) throws IOException
    {   
        try(BufferedReader r = new BufferedReader(new FileReader(input));
            BufferedWriter w = new BufferedWriter(new FileWriter(output)))
        {
            String line;
            while((line = r.readLine())!=null)
            {
                String pro = Text(line, SHIFT);
                w.write(pro);
                w.newLine();
            }
        }
    }

    public String Text(String text, int SHIFT)
    {
        StringBuilder b = new StringBuilder();
        char[] c = text.toCharArray();
        for(int i =0; i<c.length; i++)
        {
            char index = c[i];
            if(Character.isLetter(index))
            {
                char base;
                if(Character.isUpperCase(index))
                {
                    base = 'A';
                }
                else
                {
                    base = 'a';
                }
                b.append((char)((index - base + SHIFT + 26) % 26 + base));
            }
            else if(Character.isDigit(index))
            {
                b.append((char)((index - '0' + SHIFT + 10) % 10 + '0'));
            }
            else if(index >= ' ' && index <= '~')// Printable ASCII range 32-126, 95 values
            {// ' ' ASCII code is 32, ~ code is 126
                b.append((char)((index - ' ' + SHIFT + 95) % 95 + ' '));
                System.out.println("Original: " + index + " ASCII: " + (int)index);
            }
            else
            {
                b.append(index);
            }
        }
        return b.toString();
    }
    
}
public class FileEnDe
{
    

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        File obj = new File();
        System.out.println("Enter the file path:");
        String Path = in.nextLine();

        // Prompt user for output file path
        System.out.println("Enter the output file path:");
        String outPath = in.nextLine();

       
        System.out.println("1.Encrypt 2.Decrypt 3.Exit");
        int op = in.nextInt();
            
        try
        {
            if(op==1)
            {
                obj.encrypt(Path,outPath);
                System.out.println("file encrypted succesfully");
            }
            else if(op==2)
            {
                obj.decrypt(Path,outPath);
                System.out.println("file decrypted succesfully");
            }
            else
            {
                System.out.println("Invalid choice");
            } 
        }
        catch(IOException e)
        {
            System.out.println("Error "+e.getMessage());
        }
        finally
        {
            in.close();
        }
            
    }
}
