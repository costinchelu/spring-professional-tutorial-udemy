package module01.question18.bls;

import module01.question18.ds.Record;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class DbRecordsProcessor implements RecordsProcessor {

    @Override
    public Collection<Record> processRecords(Collection<Record> records) {
        return Collections.emptyList();
    }
}
