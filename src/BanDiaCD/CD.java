package BanDiaCD;
public class CD {
    private int maCD;
    private String tuaCD;
    private int soBaiHat;
    private double giaThanh;

    // Constructor mặc định
    public CD() {
        this.maCD = 999999;
        this.tuaCD = "chưa xác định";
        this.soBaiHat = 1;
        this.giaThanh = 1;
    }

    // Constructor đầy đủ
    public CD(int maCD, String tuaCD, int soBaiHat, double giaThanh) {
        setMaCD(maCD);
        setTuaCD(tuaCD);
        setSoBaiHat(soBaiHat);
        setGiaThanh(giaThanh);
    }

    // Getter - Setter mã CD
    public int getMaCD() {
        return maCD;
    }

    public void setMaCD(int maCD) {
        if (maCD > 0) {
            this.maCD = maCD;
        } else {
            throw new IllegalArgumentException("Mã CD phải > 0");
        }
    }

    // Getter - Setter tựa CD
    public String getTuaCD() {
        return tuaCD;
    }

    public void setTuaCD(String tuaCD) {
        if (tuaCD != null && !tuaCD.trim().isEmpty()) {
            this.tuaCD = tuaCD;
        } else {
            throw new IllegalArgumentException("Tựa CD không được rỗng");
        }
    }

    // Getter - Setter số bài hát
    public int getSoBaiHat() {
        return soBaiHat;
    }

    public void setSoBaiHat(int soBaiHat) {
        if (soBaiHat > 0) {
            this.soBaiHat = soBaiHat;
        } else {
            throw new IllegalArgumentException("Số bài hát phải > 0");
        }
    }

    // Getter - Setter giá thành
    public double getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(double giaThanh) {
        if (giaThanh > 0) {
            this.giaThanh = giaThanh;
        } else {
            throw new IllegalArgumentException("Giá thành phải > 0");
        }
    }

    // toString
    @Override
    public String toString() {
        return String.format(
            "%-10d %-30s %-15d %,.2f",
            maCD, tuaCD, soBaiHat, giaThanh
        );
    }
}
