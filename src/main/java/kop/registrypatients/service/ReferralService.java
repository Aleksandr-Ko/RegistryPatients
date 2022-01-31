package kop.registrypatients.service;

import kop.registrypatients.entity.Referral;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ReferralService {

    Referral create(Referral referral);

    Page<Referral> readAll(Pageable pageable);

    Referral readOne(Integer id);

    Referral update(Referral referral, Integer id);

    boolean deleteById(Integer id);
}
