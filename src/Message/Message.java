package Message;

public abstract class Message {
    public abstract String getMessageType();

    protected String getMessageText() { return getMessageType(); }

    @Override
    public String toString() {
        return String.format("%s %s", this.getClass().getSimpleName(), getMessageText());
    }
}
