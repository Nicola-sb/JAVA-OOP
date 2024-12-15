package calculator;

public class InputInterpreter {
    private CalculationEngine engine;

    public InputInterpreter(CalculationEngine engine){
        this.engine = engine;
    }

    public boolean interpret(String input) {//Ние вкараваме или число или двигател в нашият Интерпретатор за сметки         Engine
        //В CalculationEngine е мястото,където се случва самата сметка

        //на public boolean interpret единствената му работа е да види дали имаме число или имаме операция и да види каква е операцията (getOperation)
        //Метод,който проверява дали имаме число или имаме операция
        //Ако имаме число (2) -- >> ще вкараме число
        try {
            engine.pushNumber(Integer.parseInt(input));
        }catch (Exception ex){
            //Ако имаме операцията --> * / умножаване/делене  --> ще вкараме операцията
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }
    public Operation getOperation(String operation) {
        //При getOperation си правим проверка каква точно е нашата операция
        if (operation.equals("*")) {
            return new MultiplicationOperation();
        }

        return null;
    }
}
