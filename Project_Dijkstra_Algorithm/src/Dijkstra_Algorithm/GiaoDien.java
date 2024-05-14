package Dijkstra_Algorithm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import javax.swing.ScrollPaneConstants;
import java.awt.Window.Type;

public class GiaoDien extends JFrame {

	/**
	 * Phạm Mạnh Trung Nguyên
	 * 1800000521
	 * 18DTH1A
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblDauVao;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien frame = new GiaoDien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GiaoDien() {
		setType(Type.POPUP);
		setResizable(false);
		setTitle("Thuật toán Dijkstra");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 833);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		// Panel
		JPanel pnlThaoTac = new JPanel();
		pnlThaoTac.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlThaoTac.setBounds(10, 10, 172, 696);
		contentPane.add(pnlThaoTac);
		pnlThaoTac.setLayout(null);
		
		JPanel pnlDauVao = new JPanel();
		pnlDauVao.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlDauVao.setBounds(192, 10, 884, 696);
		contentPane.add(pnlDauVao);
		pnlDauVao.setLayout(null);
		
		JPanel pnlDauRa = new JPanel();
		pnlDauRa.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlDauRa.setBounds(10, 716, 1066, 79);
		contentPane.add(pnlDauRa);
		pnlDauRa.setLayout(null);
		
		// Label
		JLabel lblDinh = new JLabel("Số đỉnh:");
		lblDinh.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDinh.setBounds(10, 10, 100, 45);
		pnlThaoTac.add(lblDinh);
		
		JLabel lblLoaiDoThi = new JLabel("Loại đồ thị:");
		lblLoaiDoThi.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblLoaiDoThi.setBounds(10, 50, 130, 36);
		pnlThaoTac.add(lblLoaiDoThi);
		
		JLabel lblNhapDinh = new JLabel("Đỉnh tới Đỉnh");
		lblNhapDinh.setBounds(10, 170, 155, 40);
		pnlThaoTac.add(lblNhapDinh);
		lblNhapDinh.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblTrongSo = new JLabel("Trọng số:");
		lblTrongSo.setBounds(10, 250, 113, 40);
		pnlThaoTac.add(lblTrongSo);
		lblTrongSo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		// Spinner
		JSpinner snrDinh = new JSpinner();
		snrDinh.setToolTipText("Nhập số đỉnh (từ 3 đến 16)");
		snrDinh.setModel(new SpinnerNumberModel(3, 3, 16, 1));
		snrDinh.setFont(new Font("Tahoma", Font.PLAIN, 25));
		snrDinh.setBounds(105, 13, 61, 32);
		pnlThaoTac.add(snrDinh);
		
		// Table
		tblDauVao = new JTable();
		tblDauVao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblDauVao.setFont(new Font("Tahoma", Font.PLAIN, 25));
		tblDauVao.setBackground(Color.LIGHT_GRAY);
		tblDauVao.setRowHeight(40);
		tblDauVao.setBounds(10, 10, 864, 676);
		pnlDauVao.add(tblDauVao);
		
		// Radio Button
		JRadioButton rdbtnCoHuong = new JRadioButton("Có hướng");
		rdbtnCoHuong.setToolTipText("Đồ thị có hướng (Giữa 2 đỉnh có thể có 2 trọng số)");
		rdbtnCoHuong.setSelected(true);
		rdbtnCoHuong.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnCoHuong.setBounds(10, 90, 135, 35);
		pnlThaoTac.add(rdbtnCoHuong);
		
		JRadioButton rdbtnVoHuong = new JRadioButton("Vô hướng");
		rdbtnVoHuong.setToolTipText("Đồ thị vô hướng (Giữa 2 đỉnh chỉ có một trọng số)");
		rdbtnVoHuong.setSelected(true);
		rdbtnVoHuong.setFont(new Font("Tahoma", Font.PLAIN, 25));
		rdbtnVoHuong.setBounds(10, 130, 135, 35);
		pnlThaoTac.add(rdbtnVoHuong);
		
		ButtonGroup bg = new ButtonGroup();
        bg.add(rdbtnCoHuong);
        bg.add(rdbtnVoHuong);
        
	     // Text field
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(999);
	    formatter.setAllowsInvalid(false);
	    formatter.setCommitsOnValidEdit(true);
		JFormattedTextField txtTrongSo = new JFormattedTextField(formatter);
		txtTrongSo.setText("0");
		txtTrongSo.setBounds(10, 290, 150, 30);
		pnlThaoTac.add(txtTrongSo);
		txtTrongSo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTrongSo.setToolTipText("Từ 1 đến 999 (Nhập 0 để xóa cạnh)");
		txtTrongSo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtTrongSo.setColumns(10);
		
		// Text Area
		JTextArea txtDauRa = new JTextArea();
		txtDauRa.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtDauRa.setForeground(Color.DARK_GRAY);
		txtDauRa.setEditable(false);
		txtDauRa.setBounds(10, 10, 1046, 59);
		pnlDauRa.add(txtDauRa);
		
		// Scroll Pane
		JScrollPane speThanhTruot = new JScrollPane(txtDauRa, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		speThanhTruot.setLocation(0, 0);
		speThanhTruot.setSize(1066, 79);
		pnlDauRa.add(speThanhTruot);
		
		// Combo Box
		JComboBox<String> cbxNhapBatDau = new JComboBox<String>();
		cbxNhapBatDau.setToolTipText("Đỉnh bắt đầu");
		cbxNhapBatDau.setBounds(10, 210, 50, 30);
		pnlThaoTac.add(cbxNhapBatDau);
		cbxNhapBatDau.setModel(new DefaultComboBoxModel<String>(new String[] {"A", "B", "C"}));
		cbxNhapBatDau.setSelectedIndex(0);
		cbxNhapBatDau.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbxNhapBatDau.setMaximumRowCount(5);
		
		JComboBox<String> cbxNhapKetThuc = new JComboBox<String>();
		cbxNhapKetThuc.setToolTipText("Đỉnh kết thúc");
		cbxNhapKetThuc.setBounds(105, 210, 50, 30);
		pnlThaoTac.add(cbxNhapKetThuc);
		cbxNhapKetThuc.setModel(new DefaultComboBoxModel<String>(new String[] {"A", "B", "C"}));
		cbxNhapKetThuc.setSelectedIndex(1);
		cbxNhapKetThuc.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbxNhapKetThuc.setMaximumRowCount(5);
		
		// Button
		JButton btnLuu = new JButton("Cập nhập");
		btnLuu.setToolTipText("Cập nhập trọng số của cạnh");
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLuu.setBounds(10, 330, 150, 50);
		pnlThaoTac.add(btnLuu);
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setToolTipText("Làm mới bảng dữ liệu");
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLamMoi.setBounds(10, 510, 150, 50);
		pnlThaoTac.add(btnLamMoi);
		
		JButton btnTinh = new JButton("Duyệt tới");
		btnTinh.setToolTipText("Chọn đỉnh để duyệt");
		btnTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTinh.setBounds(10, 390, 150, 50);
		pnlThaoTac.add(btnTinh);
		
		JButton btnTinhTatCa = new JButton("Duyệt tất cả");
		btnTinhTatCa.setToolTipText("Duyệt qua tất cả các đỉnh");
		btnTinhTatCa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTinhTatCa.setBounds(10, 450, 150, 50);
		pnlThaoTac.add(btnTinhTatCa);
		
		JButton btnLuuFlie = new JButton("Lưu Flie");
		btnLuuFlie.setToolTipText("Lưu thông tin đồ thị thành File txt");
		btnLuuFlie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLuuFlie.setBounds(10, 570, 150, 50);
		pnlThaoTac.add(btnLuuFlie);
		
		JButton btnMoFlie = new JButton("Mở Flie");
		btnMoFlie.setToolTipText("Mở File txt");
		btnMoFlie.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMoFlie.setBounds(10, 630, 150, 50);
		pnlThaoTac.add(btnMoFlie);
//// END ////
		
		// Cập nhập bảng ban đầu
		capNhapBang(snrDinh, tblDauVao);
		
//// Event ////	
		// Thay đổi dữ liệu theo số đỉnh
		snrDinh.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {				
				capNhapHopDuLieu(snrDinh, cbxNhapBatDau, cbxNhapKetThuc);
								
				capNhapBang(snrDinh, tblDauVao);
						
				txtDauRa.setText("");
			}
		});

		// Đảm bảo dữ liệu giữa 2 đỉnh
		rdbtnVoHuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.showConfirmDialog (null, "Bảng dữ liệu sẽ bị xóa để đảm bảo sự trùng lập dữ liệu! bạn chắc chứ?",
						"Cảnh báo!", JOptionPane.YES_NO_OPTION);
				if (dialogButton == JOptionPane.YES_OPTION)
					capNhapBang(snrDinh, tblDauVao);
				else
					rdbtnCoHuong.setSelected(true);			
			}
		});
		
		// Thêm trọng số vào các cạnh
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tblModel = (DefaultTableModel) tblDauVao.getModel();
				if (cbxNhapKetThuc.getSelectedIndex() == cbxNhapBatDau.getSelectedIndex())
					JOptionPane.showMessageDialog(null, "Đỉnh đầu không được trùng đỉnh sau!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
				else
					if (Integer.valueOf(txtTrongSo.getText()) == 0)
						tblModel.setValueAt(null, cbxNhapBatDau.getSelectedIndex() + 1, cbxNhapKetThuc.getSelectedIndex() + 1);
					else
						tblModel.setValueAt(txtTrongSo.getText(), cbxNhapBatDau.getSelectedIndex() + 1, cbxNhapKetThuc.getSelectedIndex() + 1);
				if (rdbtnVoHuong.isSelected())
					if (Integer.valueOf(txtTrongSo.getText()) == 0)
						tblModel.setValueAt(null, cbxNhapKetThuc.getSelectedIndex() + 1, cbxNhapBatDau.getSelectedIndex() + 1);
					else
						tblModel.setValueAt(txtTrongSo.getText(), cbxNhapKetThuc.getSelectedIndex() + 1, cbxNhapBatDau.getSelectedIndex() + 1);
			}
		});
		
		// Làm mới bảng dữ liệu
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDauRa.setText("Đang làm mới dữ liệu...");
				int dialogButton = JOptionPane.showConfirmDialog (null, "Bảng dữ liệu sẽ bị xóa sạch dữ liệu! bạn chắc chứ?", "Cảnh báo!", JOptionPane.YES_NO_OPTION);
				if (dialogButton == JOptionPane.YES_OPTION) {
					capNhapBang(snrDinh, tblDauVao);
					txtDauRa.setText("Làm mới dữ liệu thành công!");
				} else
					txtDauRa.setText("Làm mới dữ liệu thất bại!");
			}
		});
		
		// Tính tới đỉnh cuối đã chọn
		btnTinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				Dinh[] dsDinh = capNhapDuLieu(snrDinh, tblDauVao);
				ThuatToanDijkstra dijkstra = new ThuatToanDijkstra();		
				dijkstra.duongDiNganNhat(dsDinh[cbxNhapBatDau.getSelectedIndex()]);
				txtDauRa.setText(xuatKetQua(dsDinh, cbxNhapBatDau.getSelectedIndex(), cbxNhapKetThuc.getSelectedIndex(), dijkstra));
			}
		});
		
		// Duyệt qua tất cả các đỉnh
		btnTinhTatCa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dinh[] dsDinh = capNhapDuLieu(snrDinh, tblDauVao);
				ThuatToanDijkstra dijkstra = new ThuatToanDijkstra();
				dijkstra.duongDiNganNhat(dsDinh[cbxNhapBatDau.getSelectedIndex()]);
				String KetQua = "";
		        for (int i = 0; i <= (int) snrDinh.getValue() - 1; i++)
		        	if (i != cbxNhapBatDau.getSelectedIndex())
		        		KetQua += xuatKetQua(dsDinh, cbxNhapBatDau.getSelectedIndex(), i, dijkstra) + "\n";
		        txtDauRa.setText(KetQua);
			}
		});

		// Xuất File
		btnLuuFlie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = chonFile();
				xuatFile(txtDauRa, tblDauVao, snrDinh, file);
			}
		});
				
		// Mở File
		btnMoFlie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = chonFile();
				moFile(txtDauRa, tblDauVao, snrDinh, file);
			}
		});
					

//// END ////
	}
	
//// Function ////	
	// Cập nhập dữ liệu 2 hộp xổ dữ liệu
	public static void capNhapHopDuLieu(JSpinner snrDinh, JComboBox<String> cbxNhapBatDau, JComboBox<String> cbxNhapKetThuc) {
		String[] cbxList = new String[(int) snrDinh.getValue()];
		for (int i = 0; i < (int) snrDinh.getValue(); i++)
			cbxList[i] = Character.toString((char) (i + 65));
		cbxNhapBatDau.setModel(new DefaultComboBoxModel<String>(cbxList));
		cbxNhapKetThuc.setModel(new DefaultComboBoxModel<String>(cbxList));
		cbxNhapKetThuc.setSelectedIndex(1);
	}
	
	// Cập nhập dữ liệu bảng
	public static void capNhapBang(JSpinner snrDinh, JTable tblDauVao) {
		DefaultTableCellRenderer dtbl = new DefaultTableCellRenderer();
		dtbl.setHorizontalAlignment(JLabel.CENTER);
		String[][] tblList = new String[(int) snrDinh.getValue() + 1][(int) snrDinh.getValue() + 1];
		for (int i = 1; i <= (int) snrDinh.getValue(); i++) {
			tblList[0][i] = Character.toString((char) (i + 64));
			tblList[i][0] = Character.toString((char) (i + 64));
			for (int j = 1; j <= (int) snrDinh.getValue(); j++)
				if (i == j)
					tblList[i][j] = "0";
		}
		tblDauVao.setModel(new DefaultTableModel(tblList, tblList[0]) {
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			});
		for (int i = 0; i <= (int) snrDinh.getValue(); i++)
			tblDauVao.getColumnModel().getColumn(i).setCellRenderer(dtbl);
	}
	
	// Đổ dữ liệu vào để tính toán
	public static Dinh[] capNhapDuLieu(JSpinner snrDinh, JTable tblDauVao) {
		Dinh[] dsDinh = new Dinh[(int) snrDinh.getValue()];
		for (int i = 0; i < (int) snrDinh.getValue(); i++)
			dsDinh[i] = new Dinh(String.valueOf((char) (i + 65)));
		for (int i = 0; i < (int) snrDinh.getValue(); i++)
			for (int j = 0; j < (int) snrDinh.getValue(); j++)
				if (tblDauVao.getValueAt(i + 1, j + 1) != null)
					dsDinh[i].themCanh(new Canh(Integer.valueOf((String) tblDauVao.getValueAt(i + 1, j + 1)), dsDinh[i], dsDinh[j]));
		return dsDinh;
	}

	// Xuất kết quả
	public static String xuatKetQua(Dinh[] dsDinh, int batDau, int ketThuc, ThuatToanDijkstra dijkstra) {
		 if (dsDinh[ketThuc].getTongTrongSo() != Integer.MAX_VALUE)
			 return ("Từ đỉnh " + (char) (batDau + 65) + " đến đỉnh " + (char) (ketThuc + 65) + " có khoảng cách là: " + dsDinh[ketThuc].getTongTrongSo() 
					 + "; Đường đi như sau: " + dijkstra.layDuongDiNganNhat(dsDinh[ketThuc]));
       else
	        return ("Từ đỉnh " + (char) (batDau + 65) + " đến đỉnh " + (char) (ketThuc + 65) + " không có đường để di chuyển!");
	}
	
	// Chọn File
	public static File chonFile() {
		String filePatch = System.getProperty("user.dir");
		JFileChooser chonFile = new JFileChooser(new File (filePatch));
		chonFile.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("File văn bản", "txt");
        chonFile.addChoosableFileFilter(filter);
		int chon = chonFile.showDialog(null, "Chọn");
		if (chon == JFileChooser.APPROVE_OPTION)
			filePatch = chonFile.getSelectedFile().getAbsolutePath();
		File file = new File(filePatch);
		return file;
	}

	// Xuất File
	public static void xuatFile(JTextArea txtDauRa, JTable tblDauVao, JSpinner snrDinh, File file) {
		try {
			txtDauRa.setText("Đang lưu File...");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < tblDauVao.getRowCount(); i++) {
				for (int j = 0; j < tblDauVao.getColumnCount(); j++)
					if (j == tblDauVao.getRowCount() - 1)
						if (tblDauVao.getValueAt(i, j) != null)
							bw.write(tblDauVao.getValueAt(i, j).toString());
						else
							bw.write("*");
					else
						if (tblDauVao.getValueAt(i, j) != null)
							bw.write(tblDauVao.getValueAt(i, j).toString() + " ");
						else
							bw.write("* ");
				bw.newLine();
			}
			bw.close();
			fw.close();
			txtDauRa.setText("Lưu File thành công!"
			+ "\nFlie được lưu tại: " + file.getAbsolutePath());
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Không thể xuất File!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
			txtDauRa.setText("Lưu File thất bại!");
		}
	}
	
	// Mở File
	public static void moFile(JTextArea txtDauRa, JTable tblDauVao, JSpinner snrDinh, File file) {
		try {
			txtDauRa.setText("Đang mở File...");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			DefaultTableModel model = (DefaultTableModel) tblDauVao.getModel();	
			Object[] hang = br.lines().toArray();
			if ((int) snrDinh.getValue() != hang.length - 1) {
				snrDinh.setValue(hang.length - 1);
				moFile(txtDauRa, tblDauVao, snrDinh, file);
			}
			else {
				for (int i = (int) snrDinh.getValue(); i >= 0; i--)
					model.removeRow(i);
				DefaultTableCellRenderer dtbl = new DefaultTableCellRenderer();
				dtbl.setHorizontalAlignment(JLabel.CENTER);
				String[][] tblList = new String[(int) snrDinh.getValue() + 1][(int) snrDinh.getValue() + 1];
				for (int i = 1; i <= (int) snrDinh.getValue(); i++) {
					tblList[0][i] = Character.toString((char) (i + 64));
					tblList[i][0] = Character.toString((char) (i + 64));
					for (int j = 1; j <= (int) snrDinh.getValue(); j++) {
						String[] cot = hang[i].toString().split(" ");
						if (!cot[j].equals("*"))
							tblList[i][j] = cot[j];
					}
				}
				tblDauVao.setModel(new DefaultTableModel(tblList, tblList[0]) {
						public boolean isCellEditable(int row, int column) {
							return false;
						}
					});
				for (int i = 0; i <= (int) snrDinh.getValue(); i++)
					tblDauVao.getColumnModel().getColumn(i).setCellRenderer(dtbl);
				br.close();
				fr.close();
				txtDauRa.setText("Mở File thành công!"
				+ "\nFlie được mở tại: " + file.getAbsolutePath());
			}
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy File hoặc File không đúng!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
			txtDauRa.setText("Mở File thất bại!");
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "Lỗi không xác định khi mở file!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
			txtDauRa.setText("Mở File thất bại!");
		}
	}
//// END ////	
}
