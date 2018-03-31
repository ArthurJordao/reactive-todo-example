package io.github.arthurjordao.reactivetodoexample.todo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

interface TodoRepository extends ReactiveMongoRepository<TodoEntity, String> { }
