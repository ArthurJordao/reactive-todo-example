package io.github.arthurjordao.reactivetodoexample;

/**
 * Interface to map a model to its entity class
 * @param <T> The entity class
 */
public interface ConvertibleToEntity<T> {
    T toEntity();
}
