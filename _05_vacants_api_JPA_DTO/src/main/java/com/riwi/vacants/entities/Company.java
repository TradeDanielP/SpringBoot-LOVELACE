package com.riwi.vacants.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 40, nullable = false)
    private String name;
    private String location;
    @Column(length = 14, nullable = false)
    private String contact;

    // Onetomany relacion uno a muchos, es decir una empresa puede tener muchas vacantes, y vacantes se guarda en una lista.
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL,orphanRemoval = false, fetch = FetchType.EAGER)
    //Eliminar el To String desde lombok para no generar un ciclo infinito que llame a ambos to string
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Vacant> vacants;

}
