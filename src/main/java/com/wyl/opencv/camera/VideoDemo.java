package com.wyl.opencv.camera;

import com.wyl.opencv.base.OpenCVProcessBase;
import org.junit.Test;

/**
 * @Auther: wangyulin
 * @Date: 2018/11/14 23:40
 * @Description:
 */
public class VideoDemo extends OpenCVProcessBase {

    @Test
    public void testCapturing() {
        WylGUI wylGUI = new WylGUI();
        wylGUI.initGUI();
        wylGUI.runMainLoop();
    }

}
