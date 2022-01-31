package kop.registrypatients.repository;

import kop.registrypatients.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Override
    Page<Patient> findAll(Pageable pageable);

    @Override
    Optional<Patient> findById(Integer integer);

    @Override
    void deleteById(Integer integer);


}
