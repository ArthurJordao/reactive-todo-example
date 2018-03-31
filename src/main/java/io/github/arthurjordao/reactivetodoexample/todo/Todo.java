package io.github.arthurjordao.reactivetodoexample.todo;

import io.github.arthurjordao.reactivetodoexample.ConvertibleToEntity;
import org.bson.types.ObjectId;

public class Todo implements ConvertibleToEntity<TodoEntity> {
    private String id;
    private String content;
    private boolean done;


    public Todo() { }

    public Todo(String id, String content, boolean done) {
        this.id = id;
        this.content = content;
        this.done = done;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", done=" + done +
                '}';
    }

    @Override
    public TodoEntity toEntity() {
        if (id != null) {
            return new TodoEntity(new ObjectId(this.id), content, done);
        } else {
            return new TodoEntity(null, content, done);
        }
    }
}
