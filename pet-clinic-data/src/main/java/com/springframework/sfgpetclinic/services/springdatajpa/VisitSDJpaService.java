package com.springframework.sfgpetclinic.services.springdatajpa;

import com.springframework.sfgpetclinic.model.Visit;
import com.springframework.sfgpetclinic.repositories.VisitRepository;
import com.springframework.sfgpetclinic.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

    private final VisitRepository visitRepository;

    @Autowired
    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findALL() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);

        return visits;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
