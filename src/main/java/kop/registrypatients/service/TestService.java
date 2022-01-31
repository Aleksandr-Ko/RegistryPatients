package kop.registrypatients.service;

import kop.registrypatients.entity.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TestService {

    Test create(Test test);

    Page<Test> readAll(Pageable pageable);

    Test readOne(Integer id);

    Test update(Test test, Integer id);

    boolean deleteById(Integer id);
}
