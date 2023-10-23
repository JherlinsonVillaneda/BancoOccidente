package bancoOccidente.model.repository.user;

import bancoOccidente.model.entity.usuario.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository <UserEntity, Integer>{

}
