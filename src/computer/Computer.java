package computer;

import publisher.EventManager;

public class Computer {

    public EventManager eventManager;

    public Computer() {
        this.eventManager = new EventManager();
    }

    public void login(String username) {
        System.out.println(username + " has logged in");
        eventManager.notify("login", username);
    }

    public void logoff(String username) {
        System.out.println(username + " has logged off");
        eventManager.notify("logoff", username);
    }
}
