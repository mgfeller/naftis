package net.mgfeller.naftis;

public interface Command {

    String getId();

    CommandResult getCommandResult();

    CommandResult execute();

}
