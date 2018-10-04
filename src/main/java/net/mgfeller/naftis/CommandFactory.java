package net.mgfeller.naftis;

import org.springframework.stereotype.Service;


@Service
public class CommandFactory {

    public Command create(final CommandInput commandInput) {
        switch (commandInput.getCommand()) {
            case echo:
                return new EchoCommand(commandInput);
            case egress_http:
                return new EgressCommand(commandInput, false);
            case egress_https:
                return new EgressCommand(commandInput, true);
            default:
                throw new InvalidCommandException(String.format("The command '%s' is invalid.", commandInput.getCommand()));
        }
    }
}
