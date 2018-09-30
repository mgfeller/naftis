package net.mgfeller.naftis;

import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import java.util.Collection;

@Component
@Path("/commands")
public class CommandController {

    private CommandService commandService;

    public CommandController(CommandService commandService) {
        this.commandService = commandService;
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    /**
     *  headers:
     *         Accept: application/json
     *         Content-Type: application/json
     *
     * {"externalId":1,"command":"ping","message":"hello","parameters":{"a":"1", "b":2},"sender":"me"}
     */
    public CommandResult submitCommand(CommandInput commandInput) {
        return commandService.submitCommand(commandInput);
    }

    @GET
    @Produces("application/json")
    public Collection<CommandResult> getAllCommands() {
        return commandService.getAllCommands();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public CommandResult getCommand(@PathParam("id") String id) {
        return commandService.getCommand(id);
    }
}
