
package DTO;

public class ProdutoDTO {

    private int id_produto, produto_cimento, produto_argamassa, produto_cal_reboco;

    public int getProduto_cimento() {
        return produto_cimento;
    }

    public void setProduto_cimento(int produto_cimento) {
        this.produto_cimento = produto_cimento;
    }

    public int getProduto_argamassa() {
        return produto_argamassa;
    }

    public void setProduto_argamassa(int produto_argamassa) {
        this.produto_argamassa = produto_argamassa;
    }

    public int getProduto_cal_reboco() {
        return produto_cal_reboco;
    }

    public void setProduto_cal_reboco(int produto_cal_reboco) {
        this.produto_cal_reboco = produto_cal_reboco;
    }
    
     public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }
}
