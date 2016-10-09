package ch.ethz.ssh2.remote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class mymGany {

    public static void main(String args[]) {
        try {
            Connection connection = new Connection("199.155.122.114");// 创建一个连接实例
            connection.connect();// Now connect
            boolean isAuthenticated = connection.authenticateWithPassword("root", "test123");// Authenticate
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
            out.println("cd /opt/tracy/test");
            //out.println("cat statistics.log");
            // out.println("tar -zxvf mysql-5.0.87-linux-i686-glibc23.tar.gz");
           // out.println("cat statistics.log | sort -t: -k1 | awk -F'\\t' '{print $4}'  ");
            out.println("sh myTest.sh");
            //out.println("ls");
            out.println("exit");
            //System.out.println(exe.exec("sh /webapp/myshell/myTest.sh java Know dummy"));
            out.close();
            
            
            sess.waitForCondition(ChannelCondition.CLOSED | ChannelCondition.EOF | ChannelCondition.EXIT_STATUS, 30000);
            System.out.println("下面是从stdout输出:");
            Map<String,String> map=new LinkedHashMap<String, String>();
            String v=null;
            while (true) {
                String line = stdoutReader.readLine();
                if (line == null ) break;
                if(!line.contains("timelog")){
                    continue;
                }
                line=line.replaceAll("timelog ", "");
                if(line.contains("AVG") && v!=null){
                    map.put(v, line);
                    v=null;
                }else{
                    v=line;
                }
                //   System.out.println(line);
            }
            Set<String> set=map.keySet();
            for (String s : set) {
                System.out.println(s+"\t"+map.get(s));
            }
            System.out.println("下面是从stderr输出:");
            while (true) {
                String line = stderrReader.readLine();
                if (line == null) break;
                System.out.println(line);
            }
            System.out.println("ExitCode: " + sess.getExitStatus());
            sess.close();/* Close this session */
            connection.close();/* Close the connection */
        } catch (IOException e) {
            e.printStackTrace(System.err);
            System.exit(2);
        }
        //arr=("all_time" "cache_time" "main_time" "all_time_cache" "all_time_nocache" "no_v_cat_time" "p4p_time" "v_cat_time" "t07_t63_time" "t07_time" "t63_time" "v_time" "v_engine_time" "item_api_time" "search_api_time" "alianalysis" "initResult_time")
    }
    
    public static Map<String,String> timeLogMap=null;
    static {
        timeLogMap=new HashMap<String, String>();
        timeLogMap.put("all_time", "总时间");
        timeLogMap.put("all_time_cache", "总时间（有缓存）");
        timeLogMap.put("all_time_nocache", "总时间（无缓存）");
        timeLogMap.put("cache_time", "缓存时间");
        timeLogMap.put("main_time", "主流程");
        timeLogMap.put("v_cat_time", "图像类目路径");
        timeLogMap.put("no_v_cat_time", "非图像类目路径");
        timeLogMap.put("t07_t63_time", "前置T");
        timeLogMap.put("t07_time", "t07");
        timeLogMap.put("t63_time", "t63");
        timeLogMap.put("v_time", "引擎（包含组装）");
        timeLogMap.put("v_engine_time", "引擎");
        timeLogMap.put("item_api_time", "源商品api");
        timeLogMap.put("search_api_time", "搜索api");
        timeLogMap.put("alianalysis", "分词");
        timeLogMap.put("p4p_time", "p4p路径");
        timeLogMap.put("initResult_time", "最后组装写缓存");
    }
}
