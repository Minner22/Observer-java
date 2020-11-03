package listeners;

import java.util.LinkedHashMap;
import java.util.Map;

public class AlertManager implements EventListener {

    private int loginCounter;
    private final String adminContact;
    private final LinkedHashMap<Integer, String> last5 = new LinkedHashMap<>() {
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
            return this.size() > 5;
        }
    };



    public AlertManager(String email) {
        this.adminContact = email;
    }


    @Override
    public void update(String eventType, String username) {
        if (eventType.equals("login")) {
            loginCounter++;
            if (checkLast5(username)) {
                System.out.println("ACHTUNG!!!\n" + username + " behaviour is suspicious");
                System.out.println("notifying Administrator: " + adminContact);
            } else {
                last5.put(loginCounter, username);
            }
        }
    }

    private boolean checkLast5(String username) {
        if (last5.size() < 5) {
            return false;
        }
        for (String s : last5.values()) {
            if (!s.equals(username)) {
                return false;
            }
        }
        return true;
    }
}
