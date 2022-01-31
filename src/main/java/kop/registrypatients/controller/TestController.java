package kop.registrypatients.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kop.registrypatients.entity.Test;
import kop.registrypatients.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/secret/test")
@Hidden
@Tag(name = "Секретный контролер Тест", description = "Позволяет работать с Тестами напрямую через entity")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping
    @Operation(summary = "Постраничный вывод справочника Тестов")
    public ResponseEntity<List<Test>> readAll(@PageableDefault Pageable pageable) {
        Page<Test> pages = testService.readAll(pageable);
        return ResponseEntity.ok().body(pages.getContent());
    }

    @GetMapping("{id}")
    @Operation(summary = "Позволяет получить Тест по ID")
    public Test readOne(@Validated @PathVariable("id") Integer id) {
        return testService.readOne(id);
    }

    @PutMapping("{id}")
    @Operation(summary = "Позволяет обновить данные о Тесте по ID")
    public Test update(@PathVariable("id") Integer id, @RequestBody Test test) {
        return testService.update(test, id);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Позволяет удалить Тест по Id")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Integer id) {
        final boolean deleted = testService.deleteById(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.NOT_MODIFIED)
                : new ResponseEntity<>(HttpStatus.OK);
    }
}