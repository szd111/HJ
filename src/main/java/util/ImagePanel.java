package util;

import javax.swing.*;
import java.awt.*;


/**
 * @创建人 shizhendong
 * @创建时间 2018/9/26
 * @描述 这是图片面板 用于加载图片用的
 */

public class ImagePanel extends JPanel{

Image img;
public ImagePanel(Image img)
{
	this.img=img;
	int width=Toolkit.getDefaultToolkit().getScreenSize().width;
	int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	this.setSize(width,height);
}
public void paintComponent(Graphics g)
{
	super.paintComponent(g);
	g.drawImage(img, 0,0, this.getWidth(), this.getHeight(),this);
}
}
