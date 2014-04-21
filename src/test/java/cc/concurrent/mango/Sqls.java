package cc.concurrent.mango;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ash
 */
public enum Sqls {

    USER("user.sql");

    private String name;

    private Sqls(String name) {
        this.name = name;
    }

    public void run(Connection conn) throws IOException, SQLException {
        ScriptRunner sr = new ScriptRunner(conn, false, true);
        InputStream is = MangoTest.class.getResourceAsStream("/" + Config.getDir() + "/" + name);
        sr.runScript(new InputStreamReader(is));
    }

}
