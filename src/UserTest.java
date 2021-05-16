import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.print.*;
import java.io.File;
import java.io.IOException;

public class UserTest {
    public static void PrintUser(String name1, String tel1, String addr1, String name2,
                                 String tel2, String addr2) {

        try {
            // 通俗理解就是书、文档
            Book book = new Book();
            // 设置成竖打
            PageFormat pf = new PageFormat();
            pf.setOrientation(PageFormat.PORTRAIT);

            // 通过Paper设置页面的空白边距和可打印区域。必须与实际打印纸张大小相符。
            Paper paper = new Paper();
            paper.setSize(230, 85);// 纸张大小
            paper.setImageableArea(10, 3, 210, 75);
            pf.setPaper(paper);
            book.append(new UserTicket(name1,tel1,addr1,name2,tel2,addr2), pf);

            // 获取打印服务对象
            PrinterJob job = PrinterJob.getPrinterJob();
            // 设置打印类
            job.setPageable(book);
            job.print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }

    //该main函数是为了测试，可以在本地以图片的形式呈现一下打印小票的样式，方便打印测试，节省纸卷和碳带的资源
/*    public static void main(String[] args) {
        Font font = null;
        String path = "D:/testimg.png";
        int right = 120;        //右边一张距离左边的距离
        int first_second = 0;   //第一行与第二行的距离
        int w = 226;
        int h = 85;
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setColor(Color.black);

        PageFormat pf = new PageFormat();
        pf.setOrientation(PageFormat.PORTRAIT);
        Paper paper = new Paper();
        paper.setSize(226, 85);// 纸张大小
        paper.setImageableArea(10, 5, 200, 72);
        pf.setPaper(paper);
        double x = pf.getImageableX();
        double y = pf.getImageableY();

        font = new Font("宋体", Font.BOLD, 10);
        g2.setFont(font);// 设置字体
        float heigth = font.getSize2D();// 字体高度
        // 标题 第一行

        g2.drawString("凤馨堂广和月子餐", (float) x, (float) y + heigth);
        g2.drawString("凤馨堂广和月子餐", (float) x + right, (float) y + heigth);
        float line = 2 * heigth + first_second;
        g2.scale(1, 1.5);
        font = new Font("宋体", Font.BOLD, 8);
        g2.setFont(font);// 设置字体
        heigth = font.getSize2D();// 字体高度
        // 标题 第一点五行，电话和名字

        g2.drawString("马蓉蓉", (float) x, (float) y + line);
        g2.drawString("13023237878", (float) x + 30, (float) y + line);
        g2.drawString("王宝", (float) x + right, (float) y + line);
        g2.drawString("17877665566", (float) x + right + 30, (float) y + line);
        line += 1.3 * heigth;

        font = new Font("宋体", Font.BOLD, 8);
        g2.setFont(font);// 设置字体
        heigth = font.getSize2D();// 字体高度

        // 第二行：地址
        g2.drawString("妇幼10楼38床", (float) x, (float) y + line);
        g2.drawString("中医药附10楼33床", (float) x + right, (float) y + line);
        line += heigth;

        g2.scale(1, 0.67);
        // 第三行：广告语
        font = new Font("宋体", Font.BOLD, 8);
        g2.setFont(font);// 设置字体
        g2.drawString("科学坐月子、健康一辈子", (float) x, (float) 75);
        g2.drawString("科学坐月子、健康一辈子", (float) x + right, (float) 75);
        try {
            ImageIO.write(img, "PNG", new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) {

        //参数顺序，左边餐点时间，菜品明，右餐时间，菜名明,名字1，电话1，名字2，电话2
        PrintUser("马蓉蓉","13023982321","妇幼10楼38床","王宝","13823894857","中医药附10楼33床");
    }
}
