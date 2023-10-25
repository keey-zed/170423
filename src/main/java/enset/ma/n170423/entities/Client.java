package enset.ma.n170423.entities;

import enset.ma.n170423.enums.Type;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
@XmlRootElement(name = "client")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "CLIENT")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String username;
    @XmlTransient
    @OneToMany
    private Collection<Abonnement> abonnements;
}
