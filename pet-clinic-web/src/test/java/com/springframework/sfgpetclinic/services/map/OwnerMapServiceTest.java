package com.springframework.sfgpetclinic.services.map;

import com.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long ownerId=1L;
    final String lastName="Doe";

    @BeforeEach
    void setUp() {
        ownerMapService=new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findALL() {
        Set<Owner> ownerSet = ownerMapService.findALL();
        assertEquals(1,ownerSet.size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0,ownerMapService.findALL().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0,ownerMapService.findALL().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner newOwner = Owner.builder().id(id).build();
        Owner savedOwner = ownerMapService.save(newOwner);
        assertEquals(id,savedOwner.getId());

    }
    @Test
    void saveNoId() {

        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertEquals(ownerId+1,savedOwner.getId());

    }
    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId,owner.getId());
    }
    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(lastName);
        assertNotNull(owner);
        assertEquals(ownerId,owner.getId());
    }
    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerMapService.findByLastName("foo");
        assertNull(owner);
    }
}