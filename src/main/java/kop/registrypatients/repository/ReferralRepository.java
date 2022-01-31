package kop.registrypatients.repository;

import kop.registrypatients.entity.Referral;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ReferralRepository extends JpaRepository<Referral, Integer> {

    @Override
    Optional<Referral> findById(Integer integer);

    @Override
    Page<Referral> findAll(Pageable pageable);

    @Override
    void deleteById(Integer integer);
}
