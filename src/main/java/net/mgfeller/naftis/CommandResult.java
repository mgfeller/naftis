package net.mgfeller.naftis;

import java.time.Duration;
import java.time.ZonedDateTime;

public class CommandResult {

    private final CommandInput commandInput;
    private final String id;
    private CommandStatus status;
    private String commandOutput;
    private ZonedDateTime commandCreatedAt = ZonedDateTime.now();
    private ZonedDateTime commandFinishedAt;

    public CommandResult(CommandInput commandInput, String id) {
        this.commandInput = commandInput;
        this.id = id;
        status = CommandStatus.SUBMITTED;
    }

    public String getCommandCreatedAt() {
        return commandCreatedAt.toString();
    }

    public String getCommandFinishedAt() {
        return commandFinishedAt.toString();
    }

    public void setCommandFinishedAtNow() {
        commandFinishedAt = ZonedDateTime.now();
    }

    public String getCommandDuration() {
        return Duration.between(commandCreatedAt, commandFinishedAt).toString();
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
