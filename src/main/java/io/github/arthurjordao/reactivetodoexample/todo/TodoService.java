package io.github.arthurjordao.reactivetodoexample.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TodoService {
    private TodoRepository repository;

    @Autowired
    public void setRepository(TodoRepository repository) {
        this.repository = repository;
    }

    public Mono<Todo> findById(String id) {
        return repository.findById(id).map(TodoEntity::toModel);
    }

    public Flux<Todo> findAll() {
        return repository.findAll().map(TodoEntity::toModel);
    }

    public Mono<Todo> create(Todo todo) {
        todo.setId(null);
        return repository.save(todo.toEntity()).map(TodoEntity::toModel);
    }

    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

    public Mono<Todo> toggleTodo(Todo todo, String id) {
        return repository.findById(id)
                .map(saved -> new Todo(saved.getId().toString(), saved.getContent(), todo.isDone()))
                .flatMap(model -> repository.save(model.toEntity()).map(TodoEntity::toModel));
    }
}
