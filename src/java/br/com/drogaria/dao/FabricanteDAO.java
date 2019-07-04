/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.dao;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.factory.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SKY
 */
public class FabricanteDAO {

    public void salvar(Fabricante fab) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO fabricante ");
        sql.append("(descricao)");
        sql.append("VALUES (?)");

        Connection conexao = ConexaoFactory.con();

        PreparedStatement comando = conexao.prepareStatement(sql.toString());
        comando.setString(1, fab.getDescricao());

        comando.executeUpdate();
    }

    public static void main(String[] args) {

        Fabricante fabricante = new Fabricante();
        fabricante.setDescricao("Descrição1");

        Fabricante fabricante1 = new Fabricante();
        fabricante1.setDescricao("Descrição2");

        FabricanteDAO fundador = new FabricanteDAO();
        try {

            fundador.salvar(fabricante);
            fundador.salvar(fabricante1);
            System.out.println("Os fabricantes foram salvos com sucesso");
        } catch (SQLException ex) {
            System.out.println("não deu certo");

        }

    }
}
