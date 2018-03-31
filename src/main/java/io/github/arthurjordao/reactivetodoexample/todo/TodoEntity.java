package io.github.arthurjordao.reactivetodoexample.todo;

import io.github.arthurjordao.reactivetodoexample.ConvertibleToModel;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
class TodoEntity implements ConvertibleToModel<Todo> {
    @Id
    private ObjectId _id;
    private String content;
    private boolean done;

    TodoEntity() {    }

    TodoEntity(ObjectId id, String content, boolean done) {
        this._id = id;
        this.content = content;
        this.done = done;
    }

    ObjectId getId() {
        return _id;
    }

    void setId(ObjectId id) {
        this._id = id;
    }

    String getContent() {
        return content;
    }

    void setContent(String content) {
        this.content = content;
    }

    boolean isDone() {
        return done;
    }

    void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "TodoEntity{" +
                "_id=" + _id +
                ", content='" + content + '\'' +
                ", done=" + done +
                '}';
    }

    @Override
    public Todo toModel() {
        return new Todo(_id.toString(), content, done);
    }
}
