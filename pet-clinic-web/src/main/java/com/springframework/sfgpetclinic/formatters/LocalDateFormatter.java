package com.springframework.sfgpetclinic.formatters;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;

@Component
public class LocalDateFormatter implements Formatter<LocalDate> {

//    private final VisitService visitService;
//
//    @Autowired
//    public LocalDateFormatter(VisitService visitService) {
//        this.visitService = visitService;
//    }

    @Override
    public String print(LocalDate object, Locale locale) {
        return object.toString();
    }
    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return LocalDate.parse(text);
    }


}
