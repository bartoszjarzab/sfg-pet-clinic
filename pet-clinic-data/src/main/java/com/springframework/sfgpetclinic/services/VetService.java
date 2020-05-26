package com.springframework.sfgpetclinic.services;


import com.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Vet id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
