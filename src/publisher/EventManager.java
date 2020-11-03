package publisher;

import listeners.EventListener;

import java.util.HashSet;
import java.util.Set;

public class EventManager {
    Set<EventListener> listeners = new HashSet<>();

    public void subscribe(EventListener listener) {
        listeners.add(listener);
    }

    public void unsubscribe(EventListener listener) {
        listeners.remove(listener);
    }

    public void notify(String eventType, String username) {
        for (EventListener listener : listeners) {
            listener.update(eventType, username);
        }
    }
}
