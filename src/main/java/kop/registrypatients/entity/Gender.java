package kop.registrypatients.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gender")
public class Gender {

    @Id
    @Column(name = "gender_id")
    @SequenceGenerator(name = "genderIdSeq", sequenceName = "gender_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genderIdSeq")
    private int genderId;


    @Column(name = "name")
    private String name;

}