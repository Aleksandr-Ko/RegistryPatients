package kop.registrypatients.dto;

import kop.registrypatients.entity.Referral;
import kop.registrypatients.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {

    private Integer testId;

    @NotBlank
    @Size(min = 1, max = 2, message = "Кодовое обозначение результата: 1 - однаружено, 2 - не обнаружено")
    private String result;
    private Service service;
    private Referral referralId;

}
