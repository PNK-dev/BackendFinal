package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="notas")
public class Notas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nota1")
    private double nota1;

    @Column(name = "nota2")
    private double nota2;

    @Column(name = "nota3")
    private double nota3;

    @Column(name = "promedio")
    private double promedio;

    @ManyToOne
    @JoinColumn(name="cursos_id", nullable = false)
    private Cursos cursos;

    @ManyToOne
    @JoinColumn(name="alumnos_id", nullable = false)
    private Alumnos alumnos;

    public void setNota1(double nota1) {
        this.nota1 = nota1;
        calcularPromedio();
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
        calcularPromedio();
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
        calcularPromedio();
    }

    private void calcularPromedio() {
        this.promedio = (this.nota1 + this.nota2 + this.nota3) / 3;
    }

    public Notas(double nota1, double nota2, double nota3, Cursos cursos, Alumnos alumnos) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.cursos = cursos;
        this.alumnos = alumnos;
        calcularPromedio();
    }
}
