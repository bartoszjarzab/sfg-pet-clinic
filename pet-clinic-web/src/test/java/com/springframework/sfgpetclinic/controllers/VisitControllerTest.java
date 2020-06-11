package com.springframework.sfgpetclinic.controllers;

import com.springframework.sfgpetclinic.model.Pet;
import com.springframework.sfgpetclinic.model.Visit;
import com.springframework.sfgpetclinic.services.PetService;
import com.springframework.sfgpetclinic.services.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@ExtendWith(MockitoExtension.class)
class VisitControllerTest {

    @Mock
    VisitService visitService;
    @Mock
    PetService petService;

    @InjectMocks
    VisitController visitController;

    MockMvc mockMvc;
    Visit visit;

    @BeforeEach
    void setUp() {
        visit = Visit.builder().id(1L).build();
        mockMvc = MockMvcBuilders
                .standaloneSetup(visitController)
                .build();
    }

    @Test
    void setAllowedFields() {

    }

    @Test
    void loadPetWithVisit() {
    }

    @Test
    void initNewVisitForm() throws Exception {
     //  when(visitController.loadPetWithVisit().thenReturn(visit);
        when(petService.findById(anyLong())).thenReturn(Pet.builder().id(1L).build());
        mockMvc.perform(MockMvcRequestBuilders.get("/owners/1/pets/1/visits/new"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("visit"))
                .andExpect(view().name("pets/createOrUpdateVisitForm"));
    }

    @Test
    void processNewVisitForm() throws Exception {
        when(petService.findById(anyLong())).thenReturn(Pet.builder().id(1L).build());
        mockMvc.perform(MockMvcRequestBuilders.post("/owners/1/pets/1/visits/new"))
                .andExpect(status().is3xxRedirection())
                .andExpect(model().attributeExists("visit"))
                .andExpect(view().name("redirect:/owners/{ownerId}"));

    }
}