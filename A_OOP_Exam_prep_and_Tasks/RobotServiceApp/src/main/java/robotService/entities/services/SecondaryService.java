package robotService.entities.services;

public class SecondaryService extends BaseService{

    //Has 15 capacity.
    //The constructor should take the following values upon initialization:
    //(String name
    private static final int DEFAUL_CAPACITY_SECONDARY_SERVISE=15;

    public SecondaryService(String name) {
        super(name, DEFAUL_CAPACITY_SECONDARY_SERVISE);
    }
}
