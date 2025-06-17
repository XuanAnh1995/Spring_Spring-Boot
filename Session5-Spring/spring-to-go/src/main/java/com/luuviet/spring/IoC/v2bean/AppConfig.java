package com.luuviet.spring.IoC.v2bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration  // Báo trùm cuối ApplicationContext vào đây tim info để new các bean, quản lí chúng, tiêm chúng
//@ComponentScan("com.luuviet.spring.IoC.v2bean")   // ko quét luôn
public class AppConfig {

    // thì phải new bean ở đây
    // @Bean   // obj được return từ hàm này, đi vào Container ngay
               // chủ động new là mình, chủ động đặt tên obj, nhưng đưa obj cho Container
    // TÊN HÀM PHÁ CHUẨN VERB + OBJ TRUYỀN THỐNG MÀ MANG Ý NGHĨA TÊN BIẾN OBJ , ĐỂ ĐƯỢC DÙNG NGẦM TRONG CONTAINER
//    @Bean("ngocTrinh")
//    public PdfGenerator pdfGenerator() {
//        return new PdfGenerator();
//        // nếu bean/class gốc có constructor có tham số, DÙNG BEAN TỰ NEW , TỰ TRUYỀN ĐƯỢC THAM SỐ VÀO CONSTRUCTOR
//        // SPRING SẼ THUA KHI KO BIẾT ĐƯA THAM SỐ THẾ NÀO
//    }

//    @Bean
//    public DocumentGenerator pdfGenerator(){
//        return new PdfGenerator();
//    }
//
//    @Bean
//    public DocumentGenerator exelGenerator(){
//        return new ExcelGenerator();
//    }

    @Bean
//    @Primary    // Chỉ định bean ưu tiên khi có nhiều bean cùng loại
    public PdfGenerator pdfGenerator() {
        return new PdfGenerator();
    }

    @Bean
    public ExcelGenerator excelGenerator() {
        return new ExcelGenerator();
    }

}

// TODO: ĐIỀU GÌ XẢY RA NẾU CÓ 2 OBJ CỦA CÙNG CLASS ???
// VÍ DỤ: PdfGenerator và ExcelGenerator đều là (implement) interface DocumentGenerator
// @Primary, @Qualifier khi có nhiều bean cùng kiểu