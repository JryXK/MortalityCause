package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

public class Initial {

	private JFrame frame;
	private JPanel Explaination;
	private JPanel Initial;
	private JPanel SearchModule;
	private JPanel Connected;
	private JPanel Similarity;
	private JTextField textField;
	private JTable table;
	private JPanel display;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Initial window = new Initial();
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
	public Initial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		readFile.load();
		Data.setUp();
		RWRF.load();
		Graph[] D = RWRF.getGraph();

		String[] causes = new String[136];
		int index = 0;
		System.out.println(1);

		for (String w : RWRF.getCauses()) {
			causes[index] = w;
			index++;
		}

		index = 0;

		boolean[] RFs = new boolean[26];

		String sim;

		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		final JPanel Explaination = new JPanel();
		frame.getContentPane().add(Explaination, "name_181334256118407");
		Explaination.setLayout(null);
		Explaination.setVisible(true);

		final JPanel Choose = new JPanel();
		frame.getContentPane().add(Choose, "name_181334263692911");
		Choose.setLayout(null);
		Choose.setVisible(false);

		final JButton Comfirm = new JButton("Next");
		Comfirm.setIcon(null);
		Comfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Explaination.setVisible(false);
				Choose.setVisible(true);
			}
		});
		Comfirm.setBounds(248, 246, 90, 25);
		Explaination.add(Comfirm);

		final JPanel SearchModule_1 = new JPanel();
		frame.getContentPane().add(SearchModule_1, "name_201436246045538");
		SearchModule_1.setLayout(null);

		SpinnerModel value = new SpinnerNumberModel(0, // initial value
				0, // minimum value
				90, // maximum value
				1); // step
		JSpinner spinner = new JSpinner(value);
		spinner.setBounds(100, 100, 50, 30);
		SearchModule_1.add(spinner);

		/*textField = new JTextField();
		textField.setBounds(250, 125, 300, 30);
		SearchModule_1.add(textField);
		textField.setColumns(10);*/

		JLabel lblNewLabel_8 = new JLabel("Please enter your age");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(62, 120, 179, 37);
		SearchModule_1.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Please select your gender");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(62, 231, 179, 20);
		SearchModule_1.add(lblNewLabel_9);

		final JPanel SearchModule_2 = new JPanel();
		frame.getContentPane().add(SearchModule_2, "name_181334271353933");
		SearchModule_2.setLayout(null);
		SearchModule_2.setVisible(false);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Both Gender"}));
		comboBox_3.setBounds(250, 203, 328, 80);
		SearchModule_1.add(comboBox_3);
		
		final JPanel Display = new JPanel();
		frame.getContentPane().add(Display, "name_281181255169076");
		Display.setLayout(null);
		

		JButton btnNewButton_2 = new JButton("Next step");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int age;
				
				try {
					age = (int) spinner.getValue();
					if(age > 90) {
						age = 90;
						spinner.setValue(90);
						JOptionPane.showMessageDialog(null, "Age over 90 will be treat the same.");
					}else if(age < 0) {
						age = 0;
						spinner.setValue(0);
						JOptionPane.showMessageDialog(null, "Age cannot be negative.");
					}
				} catch (NumberFormatException ex) {
					age = -1;
					JOptionPane.showMessageDialog(null, "Wrong input format pls try agin: (int is required.)");
				}
				
				String gender = (String) comboBox_3.getSelectedItem();
				Search a = new Search(age, gender.toUpperCase(), 0);
				ADT[] aaa = a.getSeq();
				LinkedList<Integer>[] blabla = Help.getPaths(D);
				Sort.sortMerge(aaa, aaa.length);
				ADT[] list136 = Help.getRisk(aaa);
				String[][] causes = new String[136][2];
				for (int j = 0; j < 136; j++) {
					if (list136[j] != null) {
						causes[j][0] = list136[j].getCause();
						causes[j][1] = Double.toString(list136[j].getValue());
				}
				}
				Object[][] data = causes;
				Object[] columnNames = {"Mortality Cause",
			            "Number of death per year",
			            };
				table = new JTable(data, columnNames);
				table.setBounds(50, 53, 684, 349);
				

				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setLocation(50, 11);
				scrollPane.setSize(647, 351);
				Display.add(scrollPane);

				
				JOptionPane.showMessageDialog(null, "This is going to show you the result");
				SearchModule_1.setVisible(false);
				Display.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(300, 342, 130, 80);
		SearchModule_1.add(btnNewButton_2);

		final JPanel Connected = new JPanel();
		frame.getContentPane().add(Connected, "name_181334279721719");
		Connected.setLayout(null);
		Connected.setVisible(false);

		final JPanel Similarity = new JPanel();
		frame.getContentPane().add(Similarity, "name_181334288037752");
		Similarity.setLayout(null);

		JComboBox comboBox = new JComboBox(causes);
		comboBox.setBounds(161, 23, 484, 90);
		Connected.add(comboBox);

		final JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(357, 163, 89, 23);
		Connected.add(btnNewButton);

		JCheckBox elder = new JCheckBox("Elder(>60)");
		elder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (elder.isSelected() == true) {
					RFs[0] = true;
				} else
					RFs[0] = false;
			}
		});
		elder.setBounds(10, 10, 103, 23);

		JCheckBox underage = new JCheckBox("Underage");
		underage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (underage.isSelected() == true)
					RFs[1] = true;
				else
					RFs[1] = false;

			}
		});
		underage.setBounds(140, 10, 103, 23);

		JCheckBox tobacco = new JCheckBox("smoking");
		tobacco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tobacco.isSelected() == true)
					RFs[2] = true;
				else
					RFs[2] = false;
			}
		});
		tobacco.setBounds(270, 10, 103, 23);

		JCheckBox alcohol = new JCheckBox("alcohol abuse");
		alcohol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (alcohol.isSelected() == true)
					RFs[3] = true;
				else
					RFs[3] = false;
			}
		});
		alcohol.setBounds(400, 10, 128, 23);

		JCheckBox drug = new JCheckBox("drug abuse");
		drug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (drug.isSelected() == true)
					RFs[4] = true;
				else
					RFs[4] = false;
			}
		});
		drug.setBounds(530, 10, 102, 23);

		JCheckBox poverty = new JCheckBox("poverty");
		poverty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (poverty.isSelected() == true)
					RFs[5] = true;
				else
					RFs[5] = false;
			}
		});
		poverty.setBounds(660, 10, 103, 23);

		JCheckBox unhealthy_diet = new JCheckBox("unhealthy diet");
		unhealthy_diet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (unhealthy_diet.isSelected() == true)
					RFs[6] = true;
				else
					RFs[6] = false;
			}
		});
		unhealthy_diet.setBounds(10, 45, 128, 23);

		JCheckBox raw_food = new JCheckBox("raw food");
		raw_food.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (raw_food.isSelected() == true)
					RFs[7] = true;
				else
					RFs[7] = false;
			}
		});
		raw_food.setBounds(140, 45, 78, 23);

		JCheckBox crowded = new JCheckBox("crowded work/residental environment");
		crowded.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (crowded.isSelected() == true)
					RFs[8] = true;
				else
					RFs[8] = false;
			}
		});
		crowded.setBounds(270, 45, 253, 23);

		JCheckBox chem = new JCheckBox("chemical/UV/radiation exposure");
		chem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chem.isSelected() == true)
					RFs[9] = true;
				else
					RFs[9] = false;
			}
		});
		chem.setBounds(530, 45, 233, 23);

		JCheckBox minorTrauma = new JCheckBox("insect/animal bite/minor trauma");
		minorTrauma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (minorTrauma.isSelected() == true)
					RFs[10] = true;
				else
					RFs[10] = false;
			}
		});
		minorTrauma.setBounds(10, 80, 258, 23);

		JCheckBox transfusion = new JCheckBox("recent transfusion");
		transfusion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (transfusion.isSelected() == true)
					RFs[11] = true;
				else
					RFs[11] = false;
			}
		});
		transfusion.setBounds(270, 80, 177, 23);

		JCheckBox developing = new JCheckBox("recently travel to developing country");
		developing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (developing.isSelected() == true)
					RFs[12] = true;
				else
					RFs[12] = false;
			}
		});
		developing.setBounds(530, 80, 248, 23);

		JCheckBox injury = new JCheckBox("head/brain injury");
		injury.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (injury.isSelected() == true)
					RFs[13] = true;
				else
					RFs[13] = false;
			}
		});
		injury.setBounds(10, 115, 189, 23);

		JCheckBox surgery = new JCheckBox("recent or upcoming surgery");
		surgery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (surgery.isSelected() == true)
					RFs[14] = true;
				else
					RFs[14] = false;
			}
		});
		surgery.setBounds(270, 115, 212, 23);

		JCheckBox dig = new JCheckBox("digestive system disorder");
		dig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dig.isSelected() == true)
					RFs[15] = true;
				else
					RFs[15] = false;
			}
		});
		dig.setBounds(530, 115, 233, 23);

		JCheckBox res = new JCheckBox("respiratory system disorder");
		res.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (res.isSelected() == true)
					RFs[16] = true;
				else
					RFs[16] = false;
			}
		});
		res.setBounds(10, 150, 208, 23);

		JCheckBox cir = new JCheckBox("circulation system disorder");
		cir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cir.isSelected() == true)
					RFs[17] = true;
				else
					RFs[17] = false;
			}
		});
		cir.setBounds(270, 150, 203, 23);

		JCheckBox hypertension = new JCheckBox("hypertension");
		hypertension.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hypertension.isSelected() == true)
					RFs[18] = true;
				else
					RFs[18] = false;
			}
		});
		hypertension.setBounds(530, 150, 107, 23);

		JCheckBox pregnancy = new JCheckBox("pregnancy");
		pregnancy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pregnancy.isSelected() == true)
					RFs[19] = true;
				else
					RFs[19] = false;
			}
		});
		pregnancy.setBounds(660, 150, 118, 23);

		JCheckBox immunity = new JCheckBox("low immunity");
		immunity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (immunity.isSelected() == true)
					RFs[20] = true;
				else
					RFs[20] = false;
			}
		});
		immunity.setBounds(10, 185, 128, 23);

		JCheckBox infection = new JCheckBox("other virus or bacteria infection");
		infection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (infection.isSelected() == true)
					RFs[21] = true;
				else
					RFs[21] = false;
			}
		});
		infection.setBounds(140, 185, 217, 23);

		JCheckBox gay = new JCheckBox("gay or excess sex");
		gay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gay.isSelected() == true)
					RFs[22] = true;
				else
					RFs[22] = false;
			}
		});
		gay.setBounds(449, 185, 153, 23);

		JCheckBox overweight = new JCheckBox("overweight");
		overweight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (overweight.isSelected() == true)
					RFs[23] = true;
				else
					RFs[23] = false;
			}
		});
		overweight.setBounds(660, 185, 103, 23);

		JCheckBox accident = new JCheckBox("accident");
		accident.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (accident.isSelected() == true)
					RFs[24] = true;
				else
					RFs[24] = false;
			}
		});
		accident.setBounds(10, 280, 103, 23);

		JCheckBox sOrcCide = new JCheckBox("suicide or homicide");
		sOrcCide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sOrcCide.isSelected() == true) {
					RFs[25] = true;
					System.out.println(RFs[25]);
				} else {
					RFs[25] = false;
					System.out.println(RFs[25]);
				}
			}
		});
		sOrcCide.setBounds(140, 280, 164, 23);

		SearchModule_2.setLayout(null);
		SearchModule_2.add(elder);
		SearchModule_2.add(underage);
		SearchModule_2.add(tobacco);
		SearchModule_2.add(alcohol);
		SearchModule_2.add(drug);
		SearchModule_2.add(poverty);
		SearchModule_2.add(unhealthy_diet);
		SearchModule_2.add(raw_food);
		SearchModule_2.add(crowded);
		SearchModule_2.add(chem);
		SearchModule_2.add(minorTrauma);
		SearchModule_2.add(transfusion);
		SearchModule_2.add(developing);
		SearchModule_2.add(injury);
		SearchModule_2.add(surgery);
		SearchModule_2.add(dig);
		SearchModule_2.add(res);
		SearchModule_2.add(cir);
		SearchModule_2.add(hypertension);
		SearchModule_2.add(pregnancy);
		SearchModule_2.add(immunity);
		SearchModule_2.add(infection);
		SearchModule_2.add(gay);
		SearchModule_2.add(overweight);
		SearchModule_2.add(accident);
		SearchModule_2.add(sOrcCide);

		JLabel lblNewLabel_4 = new JLabel(
				"Unhealthy diet: food that is highly salty and smoked, low on vegetable and fruit or diets rich in fat and cholesterol");
		lblNewLabel_4.setBounds(10, 221, 641, 14);
		SearchModule_2.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel(
				"Acciden, suicide or homicide are not risk factors, but can still be chosen if interested.");
		lblNewLabel_5.setBounds(10, 246, 552, 14);
		SearchModule_2.add(lblNewLabel_5);

		JButton SearchButton = new JButton("Start Search");
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String age = textField.getText();
				String gender = (String) comboBox_3.getSelectedItem();
			}
		});
		SearchButton.setBounds(250, 380, 253, 98);
		SearchModule_2.add(SearchButton);

		JComboBox comboBox_1 = new JComboBox(causes);
		comboBox_1.setBounds(60, 96, 330, 189);
		Similarity.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox(causes);
		comboBox_2.setBounds(390, 96, 330, 189);
		Similarity.add(comboBox_2);

		JLabel lblNewLabel_6 = new JLabel("Select the two mortality causes concern you");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(211, 22, 362, 63);
		Similarity.add(lblNewLabel_6);

		JButton btnNewButton_1 = new JButton("Check Similarity");
		btnNewButton_1.setBounds(285, 386, 210, 63);
		Similarity.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Search, Connection and Similarity\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 59, 298, 14);
		Explaination.add(lblNewLabel);

		JLabel Explain = new JLabel("In the next window, you will see three buttons: \r\n");
		Explain.setBounds(10, 19, 286, 14);
		Explain.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Explaination.add(Explain);

		JLabel lblNewLabel_1 = new JLabel(
				"Search: identify your potential thread based on age, gender and risk factor\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 99, 414, 14);
		Explaination.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Connection: what may cause the multiple diseases to your relatives.\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 139, 414, 14);
		Explaination.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Similarity: provide causes that are trigger by the same risk factor.");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 179, 392, 14);
		Explaination.add(lblNewLabel_3);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(Initial.class.getResource("/project/doctor.jpg")));
		lblNewLabel_7.setBounds(458, 211, 261, 222);
		Explaination.add(lblNewLabel_7);

		JButton Search = new JButton("Search");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Choose.setVisible(false);
				SearchModule_1.setVisible(true);
			}
		});
		Search.setBounds(115, 200, 130, 80);
		Choose.add(Search);

		JButton Connection = new JButton("Connection");
		Connection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Choose.setVisible(false);
				Connected.setVisible(true);
			}
		});
		Connection.setBounds(330, 200, 130, 80);
		Choose.add(Connection);

		JButton Sim = new JButton("Similarity");
		Sim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Choose.setVisible(false);
				Similarity.setVisible(true);
			}
		});
		Sim.setBounds(545, 200, 130, 80);
		Choose.add(Sim);
		


	}
}
