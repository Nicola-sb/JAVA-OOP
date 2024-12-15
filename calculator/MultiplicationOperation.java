package calculator;

import java.util.ArrayList;
import java.util.List;

public class MultiplicationOperation implements Operation {
    private List<Integer> operands;
    private int result;

    //Как изглеждат една операция --> имат  operands --> те са сътоветне ляв и десен и имат резултат

    //Когато добавим операнд започваме да си събираме числа.Когато имаме 2 числа можем да си направим умножение -->
    //такаче казваме,че операцията е приключила(ред 23)

    public MultiplicationOperation(){
        this.operands = new ArrayList<>();
    }

    @Override
    public void addOperand(int operand) {
        this.operands.add(operand);

        if (this.isCompleted()) {
            this.result = this.operands.get(0) * this.operands.get(1);
        }
    }

    @Override
    public boolean isCompleted() {
        return this.operands.size() == 2;
    }

    @Override
    public int getResult() {
        return this.result;
    }
}
