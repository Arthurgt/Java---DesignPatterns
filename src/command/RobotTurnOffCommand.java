package command;

public class RobotTurnOffCommand implements Command {
    private Robot robot;

    public RobotTurnOffCommand(Robot robot) {
        this.robot = robot;
    }

    public void execute() {
        robot.turnOff();
    }
}
