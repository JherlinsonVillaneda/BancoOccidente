package bancoOccidente.commons.converter.bankAccount;

import bancoOccidente.commons.dto.BankAccountDto;
import bancoOccidente.commons.endPoints.response.IResponse;
import bancoOccidente.commons.helpers.HelperMapper;
import bancoOccidente.model.entity.bankAccount.BankAccountEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class BankAccountConverter {
    public BankAccountEntity convertBankAccountDtoToEntity(BankAccountDto bankAccountDto)
    {
        BankAccountEntity bankAccountEntity = new BankAccountEntity();
        try{
            bankAccountEntity = HelperMapper.modelMapper().map(bankAccountDto, BankAccountEntity.class);
        }
        catch (Exception e){
            log.error(IResponse.DOCUMENT_FAIL + e);
        }
        return bankAccountEntity;
    }

}
