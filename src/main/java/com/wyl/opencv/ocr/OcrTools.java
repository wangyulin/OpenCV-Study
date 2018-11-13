package com.wyl.opencv.ocr;

/**
 * @Auther: wangyulin
 * @Date: 2018/11/12 23:02
 * @Description:
 */
public class OcrTools {

    public static Integer getFileType(String filename) {

        String fileSuffix = filename.substring(filename.lastIndexOf(".") + 1);

        if (fileSuffix.equalsIgnoreCase("bmp")) {
            return OcrConstants.FILE_TYPE_IMAGE_BMP;
        } else if (fileSuffix.equalsIgnoreCase("tif")) {
            return OcrConstants.FILE_TYPE_IMAGE_TIF;
        } else if (fileSuffix.equalsIgnoreCase("jpg") || fileSuffix.equalsIgnoreCase("jpeg")
                || fileSuffix.equalsIgnoreCase("png")) {
            return OcrConstants.FILE_TYPE_IMAGE;
        }

        return null;
    }

    public static long createProcessId() {
        return System.nanoTime() >> 1;
    }

}
