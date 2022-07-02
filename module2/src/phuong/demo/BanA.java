package phuong.demo;

public class BanA extends HocSinh{
    private Double physical;

    public BanA() {
    }

    public BanA(Double physical) {
        this.physical = physical;
    }

    public BanA(Integer maHocSinh, String name, String dayOfBirth, String gender, String clazz, Double math, Double chemistry, Double physical) {
        super(maHocSinh, name, dayOfBirth, gender, clazz, math, chemistry);
        this.physical = physical;
    }

    public Double getPhysical() {
        return physical;
    }

    public void setPhysical(Double physical) {
        this.physical = physical;
    }

    @Override
    public Double getDiemTrungBinh() {
        return ((super.getMath()*2 + super.getChemistry() + this.physical)/4);
    }

    @Override
    public String toString() {
        return "BanA{" + super.toString() +
                "physical=" + physical +
                '}';
    }
}
