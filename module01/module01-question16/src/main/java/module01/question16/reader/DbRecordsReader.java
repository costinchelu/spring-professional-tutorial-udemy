package module01.question16.reader;

import module01.question16.ds.Record;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class DbRecordsReader implements RecordsReader {

    @Override
    public Collection<Record> readRecords() {
        return Collections.emptyList();
    }
}
