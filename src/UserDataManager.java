import java.util.ArrayList;
import java.util.List;

public class UserDataManager {

    private static List<UserData> userList = new ArrayList<>();

    public static List<UserData> getUserList() {
        return userList;
    }

    public static void addUser(UserData userData) {
        userList.add(userData);
    }
    public static void updateUser(List<UserData> userList2) {
        // Find the user in the list based on the account ID
        for (int i = 0; i < userList.size(); i++) {
            UserData currentUser = userList.get(i);
            if (currentUser.getID().equals(((UserData) userList2).getID())) {
                // Update the user data with the new information
                userList.set(i, (UserData) userList2);
                return;
            }
        }
    }
    
}
