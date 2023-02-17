
import java.util.HashMap;

public class IDPasswords {

    HashMap<String,String> loginInfo = new HashMap<String, String>();
    HashMap<String,String> accountInfo = new HashMap<String, String>();


    IDPasswords(){
        loginInfo.put("JohnGomes","password");
        accountInfo.put("johngomes@gmail.com","password");

    }

    protected HashMap getLoginInfo(){
        return loginInfo;
    }
    protected HashMap getAccountInfo(){
        return accountInfo;
    }

}
