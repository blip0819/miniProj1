package miniProj1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.batch.Main;

public class MemberDAO {
	private static Connection conn = null;
    private static PreparedStatement memberListPstmt = null;

	static {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/miniProj_DB",
                    "bituser",
                    "1004"
            );
            System.out.println("연결 성공 대박");
            conn.setAutoCommit(false);

            memberListPstmt = conn.prepareStatement("select * from TB_MEMBER");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        

    }

}
