import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

//实现Printable接口 用于创建打印内容
public class UserTicket implements Printable {
    private String name1;
    private String tel1;
    private String addr1;
    private String name2;
    private String tel2;
    private String addr2;
    private Font font;

    public UserTicket(String name1, String tel1, String addr1, String name2,
                      String tel2, String addr2) {
        super();
        this.name1 = name1;
        this.tel1 = tel1;
        this.addr1 = addr1;
        this.name2 = name2;
        this.tel2 = tel2;
        this.addr2 = addr2;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        int right = 115;        //右边一张距离左边的距离
        int first_second = 0;   //第一行与第二行的距离
        // 转换成Graphics2D 拿到画笔
        Graphics2D g2 = (Graphics2D) graphics;
        // 设置打印颜色为黑色
        g2.setColor(Color.black);

        // 打印起点坐标
        double x = pageFormat.getImageableX();
        double y = pageFormat.getImageableY();
        // 设置打印字体（字体名称、样式和点大小）（字体名称可以是物理或者逻辑名称）
        font = new Font("宋体", Font.BOLD, 10);
        g2.setFont(font);// 设置字体
        float heigth = font.getSize2D();// 字体高度
        // 标题 第一行

        g2.drawString("凤馨堂广和月子餐", (float) x, (float) y + heigth);
        g2.drawString("凤馨堂广和月子餐", (float) x + right, (float) y + heigth);
        float line = 2 * heigth + first_second;
        g2.scale(1, 1.5);            //对接下来的内容（字体）进行拉高
        font = new Font("宋体", Font.BOLD, 8);
        g2.setFont(font);// 设置字体
        heigth = font.getSize2D();// 字体高度
        // 标题 第一点五行，电话和名字

        g2.drawString(name1, (float) x, (float) y + line);
        g2.drawString(tel1, (float) x + 30, (float) y + line);
        g2.drawString(name2, (float) x + right, (float) y + line);
        g2.drawString(tel2, (float) x + right + 30, (float) y + line);
        line += 1.3 * heigth;

        font = new Font("宋体", Font.BOLD, 8);
        g2.setFont(font);// 设置字体
        heigth = font.getSize2D();// 字体高度

        // 第二行：地址
        g2.drawString(addr1, (float) x, (float) y + line);
        g2.drawString(addr2, (float) x + right, (float) y + line);
        line += heigth;

        g2.scale(1, 0.67);              //将比例还原
        // 第三行：广告语
        font = new Font("宋体", Font.BOLD, 8);
        g2.setFont(font);// 设置字体
        g2.drawString("科学坐月子、健康一辈子", (float) x, (float) 75);
        g2.drawString("科学坐月子、健康一辈子", (float) x + right, (float) 75);
        switch (pageIndex) {
            case 0:
                return PAGE_EXISTS;
            default:
                return NO_SUCH_PAGE;

        }
    }
}
