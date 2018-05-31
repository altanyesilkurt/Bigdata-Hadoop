package flightTracker;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JInternalFrame;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.BoxLayout;
import java.awt.Image;
public class Arayuz {
	Thread t;
	DefaultListModel capitalListModel =  new DefaultListModel();
	DefaultListModel flightListModel = new DefaultListModel();
	
	private JFrame frame;
	private JTable table;

	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Arayuz window = new Arayuz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	* Create the application.
	*/
	public Arayuz() {
		initialize();
	}

	/**
	* Initialize the contents of the frame.
	*/
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		JTabbedPane menu = new JTabbedPane(JTabbedPane.TOP);
		panel.add(menu);
		
		
		
		JPanel panel_1 = new JPanel();
		menu.addTab("COUNTRY MISSION", null, panel_1, null);
		
		
		
		
		JButton btnShow_1 = new JButton("SHOW");
		btnShow_1.setBounds(150,50, 120, 40);
		panel_1.add(btnShow_1);
		
		JLabel lblImg = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/war-011-512-big.png")).getImage();
		lblImg.setIcon(new ImageIcon(img));
		lblImg.setBounds(200, 100, 250, 180);
		panel_1.add(lblImg);
		
		
		btnShow_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
       
            	
            	
            	
            	  DefaultPieDataset pieDataSet = new DefaultPieDataset();
            	  //total:1047703 missions
            	  //Australia : 2871
            	  //South Korea:5541
            	  //Laos : 7510
            	  //United States of America: 890755
            	  //Vietnam: 141026
                  pieDataSet.setValue("AUSTRALIA", new Integer(1));
                  pieDataSet.setValue("SOUTH KOREA", new Integer(1));
                  pieDataSet.setValue("LAOS", new Integer(1));
                  pieDataSet.setValue("USA", new Integer(84));
                  pieDataSet.setValue("VIETNAM", new Integer(13));
                  JFreeChart chart= ChartFactory.createPieChart3D("FLY MISSION COUNTRY",pieDataSet,true,true,true);
                  PiePlot3D P = (PiePlot3D)chart.getPlot();
                  //P.setForegroundAlpha(TOP_ALIGNMENT);
                  ChartFrame frame = new ChartFrame("FLY MISSION COUNTRY",chart);
                  frame.setVisible(true);
                  frame.setSize(900, 700);
                 
                  
            }
        });
			
			
			
	       
	       
			
			
			JPanel capitalPanel = new JPanel();
			menu.addTab("AVERAGE BOMBING", null, capitalPanel, null);
			capitalPanel.setLayout(null);
			
			JButton btnShow_2 = new JButton("SHOW");
			btnShow_2.setBounds(251, 36, 117, 25);
			capitalPanel.add(btnShow_2);
			
			
			
			JLabel lblNewLabel = new JLabel("");
			Image img1=new ImageIcon(this.getClass().getResource("/Bomb-Cool-icon.png")).getImage();
			lblNewLabel.setIcon(new ImageIcon(img1));
			lblNewLabel.setBounds(200, 100, 350, 300);
			capitalPanel.add(lblNewLabel);
		
			
			btnShow_2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	                DefaultCategoryDataset dod= new DefaultCategoryDataset();
	                dod.setValue(7710,  "MEAN VALUES","MEAN VALUES");
	               
	               
	                	
	           
	               
	               
	                JFreeChart jchart=ChartFactory.createBarChart3D( "AVERAGE BOMBING", "", "", dod,PlotOrientation.VERTICAL,true,true,false);
	               
	                CategoryPlot plot =jchart.getCategoryPlot();
	                plot.setRangeGridlinePaint(Color.black);
	               
	                ChartFrame chartFrm = new ChartFrame ("MEAN TABLE",jchart,true);
	                chartFrm.setVisible(true);
	                chartFrm.setSize(900, 600);
	                ChartPanel chartPanel= new ChartPanel(jchart);
	               
	               
	               
	               
	               
	               
	               
	            }
	        });
			
			
			
			
			JPanel towerPanel = new JPanel();
			menu.addTab("WEAPON TYPE", null, towerPanel, null);
			towerPanel.setLayout(null);
			
			JButton btnWeaponCounts = new JButton("WEAPON COUNTS");
			btnWeaponCounts.setBounds(250, 47, 198, 39);
			towerPanel.add(btnWeaponCounts);
			
			
			
			JLabel lblNewLabel_1 = new JLabel("");
			Image img2=new ImageIcon(this.getClass().getResource("/Travel-Airplane-icon.png")).getImage();
			lblNewLabel_1.setIcon(new ImageIcon(img2));
			lblNewLabel_1.setBounds(100, 100, 550, 500);
			towerPanel.add(lblNewLabel_1);
		
			btnWeaponCounts.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	       
	            	
	            	
	            	
	            	  DefaultPieDataset pieDataSet = new DefaultPieDataset();
	            	  //BOMB	1683428
	            	  //GUN	100660
	            	  //MISSILE	90414
	            	  //ROCKET	164813
	            	  //SUPPORT	227604
	                  pieDataSet.setValue("BOMB %74", new Integer(74));
	                  pieDataSet.setValue("GUN  %4", new Integer(4));
	                  pieDataSet.setValue("MISSILE %4", new Integer(4));
	                  pieDataSet.setValue("ROCKET  %7", new Integer(7));
	                  pieDataSet.setValue("SUPPORT  %11", new Integer(11));
	                  JFreeChart chart= ChartFactory.createPieChart3D("Pie Chart",pieDataSet,true,true,true);
	                  PiePlot3D P = (PiePlot3D)chart.getPlot();
	                  //P.setForegroundAlpha(TOP_ALIGNMENT);
	                  ChartFrame frame = new ChartFrame("WEAPON TYPE COUNTS",chart);
	                  frame.setVisible(true);
	                  frame.setSize(900, 700);
	                 
	                  
	            }
	        });
			
		
		JPanel systemTimePanel = new JPanel();
		menu.addTab("FLY MISSION", null, systemTimePanel, null);
		systemTimePanel.setLayout(null);
		
		JButton btnShow = new JButton("show");
		btnShow.setBounds(275, 30, 117, 25);
		systemTimePanel.add(btnShow);
		
		 btnShow.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	                DefaultCategoryDataset dod= new DefaultCategoryDataset();
	                dod.setValue(3136,  "Aircraft Application","CLOSE_SUPPORT");
	                dod.setValue(26088,  "Aircraft Application","EARLY_WARNING" );
	                dod.setValue(8361, "Aircraft Application", "HELICOPTER");
	                dod.setValue(122597, "Aircraft Application", "STRATEGIC");
	                dod.setValue(117921, "Aircraft Application", "TACTICAL");
	                dod.setValue(254328, "Aircraft Application", "TRANSPORT");

	               
	               
	                	
	           
	               
	               
	                JFreeChart jchart=ChartFactory.createBarChart3D( "FLY MISSION COUNT", "MISSIONS", "VALUES", dod,PlotOrientation.VERTICAL,true,true,false);
	               
	                CategoryPlot plot =jchart.getCategoryPlot();
	                plot.setRangeGridlinePaint(Color.black);
	               
	                ChartFrame chartFrm = new ChartFrame ("FLY MISSION TABLE",jchart,true);
	                chartFrm.setVisible(true);
	                chartFrm.setSize(900, 600);
	                ChartPanel chartPanel= new ChartPanel(jchart);
	               
	               
	               
	               
	               
	               
	               
	            }
	        });
		 
		
			JPanel panel_2 = new JPanel();
			menu.addTab("TARGET COUNT", null, panel_2, null);
			
			JButton btnShow_3 = new JButton("SHOW");
			panel_2.add(btnShow_3);
			
			
			
			JLabel lblNewLabel_3 = new JLabel("");
			Image img4=new ImageIcon(this.getClass().getResource("/Archery-Target-icon.png")).getImage();
			lblNewLabel_3.setIcon(new ImageIcon(img4));
			lblNewLabel_3.setBounds(100, 100, 550, 500);
			panel_2.add(lblNewLabel_3);
			
			
			JLabel lblNewLabel_2 = new JLabel("");
			Image img3=new ImageIcon(this.getClass().getResource("/plane-flight-icon.png")).getImage();
			lblNewLabel_2.setIcon(new ImageIcon(img3));
			lblNewLabel_2.setBounds(80, 80, 650, 550);
			systemTimePanel.add(lblNewLabel_2);
			
			
			btnShow_3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	                DefaultCategoryDataset dod= new DefaultCategoryDataset();
	                dod.setValue(127845,   "TARGETS", "AVUSTRALIA");
	                dod.setValue(177176,   "TARGETS", "CAMBODIA");
	                dod.setValue(799148,   "TARGETS", "LAOS" );
	                dod.setValue(338654,   "TARGETS", "NORTHVIETNAM");
	                dod.setValue(1351759,  "TARGETS", "SOUTHVIETNAM");
	                dod.setValue(53205,    "TARGETS", "THAILAND");
	                dod.setValue(38,       "TARGETS", "UNKNOWN");
	                dod.setValue(9,        "TARGETS", "WESTPACWATERS");

	                //dod.setValue(58.80, "necati", "fahri");
	                /*-		127845
	    			CAMBODIA	177176
	    			LAOS		799148
	    			NORTHVIETNAM	338654
	    			SOUTHVIETNAM	1351759
	    			THAILAND	53205
	    			UNKNOWN		38
	    			WESTPACWATERS	9*/
	    			
	                	
	           
	               
	               
	                JFreeChart jchart=ChartFactory.createBarChart3D( "TARGET COUNTS", "PLACES", "VALUES", dod,PlotOrientation.VERTICAL,true,true,false);
	               
	                CategoryPlot plot =jchart.getCategoryPlot();
	                plot.setRangeGridlinePaint(Color.black);
	               
	                ChartFrame chartFrm = new ChartFrame ("FLY MISSION TABLE",jchart,true);
	                chartFrm.setVisible(true);
	                chartFrm.setSize(900, 600);
	                ChartPanel chartPanel= new ChartPanel(jchart);
	               
	               
	               
	               
	               
	               
	               
	            }
	        });
			
			
			
			
			
			
			
			
			
			
			
			
			
	}
}