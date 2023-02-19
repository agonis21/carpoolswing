package entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userID;
    private String userName;
    private String userType; /*donor, renter, admin*/
    private List<String> userVehicles;

    public User() {
        this.userVehicles = new ArrayList<>();
    }

    public User(String userID, String userName, String userType, List<String> userVehicles) {
        this.userID = userID;
        this.userName = userName;
        this.userType = userType;
        this.userVehicles = userVehicles;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserType() {
        return this.userType;
    }

    public List<String> getUserVehicles(){
        return this.userVehicles;
    }
}
