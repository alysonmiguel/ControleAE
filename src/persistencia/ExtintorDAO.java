/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import modelo.Extintor;

/**
 *
 * @author Aluno
 */
public class ExtintorDAO {

    private final Conexao con = new Conexao();

    private final String INSERTEXTINTOR = "INSERT INTO EXTINTOR (TIPO, PESO, VALIDADE, SETOR, ID_EXTINTOR) VALUES (?, ?, ?, ?, ?)";
    private final String UPDATEXTINTOR = "UPDATE EXTINTOR SET TIPO = ?, PESO = ?, VALIDADE = ?, SETOR = ? WHERE  ID_EXTINTOR = ?";
    private final String LISTEXTINTOR = "SELECT * FROM EXTINTOR ";
    //  private final String DELETEXTINTOR = "DELETE * FROM EXTINTOR";

    public boolean insertExtintor(Extintor e) {
        try {
            // CONECTA
            con.conecta();

            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTEXTINTOR);

            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setString(1, e.getTipo().toUpperCase());
            preparaInstrucao.setInt(2, e.getPeso());
            preparaInstrucao.setDate(3, e.getValidade());
            preparaInstrucao.setString(4, e.getSetor().toUpperCase());
            preparaInstrucao.setInt(5, DataSingleton.getInstance().getUser());

            // EXECUTA A INSTRUCAO
            preparaInstrucao.execute();

            // DESCONECTA
            con.desconecta();

            return true;

        } catch (SQLException erro) {
            return false;

        }
    }

    public boolean atualizar(Extintor e) {
        try {
            // CONECTA
            con.conecta();

            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(UPDATEXTINTOR);

            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            preparaInstrucao.setString(1, e.getTipo().toUpperCase());
            preparaInstrucao.setInt(2, e.getPeso());
            preparaInstrucao.setDate(3, e.getValidade());
            preparaInstrucao.setString(4, e.getSetor().toUpperCase());
            preparaInstrucao.setInt(5, e.getIdExtintor());
            
            System.out.println(e.getIdExtintor());
           
            // EXECUTA A INSTRUCAO
            preparaInstrucao.execute();

            // DESCONECTA
            con.desconecta();

            return true;

        } catch (SQLException erro) {
            return false;

        }
    }

    public ArrayList<Extintor> listExtintor() {
        ArrayList<Extintor> lista = new ArrayList<>();

        try {
            // CONECTA
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(LISTEXTINTOR);
            // EXECUTA A INSTRUCAO
            ResultSet rs = preparaInstrucao.executeQuery();
            //TRATA O RETORNO DA CONSULTA
            while (rs.next()) { //enquanto houver registro
                Extintor e = new Extintor(rs.getDate("VALIDADE"), rs.getString("SETOR"), rs.getString("TIPO"), rs.getInt("PESO"), rs.getInt("ID_USUARIO"), rs.getInt("ID_EXTINTOR"));
                lista.add(e);
            }
            // DESCONECTA
            con.desconecta();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }

        return lista;
    }

}
