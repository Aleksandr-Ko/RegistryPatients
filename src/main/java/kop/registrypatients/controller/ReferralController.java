package kop.registrypatients.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kop.registrypatients.entity.Referral;
import kop.registrypatients.service.ReferralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/secret/referral")
@Hidden
@Tag(name = "Секретный контролер Направления", description = "Позволяет работать с Направлениями напрямую через entity")
public class ReferralController {

    @Autowired
    ReferralService referralService;

    @GetMapping
    @Operation(summary = "Постраничный вывод справочника Направлений")
    public ResponseEntity<List<Referral>> readAll(@PageableDefault Pageable pageable) {
        Page<Referral> pages = referralService.readAll(pageable);
        return ResponseEntity.ok().body(pages.getContent());
    }

    @GetMapping("{id}")
    @Operation(summary = "Позволяет получить Напрвление по ID")
    public Referral readOne(@PathVariable("id") Integer id) {
        return referralService.readOne(id);
    }

    @PostMapping
    @Operation(summary = "Регистрация нового Направления", description = "Позволяет зарегистрировать Направление")
    public ResponseEntity<Referral> create(@RequestBody Referral referral) {
        referralService.create(referral);
        return ResponseEntity.ok().body(referral);
    }
}