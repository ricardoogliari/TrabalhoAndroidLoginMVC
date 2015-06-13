package com.example.trabalhoandroidloginmvc.bean;

/**
 * Created by thaisandrade on 06/06/15.
 */
public class Entrega {
    private String id;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String email;
    private String telefone;
    private String cep;
    private int horaDe;
    private int horaAte;
    private long dataEntregue;
    private byte[] foto;
    private String idProduto;
    private String idCliente;
    private boolean cancelada;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getHoraDe() {
        return horaDe;
    }

    public void setHoraDe(int horaDe) {
        this.horaDe = horaDe;
    }

    public int getHoraAte() {
        return horaAte;
    }

    public void setHoraAte(int horaAte) {
        this.horaAte = horaAte;
    }

    public long getDataEntregue() {
        return dataEntregue;
    }

    public void setDataEntregue(long dataEntregue) {
        this.dataEntregue = dataEntregue;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }
}
