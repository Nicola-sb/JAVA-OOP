package calculator;

public class CalculationEngine {
    private int result;
    private Operation currentOperation;

    //В CalculationEngine вече имаме текуща операция(currentOperation)  * / + или пък null

    public CalculationEngine(){
        this.result = 0;
        this.currentOperation = null;
    }

    //В зависимост от това дали ни дават число(public void pushNumber(int number) или ни дават операция
    // void pushOperation(Operation operation)  си правим проверка

   public void pushNumber(int number) {
        //Ако ни дават число,гледаме дали имаме текуща оперцаия -->
       //Текущата операцяи значи. Пример: ако имаме 4 * ... --> ние чакаме вторият елемент да дойде за да можем да го добавим
       //да видим дали е приключила нашата операция(currentOperation.isCompleted()) и да си извършим сметката
        if (this.currentOperation != null) {
            currentOperation.addOperand(number);

            if (currentOperation.isCompleted()) {
                this.result = currentOperation.getResult();
                this.currentOperation = null;
            }
        } else {
            this.result = number;
        }
    }

    void pushOperation(Operation operation) {
//        if(operation == null){
//            return;
//        }

        //Ако имаме операция я сетваме да бъде нашата новата текуща операция--> ред 42  this.currentOperation = operation;

        if (operation.isCompleted()) {
            this.pushNumber(operation.getResult());
        } else {
            this.currentOperation = operation;
            this.pushNumber(this.result);
        }
    }

    int getCurrentResult() {
        return this.result;
    }
}
