package com.wyl.opencv.first;

import com.wyl.opencv.base.OpenCVProcessBase;
import org.junit.Test;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;

/**
 * @Auther: wangyulin
 * @Date: 2018/11/12 23:19
 * @Description: 1. 图像空间压缩 <br/>
 */
public class StudySection_5 extends OpenCVProcessBase {

    private String save_dir = "study-output/study-opencv-5";

    /**
     * 图像空间压缩
     */
    @Test
    public void testColorReduce() {

        // 读取彩色图
        Mat sourceImage = Imgcodecs.imread(this.p_test_file_path + "/5cent.jpg", Imgcodecs.CV_LOAD_IMAGE_COLOR);

        this.saveImage(this.save_dir + "/image_process_reduce_0.png", sourceImage);

        Mat dstImage = new Mat();
        dstImage.create(sourceImage.rows(), sourceImage.cols(), sourceImage.type());

        long start = Core.getTickCount();

        this.colorReduce(sourceImage, dstImage, 32);

        long end = Core.getTickCount();

        System.out.println((end - start) / Core.getTickFrequency());

        this.saveImage(this.save_dir + "/image_process_reduce_1.png", dstImage);

        // 已知问题，压缩后，如何还原？？？？？

        Mat dstImage2 = new Mat();
        dstImage2.create(dstImage.rows(), dstImage.cols(), dstImage.type());
        this.colorReduce_2(dstImage, dstImage2, 32);

        this.saveImage(this.save_dir + "/image_process_reduce_2.png", dstImage2);

    }

    private void colorReduce(Mat src, Mat dst, int div) {
        dst = src.clone();
        int rowNumber = dst.rows();
        int colNumber = dst.cols();//列数 * 通道数，等于每一行元素的个数

        for (int i = 0; i < rowNumber; i++) {

            for (int j = 0; j < colNumber; j++) {

                int channelIndex = 0;
                while (channelIndex < dst.channels()) {
                    //颜色空间压缩处理

                    if (j == 0 && i < 10) {
                        System.out.printf("Point[%d,%d],Channel[%d] >> %s", i, j, channelIndex + 1, dst.get(i, j)[channelIndex]);
                        System.out.printf(" , after >> %s | ", (dst.get(i, j)[channelIndex] / div) * div);

                        if (channelIndex + 1 == dst.channels()) {
                            System.out.printf("\r\n");
                        }
                    }

                    dst.get(i, j)[channelIndex] = (dst.get(i, j)[channelIndex] / div) * div;
                    channelIndex++;
                }
            }
        }
    }

    private void colorReduce_2(Mat src, Mat dst, int div) {
        dst = src.clone();
        int rowNumber = dst.rows();
        int colNumber = dst.cols();//列数 * 通道数，等于每一行元素的个数

        for (int i = 0; i < rowNumber; i++) {

            for (int j = 0; j < colNumber; j++) {

                int channelIndex = 0;
                while (channelIndex < dst.channels()) {
                    //颜色空间压缩处理

                    if (j == 0 && i < 10) {
                        System.out.printf("Point[%d,%d],Channel[%d] >> %s", i, j, channelIndex + 1, dst.get(i, j)[channelIndex]);
                        System.out.printf(" , after >> %s | ", (dst.get(i, j)[channelIndex]) / div * div);

                        if (channelIndex + 1 == dst.channels()) {
                            System.out.printf("\r\n");
                        }
                    }

                    dst.get(i, j)[channelIndex] = (dst.get(i, j)[channelIndex]) / div * div;
                    channelIndex++;
                }
            }
        }
    }
}