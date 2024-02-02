// UserData class representing a user
public class UserData {
    private String accountid;
    private String name;
    private String password;
    private String email;
    private String number;
    private String accountType;
    private String initialBalance;

    public UserData(String accountid, String name, String password, String email, String number, String accountType,String initialBalance) {
        this.accountid = accountid;
        this.name = name;
        this.password = password;
        this.email = email;
        this.number = number;
        this.accountType = accountType;
        this.initialBalance = initialBalance;
    }
    public void setID(String id){
        this.accountid = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPassword(String newPassword){
        this.password = newPassword;
    }
    public void setEmail(String newEmail){
        this.email = newEmail;
    }
    public void setNumber(String newNumber){
        this.number = newNumber;
    }
    public void setBalance(String newBalance){
        this.initialBalance = newBalance;
    }
    public String getID() {
        return accountid;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public String getAccountType() {
        return accountType;
    }
    public String getInitialBalance() {
        return initialBalance;
    }
}
