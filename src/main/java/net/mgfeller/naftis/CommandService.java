package net.mgfeller.naftis;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Service
public class CommandService {

    private final ConcurrentMap<String, Command> commands;

    public CommandService() {
        commands = new ConcurrentHashMap<>();
    }

    public CommandResult getCommand(final String id) {
        if (!commands.containsKey(id)) {
            throw new CommandNotFoundException(String.format("Command with id '%s' not found.", id));
        }
        return commands.get(id).getCommandResult();
    }

    public Collection<CommandResult> getAllCommands() {
        return commands.values().stream().map(Command::getCommandResult).collect(Collectors.toList());
    }

    public CommandResult submitCommand(CommandInput commandInput) {
        Command command = new Command(commandInput);
        commands.put(command.getId(), command);
        return command.getCommandResult();
    }
}
