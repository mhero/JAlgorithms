package com.mac.algorithms.avl;

/**
 *
 * @author marco
 * @param <K>
 */
public interface BinarySearchTreeInterface<K> {

    void insert(K key);

    void delete(K key);

    boolean contains(K key);

    int size();

    boolean isEmpty();

}
