package kop.registrypatients.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kop.registrypatients.dto.ReferralDto;
import kop.registrypatients.entity.Referral;
import kop.registrypatients.service.ReferralService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/referral")
@Tag(name = "Направление", description = "Взаимодействие с Направлениями")
public class ReferralDtoController {

    @Autowired
    ReferralService referralService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    @Operation(summary = "Постраничный вывод справочника Направлений")
    public ResponseEntity<List<Referral>> readAll(@PageableDefault Pageable pageable) {
        Page<Referral> pages = referralService.readAll(pageable);
        return ResponseEntity.ok().body(pages.getContent());
    }

    @GetMapping("{id}")
    @Operation(summary = "Позволяет получить Напрвление по ID")
    public ResponseEntity<ReferralDto> readOneDto(@PathVariable("id") Integer id) {
        Referral referral = referralService.readOne(id);
        ReferralDto referralResponse = modelMapper.map(referral, ReferralDto.class);
        return ResponseEntity.ok().body(referralResponse);
    }

    @PostMapping
    @Operation(summary = "Регистрация нового Направления", description = "Позволяет зарегистрировать Направление")
    public ResponseEntity<ReferralDto> create(@Valid @RequestBody ReferralDto referralDto) {
        // convert PatientDto to Patient entity
        Referral referral = new Referral();
        referral.setDateReferral(referralDto.getDateReferral());
        referral.setDateResult(referralDto.getDateResult());
        referral.setStatus(referralDto.getStatus());
        referral.setPatientId(referralDto.getPatientId());
        referral.setCreatedMuId(referralDto.getCreatedMuId());
        referral.setExecutedMuId(referralDto.getExecutedMuId());
        Referral referralSaved = referralService.create(referral);
        // convert Patient entity to PatientDto class
        ReferralDto referralResponse = new ReferralDto();
        referralResponse.setDateReferral(referralSaved.getDateReferral());
        referralResponse.setDateResult(referralSaved.getDateResult());
        referralResponse.setStatus(referralSaved.getStatus());
        referralResponse.setPatientId(referralSaved.getPatientId());
        referralResponse.setCreatedMuId(referralSaved.getCreatedMuId());
        referralResponse.setExecutedMuId(referralSaved.getExecutedMuId());
        return ResponseEntity.ok().body(referralResponse);
    }
}
