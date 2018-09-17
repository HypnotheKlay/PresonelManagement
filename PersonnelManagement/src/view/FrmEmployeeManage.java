package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;

import model.Employee;
import service.DepartmentServiceImpl;
import service.EmployeeServiceImpl;

public class FrmEmployeeManage extends JFrame   implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8888214853851606111L;
	// 定义添加界面
	FrmEmployeeAdd fpa = null;
	FrmEmployeeUdate fua=null;
	Department dt=null;
	EmployeeServiceImpl csi = new EmployeeServiceImpl();
	DepartmentServiceImpl dsi=new DepartmentServiceImpl();
	JTable table;
	public int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    public int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    public int windowsWedth = 800;
    public int windowsHeight = 400;
    //public int windowsWedth = 1050;
    //public int windowsHeight = 400;
    
    
	

	public FrmEmployeeManage() {
		// 添加页面实例化
		fpa = new FrmEmployeeAdd();
		fua=new FrmEmployeeUdate();
		dt=new Department();
		JButton buttonadd, buttonclose, buttondelete;
		// 添加删除面板
		final JPanel panel_1 = new JPanel();
		
		panel_1.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1,false));
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setVgap(2);
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.setLayout(flowLayout);
		
	/*	final JPanel panel_2 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.activeCaptionBorder, 1,false));
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		final FlowLayout flowLayout_2 = new FlowLayout();
		flowLayout_2.setVgap(2);
		flowLayout_2.setHgap(30);
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_2.setLayout(flowLayout);
		*/
		
		buttonadd = new JButton();
		buttonadd.addActionListener(new AddActionListener());
		buttonadd.setText("添加员工");
		panel_1.add(buttonadd);
		
		buttondelete = new JButton();
		buttondelete.addActionListener(new DeleteActionListener());
		buttondelete.setText("删除员工");
		panel_1.add(buttondelete);
		
		buttonclose = new JButton();
		buttonclose.addActionListener(new  UpateActionListener());
		buttonclose.setText("修改员工");
		panel_1.add(buttonclose);
		
		buttonclose = new JButton();
		buttonclose.addActionListener(new  DepartmentActionListener());
		buttonclose.setText("部门信息");
		panel_1.add(buttonclose);
		
		buttonclose = new JButton();
		buttonclose.addActionListener(new CloseActionListener());
		buttonclose.setText("退出系统");
		panel_1.add(buttonclose);
		
		
		// 内部类，表模型
		TableModel btm = new TableModel();
		// 生成表控件　
		table = new JTable(btm);
		// 在表上添加鼠标监听
		table.addMouseListener(this);
		table.setFillsViewportHeight(true);
		table.setAutoResizeMode(WIDTH);
		// 用表控件构建滚动面板
		JScrollPane scrollPane = new JScrollPane(table);
		// 获取JFrame容器控件
		JPanel jp = (JPanel) getContentPane();

		// 容器控件中添加滚动面板控件
		jp.add(scrollPane, BorderLayout.CENTER);

		jp.add(panel_1, BorderLayout.NORTH);
		// JFrame外观设置
		setTitle("员工信息管理");
		setSize(800, 600);
		//setSize(1050, 500);
		//
		setBounds((width - windowsWedth) / 2,(height - windowsHeight) / 2, windowsWedth, windowsHeight);
		// JFrame可视化
		setVisible(true);
		
	}
	class TableModel extends AbstractTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3101481166009329580L;
		private List<Employee> data = new EmployeeServiceImpl().findAll();

		@Override
		public int getRowCount() {
			return data.size();
		}

		@Override
		public int getColumnCount() {
			// 根据实际情况返回列数
			return 4;
		}

		@Override
		public String getColumnName(int column) {
			// 根据实际情况返回列名
			if (column == 0)
				return "员工ID";
			else if (column == 1)
				return "姓名";
			else if (column == 2)
				return "职位";
			else if (column == 3)
				return "所属部门";
			return null;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Employee entity = data.get(rowIndex);
			if (columnIndex == 0)
				return entity.getId();
			else if (columnIndex == 1)
				return entity.getName();
			else if (columnIndex == 2)
				return entity.getProfessional();
			else if (columnIndex == 3)
				return entity.getDepartment().getName();
			return null;
		}

		/*public void setData(List<Employee> data) {
			if (data == null)
				throw new IllegalArgumentException("参数data不能为null。");

			this.data = data;

			fireTableDataChanged();
		}
*/
	}

	class AddActionListener implements ActionListener { // 添加添加按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			fpa.setVisible(true);
		}
	}
	
	class CloseActionListener implements ActionListener{//添加关闭按钮的事件监听器
		public void actionPerformed(final ActionEvent e){
			System.exit(0);
		}
	}
	
	class UpateActionListener implements ActionListener { // 添加修改按钮的事监听器
		public void actionPerformed(final ActionEvent e) {
			fua.setVisible(true);
		}
	}
	
	class DepartmentActionListener implements ActionListener { // 添加部门信息按钮的事监听器
		public void actionPerformed(final ActionEvent e) {
			dt.setVisible(true);
		}
	}
	
	class DeleteActionListener implements ActionListener {//添加删除按钮的事件监听器
		public void actionPerformed(final ActionEvent e) {
			int row =table.getSelectedRow();
			int value=(int) table.getValueAt(row,0);
			boolean i=csi.delete(value);
			if(i=true){
				JOptionPane.showMessageDialog(null, "删除成功");
				new FrmEmployeeManage();
				}
			}
	}

	/*class DisposeActionListener implements ActionListener{//添加关闭当前窗口按钮的事件监听器
		public void actionPerformed(final ActionEvent e){
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}*/
	// add frame begin
	class FrmEmployeeAdd extends JFrame {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3786832018649489345L;
		JTextField jTName, jTProfessional,jTPassword;
		JComboBox <String> Department;
		JComboBox <String> Power;
		

		public FrmEmployeeAdd() {
			int width_1 = Toolkit.getDefaultToolkit().getScreenSize().width;
		    int height_1 = Toolkit.getDefaultToolkit().getScreenSize().height;
		    int windowsWedth_1 =410;
		    int windowsHeight_1 = 200;
			setBounds((width_1 - windowsWedth_1) / 2,(height_1 - windowsHeight_1) / 2, windowsWedth_1, windowsHeight_1);
			JPanel mainPanel = new JPanel();
			
			
			setTitle("添加员工信息界面");
			// 名称面板　　
			JPanel jpName = new JPanel();
			JLabel jlName = new JLabel("姓名：");
			jTName = new JTextField(20);
			jpName.add(jlName);
			jpName.add(jTName);
			// 职位面板
			JPanel jpProfessional = new JPanel();
			JLabel jlProfessional = new JLabel("职位：");
			jTProfessional= new JTextField(20);
			jpProfessional.add(jlProfessional);
			jpProfessional.add(jTProfessional);
			//	密码面板
			JPanel jpPassword= new JPanel();
			JLabel jlPassword = new JLabel("密码：");
			jTPassword = new JTextField(20);
			jpPassword.add(jlPassword);
			jpPassword.add(jTPassword);
			// 部门面板
			JPanel jpDepartment = new JPanel();
			JLabel jlDepartment = new JLabel("部门：");
			Department=new JComboBox <String>();
			Department.addItem("网络部");  
			Department.addItem("人力资源部");  
			Department.addItem("秘书部");
			Department.addItem("公关部");  
			jpDepartment.add(jlDepartment);
			jpDepartment.add(Department);
			//	登录权限面板
			JPanel jpPower = new JPanel();
			JLabel jlPower = new JLabel("权限：");
			Power=new JComboBox<String> ();
			Power.addItem("0");  
			Power.addItem("1");   
			jpPower.add(jlPower);
			jpPower.add(Power);
			
			// 添加控件到主面板
			mainPanel.add(jpName);
			mainPanel.add(jpProfessional);
			mainPanel.add(jpPassword);
			mainPanel.add(jpDepartment);
			mainPanel.add(jpPower);
			
			JButton btnSave = new JButton("提交");
			// 提交按钮添加事件监听，内部类完成监听的功能
			btnSave.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 生成对象
					Employee p = new Employee();
					// 填充对象
					p.setName(jTName.getText());
					p.setProfessional(jTProfessional.getText());
					p.setDepartmentID(dsi.findByName(Department.getSelectedItem().toString()).getId());
					String s=Power.getSelectedItem().toString();
					//强制转换
					try {
					    int a = Integer.parseInt(s);
					    p.setPower(a);
					} catch (NumberFormatException ee) {
					    ee.printStackTrace();
					}
					p.setPassword(jTPassword.getText());
					// 添加对象，根据返回值给出提示
					if (csi.insert(p)) {
						JOptionPane.showMessageDialog(null, "添加成功！");
						new FrmEmployeeManage();
					} else {
						JOptionPane.showMessageDialog(null, "添加失败！");
					}
				}
			});
			mainPanel.add(btnSave);
			this.getContentPane().add(mainPanel);
			this.setSize(400, 200);
		}
	} // add frame end
	
	// update frame begin
	class FrmEmployeeUdate extends JFrame{
		/**
		 * 
		 */
		private static final long serialVersionUID = 8185805625656847011L;
		JTextField jTID,jTName, jTProfessional,jTDepartment,jTPower,jTPassword;
		JComboBox <String> Department;
		JComboBox <String> Power;
	    @SuppressWarnings("unchecked")
		public FrmEmployeeUdate(){
	    	setTitle("修改员工信息界面");
	    	int width_2 = Toolkit.getDefaultToolkit().getScreenSize().width;
		    int height_2 = Toolkit.getDefaultToolkit().getScreenSize().height;
		    int windowsWedth_2 =1000;
		    int windowsHeight_2 = 500;
		    setBounds((width_2 - windowsWedth_2) / 2,(height_2 - windowsHeight_2) / 2, windowsWedth_2, windowsHeight_2);
			//
		    final JPanel panel_1 = new JPanel();
		    final FlowLayout flowLayout = new FlowLayout();
			flowLayout.setVgap(2);
			flowLayout.setHgap(30);
			flowLayout.setAlignment(FlowLayout.LEFT);
			panel_1.setLayout(flowLayout);
			
			//编辑框 姓名面板
			JPanel jpID = new JPanel();
			JLabel jlID = new JLabel("员工ID：");
			jTID = new JTextField(5);
			jpID.add(jlID);
			jpID.add(jTID);
			//
			JPanel jpName = new JPanel();
			JLabel jlName = new JLabel("姓名：");
			jTName = new JTextField(5);
			jpName.add(jlName);
			jpName.add(jTName);
			// 职位面板
			JPanel jpProfessional = new JPanel();
			JLabel jlProfessional = new JLabel("职位：");
			jTProfessional= new JTextField(5);
			jpProfessional.add(jlProfessional);
			jpProfessional.add(jTProfessional);
			//	密码面板
			JPanel jpPassword= new JPanel();
			JLabel jlPassword = new JLabel("密码：");
			jTPassword = new JTextField(5);
			jpPassword.add(jlPassword);
			jpPassword.add(jTPassword);
			// 部门面板
			JPanel jpDepartment = new JPanel();
			JLabel jlDepartment = new JLabel("部门：");
			Department=new JComboBox <String>();
			Department.addItem("网络部");  
			Department.addItem("人力资源部");  
			Department.addItem("秘书部");
			Department.addItem("公关部");  
			jpDepartment.add(jlDepartment);
			jpDepartment.add(Department);
			//	登录权限面板
			JPanel jpPower = new JPanel();
			JLabel jlPower = new JLabel("权限：");
			Power=new JComboBox<String> ();
			Power.addItem("0");  
			Power.addItem("1");   
			jpPower.add(jlPower);
			jpPower.add(Power);
			
			panel_1.add(jpID);
			panel_1.add(jpName);
			panel_1.add(jpProfessional);
			panel_1.add(jpPassword);
			panel_1.add(jpDepartment);
			panel_1.add(jpPower);
			
			
			//
			
			JButton buttonadd = new JButton("提交");
			// 提交按钮添加事件监听，内部类完成监听的功能
			buttonadd.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 生成对象
					Employee p = new Employee();
					// 填充对象
					String s1=jTID.getText();
					try {
					    int a = Integer.parseInt(s1);
					    p.setId(a);								//setID
					} catch (NumberFormatException ee) {
					    ee.printStackTrace();
					}
					p.setName(jTName.getText());				//setName
					p.setProfessional(jTProfessional.getText());//setProfessional
					p.setDepartmentID(dsi.findByName(Department.getSelectedItem().toString()).getId());//setDepartmentID
					String s=Power.getSelectedItem().toString();
					//强制转换
					try {
					    int a = Integer.parseInt(s);
					    p.setPower(a);//setPower
					} catch (NumberFormatException ee) {
					    ee.printStackTrace();
					}
					p.setPassword(jTPassword.getText());
					// 添加对象，根据返回值给出提示
					if (csi.update(p)) {
						JOptionPane.showMessageDialog(null, "修改成功！");
						new FrmEmployeeManage();
					} else {
						JOptionPane.showMessageDialog(null, "修改失败！");
					}
				}
			});
			panel_1.add(buttonadd);
			
			// 获取JFrame容器控件
			JPanel jp = (JPanel) getContentPane();
			
		    //生成列表
		    Vector columnNames; 
			columnNames=new Vector();  
            //设置列名  
            columnNames.add("员工ID");  
            columnNames.add("名字");  
            columnNames.add("职位");
            columnNames.add("所属部门");
            columnNames.add("登录权限");  
            columnNames.add("密码");
            
			JTable jt=null;  
		    JScrollPane jsp=null;
		    
		    Vector rowData= new EmployeeServiceImpl().findAll_vector();
		    
		    jt = new JTable(rowData,columnNames); //表
		    jsp = new JScrollPane(jt);  //滚动面板
		    
		    // 容器控件中添加滚动面板控件
		    jp.add(jsp, BorderLayout.CENTER);
		    //	容器控件中添加按钮控件
		 	jp.add(panel_1, BorderLayout.SOUTH); 
		    setSize(1050, 500);  
		}
	}
	
	class Department extends JFrame{
		public Department(){
			setTitle("部门信息管理界面");
	    	int width_2 = Toolkit.getDefaultToolkit().getScreenSize().width;
		    int height_2 = Toolkit.getDefaultToolkit().getScreenSize().height;
		    int windowsWedth_2 =800;
		    int windowsHeight_2 = 400;
		    setBounds((width_2 - windowsWedth_2) / 2,(height_2 - windowsHeight_2) / 2, windowsWedth_2, windowsHeight_2);
		    Vector columnNames; 
			columnNames=new Vector();  
            //设置列名  
            columnNames.add("部门ID");  
            columnNames.add("部门名");  
            columnNames.add("部门负责人");
        	JTable jt=null;  
		    JScrollPane jsp=null;
		    Vector rowData=new DepartmentServiceImpl().findAll_vector();
		    jt = new JTable(rowData,columnNames); 
		    jsp = new JScrollPane(jt);  
		    add(jsp);  
		    setSize(800, 400);  
		}
	}
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}
	public void mouseClicked(MouseEvent e) {
		/*int row = table.getSelectedRow();
		int col = table.getSelectedColumn();
		Object value = table.getValueAt(row, col);
		JOptionPane.showMessageDialog(null, value);*/
	}

	public void mouseEmployeeed(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根

	}
}// FrmEmployeeManage