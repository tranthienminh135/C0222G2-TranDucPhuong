package phuong.demo;

public class BanB extends HocSinh{
    private Double biological;

    public BanB() {
    }

    public BanB(Double biological) {
        this.biological = biological;
    }

    public BanB(Integer maHocSinh, String name, String dayOfBirth, String gender, String clazz, Double math, Double chemistry, Double biological) {
        super(maHocSinh, name, dayOfBirth, gender, clazz, math, chemistry);
        this.biological = biological;
    }

    public Double getBiological() {
        return biological;
    }

    public void setBiological(Double biological) {
        this.biological = biological;
    }

    @Override
    public Double getDiemTrungBinh() {
        return ((super.getChemistry() + super.getMath() + this.biological*2)/4);
    }

    @Override
    public String toString() {
        return "BanB{" + super.toString() +
                "biological=" + biological +
                '}';
    }
}
