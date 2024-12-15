package vehicleShop.models.tool;

import vehicleShop.common.ExceptionMessages;

public class ToolImpl implements Tool{

    private int power;

    public ToolImpl(int power) {
        this.setPower(power);
    }

    public void setPower(int power) {
        if(power < 0){
            throw new IllegalArgumentException(ExceptionMessages.TOOL_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }


    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void decreasesPower() {
        //The decreasesPower() method decreases the tool's power by 5.
        //•	A tool's power should not drop below 0. (If the power becomes less than 0, set it to 0).
        setPower(Math.max(0,getPower()-5));
    }

    @Override
    public boolean isUnfit() {
        return power==0;
    }
}
