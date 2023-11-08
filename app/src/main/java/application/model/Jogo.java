package application.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jogos")
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    private Genero genero;
    @ManyToMany
    @JoinTable(
        name = "jogos_possuem_plataformas",
        joinColumns = @JoinColumn(name = "jogos_id"),
        inverseJoinColumns = @JoinColumn(name = "plataformas_id")
    )
    private Set<Plataforma> plataformas;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public Set<Plataforma> getPlataformas() {
        return plataformas;
    }
    public void setPlataformas(Set<Plataforma> plataformas) {
        this.plataformas = plataformas;
    }
    
}
