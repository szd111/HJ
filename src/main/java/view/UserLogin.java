package view;



import controller.LoginController;
import controller.factory.ControllerFactory;
import model.entity.User;

import util.FontTools;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * @创建人 shizhendong
 * @创建时间 2018/9/26
 * @描述 这是登录界面，进行系统登录用的
 */

public class UserLogin extends JDialog implements ActionListener{

	/**
	 * @param args
	 */
	JLabel jl1,jl2,jl3;
	JTextField jname;
	JPasswordField jpass;
	JButton jconfirm,jcancel;
	//Font f1=new Font("宋体", Font.PLAIN, 16);
	//Font f2=new Font("黑体", Font.ITALIC, 12);
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {

				//此处设置皮肤和主题

				try {

					UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceBusinessBlackSteelLookAndFeel");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}

				// 另外如果想让整体界面变得协调，最好设置容器窗体的DefaultLookAndFeelDecorated属性为true。

				JFrame.setDefaultLookAndFeelDecorated(true);

				JDialog.setDefaultLookAndFeelDecorated(true);

				UserLogin ul=new UserLogin();

			}});



	}
	public UserLogin(){
		Container ct=this.getContentPane();
		this.setLayout(null);
		jl1=new JLabel("请输入用户名:");
		jl1.setFont(FontTools.f1);
		jl1.setBounds(60, 190, 150, 30);
		ct.add(jl1);
		jname=new JTextField(20);
		jname.setFont(FontTools.f1);
		jname.setBounds(180, 190, 120, 30);
		jname.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jname);
		
		jl2=new JLabel("(用户Id)");
		jl2.setFont(FontTools.f2);
		jl2.setForeground(Color.red);
		jl2.setBounds(100, 210, 100, 30);
		ct.add(jl2);
		
		jl3=new JLabel("请 输入密 码 :");
		jl3.setFont(FontTools.f1);
		jl3.setBounds(60, 240, 150, 30);
		ct.add(jl3);
		jpass=new JPasswordField(20);
		jpass.setFont(FontTools.f1);
		jpass.setBounds(180, 240, 120, 30);
		jpass.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jpass);
		
		jconfirm=new JButton("确定");
		jconfirm.addActionListener(this);
		jconfirm.setFont(FontTools.f1);
		jconfirm.setBounds(110, 300, 70, 30);
		ct.add(jconfirm);
		
		jcancel=new JButton("取消");
		jcancel.addActionListener(this);
		jcancel.setFont(FontTools.f1);
		jcancel.setBounds(210, 300, 70, 30);
		ct.add(jcancel);
		BackImage bi=new BackImage();
		bi.setBounds(0, 0, 360, 360);
		//this.add(bi);
		ct.add(bi);
		this.setUndecorated(true);
		this.setSize(370, 390);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200, height/2-200);
		this.setVisible(true);

	}
//	内部类 放图片
	public class BackImage extends JPanel{
		Image img;
		public BackImage()
		{
			try {
				img=ImageIO.read(new File("src/main/resources/image/login.png"));
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		public void paintComponent(Graphics g)
		{
			g.drawImage(img, 0, 0, 360, 360,this);
		}
	}
	//响应登录请求
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		ControllerFactory cf=new ControllerFactory();
		if(e.getSource()==jconfirm)
		{
			String uid=this.jname.getText().trim();
			String p=new String(this.jpass.getPassword());
			User u=new User();
			u.setName(uid);
			u.setPassword(p);
//			System.out.println(u);

			String zhiwei=uid;

			LoginController lg= (LoginController) cf.getConTrollers("Login");

			int flag=lg.loginController(u);

			if(flag==1)
			{

				new Windows();
				
				this.hide();
				String welcome="欢迎您--"+zhiwei;
				JOptionPane.showMessageDialog(this, welcome);
				this.dispose();
			}
			else 
			{
				JOptionPane.showMessageDialog(this, "对不起！您的权限不足无法登陆！");
			}
			

		}
		else if(e.getSource()==jcancel)
			
		{
			
			//当点击取消按钮时，关闭登陆框，退出系统
			this.dispose();
		}
		
	}


}
