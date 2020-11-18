package model;

import java.util.ArrayList;

public class AdminManager {
    private static AdminManager instance;
    private Admin admin;

    private AdminManager(){

    }

    public static AdminManager getInstance() {
        if (instance == null) {
            instance = new AdminManager();
        }
        return instance;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
