package kop.registrypatients.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service")
public class Service {

    @Id
    @Column(name = "service_id")
    @SequenceGenerator(name = "serviceIdSeq", sequenceName = "service_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serviceIdSeq")
    private Integer serviceId;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

}