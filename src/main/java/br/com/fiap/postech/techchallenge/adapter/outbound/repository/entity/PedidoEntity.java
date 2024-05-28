package br.com.fiap.postech.techchallenge.adapter.outbound.repository.entity;

import br.com.fiap.postech.techchallenge.application.domain.StatusPedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity clienteEntity;

    @Column(name = "preco_total")
    private BigDecimal precoTotal;

    @OneToMany(mappedBy = "pedidoEntity", cascade = CascadeType.ALL)
    private List<ProdutoPedidoEntity> produtoPedidoEntityList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteEntity getClienteEntity() {
        return clienteEntity;
    }

    public void setClienteEntity(ClienteEntity clienteEntity) {
        this.clienteEntity = clienteEntity;
    }

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }

    public List<ProdutoPedidoEntity> getProdutoPedidoEntityList() {
        return produtoPedidoEntityList;
    }

    public void setProdutoPedidoEntityList(List<ProdutoPedidoEntity> produtoPedidoEntityList) {
        this.produtoPedidoEntityList = produtoPedidoEntityList;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
