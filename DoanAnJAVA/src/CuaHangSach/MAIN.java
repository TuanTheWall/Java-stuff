package CuaHangSach;

import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        DSNV dsnv = new DSNV();
        BillList billList = new BillList();
        ProductList plist = new ProductList(); 
        
        System.out.println("Đang đọc dữ liệu từ file...");
        plist.doc_file();
        dsnv.doc_file();
        billList.doc_file();
        System.out.println("Đọc dữ liệu hoàn tất!\n");
        
        
        int choice;
        do {
            showMenu();
            choice = readInt(reader, "Nhập lựa chọn của bạn: ");

            switch (choice) {
                case 1:
                    quanLySach(reader, plist);
                    break;
                case 2:
                    quanLyNhanVien(reader, dsnv);
                    break;
                case 3:
                    quanLyHoaDon(reader, billList, plist);
                    break;
                case 0:
                    System.out.println("Hẹn gặp lại!");
                    break;
                default:
                    System.out.println("Lỗi, vui lòng nhập lại.");
            }
        } while (choice != 0);

        reader.close();
    }

    // Menu chính
    private static void showMenu() {
        System.out.println("\n===== QUẢN LÝ CỦA HÀNG SÁCH =====");
        System.out.println("1. Quản lý sách");
        System.out.println("2. Quản lý nhân viên");
        System.out.println("3. Quản lý hóa đơn");
        System.out.println("0. Thoát");
    }

    // Đọc số nguyên 
    private static int readInt(Scanner reader, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(reader.nextLine()); 
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nhập không hợp lệ, vui lòng nhập lại!");
            }
        }
        return value;
    }

    // Quản lý nhân viên
    private static void quanLyNhanVien(Scanner reader, DSNV dsnv) {
        int choice;
        do {
            System.out.println("\n--- QUẢN LÝ NHÂN VIÊN ---");
            System.out.println("1. Nhập danh sách");
            System.out.println("2. Thêm nhân viên");
            System.out.println("3. Xuất danh sách");
            System.out.println("4. Tìm nhân viên");
            System.out.println("5. Sửa nhân viên");
            System.out.println("6. Xóa nhân viên");
            System.out.println("0. Trở về trang chủ");

            choice = readInt(reader, "Nhập lựa chọn: ");

            switch (choice) {
                case 1: {
                	dsnv.nhap(reader);
                	dsnv.xuat_file();
                	dsnv.doc_file();
                	break;
                	
                }
                case 2: {
                	dsnv.them(reader);
                	dsnv.xuat_file();
                	dsnv.doc_file();
                	break;
                }
                case 3: dsnv.xuat(); break;
                case 4: dsnv.tim(reader); break;
                case 5: {
                	dsnv.sua(reader);
                	dsnv.xuat_file();
                	dsnv.doc_file();
                	break;
                }
                case 6: {
                	dsnv.xoa(reader);
                	dsnv.xuat_file();
                	dsnv.doc_file();
                	break;
                }
                case 0: break;
                default: System.out.println("Lỗi nhập!"); break;
            }
        } while (choice != 0);
    }

    // Quản lý sách
    private static void quanLySach(Scanner reader, ProductList plist) {
        int choice;
        do {
        System.out.println("\n--- QUẢN LÝ SÁCH ---");
            System.out.println("1. Nhập danh sách sách");
            System.out.println("2. Thêm sách");
            System.out.println("3. Xuất danh sách sách");
            System.out.println("4. Tìm sách");
            System.out.println("5. Sửa sách");
            System.out.println("6. Xóa sách");
            System.out.println("0. Trở về trang chủ");

            choice = readInt(reader, "Nhập lựa chọn: ");

            switch (choice) {
                case 1: {
                    plist.nhapsp(reader);  
                        	plist.xuat_file();
                        	plist.doc_file();
                        	break;
                }
                case 2: {
                	plist.them(reader);
                	plist.xuat_file();
                	plist.doc_file();
                	break;
                }
                case 3: plist.xuat(); break;
                case 4: {
                	plist.search(reader);
                	break;
                }
                case 5: {
                	plist.sua(reader);
                	plist.xuat_file();
                	plist.doc_file();
                	break;
                }
                case 6: {
                	plist.xoa(reader);
                   	plist.xuat_file();
                	plist.doc_file();
                	break;
                }

                case 0: break;
                default: System.out.println("Nhập lỗi!"); break;
            }
        } while (choice != 0);
    }

    // Quản lý hóa đơn
    private static void quanLyHoaDon(Scanner reader, BillList billList, ProductList plist) {
        int choice;
        do {
            System.out.println("\n--- QUẢN LÝ HÓA ĐƠN ---");
            System.out.println("1. Nhập danh sách hóa đơn");
            System.out.println("2. Thêm hóa đơn");
            System.out.println("3. Xuất danh sách hóa đơn");
            System.out.println("4. Sửa hóa đơn");
            System.out.println("5. Xóa hóa đơn");
            System.out.println("0. Trở về trang chủ");

            choice = readInt(reader, "Nhập lựa chọn: ");

            switch (choice) {
                case 1: {
                	billList.nhap(reader, plist);
                	billList.xuat_file();
                	billList.doc_file();
                	break;
                }
                case 2:{	
                	billList.them(reader, plist); 
                	billList.xuat_file();
                	billList.doc_file();
                	break;
                }
                case 3: billList.xuat(); break;
                case 4: {
                	billList.sua(reader, plist);
                	billList.xuat_file();
                	billList.doc_file();
                	break;
                	
                }
                case 5:{
                	billList.xoa(reader);
                	billList.xuat_file();
                	billList.doc_file();
                	break;
                }
                case 0: break;
                default: System.out.println("Lỗi nhập!"); break;
            }
        } while (choice != 0);
    }
}