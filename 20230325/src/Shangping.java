public class Shangping {
    private String name;
    private int zhekoujia;
    private int yuanjia;
    private int xioaliang;
    private String caizhi;

    @Override
    public String toString() {
        return "Shangping{" +
                "name='" + name + '\'' +
                ", zhekoujia=" + zhekoujia +
                ", yuanjia=" + yuanjia +
                ", xioaliang=" + xioaliang +
                ", caizhi='" + caizhi + '\'' +
                ", size='" + size + '\'' +
                ", kuanshi='" + kuanshi + '\'' +
                '}';
    }

    public String getCaizhi() {
        return caizhi;
    }

    public void setCaizhi(String caizhi) {
        this.caizhi = caizhi;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getKuanshi() {
        return kuanshi;
    }

    public void setKuanshi(String kuanshi) {
        this.kuanshi = kuanshi;
    }

    private String size;
    private String kuanshi;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZhekoujia() {
        return zhekoujia;
    }

    public void setZhekoujia(int zhekoujia) {
        this.zhekoujia = zhekoujia;
    }

    public int getYuanjia() {
        return yuanjia;
    }

    public void setYuanjia(int yuanjia) {
        this.yuanjia = yuanjia;
    }

    public int getXioaliang() {
        return xioaliang;
    }

    public void setXioaliang(int xioaliang) {
        this.xioaliang = xioaliang;
    }

}
