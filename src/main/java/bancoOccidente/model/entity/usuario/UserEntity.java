package bancoOccidente.model.entity.usuario;

import bancoOccidente.commons.endPoints.user.IUserEndPoints;
import bancoOccidente.model.entity.bankAccount.BankAccountEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name= IUserEndPoints.TABLE_USER)
@Getter
@Setter
@ToString
@Data

public class UserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "identificacion")
    private Integer identificacion;

    @Column(name = "correo")
    private String correo;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "telefono")
    private Integer telefono;

    @Column(name = "genero")
    private String genero;

    @OneToMany(mappedBy = "propietario")
    @JsonIgnore
    private List<BankAccountEntity> listBankAccount;





}
