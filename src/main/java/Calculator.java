import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        String[] inputData = calc.readInput();
        System.out.println("Результат выполнения операции - " + calc.calculate(inputData[0], inputData[1], inputData[2]));
    }

    public String calculate (String inputData1, String inputData2, String inputData3) throws Exception {
        Context context = new Context();
        if (inputData2.equals("+")) {
            context.setStrategy(new ConcreteStrategyAdd());
        } else if (inputData2.equals("-")) {
            context.setStrategy(new ConcreteStrategySubtract());
        } else if (inputData2.equals("*")) {
            context.setStrategy(new ConcreteStrategyMultiply());
        } else if (inputData2.equals("/") || inputData2.equals(":")) {
            context.setStrategy(new ConcreteStrategyDivide());
        } else {
            throw new Exception("Неизвестная операция");
        }
        return context.executeStrategy(inputData1, inputData3);
    }

    public String[] readInput() {
        System.out.println("Введите число1, оператор и число2 через пробел");
        String[] temp = new String[3];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            temp[i] = sc.nextLine();
        }
        return temp;
    }
}
