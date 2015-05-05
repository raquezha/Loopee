package net.nueca.jn.loopee.controllers;


public class SessionManager {

    public String account_id;
    public String email;
    public String password;


    private static SessionManager instance = new SessionManager();

    private SessionManager() { }

    // This method should be called first to do singleton initialization
    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }


}
