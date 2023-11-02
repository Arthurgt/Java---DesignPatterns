package command;

import java.util.ArrayList;
import java.util.List;

public class Workshop {

    private List<Command> commandQueue = new ArrayList<>();

    public void addCommandToQueue(Command command) {
        commandQueue.add(command);
    }

    public void run() {
        if(commandQueue.isEmpty()) {
            System.out.println("Command queue is empty");
        }
        for(Command command : commandQueue) {
            command.execute();
        }
        commandQueue.clear();
    }
}
