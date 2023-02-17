public class Main {
    public static void main(String[] args) {

        IDPasswords idandpass = new IDPasswords();

        IDPasswords passRecover = new IDPasswords();

        SignIn loginPage = new SignIn(idandpass.getLoginInfo());

        SignIn passwordRecovery = new SignIn(passRecover.getAccountInfo());

    }

}