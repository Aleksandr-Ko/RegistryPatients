package kop.registrypatients.service;

import kop.registrypatients.entity.Referral;
import kop.registrypatients.repository.ReferralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ReferralServiceImpl implements ReferralService {

    @Autowired
    ReferralRepository referralRepository;

    @Override
    public Referral create(Referral referral) {
        return referralRepository.save(referral);
    }

    @Override
    public Page<Referral> readAll(Pageable pageable) {
        return referralRepository.findAll(pageable);
    }

    @Override
    public Referral readOne(Integer id) {
        Optional<Referral> result = referralRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException("Направление с ID " + id + " не найдено");
        }
    }

    @Override
    public Referral update(Referral referralRequest, Integer id) {
        Referral referral = referralRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Направление с ID " + id + " не изменено"));
        referral.setDateReferral(referralRequest.getDateReferral());
        referral.setDateResult(referralRequest.getDateResult());
        referral.setStatus(referralRequest.getStatus());
        return referralRepository.save(referral);
    }

    @Override
    public boolean deleteById(Integer id) {
        referralRepository.deleteById(id);
        return false;
    }
}
