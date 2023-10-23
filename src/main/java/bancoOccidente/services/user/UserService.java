package bancoOccidente.services.user;

import bancoOccidente.commons.converter.user.UserConverter;
import bancoOccidente.commons.dto.UserDto;
import bancoOccidente.commons.endPoints.response.IResponse;
import bancoOccidente.model.entity.usuario.UserEntity;
import bancoOccidente.model.repository.user.IUserRepository;
import org.apache.kafka.common.quota.ClientQuotaAlteration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private IUserRepository iUserRepository;

    public String createUser(UserEntity userEntity){

        try{
            Optional<UserEntity>find=this.iUserRepository.findById(userEntity.getId());
            if (!find.isPresent())
            {
                this.iUserRepository.save(userEntity);
                return IResponse.CREATE_SUCCESS;

            }
            else {
                return IResponse.CREATE_FAIL;
            }
        }
        catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

    public String deleteUser(Integer id)
    {
        try{
            Optional<UserEntity>find=this.iUserRepository.findById(id);
            if (find.isPresent())
            {
                this.iUserRepository.delete(find.get());
                return IResponse.DELETE_SUCCESS;
            }
            else {
                return IResponse.DELETE_FAIL;
            }

        }
        catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

    public String updateUser(UserDto userDto)
    {
        try{
            if (userDto == null || userDto.getId()==null){
                return IResponse.NOT_FOUND;
            }
            Optional<UserEntity>find=this.iUserRepository.findById(userDto.getId());
            if (find.isPresent())
            {
                UserEntity userEntity = userConverter.convertUserDtoToEntity(userDto);
                this.iUserRepository.save(userEntity);
                return IResponse.UPDATE_SUCCESS;
            }
            else {
                return IResponse.UPDATE_FAIL;
            }


        }
        catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }

    }
    public String findUser(Integer id)
    {
        try {
            Optional<UserEntity>find = this.iUserRepository.findById(id);
            if (find.isPresent()){
                return find.toString();
            }
            else {
                return IResponse.NOT_FOUND;
            }

        }
        catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

    public List<UserEntity> findAllUsers()
    {
        try{
            List<UserEntity> findAll=this.iUserRepository.findAll();
            return findAll;
        }
        catch (Exception e){
            List<UserEntity> findAll=this.iUserRepository.findAll();
            return findAll;
        }
    }





}
