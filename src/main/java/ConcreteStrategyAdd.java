import java.math.BigDecimal;

public class ConcreteStrategyAdd implements Strategy {
    @Override
    public String execute(String a, String b) {
        try {
            return String.valueOf((Integer.parseInt(a) + Integer.parseInt(b)));
        } catch (NumberFormatException e) {
            return "Введено(ы) не число(а)";
        }
    }
}
