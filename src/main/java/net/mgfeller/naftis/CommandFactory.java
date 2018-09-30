package net.mgfeller.naftis;

import org.springframework.stereotype.Service;


@Service
public class CommandFactory {

    public Command create(final CommandInput commandInput) {
        switch (commandInput.getCommand()) {
            case echo:
                return new EchoCommand(commandInput);
            default:
                throw new InvalidCommandException(String.format("The command '%s' is invalid.", commandInput.getCommand()));
        }
    }
}
