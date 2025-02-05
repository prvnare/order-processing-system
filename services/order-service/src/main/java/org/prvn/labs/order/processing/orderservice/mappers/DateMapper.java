package org.prvn.labs.order.processing.orderservice.mappers;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

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

}