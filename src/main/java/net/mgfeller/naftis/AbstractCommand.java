package net.mgfeller.naftis;

import java.util.UUID;

public abstract class AbstractCommand implements Command {
    final CommandInput commandInput;
    private final String id;
    private final CommandResult commandResult;

    public AbstractCommand(final CommandInput commandInput) {
        this.commandInput = commandInput;
        id = UUID.randomUUID().toString();
        commandResult = new CommandResult(commandInput, id);
    }

    @Override
    public final String getId() {
        return id;
    }

    @Override
    public final CommandResult getCommandResult() {
        return commandResult;
    }

    @Override
    public final CommandResult execute() {
        String output = run();
        commandResult.setStatus(CommandStatus.COMPLETED);
        commandResult.setCommandOutput(output);
        return commandResult;
    }

    protected abstract String run();
}
