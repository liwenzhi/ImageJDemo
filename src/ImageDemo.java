import ij.plugin.DICOM;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * dicom文件java解析，生成图片
 * 不过这里不能解析压缩的dicom文件
 */
public class ImageDemo {

    public static void main(String args[]) {
//        create("test1.dcm");    //在本地目录生成test1.dcm.jpg图片文件
        create2("D:\\dicom\\test3.dcm");   //在电脑dicom文件夹下生成test1.dcm.jpg图片文件

    }


    /**
     * 根据dicom文件生成jpg图片
     * <p/>
     * 这里输入的是image文件夹的dicom文件名字，
     * 运行即可得到一个jpg图片，显示的是dicom里面的图形
     */
    private static void create(String fileName) {
        try {
            String projectPath = System.getProperty("user.dir");
            //Check class DICOM
            DICOM dicom = new DICOM();
            String imagePath = projectPath + "\\image\\" + fileName;
            dicom.run(imagePath);
            BufferedImage bi = (BufferedImage) dicom.getImage();
            int width = bi.getWidth();
            int height = dicom.getHeight();
            System.out.println("width: " + width + "\n" + "height: " + height);
            imagePath = projectPath + "\\image\\" + fileName + ".jpg";
            ImageIO.write(bi, "jpg", new File(imagePath));
            System.out.println("Hehe,Game over!!!");

        } catch (Exception e) {
            System.out.println("错误" + e.getMessage());
        }

    }


    /**
     * 输入一个dicom文件的绝对路径和名字
     * 获取一个jpg文件
     */
    private static void create2(String filePath) {
        try {
            DICOM dicom = new DICOM();
            dicom.run(filePath);
            BufferedImage bi = (BufferedImage) dicom.getImage();
            int width = bi.getWidth();
            int height = dicom.getHeight();
            System.out.println("width: " + width + "\n" + "height: " + height);
            String imagePath = filePath + ".jpg";
            ImageIO.write(bi, "jpg", new File(imagePath));
            System.out.println("Hehe,Game over!!!");

        } catch (Exception e) {
            System.out.println("错误" + e.getMessage());
        }

    }


}
