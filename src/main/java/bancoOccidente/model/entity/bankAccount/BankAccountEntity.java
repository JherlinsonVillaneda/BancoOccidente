package bancoOccidente.model.entity.bankAccount;

import bancoOccidente.commons.endPoints.bankAccount.IBankAccountEndPoints;
import bancoOccidente.model.entity.usuario.UserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;

@Entity
@Table(name= IBankAccountEndPoints.TABLE_ACCOUNT)
@Getter
@Setter
@Data
@ToString
public class BankAccountEntity {
    @Id
    @Column(name = "numero_cuenta")
    private Integer numeroCuenta;

    @Column(name = "tipo_cuenta")
    private String tipoCuenta;

    @Column(name = "saldo")
    private Double saldo;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_apertura")
    private LocalDate fechaApertura;


    @ManyToOne
    @JoinColumn(name = "propietario_cliente_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private UserEntity propietario;


}
