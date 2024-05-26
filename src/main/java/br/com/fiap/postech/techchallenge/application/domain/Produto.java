package br.com.fiap.postech.techchallenge.application.domain;

import java.math.BigDecimal;

public class Produto {

    private Long id;

    private CategoriaEnum categoria;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    public void atualizarCom(Produto produtoAtualizado) {
        this.nome = produtoAtualizado.getNome();
        this.descricao = produtoAtualizado.getDescricao();
        this.preco = produtoAtualizado.getPreco();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoriaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
