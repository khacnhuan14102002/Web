package vn.edu.hcmuaf.fit.bean;

public class Logging {
    private static Logging install;

    public static Logging me() {
        if (install == null) install = new Logging();
        return install;
    }

    private Logging() {
    }

    private void log(int level, int userId, String src, String content) {
    }

}
