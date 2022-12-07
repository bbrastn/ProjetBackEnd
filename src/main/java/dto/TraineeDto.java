package dto;


import canard.intern.post.following.backend.enums.Gender;
import canard.intern.post.following.backend.validator.DateLessThan;
import lombok.Builder;
import lombok.Data;


import javax.validation.constraints.*;
import java.time.LocalDate;


@Builder
@Data
public class TraineeDto {
    private Integer id;


    @NotBlank
    private String lastName;
    @NotBlank
    private String firstName;
    private Gender gender;

    @DateLessThan
    private LocalDate birthDate;
    @NotBlank @Email
    private String email;
    @Pattern(regexp = "(\\+33|0)[0-9]{9}")
    private String phoneNumber;

}
