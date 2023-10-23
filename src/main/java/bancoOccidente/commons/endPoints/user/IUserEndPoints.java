package bancoOccidente.commons.endPoints.user;

public interface IUserEndPoints {

    String USER_BASE_URL = "/user";

    String TABLE_USER = "usuario";
    String CREATE_USER_URL = "/create";

    String DELETE_USER_URL = "/delete/{id}";

    String UPDATE_USER_URL= "/update";

    String FIND_USER_URL= "/find/{id}";

    String FINDALL_USER_URL= "/findAll";
}
