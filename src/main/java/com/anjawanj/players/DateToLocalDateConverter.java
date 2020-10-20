package com.anjawanj.players;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class DateToLocalDateConverter extends BidirectionalConverter<Date, LocalDate> {
    @Override public LocalDate convertTo(Date source, Type<LocalDate> destinationType, MappingContext mappingContext) {
        return LocalDateTime.ofInstant(source.toInstant(), ZoneId.systemDefault()).toLocalDate();
    }

    @Override public Date convertFrom(LocalDate source, Type<Date> destinationType, MappingContext mappingContext) {
        return new Date(source.atStartOfDay().atZone(ZoneOffset.systemDefault()).toInstant().toEpochMilli());
    }
}