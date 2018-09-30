package net.mgfeller.naftis;

public class CommandResult {

    private final CommandInput commandInput;
    private final String id;
    private final CommandStatus status;

    public CommandResult(CommandInput commandInput, String id, CommandStatus status) {
        this.commandInput = commandInput;
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public CommandStatus getStatus() {
        return status;
    }

    public CommandInput getCommandInput() {
        return commandInput;
    }
}
