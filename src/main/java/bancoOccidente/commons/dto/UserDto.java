package bancoOccidente.commons.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {


    private Integer id;


    private String nombre;


    private Integer identificacion;


    private String correo;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaNacimiento;


    private Integer telefono;


    private String genero;




}
