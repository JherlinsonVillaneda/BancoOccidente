package bancoOccidente.commons.endPoints.bankAccount;

public interface IBankAccountEndPoints {

    String ACCOUNT_BASE_URL = "/account";

    String TABLE_ACCOUNT = "cuentas_bancarias";

    String CREATE_ACCOUNT_URL = "/create_account";

    String DELETE_ACCOUNT_URL = "/delete_account/{numero_cuenta}";

    String UPDATE_ACCOUNT_URL = "/update_account";

    String FIND_ACCOUNT_URL = "/find_account/{numero_cuenta}";
}
