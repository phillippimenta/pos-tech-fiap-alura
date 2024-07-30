package br.com.fiap.postech.techchallenge.domain.entities;

import br.com.fiap.postech.techchallenge.domain.enums.StatusPedido;
import br.com.fiap.postech.techchallenge.domain.exception.DominioException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Long id;

    private Cliente cliente;

    private BigDecimal precoTotal = BigDecimal.ZERO;

    private LocalDateTime dataHoraCriacao;

    private List<PedidoProduto> produtos = new ArrayList<>();

    private StatusPedido status;

    public void alterarStatus(StatusPedido novoStatus) {
        if (podeAlterarPara(novoStatus)) {
            this.status = novoStatus;
        } else {
            throw new DominioException(String.format("Não é possível alterar o pedido para o status %s.", novoStatus));
        }
    }

    private boolean podeAlterarPara(StatusPedido novoStatus) {
        if (this.status == null) {
            return novoStatus == StatusPedido.RECEBIDO;
        }
        return switch (this.status) {
            case RECEBIDO -> novoStatus == StatusPedido.EM_PREPARACAO;
            case EM_PREPARACAO -> novoStatus == StatusPedido.PRONTO;
            case PRONTO -> novoStatus == StatusPedido.FINALIZADO;
            case FINALIZADO -> false;
        };
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public List<PedidoProduto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<PedidoProduto> produtos) {
        this.produtos = produtos;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
