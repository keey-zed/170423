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

import java.util.Date;
@XmlRootElement(name = "abonnement")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "AB")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @XmlTransient
    @Temporal(TemporalType.DATE)
    private Date dateAbonnement;
    @XmlTransient
    private Type typeAbonnement;
    private Double solde;
    @Column(name = "MONTANT")
    private Double montantMensuel;
    @XmlTransient
    @ManyToOne
    private Client client;
}
