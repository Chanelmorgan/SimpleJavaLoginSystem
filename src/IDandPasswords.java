import java.util.HashMap;

public class IDandPasswords {

    // hashmap - stores key and value pairs

    private HashMap<String, String> loginInfo = new HashMap<>();

    public IDandPasswords(){
        loginInfo.put("Bro", "Pizza");
        loginInfo.put("Chanel", "PASSWORD");
        loginInfo.put("BroCode", "abc123");

    }

    protected HashMap<String, String> getLoginInfo() {
        return loginInfo;
    }

}
