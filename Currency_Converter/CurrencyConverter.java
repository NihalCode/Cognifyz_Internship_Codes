import org.json.JSONObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyConverter 
{

    static Scanner in = new Scanner(System.in);

    private static final String API_KEY = "56574dc3de9298379f00d30e"; 
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static void main(String[] args) 
    {

        System.out.println("Do you want to make transaction (true/false)");// enter false if you just want to convert
        boolean response = in.nextBoolean();
        in.nextLine();
       
        try 
        {
            if(response == false)
            {

                System.out.println("Enter base currency ");
                String Base_cr = in.nextLine().trim();
                
                System.out.println("Enter target currency");
                String Target_cr = in.nextLine().trim();

                System.out.println("Enter amount");
                double amount = in.nextDouble();
                in.nextLine();

                double convertedAmount = convertCurrency(Base_cr, Target_cr, amount);
                System.out.println(amount + " " + Base_cr + " = " + convertedAmount + " " + Target_cr);
            }
            if(response == true)
            {
                System.out.println("Sell or Buy");
                String input = in.nextLine().trim();

                System.out.println("Enter base currency ");
                String Base_crp = in.nextLine().trim();
    
                System.out.println("Enter target currency");
                String Target_crp = in.nextLine().trim();
    
                System.out.println("Enter amount");
                double amountp = in.nextDouble();
                in.nextLine();

                double convertedAmount = convertCurrency(Base_crp, Target_crp, amountp);
                System.out.println(amountp + " " + Base_crp + " = " + convertedAmount + " " + Target_crp);
            
                double bsAmount = bsCurrency(Base_crp, Target_crp, amountp,input);
            
            if(input.equalsIgnoreCase("sell"))
            {
                System.out.println("Selling Amount: "+bsAmount);
            }
            else if(input.equalsIgnoreCase("buy"))
            {
                System.out.println("Buying Amount: "+bsAmount);
            }
            else
            {
                System.out.println("Invalid transaction type");
            }

            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

    }

    public static double convertCurrency(String Base_cr, String Target_cr, double amount) throws IOException, InterruptedException 
    {
        String urlString = BASE_URL + API_KEY + "/latest/" + Base_cr;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();

        JSONObject json = new JSONObject(responseBody);
        JSONObject conversionRates = json.getJSONObject("conversion_rates");
        double exchangeRate = conversionRates.getDouble(Target_cr);

        return amount * exchangeRate;
    }
    public static double bsCurrency(String Base_cr, String Target_cr, double amount, String input) throws IOException, InterruptedException 
    {
        String urlString = BASE_URL + API_KEY + "/latest/" + Base_cr;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();

        JSONObject json = new JSONObject(responseBody);
        JSONObject conversionRates = json.getJSONObject("conversion_rates");
        double exchangeRate = conversionRates.getDouble(Target_cr);

        // for small to medium transactions
        if(input.toLowerCase().equals("sell"))
        {
            return amount * (exchangeRate+(0.01*exchangeRate));

        }
        else if(input.toLowerCase().equals("buy"))
        {
            return amount * (exchangeRate-(0.01*exchangeRate));
        }
        else
        {
            throw new IllegalArgumentException("Invalid option "+input);
        }

    }
}
