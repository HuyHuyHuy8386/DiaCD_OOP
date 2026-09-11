package BanDiaCD;
public class CDList {
    private CD[] ds;
    private int count;

    // Constructor tạo danh sách có n phần tử
    public CDList(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Kích thước danh sách phải > 0");
        }

        ds = new CD[n];
        count = 0;
    }

    // Kiểm tra mã CD có bị trùng hay không
    private boolean trungMaCD(int maCD) {
        for (int i = 0; i < count; i++) {
            if (ds[i].getMaCD() == maCD) {
                return true;
            }
        }
        return false;
    }

    // Thêm một CD vào danh sách
    public boolean themCD(CD cd) {
        if (cd == null) {
            return false;
        }

        // Kiểm tra mảng còn chỗ và mã không trùng
        if (count >= ds.length || trungMaCD(cd.getMaCD())) {
            return false;
        }

        ds[count] = cd;
        count++;

        return true;
    }

    // Số lượng CD hiện có
    public int soLuongCD() {
        return count;
    }

    // Tổng giá thành
    public double tongGiaThanh() {
        double tong = 0;

        for (int i = 0; i < count; i++) {
            tong += ds[i].getGiaThanh();
        }

        return tong;
    }

    // Xuất toàn bộ danh sách
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(
            "%-10s %-30s %-15s %s%n",
            "Mã CD", "Tựa CD", "Số bài hát", "Giá thành"
        ));

        sb.append("-----------------------------------------------------------------------\n");

        for (int i = 0; i < count; i++) {
            sb.append(ds[i]).append("\n");
        }

        return sb.toString();
    }

    // Sắp xếp giảm dần theo giá thành
    public void sapXepGiamTheoGia() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (ds[i].getGiaThanh() < ds[j].getGiaThanh()) {
                    CD temp = ds[i];
                    ds[i] = ds[j];
                    ds[j] = temp;
                }
            }
        }
    }

    // Sắp xếp tăng dần theo tựa CD
    public void sapXepTangTheoTua() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (ds[i].getTuaCD().compareToIgnoreCase(ds[j].getTuaCD()) > 0) {
                    CD temp = ds[i];
                    ds[i] = ds[j];
                    ds[j] = temp;
                }
            }
        }
    }
}
