package com.ssafy.rent.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ssafy.rent.model.dto.ComDeal;
import com.ssafy.rent.model.service.ComService;
import com.ssafy.rent.model.service.ComServiceImpl;

public class ComInfoView {
	//model
	private ComService comService;

	/** main 화면 */
	private JFrame frame;
	
	//상세정보
	private JLabel[] 			comInfoL;
	
	//조회내용
	private DefaultTableModel 	comModel;
	private JTable			  	comTable;
	private JScrollPane		  	comPan;
	private String[]		  	title = { "번호", "동", "상호명", "도로명주소", "업종" };
	
	/**화면에 표시하고 있는 주택*/
	private ComDeal curCom;
	
	private void showComInfo(int code) {
		curCom = comService.search(code);
		System.out.println(curCom);
		
		comInfoL[0].setText("");
		comInfoL[1].setText("");
		comInfoL[2].setText(curCom.getComName());
		comInfoL[3].setText(""+curCom.getGu());
		comInfoL[4].setText(""+curCom.getDong());
		comInfoL[5].setText(""+curCom.getAddr());
		comInfoL[6].setText(curCom.getFloor()+"층");
		comInfoL[7].setText(curCom.getMidKind()+"");
		comInfoL[8].setText(curCom.getSmallKind()+"");
	}
	
	public ComInfoView() {
		comService=new ComServiceImpl();
		
		frame=new JFrame("WhereIsMycom -- 서울시 상권 정보");
		
		setMain();
		
		frame.setSize(1200, 800);
		frame.setResizable(true);
		frame.setVisible(true);
		showComInfo(1);
	}
	
	public ComInfoView(String dong) {
		comService=new ComServiceImpl(dong);
		
		frame=new JFrame("WhereIsMycom -- "+dong+" 상권 정보");
		
		setMain();
		
		frame.setSize(1200, 800);
		frame.setResizable(true);
		frame.setVisible(true);
		showComInfo(1);
	}
	
	public void setMain(){
		
		//왼쪽 화면
		JPanel left = new JPanel(new BorderLayout());
		JPanel leftCenter = new JPanel(new GridLayout(9, 2));
		leftCenter.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 10 , 10));
		
		String[] info= {"","","상가명","구","동","도로명주소","층","중분류명","소분류명"};
		int size = info.length;
		JLabel infoL[] = new JLabel[size];
		comInfoL = new JLabel[size];
		
		for (int i = 0; i <size; i++) {
			infoL[i] = new JLabel(info[i]);
			comInfoL[i]=new JLabel("");
			leftCenter.add(infoL[i]);
			leftCenter.add(comInfoL[i]);
		}	
		
		left.add(new JLabel("상권 정보", JLabel.CENTER),"North");
		left.add(leftCenter,"Center");
		
		//오른쪽 화면
		JPanel right = new JPanel(new BorderLayout());
		JPanel rightCenter = new JPanel(new BorderLayout());
		comModel = new DefaultTableModel(title,20);
		comTable = new JTable(comModel);
		comPan = new JScrollPane(comTable);
		comTable.setColumnSelectionAllowed(true);
		rightCenter.add(new JLabel("상가 리스트", JLabel.CENTER),"North");
		rightCenter.add(comPan,"Center");
		
		right.add(rightCenter,"Center");
		
		JPanel mainP = new JPanel(new GridLayout(1, 2));
		
		mainP.add(left);
		mainP.add(right);
		
		mainP.setBorder(BorderFactory.createEmptyBorder(20 , 10 , 10 , 10));
		frame.add(mainP,"Center");
		
		comTable.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int row =  comTable.getSelectedRow();
				System.out.println("선택된 row : " + row);
				System.out.println("선택된 row의 column 값 :"+comModel.getValueAt(row, 0));
				int code = Integer.parseInt(((String)comModel.getValueAt(row, 0)).trim());
				showComInfo(code);
			}
		});
		
		showComs();
		
		
	}
	
	public void showComs(){	
		List<ComDeal> deals = comService.searchAll();
		if(deals!=null){
			int i=0;
			String[][]data = new String[deals.size()][5];
			for (ComDeal deal: deals) {
				data[i][0]= ""+deal.getNo();
				data[i][1]= deal.getDong();
				data[i][2]= deal.getComName();
				data[i][3]= deal.getAddr();
				data[i++][4]= deal.getMidKind();
			}
			comModel.setDataVector(data, title);
		}
	}
}
	
	
