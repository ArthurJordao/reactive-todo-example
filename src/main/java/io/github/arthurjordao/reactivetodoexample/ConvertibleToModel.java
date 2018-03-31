package io.github.arthurjordao.reactivetodoexample;

/**
 * Interface to map a entity to its model class
 * @param <T> The Model class
 */
public interface ConvertibleToModel<T> {
    T toModel();
}
