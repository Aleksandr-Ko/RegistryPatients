package kop.registrypatients.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @Column(name = "patient_id")
    @SequenceGenerator(name = "patientIdSeq", sequenceName = "patient_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patientIdSeq")
    private Integer patientId;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "snils")
    private String snils;

    @OneToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

}