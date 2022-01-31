package kop.registrypatients.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "referral")
public class Referral {

    @Id
    @Column(name = "referral_id")
    @SequenceGenerator(name = "referralIdSeq", sequenceName = "referral_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "referralIdSeq")
    private Integer referralId;

    @Column(name = "date_referral")
    private LocalDateTime dateReferral;

    @Column(name = "date_result")
    private LocalDateTime dateResult;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patientId;

    @ManyToOne
    @JoinColumn(name = "created_mu_id")
    private MedicalInstitution createdMuId;

    @ManyToOne
    @JoinColumn(name = "executed_mu_id")
    private MedicalInstitution executedMuId;

}