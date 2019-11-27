
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ArCondicionado;

/**
 *
 * @author Leonardo
 */
public class ArCondicionadoDAO {
      private final Conexao con = new Conexao();

    private final String INSERTARC = "INSERT INTO ARCONDICIONADO (MODELO,SETOR,DESPESAS,FABRICANTE,DATAFABRICACAO, ID_USUARIO) VALUES (? , ? , ? , ? , ? , ?)";
        private final String LISTARC = "SELECT MODELO,SETOR,DESPESAS,FABRICANTE,DATAFABRICACAO, ID_USUARIO FROM ARCONDICIONADO";
        
    public boolean insertArC(ArCondicionado a) {
        try {
            // CONECTA
            con.conecta();

            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTARC);
            //(MODELO,SETOR,DESPESAS,FABRICANTE,DATAFABRICACAO, ID_USUARIO)
            // SETA OS VALORES DA INSTRUCAO
            // OBS: PASSA OS PARAMETROS NA ORDEM DAS ? DA INSTRUCAO
            
            
           
            preparaInstrucao.setString(1, a.getModelo().toUpperCase());
            preparaInstrucao.setString(2, a.getSetor().toUpperCase());
            preparaInstrucao.setInt(3, a.getDespesas());
            preparaInstrucao.setString(4, a.getFabricante());
            preparaInstrucao.setDate(5, a.getDatafabricacao());
            preparaInstrucao.setInt(6, DataSingleton.getInstance().getUser());

            // EXECUTA A INSTRUCAO
            preparaInstrucao.execute();

            // DESCONECTA
            con.desconecta();

            return true;

        } catch (SQLException erro) {
            System.out.println(erro);
            return false;

        }
    }

   public ArrayList<ArCondicionado> listArC() {
		ArrayList<ArCondicionado> lista = new ArrayList<>(); 
		try {
			// CONECTA
			con.conecta();
			PreparedStatement preparaInstrucao;
			preparaInstrucao = con.getConexao().prepareStatement(LISTARC); 
			
			
			// EXECUTA A INSTRUCAO
			ResultSet rs = preparaInstrucao.executeQuery(); 
			
			//TRATA O RETORNO DA CONSULTA
			while (rs.next()) { //enquanto houver registro
                            ArCondicionado a = new ArCondicionado(rs.getString("MODELO"),rs.getString("SETOR"),rs.getInt("DESPESAS"),rs.getString("FABRICANTE"),rs.getDate("DATAFABRICACAO"));
				
                        	lista.add(a); 
			}
			// DESCONECTA
			con.desconecta();
		} catch (SQLException sqle) {
                    System.out.println(sqle.getMessage());
		}
		
		return lista;
	}

}

