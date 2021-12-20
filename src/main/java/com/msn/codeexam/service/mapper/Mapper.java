package com.msn.codeexam.service.mapper;

import java.util.List;

public interface Mapper <S, T> {

    T mapToEntity(S dto);

    S mapToDto(T entity);

    List<T> mapDtoListToEntityList(List<S> dtoList);

    List<S> mapEntityListToDtoList(List<T> entityList);
}
