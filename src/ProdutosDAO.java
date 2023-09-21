/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
        //conn = new conectaDAO().connectDB();
        
    }
    
    
    public ArrayList<ProdutosDTO> listarProdutos() {
        ArrayList<ProdutosDTO> produtos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet resultSet = null;

        try {
            conn = new conectaDAO().connectDB();
            String sql = "SELECT * FROM produtos";
            prep = conn.prepareStatement(sql);
            resultSet = prep.executeQuery();

            while (resultSet.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultSet.getInt("id"));
                produto.setNome(resultSet.getString("nome"));
                produto.setValor(resultSet.getInt("valor"));
                produto.setStatus(resultSet.getString("status"));
                produtos.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Feche a conexão e os recursos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (prep != null) {
                    prep.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return produtos;
    }
    
    public void venderProduto(int produtoId) {
    Connection conn = null;
    PreparedStatement prep = null;

    try {
        conn = new conectaDAO().connectDB();
        String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";
        prep = conn.prepareStatement(sql);
        prep.setInt(1, produtoId);

        int rowsAffected = prep.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Produto vendido com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao vender o produto.");
        }
    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Erro ao vender o produto: " + erro.getMessage());
    } finally {
        // Feche a conexão e os recursos
        try {
            if (prep != null) {
                prep.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    
        
}