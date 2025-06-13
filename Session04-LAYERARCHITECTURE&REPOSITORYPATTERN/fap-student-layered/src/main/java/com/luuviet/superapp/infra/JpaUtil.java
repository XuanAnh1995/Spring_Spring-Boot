package com.luuviet.superapp.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {

    // CLASS NA CHỊU TRÁCH NHIỆM KẾT NỐI CSDL THÔNG QUA ĐỐI TƯỢNG ENTITY-MANAGER-FACTORY, HAO RAM, TỐN THỜI GIAN ĐỂ TẠO KÊNH KẾT NỐI VỚI SQL SERVER/ MY SQL -> HEAVY CLASS
    // NÓ NÊN ĐƯỢC KHỞI TẠO SỚM, 1 LẦN, 1 INSTANCE, 1 VÙNG RAM, 1 OBJECT, SINGLETON
    // CHƯA KỂ MỖI LẦN ĐƯỢC TẠO RA, CÓ KHI NÓ SẼ TẠO MỚI TABLE LUÔN (OPTION CREATE) , HOẶC NÓ SCAN LẠI CẤU TRÚC TABLE CÓ THAY ĐỔI GÌ KO ĐỂ CẬP NHẬT (OPTION UPDATE TRONG .XML)

    // KĨ THUẬT VIẾT CODE MÀ KHIẾN CHO CLASS KO NEW ĐƯỢC LẦN THỨ 2, KO NEW ĐƯỢC NHIỀU OBJECT, LỠ MAY GỌI NHIỀU CÁI CLASS NÀY, CŨNG CHỈ CÓ 1 VÙNG NEW ĐƯỢC TẠO RA
    // STATIC + PRIVATE CONSTRUCTOR
    // 1 CLASS KO CÓ CONSTRUCTOR -> JVM SẼ TẠO 1 CÁI CONSTRUCTOR RỖNG, VẪN NEW ĐƯỢC OK LUÔN
    // CẤM TẠO OBJECT TỪ MỌI CONSTRUCTOR : CLASS KO CÓ CONSTRUCTOR, VÀ  CONSTRUCTOR RỖNG MÌNH PHẾ LUÔN

    private static final EntityManagerFactory emf;
    // duy trì sự kết nối đến CSDL, đọc file persistence.xml để tạo dựng / update table
    // heavy load ở biến này

    static {
        try {
            emf = Persistence.createEntityManagerFactory("com.luuviet.superapp-PU");    // load thông tin server từ file persistence.xml
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // cấm new class này
    // biến emf Factory chỉ có 1 con đường được khởi tạo, khởi tạo 1 lần duy nhất qua đoạn lệnh trôi nổi static {} ở trên
    // KĨ THUẬT SINGLETON ĐÃ XONG - 1 OBJECT HEAVING ENTITY- MANAGER-FACTORY TRONG RAM
    private JpaUtil() {
    }

    // CÓ ÔNG NHÀ XƯỞNG FACTORY RỒI, ĐI MỜI Ô MANAGER VỂ QUẢN LÝ CÁC @ENTITY
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    // HÀM NÀY THÌ NHÓM REPOSITORY SẼ GỌI ĐẾN NHỜ VẢ XUỐNG TABLE
    // VÌ NÓ LÀ STATIC NÊN CHẤM SÀI LUÔN
    // JpaUtil.getEntityManager();

    // ĐÓNG CỬA NHÀ MÁY, KO CẦN CHƠI VỚI CSDL NỮA, KO DUY TRÌ KẾT NỐI NỮA KHI APP SHUTDOWN
    public static void shutdown() {
        emf.close();
    }
}
