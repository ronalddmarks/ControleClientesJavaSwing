package br.com.mca.dao;

import br.com.mca.model.Cliente;
import br.com.mca.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteDao extends Dao<Cliente> {

    @Override
    public boolean cadastrar(Cliente cliente) throws SQLException {
        PreparedStatement ps = null;
        String sql = "INSERT INTO CLIENTE (CLI_COD, CLI_NOME, CLI_CPF, CLI_DT_NASC, CLI_SEXO, CLI_FONE, CLI_ENDERECO)"
                + " VALUES (CLIENTE_SEQ.nextval, ?,?,?,?,?,?)";

        try {

            Connection conn = this.obterConexao();

            try {

                ps = conn.prepareStatement(sql);
                ps.setString(1, cliente.getNome());
                ps.setString(2, cliente.getCpf());
                ps.setDate(3, cliente.getNascimento());
                ps.setString(4, cliente.getSexo());
                ps.setString(5, cliente.getFone());
                ps.setString(6, cliente.getEndereco());
                
                ps.executeUpdate();

            } finally {
                
                try {
                    ConnectionFactory.closeConnection(conn,ps);
                 
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
            
            
            return false;

        }
        
        return true;

    }

    @Override
    public boolean atualizar(Cliente pojo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Cliente pojo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getCodigo(Cliente pojo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
