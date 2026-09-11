package BanDiaCD;
import java.util.Scanner;

public class TestCDList 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng CD tối đa: ");
        int n = sc.nextInt();

        CDList list = new CDList(n);

        int choice;

        do 
        {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Thêm CD");
            System.out.println("2. Hiển thị danh sách CD");
            System.out.println("3. Số lượng CD");
            System.out.println("4. Tổng giá thành");
            System.out.println("5. Sắp xếp giảm dần theo giá thành");
            System.out.println("6. Sắp xếp tăng dần theo tựa CD");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    try 
                    {
                        System.out.print("Nhập mã CD: ");
                        int maCD = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Nhập tựa CD: ");
                        String tuaCD = sc.nextLine();

                        System.out.print("Nhập số bài hát: ");
                        int soBaiHat = Integer.parseInt(sc.nextLine().trim());
                        
                        System.out.print("Nhập giá thành: ");
                        double giaThanh = Double.parseDouble(sc.nextLine().trim());

                        CD cd = new CD(maCD, tuaCD, soBaiHat, giaThanh);

                        if (list.themCD(cd)) 
                        {
                            System.out.println("Thêm CD thành công!");
                        } else 
                        {
                            System.out.println(
                                "Thêm thất bại: mã CD bị trùng hoặc danh sách đã đầy."
                            );
                        }

                    } catch (IllegalArgumentException e) 
                    {
                        System.out.println("Lỗi: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("\n===== DANH SÁCH CD =====");
                    System.out.println(list);
                    break;

                case 3:
                    System.out.println(
                        "Số lượng CD hiện có: " + list.soLuongCD()
                    );
                    break;

                case 4:
                    System.out.printf(
                        "Tổng giá thành: %,.2f%n",
                        list.tongGiaThanh()
                    );
                    break;

                case 5:
                    list.sapXepGiamTheoGia();
                    System.out.println(
                        "Đã sắp xếp giảm dần theo giá thành!"
                    );
                    System.out.println(list);
                    break;

                case 6:
                    list.sapXepTangTheoTua();
                    System.out.println(
                        "Đã sắp xếp tăng dần theo tựa CD!"
                    );
                    System.out.println(list);
                    break;

                case 0:
                    System.out.println("Kết thúc chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);

        sc.close();
    }
}
