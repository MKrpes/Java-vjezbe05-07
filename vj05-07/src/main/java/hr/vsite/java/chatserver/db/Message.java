package hr.vsite.java.chatserver.db;

import jakarta.persistence.*;

@Entity(name="message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String message;
    @ManyToOne
    @JoinColumn(name = "userName", referencedColumnName = "userName")
    private User user;
    @ManyToOne
    @JoinColumn(name = "groupName", referencedColumnName = "groupName")
    private Group group;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        this.group = group;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", user=" + user +
                ", group=" + group +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id;
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
