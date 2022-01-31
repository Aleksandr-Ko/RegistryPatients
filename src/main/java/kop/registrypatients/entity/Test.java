package kop.registrypatients.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "test")
public class Test {

    @Id
    @Column(name = "test_id")
    @SequenceGenerator(name = "testIdSeq", sequenceName = "test_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "testIdSeq")
    private Integer testId;

    @Column(name = "result")
    private String result;

    @OneToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "referral_id")
    private Referral referralId;

}