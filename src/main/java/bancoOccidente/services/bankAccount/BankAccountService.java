package bancoOccidente.services.bankAccount;

import bancoOccidente.commons.converter.bankAccount.BankAccountConverter;
import bancoOccidente.commons.dto.BankAccountDto;
import bancoOccidente.commons.endPoints.response.IResponse;
import bancoOccidente.model.entity.bankAccount.BankAccountEntity;
import bancoOccidente.model.repository.bankAccount.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountConverter bankAccountConverter;

    @Autowired
    private IAccountRepository iAccountRepository;


    public String createBankAccount(BankAccountEntity bankAccountEntity)
    {

        try {
            Optional<BankAccountEntity>find=this.iAccountRepository.findById(bankAccountEntity.getNumeroCuenta());

            if(!find.isPresent())
            {

                this.iAccountRepository.save(bankAccountEntity);
                System.out.println("se guardó");
                return IResponse.CREATE_SUCCESS;
            }
            else{
                return IResponse.CREATE_FAIL;
            }
        }
        catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }

    public String deleteBankAccount(Integer numeroCuenta)
    {
        try{
            Optional<BankAccountEntity>find=this.iAccountRepository.findById(numeroCuenta);
            if (find.isPresent())
            {
                this.iAccountRepository.delete(find.get());
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

    public String updateBankAccount(BankAccountDto bankAccountDto)
    {
        try{
            if(bankAccountDto == null || bankAccountDto.getNumeroCuenta()==null){
                return IResponse.NOT_FOUND;
            }
            Optional<BankAccountEntity>find=this.iAccountRepository.findById(bankAccountDto.getNumeroCuenta());
            if (find.isPresent())
            {
                BankAccountEntity bankAccountEntity = bankAccountConverter.convertBankAccountDtoToEntity(bankAccountDto);
                this.iAccountRepository.save(bankAccountEntity);
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

    public String findBankAccount(Integer numero_cuenta)
    {
        System.out.println("Prueba 2: entro al servicio");
        try{
            Optional<BankAccountEntity>find = this.iAccountRepository.findById(numero_cuenta);
            System.out.println("Entro a la condicion");
            if (find.isPresent())
            {
                System.out.println("Entro a la condicion");
                return find.toString();
            }

            else {
                System.out.println("funciono");
                return IResponse.NOT_FOUND;
            }
        }
        catch (Exception e){
            return IResponse.INTERNAL_SERVER_ERROR;
        }
    }


}
