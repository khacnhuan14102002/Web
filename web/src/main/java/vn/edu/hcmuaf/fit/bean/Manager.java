package vn.edu.hcmuaf.fit.bean;

public class Manager {
    int idU;
    int manager;
    int isdelete;
    int isedit;
    int isadd;

    public Manager(int idU, int manager, int isdelete, int isedit, int isadd) {
        this.idU = idU;
        this.manager = manager;
        this.isdelete = isdelete;
        this.isedit = isedit;
        this.isadd = isadd;
    }

    public Manager() {
    }

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }

    public int getIsedit() {
        return isedit;
    }

    public void setIsedit(int isedit) {
        this.isedit = isedit;
    }

    public int getIsadd() {
        return isadd;
    }

    public void setIsadd(int isadd) {
        this.isadd = isadd;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "idU=" + idU +
                ", manager=" + manager +
                ", isdelete=" + isdelete +
                ", isedit=" + isedit +
                ", isadd=" + isadd +
                '}';
    }
}
