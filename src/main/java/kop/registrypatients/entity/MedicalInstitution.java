package kop.registrypatients.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medical_institution")
public class MedicalInstitution {

    @Id
    @Column(name = "medical_institution_id")
    @SequenceGenerator(name = "medicalInstitutionIdSeq", sequenceName = "medical_institution_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicalInstitutionIdSeq")
    private int medicalInstitutionId;

    @Column(name = "name")
    private String name;

    @Column(name = "ogrn")
    private int ogrn;

    @Column(name = "oid")
    private String oid;

}