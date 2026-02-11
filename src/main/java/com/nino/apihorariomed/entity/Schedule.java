package com.nino.apihorariomed.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "horarios")
@Data                 // Lombok: Crea Getters y Setters automáticos
@NoArgsConstructor    // Lombok: Constructor vacío
@AllArgsConstructor   // Lombok: Constructor con todo
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String dosis;
    private String hora;       // Formato HH:mm
    private String frecuencia;
    private String notas;
    private Boolean activo;
}