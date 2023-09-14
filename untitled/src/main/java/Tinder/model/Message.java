package Tinder.model;

public class Message {
    private String username;
    private int id;
    private int senderId;
    private int receiverId;
    private String content;

    public Message(int id, int senderId, int receiverId, String content) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
    }
    public Message(int id, int senderId, String username, String content) {
        this.id = id;
        this.senderId = senderId;
        this.username = username;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public int getSenderId() {
        return senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public String getContent() {
        return content;
    }
}
