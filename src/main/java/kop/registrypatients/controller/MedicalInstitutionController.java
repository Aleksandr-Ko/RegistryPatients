package kop.registrypatients.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kop.registrypatients.entity.MedicalInstitution;
import kop.registrypatients.service.MedicalInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/secret/medical")
@Tag(name = "Медицинские учреждения", description = "Взаимодействие с Медицинскими учреждениями")
public class MedicalInstitutionController {

    @Autowired
    MedicalInstitutionService medicalInstitutionService;

    @GetMapping
    @Operation(summary = "Постраничный вывод справочника Медицинских учреждений")
    public ResponseEntity<List<MedicalInstitution>> readAll(@PageableDefault Pageable pageable) {
        Page<MedicalInstitution> pages = medicalInstitutionService.readAll(pageable);
        return ResponseEntity.ok().body(pages.getContent());
    }

    @GetMapping("{id}")
    public MedicalInstitution readOne(@PathVariable("id") Integer id) {
        return medicalInstitutionService.readOne(id);
    }

}