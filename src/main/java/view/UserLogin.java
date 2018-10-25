package view;



import controller.LoginController;
import controller.factory.ControllerFactory;
import model.MyProgressBar;
import model.entity.User;

import thread.LoadDataThread;
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

	JLabel jl1,jl2,jl3,jl4,jl5;
	JTextField jname;
	JPasswordField jpass;
	JButton jconfirm,jcancel;
	JCheckBox checkBox1,checkBox2;
	JProgressBar JProgressBar;

	//Font f1=new Font("宋体", Font.PLAIN, 16);
	//Font f2=new Font("黑体", Font.ITALIC, 12);
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		EventQueue.invokeLater(new Runnable() {


			public void run() {

				//此处设置皮肤和主题

				try {

					UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");

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
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		jl1=new JLabel("请输入用户名:");
		jl1.setFont(FontTools.f1);
		jl1.setBounds(width/2-500, height/2-270, 150, 30);
		jl1.setFont(FontTools.f5);
		ct.add(jl1);
		jname=new JTextField(20);
		jname.setFont(FontTools.f1);
		jname.setBounds(width/2-350, height/2-270, 150, 30);
		//jname.setBorder(BorderFactory.createLineBorder(new Color(255,255,255),3,true));
		//jname.setBorder(new RoundBorder(Color.BLUE));
		ct.add(jname);

		jl2=new JLabel("(用户Id)");
		jl2.setFont(FontTools.f2);
		jl2.setForeground(Color.red);
		jl2.setBounds(width/2-500, height/2-300, 150, 30);
		ct.add(jl2);

		jl3=new JLabel("请 输入密 码 :");
		jl3.setFont(FontTools.f5);
		jl3.setBounds(width/2-500, height/2-230, 150, 30);
		ct.add(jl3);
		jpass=new JPasswordField(20);
		jpass.setFont(FontTools.f1);
		jpass.setBounds(width/2-350, height/2-230, 150, 30);
		jpass.setBorder(BorderFactory.createLoweredBevelBorder());
		ct.add(jpass);

		checkBox1=new JCheckBox();
		checkBox1.setBounds(width/2-400,height/2-190,18,18);
		checkBox1.addActionListener(this);
		ct.add(checkBox1);
		jl4=new JLabel("审核");
		jl4.setBounds(width/2-370,height/2-190,100,20);
		ct.add(jl4);

		checkBox2=new JCheckBox();
		checkBox2.setBounds(width/2-300,height/2-190,18,18);
		checkBox2.addActionListener(this);
		ct.add(checkBox2);
		jl5=new JLabel("不审核");
		jl5.setBounds(width/2-270,height/2-190,100,20);
		ct.add(jl5);

		jconfirm=new JButton("确定");
		jconfirm.addActionListener(this);
		jconfirm.setFont(FontTools.f1);
		jconfirm.setBounds(width/2-370, height/2-150, 70, 30);
		ct.add(jconfirm);

		jcancel=new JButton("取消");
		jcancel.addActionListener(this);
		jcancel.setFont(FontTools.f1);
		jcancel.setBounds(width/2-270, height/2-150, 70, 30);
		ct.add(jcancel);
		BackImage bi=new BackImage();

		/*JProgressBar = new JProgressBar();
		JProgressBar.setIndeterminate(true); // 不确定的进度条
		JProgressBar.setString("正在加载数据...");
		JProgressBar.setBounds(730,500,140,30);

		ct.add(JProgressBar);
		JProgressBar.setVisible(false);*/


		//this.add(bi);
		ct.add(bi);
		this.setUndecorated(true);
		//this.setSize(1100, 800);

		this.setSize(width - 850, height - 440);
		bi.setBounds(0,0,this.getWidth(), this.getHeight());

		this.setLocation(width/2-200, height/2-200);
		this.setResizable(false);
		this.setVisible(true);

	}
//	内部类 放图片
	public class BackImage extends JPanel{
		Image img;
		public BackImage()
		{
			try {
				img=ImageIO.read(new File("src/main/resources/image/background02.jpg"));

			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		public void paintComponent(Graphics g)
		{
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(),this);

		}
	}
	//响应登录请求
	@Override
	public void actionPerformed(ActionEvent e) {

		// TODO 自动生成的方法存根
		ControllerFactory cf=new ControllerFactory();

		LoginController lc=new LoginController();
		if(e.getSource()==jconfirm)
		{

			String uid=this.jname.getText().trim();
			if(uid==null){

			}

			String p=new String(this.jpass.getPassword());
			User u=new User();
			u.setName(uid);
			u.setPassword(p);
//			System.out.println(u);

			if(checkBox1.isSelected()){
				String check=jl4.getText();
				lc.checkAut(check);
			}else if(checkBox2.isSelected()){
				String noCheck=jl5.getText();
				lc.checkAut(noCheck);
			}

			String zhiwei=uid;

			LoginController lg= (LoginController) cf.getConTrollers("Login");

			//int flag=lg.loginController(u);
			int flag=1;
			if(flag==1)
			{

				/*new Windows();*/
				MyProgressBar br=new MyProgressBar();
				Thread th=new Thread(br);
				th.start();
				//String welcome="欢迎您--"+zhiwei;
				//JOptionPane.showMessageDialog(this, welcome);

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
