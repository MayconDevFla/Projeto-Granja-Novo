package com.granjacontrol.granjacontrol.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ciclo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull(message = "{campo.peso.obrigatorio}")
    private Double peso;

    @Column(nullable = false)
    @NotNull(message = "{campo.quantidade.obrigatorio}")
    private Integer quantidade;

    @Column(nullable = false)
    @NotEmpty(message = "{campo.raca.obrigatorio}")
    private String raca;

    @Column(updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate registration_date;

    @PrePersist
    public void prePersist(){
        setRegistration_date(LocalDate.now());
    }

}
