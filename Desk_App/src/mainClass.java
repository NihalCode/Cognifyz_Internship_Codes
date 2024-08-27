import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class mainClass extends Application {

    private TextField display;
    private double num1 = 0;
    private String operator = "";
    private boolean start = true;
    private boolean isDegree = true;

    @Override
    public void start(Stage primaryStage) {
        display = new TextField();
        display.setEditable(false);
        display.setPrefSize(200, 50);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        String[] buttonLabels = 
        {
            "7", "8", "9", "/", 
            "4", "5", "6", "*", 
            "1", "2", "3", "-", 
            "0", "C", "=", "+",
            "sin", "cos", "deg", "rad",
            "log", "ln", "√", "x²", 
            "^", "π", "e", "!"
        };

        int row = 1;
        int col = 0;
        for (String label : buttonLabels) {
            Button button = new Button(label);
            button.setPrefSize(50, 50);
            button.setOnAction(e -> handleButtonClick(label));
            grid.add(button, col, row);
            col++;
            if (col > 3) {
                col = 0;
                row++;
            }
        }

        grid.add(display, 0, 0, 4, 1);

        Scene scene = new Scene(grid, 230, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.show();
    }

    private void handleButtonClick(String label) {
        if (label.matches("[0-9]")) {
            if (start) {
                display.clear();
                start = false;
            }
            display.appendText(label);
        } else if (label.equals("C")) {
            display.clear();
            operator = "";
            start = true;
        } 
        else if (label.equals("=")) 
        {
            if (!operator.isEmpty()) 
            {
                double num2 = Double.parseDouble(display.getText());
                double result = calculate(num1, num2, operator);
                display.setText(String.valueOf(result));
                operator = "";
                start = true;
            }
        } 
        else if(label.equals("sin")|| label.equals("cos")|| label.equals("log") || label.equals("ln"))
        {
            double value = Double.parseDouble(display.getText());
            double result = calc_trig(value, label);
            display.setText(String.valueOf(result));
            start = true;
        }
        else if(label.equals("deg"))
        {
            isDegree = true;
        }
        else if(label.equals("rad"))
        {
            isDegree = false;
        }
        else if (label.equals("√")) 
        {
            double value = Double.parseDouble(display.getText());
            double result = Math.sqrt(value);
            display.setText(String.valueOf(result));
            start = true;
        } 
        else if (label.equals("x²")) 
        {
            double value = Double.parseDouble(display.getText());
            double result = Math.pow(value, 2);
            display.setText(String.valueOf(result));
            start = true;
        }
        else if (label.equals("^")) 
        {
            if (!operator.isEmpty()) 
            {
                return;
            }
            operator = "^";
            num1 = Double.parseDouble(display.getText());
            display.clear();
        }
        else if (label.equals("π")) 
        {
            display.setText(String.valueOf(Math.PI));
            start = true;
        } 
        else if (label.equals("e")) 
        {
            display.setText(String.valueOf(Math.E));
            start = true;
        } 
        else if (label.equals("!")) 
        {
            double value = Double.parseDouble(display.getText());
            double result = factorial(value);
            display.setText(String.valueOf(result));
            start = true;
        }
        else 
        {
            if (!operator.isEmpty()) 
            {
                return;
            }
            operator = label;
            num1 = Double.parseDouble(display.getText());
            display.clear();
        }
    }

    private double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": 
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    return 0; // handle division by zero
                }
            case "^": return Math.pow(num1, num2);
            default: return 0;
        }
    }

    private double calc_trig(double value, String operator)
    {
        double angle;
        if(isDegree)
        {
            angle = Math.toRadians(value);
        }
        else
        {
            angle =   value;
        }
        switch(operator)
        {
            case "sin":
            return Math.sin(angle);

            case "cos":
            return Math.cos(angle);

            case "log":
            return Math.log10(value);

            case "ln":
            return Math.log(value);

            default:
            return 0;


        }
    }

    private double factorial(double val)
    {
        if(val<0|| val!=Math.floor(val))
        {
            return Double.NaN;// undefined for negative numbers and non-integer values
        }
        double res =1;
        for(int i=1; i<= (int)val; i++)
        {
            res *=i;
        }
        return res;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
