package net.mgfeller.naftis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Service
public class CommandService {

    private final ConcurrentMap<String, Command> commands = new ConcurrentHashMap<>();

    @Value("${naftis.command.store}")
    private boolean storeCommand;

    private final CommandFactory commandFactory;

    @Autowired
    public CommandService(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
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
        Command command = commandFactory.create(commandInput);
        if (storeCommand) {
            commands.put(command.getId(), command);
        }
        command.execute();
        return command.getCommandResult();
    }
}
