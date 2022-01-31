package kop.registrypatients.service;

import kop.registrypatients.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PatientService {

    Page<Patient> readAll(Pageable pageable);

    Patient readOne(Integer id);

    Patient create(Patient patient);

    Patient update(Patient patient, Integer id);

    boolean deleteById(Integer id);
}
