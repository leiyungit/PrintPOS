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
}
