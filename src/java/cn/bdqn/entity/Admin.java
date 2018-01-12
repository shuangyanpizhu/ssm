package cn.bdqn.entity;

/**
 * Created by Administrator on 2018/1/12 0012.
 */
public class Admin {
    private int adminId;
    private String adminName;
    private String adminPwd;
    private String adminCode;
    private String adminPhotoPath;

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getAdminPhotoPath() {
        return adminPhotoPath;
    }

    public void setAdminPhotoPath(String adminPhotoPath) {
        this.adminPhotoPath = adminPhotoPath;
    }
}
