public class CalculatorController {
    private CalculatorView view;
    private Operation operation;
    private Logger logger;

    public CalculatorController(CalculatorView view, Logger logger) {
        this.view = view;
        this.logger = logger;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void calculate(double a, double b) {
        if (operation != null) {
            try {
                double result = operation.execute(a, b);
                view.displayResult(result);
                logger.log("Performed " + operation.getClass().getSimpleName() + " with result: " + result);
            } catch (Exception e) {
                view.displayError(e.getMessage());
                logger.log("Error: " + e.getMessage());
            }
        }
    }
}