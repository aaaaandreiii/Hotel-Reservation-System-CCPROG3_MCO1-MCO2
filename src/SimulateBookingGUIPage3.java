import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SimulateBookingGUIPage3 extends JPanel {
    private JPanel parentPanel;

    private JPanel panelSearch;
    private JComboBox<String> hotelList;
    private JTextField checkInField;
    private JTextField checkOutField;
    private JButton nextButton;
    private JLabel hotelFieldJLabel;
    private JLabel calendarFieldJLabel;
    private JPanel subPanel1;
    private JPanel subPanel2;
    private JPanel subPanel3;
    private JLabel labelHotel;
    private JLabel labelCheckIn;
    private JLabel labelCheckOut;

    private JPanel panelMiddle;
    private JPanel panelName;
    private JLabel guestNameLabel;
    private JLabel discountLabel;
    private JTextField discountTextField;
    private JPanel panelRoom;
    private JLabel totalPriceLabel;
    private JLabel totalPriceTextField;

    private JPanel panelFooter;
    private JButton logoButton;
    private JLabel title;

    private static Color beige = new Color(254, 243, 226);
    private static Color darkBlue1 = new Color(96, 102, 118);
    private static Color paleGreen1 = new Color(112, 136, 113);
    private static ImageIcon fullLogoImageIconGreen = new ImageIcon("./src/photos/OpulenceOasisFullLogoGreen.png");
    private static ImageIcon hotelIcon = new ImageIcon("./src/photos/hotel_icon.png");
    private static ImageIcon calendarIcon = new ImageIcon("./src/photos/calendar_icon.png");
    
    public SimulateBookingGUIPage3() {
        parentPanel = new JPanel();

        parentPanel.setBorder(new EmptyBorder(50, 0, 0, 0));
        parentPanel.setBackground(beige);
        panelSearch = new JPanel();
        panelFooter = new JPanel();
        panelSearch.setBackground(paleGreen1);
        panelFooter.setBackground(paleGreen1);

        Image hotelIconImage = hotelIcon.getImage();
        Image scaledhotelIcon = hotelIconImage.getScaledInstance(45, 45,  java.awt.Image.SCALE_SMOOTH);
        hotelIcon = new ImageIcon(scaledhotelIcon);
        Image calendarIconImage = calendarIcon.getImage();
        Image scaledcalendarIconImage = calendarIconImage.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
        calendarIcon = new ImageIcon(scaledcalendarIconImage);
        Image fullLogoImage = fullLogoImageIconGreen.getImage();
        Image scaledfullLogoIcon = fullLogoImage.getScaledInstance(275, 275,  java.awt.Image.SCALE_SMOOTH);
        fullLogoImageIconGreen = new ImageIcon(scaledfullLogoIcon);
        
        hotelList = new JComboBox<>();
        checkInField = new JTextField("DD-MM-YYYY", 8);
        checkOutField = new JTextField("DD-MM-YYYY", 8);
        nextButton = new JButton("→");
        hotelList.setForeground(beige);
        hotelList.setBackground(paleGreen1);
        hotelList.setBorder(null);
        hotelList.setPrototypeDisplayValue("Hotel California");
        checkInField.setBackground(paleGreen1);
        checkInField.setForeground(beige);
        checkInField.setBorder(null);
        checkOutField.setBackground(paleGreen1);
        checkOutField.setForeground(beige);
        checkOutField.setBorder(null);
        nextButton.setForeground(beige);
        nextButton.setFont(new Font("Calibri", Font.PLAIN, 40));
        nextButton.setHorizontalAlignment(SwingConstants.CENTER);
        nextButton.setVerticalAlignment(SwingConstants.CENTER);


        
        hotelFieldJLabel = new JLabel(" ", SwingConstants.RIGHT);
        hotelFieldJLabel.setIcon(hotelIcon);
        calendarFieldJLabel = new JLabel("  ", SwingConstants.RIGHT);
        calendarFieldJLabel.setIcon(calendarIcon);

        nextButton.setBorder(null);
        nextButton.setFocusPainted(false);
        nextButton.setBackground(darkBlue1);
        nextButton.setPreferredSize(new Dimension(95, 95));

        try {
			File fontStyle = new File("./src/fonts/NotoSerifEthiopic_Condensed-Regular.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(18f);
            hotelList.setFont(font);
		} catch (Exception e) {
			e.printStackTrace();
			Font font = new Font("Serif", Font.PLAIN, 18);
            hotelList.setFont(font);
        }
        try {
			File fontStyle = new File("./src/fonts/NotoSerifEthiopic_Condensed-Regular.ttf");
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
			File fontStyle = new File("./src/fonts/NotoSerifEthiopic_ExtraCondensed-Bold.ttf");
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
        panelSearch.add(nextButton);


    //     private JLabel discountLabel;
    // private JTextField discountTextField;

        panelMiddle = new JPanel();
        panelName = new JPanel();
        guestNameLabel = new JLabel("", SwingConstants.CENTER);
        discountLabel = new JLabel("Enter your discount code: ", SwingConstants.CENTER);
        discountTextField = new JTextField(30);
        panelMiddle.setLayout(new GridLayout(2,1));
        panelMiddle.setBackground(beige);
        panelMiddle.setBorder(new EmptyBorder(0, 0, 0, 0));
        panelName.setLayout(new GridLayout(3,1));
        panelName.setBackground(beige);
        guestNameLabel.setForeground(paleGreen1);
        discountLabel.setForeground(paleGreen1);
        discountTextField.setForeground(beige);
        discountTextField.setBackground(paleGreen1);
        discountTextField.setBorder(null);
        discountTextField.setHorizontalAlignment(JTextField.CENTER);

        
    // private JTextField totalPriceTextField;
        panelRoom = new JPanel();
        totalPriceLabel = new JLabel("Total Price: ", SwingConstants.CENTER);
        totalPriceTextField = new JLabel();
        panelRoom.setLayout(new GridLayout(2,1));
        panelRoom.setBackground(beige);
        panelRoom.setBorder(new EmptyBorder(0, 0, 100, 0));
        totalPriceLabel.setForeground(paleGreen1);
        totalPriceTextField.setForeground(paleGreen1);
        totalPriceTextField.setBorder(null);
        totalPriceTextField.setHorizontalAlignment(JTextField.CENTER);

        try {
			File fontStyle = new File("./src/fonts/NotoSerifEthiopic_ExtraCondensed-Medium.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(25f);
            guestNameLabel.setFont(font);
            discountLabel.setFont(font);
            totalPriceLabel.setFont(font);
		} catch (Exception e) {
			e.printStackTrace();
			Font font = new Font("Serif", Font.PLAIN, 25);
            guestNameLabel.setFont(font);
            discountLabel.setFont(font);
            totalPriceLabel.setFont(font);
        } try {
			File fontStyle = new File("./src/fonts/NotoSerifEthiopic_ExtraCondensed-Medium.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(35f);
            discountTextField.setFont(font);
            totalPriceTextField.setFont(font);
		} catch (Exception e) {
			e.printStackTrace();
			Font font = new Font("Serif", Font.PLAIN, 35);
            discountTextField.setFont(font);
            totalPriceTextField.setFont(font);
        }

        

        panelName.add(guestNameLabel);
        panelName.add(discountLabel);
        panelName.add(discountTextField);

        panelRoom.add(totalPriceLabel);
        panelRoom.add(totalPriceTextField);

        panelMiddle.add(panelName);
        panelMiddle.add(panelRoom);

        logoButton = new JButton();
        title = new JLabel("   Hotel Booking");
        panelFooter.setBackground(paleGreen1);
        panelFooter.setBorder(new EmptyBorder(0, 0, 75, 0));
        logoButton.setIcon(fullLogoImageIconGreen);
        logoButton.setBorderPainted(false);
        logoButton.setBackground(null);
        logoButton.setBorder(null);
        title.setHorizontalAlignment(SwingConstants.RIGHT);
        title.setForeground(beige);
        try {
			File fontStyle = new File("./src/fonts/NotoSerifEthiopic_Condensed-Regular.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(85f);
			title.setFont(font);
		} catch (Exception e) {
			e.printStackTrace();
			Font font = new Font("Serif", Font.PLAIN, 85);
            title.setFont(font);
        }

        panelFooter.add(logoButton);
        panelFooter.add(title);
		panelFooter.setBorder(new EmptyBorder(50, 100, 145, 100));

        parentPanel.add(panelSearch, BorderLayout.NORTH);
        parentPanel.add(panelMiddle, BorderLayout.CENTER);
        parentPanel.add(panelFooter, BorderLayout.SOUTH);
    }

    public JTextField getcheckInField() {
        return checkInField;
    }

    public JTextField getcheckOutField() {
        return checkOutField;
    }

    public JComboBox<String> getHotelList() {
        return hotelList;
    }

    public JLabel gethotelFieldJLabel() {
        return hotelFieldJLabel;
    }

    public JButton getBtnnextButton() {
        return nextButton;
    }

    public JPanel getParentPanel(){
        return parentPanel;
    }

    public JLabel getguestNameLabel(){
        return guestNameLabel;
    }

    public JLabel gettotalPriceTextField() {
        return totalPriceTextField;
    }

    public JTextField getdiscountTextField() {
        return discountTextField;
    }
    
    public JButton getlogoButton() {
        return logoButton;
    }
}