public class CalculatorModel {

    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        Logger logger = new Logger();
        CalculatorController controller = new CalculatorController(view, logger);

        while (true) {

            int choice = view.getUserChoice();
            if (choice == 2) {
                logger.log("Exit");
                break;
            }
            if (choice != 1) {
                view.displayError("Такой опции нет");
                logger.log("Error: Была выбрана несуществующая опция");
                break;
            }
            double a = view.getNumber();
            double b = view.getNumber();
            char operation = view.getOperation();

            switch (operation) {
                case '+':
                    controller.setOperation(new Addition());
                    break;
                case '*':
                    controller.setOperation(new Multiplication());
                    break;
                case '/':
                    controller.setOperation(new Division());
                    break;
                default:
                    view.displayError("Некорректная операция");
                    logger.log("Error: Некорректная операция");
                    return;
            }
            controller.calculate(a, b);
        }

    }
}
