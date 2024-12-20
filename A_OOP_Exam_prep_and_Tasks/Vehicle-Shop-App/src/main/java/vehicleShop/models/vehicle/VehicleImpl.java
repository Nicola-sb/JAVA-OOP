package vehicleShop.models.vehicle;

import vehicleShop.common.ExceptionMessages;

public class VehicleImpl implements Vehicle{


    private String name;

    private int strengthRequired;

    public VehicleImpl(String name, int strengthRequired) {
        this.setName(name);
        this.setStrengthRequired(strengthRequired);
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.VEHICLE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setStrengthRequired(int strengthRequired) {
        if(strengthRequired < 0){
            throw new IllegalArgumentException(ExceptionMessages.VEHICLE_STRENGTH_LESS_THAN_ZERO);
        }
        this.strengthRequired = strengthRequired;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStrengthRequired() {
        return strengthRequired;
    }

    @Override
    public boolean reached() {
        //The reached() method returns true if the strengthRequired reaches 0.
        return strengthRequired==0;
    }

    @Override
    public void making() {
//The making() decreases the required strength of the vehicle by 5 units.
//•	A vehicle's required strength should not drop below 0.
//o	If the strength becomes less than 0, set it to 0.
        setStrengthRequired(Math.max(0,getStrengthRequired() -  5 ));
    }
}
