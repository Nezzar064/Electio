package com.msn.codeexam.service.interfaces;

import java.util.List;
import java.util.Optional;

public interface CrudService <T, Id> {

    Optional<List<T>> findAll();

    T findById(Id id);

    T save(T object);

    T edit(T object, Id id);

    void delete(Id id);
}
