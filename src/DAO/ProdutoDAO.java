package DAO;

import DTO.ProdutoDTO;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ProdutoDTO> lista = new ArrayList<>();

    public void finalizarCadastroProd(ProdutoDTO objprodutodto) {
        String sql = "insert into produtos (produto_argamassa, produto_cal, produto_cimento) values (?, ?, ?)";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objprodutodto.getProduto_argamassa());
            pstm.setInt(2, objprodutodto.getProduto_cal_reboco());
            pstm.setInt(3, objprodutodto.getProduto_cimento());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO Cadastrar: " + erro);
        }

    }

    public ArrayList<ProdutoDTO> PesquisarProduto() {
        String sql = "select * from produtos";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                ProdutoDTO objprodutodto = new ProdutoDTO();
                objprodutodto.setId_produto(rs.getInt("id_produto"));
                objprodutodto.setProduto_argamassa(rs.getInt("produto_argamassa"));
                objprodutodto.setProduto_cal_reboco(rs.getInt("produto_cal"));
                objprodutodto.setProduto_cimento(rs.getInt("produto_cimento"));

                lista.add(objprodutodto);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO Pesquisar: " + erro);
        }

        return lista;
    }

    public void AlterarProduto(ProdutoDTO objprodutodto) {
        String sql = "update produtos set produto_argamassa = ?, produto_cal = ?, produto_cimento = ? where id_produto = ?";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objprodutodto.getProduto_argamassa());
            pstm.setInt(2, objprodutodto.getProduto_cal_reboco());
            pstm.setInt(3, objprodutodto.getProduto_cimento());
            pstm.setInt(4, objprodutodto.getId_produto());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO Alterar: " + erro);
        }

    }

    public void ExcluirProduto(ProdutoDTO objprodutodto) {
        String sql = "delete from produtos where id_produto = ?";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, objprodutodto.getId_produto());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO Excluir: " + erro);
        }

    }
}
