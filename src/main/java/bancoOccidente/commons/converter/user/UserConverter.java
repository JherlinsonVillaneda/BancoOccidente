package bancoOccidente.commons.converter.user;


import bancoOccidente.commons.dto.UserDto;
import bancoOccidente.commons.endPoints.response.IResponse;
import bancoOccidente.model.entity.usuario.UserEntity;
import bancoOccidente.commons.helpers.HelperMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class UserConverter {
    public UserEntity convertUserDtoToEntity(UserDto userDto)
    {
        UserEntity userEntity = new UserEntity();
        try{
            userEntity = HelperMapper.modelMapper().map(userDto, UserEntity.class);
        }
        catch (Exception e){
            log.error(IResponse.DOCUMENT_FAIL + e);
        }
        return userEntity;
    }


}
