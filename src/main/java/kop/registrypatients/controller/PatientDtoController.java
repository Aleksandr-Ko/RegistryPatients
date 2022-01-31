package kop.registrypatients.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kop.registrypatients.dto.PatientDto;
import kop.registrypatients.entity.Patient;
import kop.registrypatients.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/patient")
@Tag(name = "Пациенты", description = "Взаимодействие с Пациентами")
public class PatientDtoController {
    @Autowired
    PatientService patientService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    @Operation(summary = "Постраничный вывод справочника Пациентов")
    public ResponseEntity<List<Patient>> readAll(@PageableDefault Pageable pageable) {
        Page<Patient> pages = patientService.readAll(pageable);
        return ResponseEntity.ok().body(pages.getContent());
    }

    @GetMapping("{id}")
    @Operation(summary = "Позволяет получить Пациента по ID")
    public ResponseEntity<PatientDto> readOneDto(@PathVariable(name = "id") Integer id) {
        // convert DTO to entity
        Patient patient = patientService.readOne(id);
        // convert entity to DTO
        PatientDto patientResponse = modelMapper.map(patient, PatientDto.class);
        return ResponseEntity.ok().body(patientResponse);
    }

    @PutMapping("{id}")
    @Operation(summary = "Позволяет обновить данные о Пациенте по ID")
    public ResponseEntity<PatientDto> updateDto(@PathVariable("id") Integer id, @Valid @RequestBody PatientDto patientDto) {
        // convert DTO to entity
        Patient patientRequest = modelMapper.map(patientDto, Patient.class);
        Patient patient = patientService.update(patientRequest, id);
        // entity to DTO
        PatientDto patientResponse = modelMapper.map(patient, PatientDto.class);
        return ResponseEntity.ok().body(patientResponse);
    }


    @PostMapping
    @Operation(summary = "Регистрация нового Пациента", description = "Позволяет зарегистрировать Пациента")
    public ResponseEntity<PatientDto> createDto(@Valid @RequestBody PatientDto patientDto) {
        // convert PatientDto to Patient entity
        Patient patientRequest = modelMapper.map(patientDto, Patient.class);
        Patient patient = patientService.create(patientRequest);
        // convert Patient entity to PatientDto class
        PatientDto patientResponse = modelMapper.map(patient, PatientDto.class);
        return new ResponseEntity<PatientDto>(patientResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Удаление Пациента по Id")
    public ResponseEntity<Patient> delete(@PathVariable(name = "id") Integer id) {
        final boolean deleted = patientService.deleteById(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.NOT_MODIFIED)
                : new ResponseEntity<>(HttpStatus.OK);
    }
}
