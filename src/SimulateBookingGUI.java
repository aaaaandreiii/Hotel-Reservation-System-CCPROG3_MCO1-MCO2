import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SimulateBookingGUI extends JPanel {
    private JPanel parentPanel;

    private JPanel panelHeader;
    private JPanel panelSearch;
    private JPanel panelFooter;

    private JLabel Header1;
    private JLabel Header2;
    private JLabel info;

    private JButton AdminMode;

    private JComboBox<String> hotelList;
    private JTextField checkInField;
    private JTextField checkOutField;
    private JButton searchButton;
        
    private JLabel hotelFieldJLabel;
    private JLabel calendarFieldJLabel;

    private JPanel subPanel1;
    private JPanel subPanel2;
    private JPanel subPanel3;
    private JLabel labelHotel;
    private JLabel labelCheckIn;
    private JLabel labelCheckOut;

    private static Color beige = new Color(254, 243, 226);
    private static Color darkBlue1 = new Color(96, 102, 118);
    private static Color paleGreen1 = new Color(112, 136, 113);
    private static ImageIcon searchButtonImageIcon = new ImageIcon("./photos/search_icon.png");
    private static ImageIcon hotelIcon = new ImageIcon("./photos/hotel_icon.png");
    private static ImageIcon calendarIcon = new ImageIcon("./photos/calendar_icon.png");
    
    public SimulateBookingGUI() {
        parentPanel = new JPanel();

        parentPanel.setBorder(null);
        parentPanel.setBackground(beige);

        Image searchButtonImage = searchButtonImageIcon.getImage();
        Image scaledButtonIcon = searchButtonImage.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH);
        searchButtonImageIcon = new ImageIcon(scaledButtonIcon);
        Image hotelIconImage = hotelIcon.getImage();
        Image scaledhotelIcon = hotelIconImage.getScaledInstance(45, 45,  java.awt.Image.SCALE_SMOOTH);
        hotelIcon = new ImageIcon(scaledhotelIcon);
        Image calendarIconImage = calendarIcon.getImage();
        Image scaledcalendarIconImage = calendarIconImage.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
        calendarIcon = new ImageIcon(scaledcalendarIconImage);

        panelHeader = new JPanel();
        panelSearch = new JPanel();
        panelFooter = new JPanel();
        
        panelHeader.setBackground(beige);
        panelSearch.setBackground(paleGreen1);
        panelFooter.setBackground(beige);

        Header1 = new JLabel("Opulence Oasis");
        Header2 = new JLabel("                                                                 Transforming Bookings into Opulent Experiences."); //sir i couldnt align it to the right 😭
        info = new JLabel("<html>Andrei Luis Balingit<br>CCPROG3 Hotel Reservation System</html>");

        Header1.setBorder(new EmptyBorder(0, 0, 15, 0));
        try {
			File fontStyle = new File("./fonts/BrittanySignature.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(130f);
			Header1.setFont(font);
            Header1.setForeground(Color.black);
		} catch (Exception e) {
			e.printStackTrace();
			Font font = new Font("Serif", Font.PLAIN, 140);
            Header1.setFont(font);
            Header1.setForeground(Color.black);
        }

        try {
			File fontStyle = new File("./fonts/NotoSerifEthiopic_Condensed-Regular.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(20f);
			Header2.setFont(font);
            Header2.setHorizontalAlignment(SwingConstants.RIGHT);
		} catch (Exception e) {
			e.printStackTrace();
			Font font = new Font("Serif", Font.PLAIN, 20);
            Header2.setFont(font);
            Header2.setHorizontalAlignment(SwingConstants.RIGHT);
        }

        AdminMode = new JButton("Admin Mode");
        AdminMode.setPreferredSize(new Dimension(250, 87));
        AdminMode.setBorder(null);
        AdminMode.setBackground(darkBlue1);
        AdminMode.setForeground(beige);
        try {
			File fontStyle = new File("./fonts/NotoSerifEthiopic_ExtraCondensed-Bold.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(30f);
            AdminMode.setFont(font);
		} catch (Exception e) {
			e.printStackTrace();
			Font font = new Font("Serif", Font.PLAIN, 30);
            AdminMode.setFont(font);
        }

        panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.Y_AXIS));
        panelHeader.add(Box.createVerticalStrut(20));
        panelHeader.add(Header1);
        panelHeader.add(Box.createVerticalStrut(10));
        panelHeader.add(Header2);

        hotelList = new JComboBox<>();
        hotelList.setForeground(beige);
        hotelList.setBackground(paleGreen1);
        hotelList.setBorder(null);
        hotelList.setPrototypeDisplayValue("Hotel California");
        
        checkInField = new JTextField("DD-MM-YYYY", 8);
        checkOutField = new JTextField("DD-MM-YYYY", 8);
        searchButton = new JButton(searchButtonImageIcon);
        checkInField.setBackground(paleGreen1);
        checkInField.setForeground(beige);
        checkInField.setBorder(null);
        checkOutField.setBackground(paleGreen1);
        checkOutField.setForeground(beige);
        checkOutField.setBorder(null);
        
        hotelFieldJLabel = new JLabel(" ", SwingConstants.RIGHT);
        hotelFieldJLabel.setIcon(hotelIcon);
        calendarFieldJLabel = new JLabel("  ", SwingConstants.RIGHT);
        calendarFieldJLabel.setIcon(calendarIcon);

        searchButton.setBorder(null);
        searchButton.setFocusPainted(false);
        searchButton.setBackground(darkBlue1);
        searchButton.setPreferredSize(new Dimension(95, 95));

        try {
			File fontStyle = new File("./fonts/NotoSerifEthiopic_Condensed-Regular.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(18f);
            hotelList.setFont(font);
		} catch (Exception e) {
			e.printStackTrace();
			Font font = new Font("Serif", Font.PLAIN, 18);
            hotelList.setFont(font);
        }
        try {
			File fontStyle = new File("./fonts/NotoSerifEthiopic_Condensed-Regular.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(22f);
			checkInField.setFont(font);
            checkOutField.setFont(font);
		} catch (Exception e) {
			e.printStackTrace();
			Font font = new Font("Serif", Font.PLAIN, 22);
            checkInField.setFont(font);
            checkOutField.setFont(font);
        }

        subPanel1 = new JPanel();
        subPanel2 = new JPanel();
        subPanel3 = new JPanel();
        labelHotel = new JLabel("Hotel");
        labelCheckIn = new JLabel("Check-In");
        labelCheckOut = new JLabel("Check-Out");

        labelHotel.setForeground(beige);
        labelCheckIn.setForeground(beige);
        labelCheckOut.setForeground(beige);

        try {
			File fontStyle = new File("./fonts/NotoSerifEthiopic_ExtraCondensed-Bold.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(15f);
            labelHotel.setForeground(beige);
            labelHotel.setFont(font);
            labelCheckIn.setFont(font);
            labelCheckOut.setFont(font);
		} catch (Exception e) {
			e.printStackTrace();
			Font font = new Font("Serif", Font.PLAIN, 15);
            labelHotel.setFont(font);
            labelCheckIn.setFont(font);
            labelCheckOut.setFont(font);
        }

        subPanel1.setLayout(new GridLayout(2, 1));
        subPanel1.setBackground(paleGreen1);
        subPanel1.setBorder(new EmptyBorder(0, 0, 0, 40));
        subPanel2.setLayout(new GridLayout(2, 1));
        subPanel2.setBackground(paleGreen1);
        subPanel3.setLayout(new GridLayout(2, 1));
        subPanel3.setBackground(paleGreen1);
        subPanel3.setBorder(new EmptyBorder(0, 0, 0, 40));

        subPanel1.add(labelHotel);
        subPanel1.add(hotelList);
        subPanel2.add(labelCheckIn);
        subPanel2.add(checkInField);
        subPanel3.add(labelCheckOut);
        subPanel3.add(checkOutField);

        panelSearch.add(hotelFieldJLabel);
        panelSearch.add(subPanel1);
        panelSearch.add(calendarFieldJLabel);  
        panelSearch.add(subPanel2);
        panelSearch.add(subPanel3);
        panelSearch.add(searchButton);

		try {
			File fontStyle = new File("./fonts/NotoSerifEthiopic_Condensed-Regular.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(20f);
			info.setFont(font);
		} catch (Exception e) {
			e.printStackTrace();
			Font font = new Font("Serif", Font.PLAIN, 20);
            info.setFont(font);
        }
		
        panelFooter.setLayout(new GridLayout(1, 2));
        panelFooter.add(info, BorderLayout.WEST);
        panelFooter.add(Box.createHorizontalGlue());
        panelFooter.add(AdminMode, BorderLayout.EAST);

		panelHeader.setBorder(new EmptyBorder(250, 100, 145, 100));
        panelSearch.setBorder(new EmptyBorder(0, 12, 0, 0));
		panelFooter.setBorder(new EmptyBorder(85, 53, 53, 53));

        parentPanel.add(panelHeader, BorderLayout.NORTH);
        parentPanel.add(panelSearch, BorderLayout.CENTER);
        parentPanel.add(panelFooter, BorderLayout.SOUTH);
    }

    public JComboBox<String> getHotelList() {
        return hotelList;
    }

    public JTextField getcheckInField() {
        return checkInField;
    }

    public JTextField getcheckOutField() {
        return checkOutField;
    }

    public JLabel gethotelFieldJLabel() {
        return hotelFieldJLabel;
    }
    public JButton getBtnAdminMode() {
        return AdminMode;
    }

    public JButton getBtnSearchButton() {
        return searchButton;
    }

    public JPanel getParentPanel(){
        return parentPanel;
    }
}