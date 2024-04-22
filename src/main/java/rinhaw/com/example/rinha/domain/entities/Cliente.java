package rinhaw.com.example.rinha.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;

  @OneToOne
  private Saldo saldo;
  @OneToMany
  private List<Transacao> transacao;

  public void deposit(long valor) {
    this.saldo.deposit(valor);
  }
}
