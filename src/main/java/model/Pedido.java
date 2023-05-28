package model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    //Muitos para 1
    @ManyToOne
    private Cliente cliente;

    //1 para muitos
    //mappedBy = Existe uma outro mapeamento do outro lado
    //CascateType.All -> Responsavel por fazer com que o pedido seja adiciono no mesmo momento da sua criação em
    // Ambas as tabelas e também deletado no mesmo momento
    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL)
    private List<ItensPedido> itens = new ArrayList<>();

    private int valor_total;
    private LocalDate data = LocalDate.now();

    public Pedido() {

    }

    public void adicionarItem(ItensPedido item) {
        //Agora o item conhece o pedido e pedido conhece o lacal que sera salvo
        item.setPedido(this);
        this.itens.add(item);
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getClientes() {
        return cliente;
    }

    public void setClientes(Cliente clientes) {
        this.cliente = clientes;
    }

}
