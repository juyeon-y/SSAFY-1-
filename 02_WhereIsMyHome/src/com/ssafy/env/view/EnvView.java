package com.ssafy.env.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ssafy.env.model.dto.EnvPollut;
import com.ssafy.env.model.service.EnvService;
import com.ssafy.env.model.service.EnvServiceImpl;
import com.ssafy.rent.WhereIsMyHomeException;
import com.ssafy.rent.model.dto.HomeDeal;
import com.ssafy.rent.model.dto.HomePageBean;
import com.ssafy.rent.model.service.HomeService;
import com.ssafy.rent.model.service.HomeServiceImpl;


public class EnvView{
	
	/**model들 */
	private EnvService 		envService;
	
	/** main 화면 */
	private JFrame frame;
	
	//상세정보
	private JLabel[] 			envInfoL;

	
	/**조회 내용 표시할 table*/
	private DefaultTableModel 	envModel;
	private JTable			  	envTable;
	private JScrollPane		  	envPan;
	private String[]		  	title = { "번호", "업체(시설)명","인허가번호","업종코드","업종명","지도점검일자","점검기관","점검기관명","지도점검구분","처분대상여부","점검사항","점검결과","소재지도로명주소","소재지주소" };
	
	/**화면에 표시하고 있는 주택*/
	private EnvPollut curPollut;

	
	private void showEnvPollutInfo(int code) {
		curPollut = envService.search(code);
		envInfoL[0].setText("");
		envInfoL[1].setText("");
		envInfoL[2].setText(curPollut.getCompanyName());
		String[] splitAdd = curPollut.getAddress().split(" ");
		if(splitAdd.length>3) {
			envInfoL[3].setText(""+splitAdd[1]);
			envInfoL[4].setText(""+splitAdd[2]);
		}else {
			envInfoL[3].setText("정보없음");
			envInfoL[4].setText("정보없음");
		}
		envInfoL[5].setText(""+curPollut.getInspDate());
		envInfoL[6].setText(curPollut.getBizCode());
		envInfoL[7].setText(curPollut.getBizName());
		envInfoL[8].setText(curPollut.getInspDesc());
		
		  
		  

//		Image img = null;
//		try {
//			img = ImageIO.read(new File("img/"+curHome.getImg()));
//         } catch (IOException ex) {
//        	 try {
//        		 img = ImageIO.read(new File("img/다세대주택.jpg"));
//			} catch (Exception e) {
//			}
//         }
//		img = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
//		imgL.setIcon(new ImageIcon(img));
	}
	
	public EnvView(){
		/*Service들 생성 */
		envService = new EnvServiceImpl();
		
		/*메인 화면 설정 */
		frame = new JFrame("주변 환경 오염 정보");
		
//		frame.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e){
//				frame.dispose();
//			}
//		});
		
		setMain();
		
		frame.setSize(1200, 800);
		frame.setResizable(true);
		frame.setVisible(true);
		showEnvPollutInfo(1);
		//showHomes();
	}
	
	/*public EnvView(String dong) {
		envService = new EnvServiceImpl(dong);
		frame=new JFrame("WhereIsMycom -- "+dong+" 상권 정보");
		
		setMain();
		
		frame.setSize(1200, 800);
		frame.setResizable(true);
		frame.setVisible(true);
		showComInfo(1);
		
	}*/

	/**메인 화면인 주택 목록을 위한 화면 셋팅하는 메서드  */
	public void setMain(){

		//왼쪽 화면
		JPanel left = new JPanel(new BorderLayout());
		JPanel leftCenter = new JPanel(new GridLayout(9, 2));
		leftCenter.setBorder(BorderFactory.createEmptyBorder(0 , 10 , 10 , 10));
		
		String[] info= {"","","업체(시설)명","구","동","지도점검일자","업종코드","업종명","점검사항"};
		int size = info.length;
		JLabel infoL[] = new JLabel[size];
		envInfoL = new JLabel[size];
		
		for (int i = 0; i <size; i++) {
			infoL[i] = new JLabel(info[i]);
			envInfoL[i]=new JLabel("");
			leftCenter.add(infoL[i]);
			leftCenter.add(envInfoL[i]);
		}	
		
		left.add(new JLabel("점검 정보", JLabel.CENTER),"North");
		left.add(leftCenter,"Center");
				
		
		
		
		/*오른쪽 화면을 위한 설정 */
		JPanel right = new JPanel(new BorderLayout());
		JPanel rightCenter = new JPanel(new BorderLayout());
		envModel = new DefaultTableModel(title,20);
		envTable = new JTable(envModel);
		envPan = new JScrollPane(envTable);
		envTable.setColumnSelectionAllowed(true);
		rightCenter.add(new JLabel("지도 점검 리스트", JLabel.CENTER),"North");
		rightCenter.add(envPan,"Center");
		
		right.add(rightCenter,"Center");
		
		JPanel mainP = new JPanel(new GridLayout(1, 2));
		mainP.add(left);
		mainP.add(right);
		
		
		mainP.setBorder(BorderFactory.createEmptyBorder(20 , 10 , 10 , 10));
		frame.add(mainP,"Center");
		
		/*이벤트 연결*/

		envTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int row =  envTable.getSelectedRow();
				//System.out.println("선택된 row : " + row);
				//System.out.println("선택된 row의 column 값 :"+envModel.getValueAt(row, 0));
				int code = Integer.parseInt(((String)envModel.getValueAt(row, 0)).trim());
				showEnvPollutInfo(code);
			}
		});
		showPolluts();
	}
	
	
	/**검색 조건에 맞는 주택 정보 검색 */
	/*
	private void searchHomes() {
		for(int i = 0, size = chooseC.length; i<size; i++) {
			if(chooseC[i].isSelected()) {
				searchType[i] = true;
			}else {
				searchType[i] = false;
			}
		}
		word = wordTf.getText().trim();
		key = choice[findC.getSelectedIndex()];
		System.out.println("word:"+word+" key:"+key);
		showHomes();		
	}*/
	/**
	 * 주택 목록을  갱신하기 위한 메서드 
	 */
	public void showPolluts(){
		
		List<EnvPollut> polluts = envService.searchAll();
		if(polluts!=null){
			int i=0;
			String[][]data = new String[polluts.size()][14];
			for (EnvPollut p: polluts) {
				data[i][0]= ""+p.getNo();
				data[i][1]= p.getCompanyName();
				data[i][2]= ""+p.getLicenseNo();
				data[i][3]= ""+p.getBizCode();
				data[i][4]= p.getBizName();
				data[i][5]= ""+p.getInspDate();
				data[i][6]= ""+p.getInspAgencyNo();
				data[i][7]= p.getInspAgencyName();
				data[i][8]=p.getInspCategory();
				data[i][9]=p.getForDisposal();
				data[i][10]=p.getInspDesc();
				data[i][11]=p.getInspRes();
				data[i][12]=p.getRoadNameAdd();
				data[i++][13]=p.getAddress();
			}
			envModel.setDataVector(data, title);
		}
	}
//	public static void main(String[] args) {
//		new HomeInfoView();
//	}
	
}


