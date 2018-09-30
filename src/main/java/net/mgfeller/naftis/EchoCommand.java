package net.mgfeller.naftis;

public class EchoCommand extends AbstractCommand {

    public EchoCommand(CommandInput commandInput) {
        super(commandInput);
    }

    @Override
    protected String run() {
        return commandInput.getMessage();
    }
}
