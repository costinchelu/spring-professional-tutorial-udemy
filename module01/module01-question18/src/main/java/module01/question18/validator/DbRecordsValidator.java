package module01.question18.validator;

import module01.question18.ds.Record;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RecordsValidatorType(RecordsValidatorType.RecordsValidatorMode.DB)
public class DbRecordsValidator implements RecordsValidator {

    @Override
    public void validate(Collection<Record> records) {

    }
}
