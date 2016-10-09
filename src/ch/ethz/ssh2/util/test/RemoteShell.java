package ch.ethz.ssh2.util.test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
public class RemoteShell {
public static Map<String,String> getTimeLogStat(){
    Map<String,String> map=new LinkedHashMap<String, String>();
     try {
                Connection connection = new Connection("199.155.122.141");// 创建一个连接实例
                connection.connect();// Now connect
                boolean isAuthenticated = connection.authenticateWithPassword("root", "testqa");// Authenticate
                if (isAuthenticated == false) throw new IOException("user and password error");
                Session sess = connection.openSession();// Create a session
                System.out.println("start exec command.......");
                sess.requestPTY("bash");
                sess.startShell();
                InputStream stdout = new StreamGobbler(sess.getStdout());
                InputStream stderr = new StreamGobbler(sess.getStderr());
                BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(stdout));
                BufferedReader stderrReader = new BufferedReader(new InputStreamReader(stderr));
                
                
                PrintWriter out = new PrintWriter(sess.getStdin());
                out.println("cd /opt/tracy");
                out.println("cat tts_ttk1.log.2013-01-08.log | while read line; do echo \"$line\"; done");
                out.println("exit");
                out.close();
                
                
                sess.waitForCondition(ChannelCondition.CLOSED | ChannelCondition.EOF | ChannelCondition.EXIT_STATUS, 30000);
                System.out.println("下面是从stdout输出:");
                
                String v=null;
                while (true) {
                    String line = stdoutReader.readLine();
                    if (line == null ) break;
                    System.out.println(line);
//                    if(!line.contains("timelog")){
//                        continue;
//                    }
//                    line=line.replaceAll("timelog ", "");
//                    if(line.contains("AVG") && v!=null){
//                        map.put(v, line);
//                        v=null;
//                    }else{
//                        v=line;
//                    }
                    //   System.out.println(line);
                }
//                Set<String> set=map.keySet();
//                for (String s : set) {
//                    System.out.println(s+"\t"+map.get(s));
//                }
//                System.out.println("下面是从stderr输出:");
//                while (true) {
//                    String line = stderrReader.readLine();
//                    if (line == null) break;
//                    System.out.println(line);
//                }
               System.out.println("ExitCode: " + sess.getExitStatus());
                sess.close();/* Close this session */
                connection.close();/* Close the connection */
            } catch (IOException e) {
                e.printStackTrace(System.err);
                System.exit(2);
            }
     return map;
}
public static void main(String[] args) {
    getTimeLogStat();
}
}
