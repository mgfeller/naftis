package net.mgfeller.naftis;

import java.util.Map;

public class CommandInput {
    private String externalId;
    private CommandName command;
    private String message;
    private Map<String, String> parameters;
    private String sender;

    public CommandInput(String externalId, CommandName command, String message, Map<String, String> parameters, String sender) {
        this.externalId = externalId;
        this.command = command;
        this.message = message;
        this.parameters = parameters;
        this.sender = sender;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public CommandName getCommand() {
        return command;
    }

    public void setCommand(CommandName command) {
        this.command = command;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "CommandInput{" +
                "externalId='" + externalId + '\'' +
                ", command='" + command + '\'' +
                ", message='" + message + '\'' +
                ", parameters=" + parameters +
                ", sender='" + sender + '\'' +
                '}';
    }
}
