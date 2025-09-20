package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    public static void criarTabela(){
        String sql = """
                CREATE TABLE IF NOT EXISTS livros (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    titulo TEXT NOT NULL,
                    autor TEXT NOT NULL,
                    ano INTEGER
                );
                """;

        try(Connection conn = DatabaseService.connect();
            Statement stm = conn.createStatement()){
                stm.execute(sql);
            System.out.println("Tabela criada/verificada com sucesso.");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
