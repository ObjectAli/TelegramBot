
public enum Commands {

    START("/start"),
    COMMANDS_LIST("/commands"),
    UNKNOWN("Unknown command");
    private final String command;

    Commands(String command){
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static Commands fromValue(String value) {
        for (final Commands command : values()) {
            if (command.command.equalsIgnoreCase(value)) {
                return command;
            }
        }
        return UNKNOWN;
    }

    public static String print(){
        return "[/start, /commands]";
    }
}
