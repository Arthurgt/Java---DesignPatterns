package command;

public class RobotCutCommand implements Command {
    private Robot robot;

    public RobotCutCommand(Robot robot) {
        this.robot = robot;
    }

    public void execute() {
        robot.cut();
    }
}
