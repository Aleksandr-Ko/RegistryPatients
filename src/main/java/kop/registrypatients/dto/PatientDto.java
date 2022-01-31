package kop.registrypatients.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import kop.registrypatients.entity.Gender;
import kop.registrypatients.valid.CapitalLetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность Пациент")
public class PatientDto {

    @Schema(description = "Идентификатор", accessMode = Schema.AccessMode.READ_ONLY)
    private Integer patientId;

    @NotBlank(message = "У Пациента должна быть фамилия")
    @CapitalLetter
    private String surname;

    @NotBlank(message = "У Пациента должно быть имя")
    @CapitalLetter
    private String name;

    @CapitalLetter
    private String patronymic;

    @NotNull(message = "У Пациента должна быть дата рождения")
    @PastOrPresent(message = "Дата рождения должна содержать прошедшую дату или сегодняшнее число")
    private LocalDate birthday;

    @NotBlank(message = "У Пациента должен быть СНИЛС")
    @Size(min = 6, max = 6, message = "Номер СНИЛСа должен содержать 6 символов")
    @Schema(description = "Номер СНИЛСа должен содержать 6 символов")
    private String snils;

    @Schema(description = "Пол должен быть: 1 - мужчина, 2 – женщина")
    private Gender gender;


}
