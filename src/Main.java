import computer.Computer;
import listeners.AlertManager;
import listeners.LogCreator;

public class Main {

    public static void main(String[] args) {

        Computer computer = new Computer();
        computer.eventManager.subscribe(new LogCreator("logs.log"));
        computer.eventManager.subscribe(new AlertManager("admin@ibm.com"));

        computer.login("testLog");
        computer.login("testAlert");
        computer.login("testAlert");
        computer.login("testAlert");
        computer.login("testAlert");
        computer.login("testAlert");
        computer.login("testAlert");
        computer.login("testAlert2");
        computer.logoff("testLog");
    }
}
