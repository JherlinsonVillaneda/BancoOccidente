package bancoOccidente.commons.dto;

import bancoOccidente.model.entity.usuario.UserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.*;
import java.time.LocalDate;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDto {

    private Integer numeroCuenta;

    private String tipoCuenta;

    private Double saldo;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaApertura;

    @JsonIdentityReference(alwaysAsId = true)
    private UserEntity propietario;

}
