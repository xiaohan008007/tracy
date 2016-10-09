/**
 * 
 */
package ch.ethz.ssh2.remote;

/**
 * @author tracy.lu
 * @date:2012-8-16 下午5:51:53
 * @version :
 */
public class ShellParam {

    private String ip;
    private String username;
    private String password;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
