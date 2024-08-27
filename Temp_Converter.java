import java.util.Scanner;
class Temperature
{
    double value;
    String unit;

    public Temperature(double value, String unit)
    {
        this.value= value;
        this.unit = unit;
    }

    public double convert(double value, String unit)
    {
        if(unit.equals("C"))
        {
            double result = (value*1.8)+32;
            return result;
        }
        else if(unit.equals("F"))
        {
            double result = (value-32)/1.8;
            return result;
        }
        else
        {
            return 0.00;
        }
    } 
}
public class Temp_Converter
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);

        while(true)
        {
            System.out.println("1.conversion 2.Exit ");
            int op = in.nextInt();

            switch(op)
            {
                case 1:
                System.out.println("Enter the temperature value");
                double temp = in.nextDouble();

                in.nextLine();

                System.out.println("Enter the unit, C or F");
                String unit = in.nextLine();

                Temperature obj = new Temperature(temp, unit);
                
                if(unit.equals("C"))
                    {
                        System.out.println(obj.convert(temp,unit)+" fahrenheit");
                    }
                else if(unit.equals("F"))
                    {
                        System.out.println(obj.convert(temp,unit)+" celsius");
                    }
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