package com.springframework.sfgpetclinic.formatters;

import com.springframework.sfgpetclinic.model.PetType;
import com.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    @Autowired
    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        PetType foundPetType = petTypeService.findByName(text);
        if(foundPetType!=null){
            return foundPetType;
        }
        throw new ParseException("type not found: " + text, 0);
    }
}
