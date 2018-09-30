package net.mgfeller.naftis;

public class CommandResult {

    private final CommandInput commandInput;
    private final String id;
    private CommandStatus status;
    private String commandOutput;

    public CommandResult(CommandInput commandInput, String id) {
        this.commandInput = commandInput;
        this.id = id;
        status = CommandStatus.SUBMITTED;
    }

    public String getCommandOutput() {
        return commandOutput;
    }

    public void setCommandOutput(String commandOutput) {
        this.commandOutput = commandOutput;
    }

    public String getId() {
        return id;
    }

    public CommandStatus getStatus() {
        return status;
    }

    public void setStatus(CommandStatus status) {
        this.status = status;
    }

    public CommandInput getCommandInput() {
        return commandInput;
    }
}
