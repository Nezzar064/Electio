package com.msn.codeexam.service.interfaces;

import java.util.List;

public interface ReadService<T, Id> {

    List<T> findAll();

    T findById(Id id);
}
