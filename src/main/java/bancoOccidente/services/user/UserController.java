package bancoOccidente.services.user;

import bancoOccidente.commons.dto.UserDto;
import bancoOccidente.commons.endPoints.user.IUserEndPoints;
import bancoOccidente.model.entity.usuario.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(IUserEndPoints.USER_BASE_URL)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(IUserEndPoints.CREATE_USER_URL)
    public String createUser(@RequestBody UserEntity userEntity)
    {
        return this.userService.createUser(userEntity);
    }

    @DeleteMapping(IUserEndPoints.DELETE_USER_URL)
    public String deleteUser(@PathVariable Integer id)
    {
        return this.userService.deleteUser(id);
    }

    @PutMapping(IUserEndPoints.UPDATE_USER_URL)
    public String updateUser(@RequestBody UserDto userDto)
    {
        return this.userService.updateUser(userDto);
    }

    @GetMapping(IUserEndPoints.FIND_USER_URL)
    public String findUser(@PathVariable Integer id)
    {
        return this.userService.findUser(id);
    }

    @GetMapping(IUserEndPoints.FINDALL_USER_URL)
    public List<UserEntity> findAllUsers()
    {
        return this.userService.findAllUsers();
    }
}
