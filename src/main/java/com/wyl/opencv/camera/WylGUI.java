package com.wyl.opencv.camera;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import javax.swing.*;
import java.awt.*;

/**
 * @Auther: wangyulin
 * @Date: 2018/11/14 23:41
 * @Description:
 */
public class WylGUI {

    private JFrame frame;
    private JLabel imageLabel;

    public void initGUI() {
        frame = new JFrame("Camera Input Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        imageLabel = new JLabel();
        frame.add(imageLabel);
        frame.setVisible(true);
    }

    public void runMainLoop() {
        ImageProcessor imageProcessor = new ImageProcessor();
        Mat webcamMatImage = new Mat();
        Image tempImage;
        VideoCapture capture = new VideoCapture(0);
        capture.set(Videoio.CAP_PROP_FRAME_WIDTH, 320);
        capture.set(Videoio.CAP_PROP_FRAME_HEIGHT, 240);
        if (capture.isOpened()) {
            while (true) {
                capture.read(webcamMatImage);
                if (!webcamMatImage.empty()) {
                    tempImage = imageProcessor.toBufferedImage(webcamMatImage);
                    ImageIcon imageIcon = new ImageIcon(tempImage, "Captured video");
                    imageLabel.setIcon(imageIcon);
                    frame.pack(); //this will resize the window to fit the image
                } else {
                    System.out.println(" -- Frame not captured -- Break!");
                    break;
                }
            }
        } else {
            System.out.println("Couldn't open capture.");
        }
    }

}
