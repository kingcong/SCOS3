package activity.code.source.es.scos.es.source.code.model;

import java.io.Serializable;

/**
 * Created by kingcong on 2016/10/11.
 */

public class User implements Serializable{


    private String userName;    // 用户名
    private String password;    // 密码
    private boolean oldUser;    // 是否是老用户

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isOldUser() {
        return oldUser;
    }

    public void setOldUser(boolean oldUser) {
        this.oldUser = oldUser;
    }

}
