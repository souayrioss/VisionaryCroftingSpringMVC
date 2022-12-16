package org.souayrioss.visionarycroftingspringmvc.service;


import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IService<T> {
    T save(T t);
    Page<T> getAll(String keyword, Pageable pageable);
    T getOne(String ref);


}
