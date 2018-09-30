package net.mgfeller.naftis;

import java.util.UUID;

public class Command {
    private final CommandInput commandInput;
    private final String id;

    public Command(final CommandInput commandInput) {
        this.commandInput = commandInput;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public CommandInput getCommandInput() {
        return commandInput;
    }

    public CommandResult getCommandResult() {
        return new CommandResult(commandInput, id, CommandStatus.FINISHED);
    }
}
