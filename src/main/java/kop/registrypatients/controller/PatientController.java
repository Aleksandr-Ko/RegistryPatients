package kop.registrypatients.controller;

import io.swagger.v3.oas.annotations.Hidden;
import kop.registrypatients.entity.Patient;
import kop.registrypatients.service.PatientService;
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
@RequestMapping("/secret/patient")
@Hidden
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> readAll(@PageableDefault Pageable pageable) {
        Page<Patient> pages = patientService.readAll(pageable);
        return ResponseEntity.ok().body(pages.getContent());
    }

    @GetMapping("{id}")
    public Patient readOne(@Valid @PathVariable("id") Integer id) {
        return patientService.readOne(id);
    }

    @PostMapping
    public ResponseEntity<Patient> create(@Valid @RequestBody Patient patient) {
        patientService.create(patient);
        return ResponseEntity.ok().body(patient);
    }

    @PutMapping("{id}")
    public Patient update(@PathVariable("id") Integer id, @RequestBody Patient patient) {
        return patientService.update(patient, id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        final boolean deleted = patientService.deleteById(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.NOT_MODIFIED)
                : new ResponseEntity<>(HttpStatus.OK);
    }

}
