package com.wyl.opencv.ocr;

/**
 * @Auther: wangyulin
 * @Date: 2018/11/12 23:01
 * @Description:
 */
public class OcrConstants {
    // ------------ 文件类型 start -----------

    /**
     * pdf 文件
     */
    public static final Integer FILE_TYPE_PDF = 1;

    /**
     * 图片文件 png\jpg
     */
    public static final Integer FILE_TYPE_IMAGE = 2;

    /**
     * 图片文件 bmp
     */
    public static final Integer FILE_TYPE_IMAGE_BMP = 3;

    /**
     * 图片文件 tif
     */
    public static final Integer FILE_TYPE_IMAGE_TIF = 4;

    // ------------ 文件类型 end-----------


    public static final String OCR_LANG_OPTION = "-l";

    public static final String OCR_PSM_OPITON = "-psm";
}
