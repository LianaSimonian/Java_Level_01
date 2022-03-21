package com.aca.exam.exam2;

import java.util.List;

public interface CrudRepository<ENTITY, ID> {
    ENTITY findById(ID id);

    List<ENTITY> findAll();
}
