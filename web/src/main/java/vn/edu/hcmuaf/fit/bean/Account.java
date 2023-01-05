package vn.edu.hcmuaf.fit.bean;

public class Account {
    private String ten;
    private int id;
    private String m_khau;
    private int khach;
    private  int Q_tri;

    public Account(String ten, int id, String m_khau, int khach, int Q_tri){
        this.id = id;
        this.ten = ten;
        this.m_khau = m_khau;
        this.khach = khach;
        this.Q_tri = Q_tri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getM_khau() {
        return m_khau;
    }

    public void setM_khau(String m_khau) {
        this.m_khau = m_khau;
    }

    public int getKhach() {
        return khach;
    }

    public void setKhach(int khach) {
        this.khach = khach;
    }

    public int getQ_tri() {
        return Q_tri;
    }

    public void setQ_tri(int q_tri) {
        Q_tri = q_tri;
    }

    @Override
    public String toString() {
        return "nhap [id=" + id + ", ten=" + ten + ", m_khau=" + m_khau + ", khach=" + khach + ", Q_tri=" + Q_tri
                + "]";
    }
}
