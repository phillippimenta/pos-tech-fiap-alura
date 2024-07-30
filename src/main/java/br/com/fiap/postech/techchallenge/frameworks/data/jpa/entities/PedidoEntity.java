package br.com.fiap.postech.techchallenge.frameworks.data.jpa.entities;

import br.com.fiap.postech.techchallenge.domain.enums.StatusPedido;
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
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    private List<PedidoProdutoEntity> produtoPedidoEntityList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @Column(name = "data_hora_criacao", insertable = true, updatable = false)
    private LocalDateTime dataHoraCriacao;

    @PrePersist
    public void prePersist() {
        this.dataHoraCriacao = LocalDateTime.now();
    }

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

    public List<PedidoProdutoEntity> getProdutoPedidoEntityList() {
        return produtoPedidoEntityList;
    }

    public void setProdutoPedidoEntityList(List<PedidoProdutoEntity> produtoPedidoEntityList) {
        this.produtoPedidoEntityList = produtoPedidoEntityList;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
