package io.github.arthurjordao.reactivetodoexample.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("todos")
class TodoController {
    private TodoService service;

    @Autowired
    public void setService(TodoService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public Mono<Todo> findBydId(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @PostMapping
    public Mono<Todo> save(@RequestBody Todo todo) {
        return service.create(todo);
    }

    @PatchMapping("{id}")
    public Mono<Todo> toggleTodo(@RequestBody Todo todo, @PathVariable("id") String id) {
        return service.toggleTodo(todo, id);
    }

    @GetMapping
    public Flux<Todo> findAll() {
        return service.findAll();
    }

    @DeleteMapping("{id}")
    public Mono<Void> delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
