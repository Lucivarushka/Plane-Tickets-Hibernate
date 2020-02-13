package com.ticketoffice.repository;

import java.io.IOException;
import java.util.List;

public interface GenericRepository<T, ID> {

    void create(T value) throws Exception;

    void update(T value) throws Exception;

    void delete(T value) throws Exception;

    List<T> getAll() throws Exception;

    T getId(ID id) throws Exception;
}
