package com.msn.codeexam.service.interfaces;

import java.util.List;
import java.util.Optional;

public interface ReadService<T, Id> {

    List<T> findAll();

    T findById(Id id);
}
