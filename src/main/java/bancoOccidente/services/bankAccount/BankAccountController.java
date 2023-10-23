package bancoOccidente.services.bankAccount;

import bancoOccidente.commons.dto.BankAccountDto;
import bancoOccidente.commons.endPoints.bankAccount.IBankAccountEndPoints;
import bancoOccidente.model.entity.bankAccount.BankAccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IBankAccountEndPoints.ACCOUNT_BASE_URL)
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping(IBankAccountEndPoints.CREATE_ACCOUNT_URL)
    public String createBankAccount(@RequestBody BankAccountEntity bankAccountEntity)
    {
        System.out.println("Prueba 1 : entro al controlador"+ bankAccountEntity.getTipoCuenta());
        return this.bankAccountService.createBankAccount(bankAccountEntity);
    }

    @DeleteMapping(IBankAccountEndPoints.DELETE_ACCOUNT_URL)
    public String deleteBankAccount(@PathVariable Integer numero_cuenta)
    {
        return this.bankAccountService.deleteBankAccount(numero_cuenta);
    }

    @PutMapping(IBankAccountEndPoints.UPDATE_ACCOUNT_URL)
    public String updateBankAccount(@RequestBody BankAccountDto bankAccountDto)
    {
        return this.bankAccountService.updateBankAccount(bankAccountDto);
    }

    @GetMapping(IBankAccountEndPoints.FIND_ACCOUNT_URL)
    public String findBankAccount(@PathVariable Integer numero_cuenta)
    {
        return this.bankAccountService.findBankAccount(numero_cuenta);
    }



}
