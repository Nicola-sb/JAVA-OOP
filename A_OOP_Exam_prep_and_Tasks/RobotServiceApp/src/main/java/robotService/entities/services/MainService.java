package robotService.entities.services;

public class MainService extends BaseService{


    private static final int DEFAULT_CAPACITY_MAIN_SERVICE=15;

    public MainService(String name) {
        super(name, DEFAULT_CAPACITY_MAIN_SERVICE);
    }
}
