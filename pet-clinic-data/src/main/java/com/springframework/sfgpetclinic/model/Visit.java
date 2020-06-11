package com.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="visits")
public class Visit extends BaseEntity{
    @Column(name="date")
    private LocalDate date;
    @Column(name="description")
    private String description;

    @Builder
    public Visit(Long id, LocalDate date, String description, Pet pet) {
        super(id);
        this.date=date;
        this.description=description;
        this.pet=pet;
    }

    @ManyToOne
    @JoinColumn(name="pet_id")
    private Pet pet;

}
