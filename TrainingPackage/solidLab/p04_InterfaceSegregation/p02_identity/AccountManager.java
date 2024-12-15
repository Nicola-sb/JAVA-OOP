package TrainingPackage.solidLab.p04_InterfaceSegregation.p02_identity;

import TrainingPackage.solidLab.p04_InterfaceSegregation.p02_identity.interfaces.Account;
import TrainingPackage.solidLab.p04_InterfaceSegregation.p02_identity.interfaces.RegistrationRestriction;


public class AccountManager implements Account, RegistrationRestriction {
    private boolean requireUniqueEmail;

    private int minRequiredPasswordLength;

    private int maxRequiredPasswordLength;


    @Override
    public boolean getRequireUniqueEmail() {
        return this.requireUniqueEmail;
    }

    @Override
    public int getMinRequiredPasswordLength() {
        return this.minRequiredPasswordLength;
    }

    @Override
    public int getMaxRequiredPasswordLength() {
        return this.maxRequiredPasswordLength;
    }

    @Override
    public void register(String username, String password) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void login(String username, String password) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changePassword(String oldPass, String newPass) {
        //change password
    }

}
