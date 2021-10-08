public class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public String executeStrategy(String a, String b) {
        return strategy.execute(a, b);
    }
}
