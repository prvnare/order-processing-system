package org.prvn.labs.order.processing.productservice.mappers;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Component
public class DateMapper {

    public OffsetDateTime getOffsetDateTimeFromTimestamp(Timestamp timestamp){
        return  OffsetDateTime.ofInstant(timestamp.toInstant(), ZoneOffset.UTC);
    }

    public Timestamp getTimestampFromOffsetDateTime(OffsetDateTime offsetDateTime){
        if(offsetDateTime != null){
            return Timestamp.from(offsetDateTime.toInstant());
        }
        return new Timestamp(System.currentTimeMillis());
    }

    public Timestamp asTimestamp(Date date) {
        return date == null ? null : new Timestamp(date.getTime());
    }

    public Date asDate(Timestamp timestamp) {
        return timestamp == null ? null : new Date(timestamp.getTime());
    }
}