package kop.registrypatients.service;

import kop.registrypatients.entity.MedicalInstitution;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface MedicalInstitutionService {

    void create(MedicalInstitution medicalInstitution);

    Page<MedicalInstitution> readAll(Pageable pageable);

    MedicalInstitution readOne(Integer id);

    MedicalInstitution update(MedicalInstitution medicalInstitution, Integer id);

    boolean deleteById(Integer id);
}
