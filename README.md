#ImageJ解析dicom文件成jpg图片
Dicom全称是医学数字图像与通讯，这里讲java解析diocm格式文件变成jpg示例。
这里的代码只能解析普通的dicom文件成jpg图片，对于压缩的dicom文件是没有办法解析的！
先看效果：
解析到本地目录：
![1](http://i.imgur.com/9U3wsXD.png)


解析到本地电脑：
![2](http://i.imgur.com/BCz1v5j.png)

ImageJ解析代码很简单，但是要导入ImageJ的jar包。
从第一个图片可以看到lib中导入了ij.jar，这就是ImageJ的jar包，下面那个zip是source文件，这样就可以看到ImageJ里面的源码。

下面是调用ImageJ的代码：

```

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



```


ImageJ的jar包和dicom文件可以看我的项目。
 



