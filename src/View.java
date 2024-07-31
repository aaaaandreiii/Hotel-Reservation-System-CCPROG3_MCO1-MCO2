import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

public class View implements ActionListener {
    private JFrame frame;
    private JPanel parentPanel;
    private CardLayout panelSwitcher;

    private MainMenuGUI MainMenu;
    private CreateHotelGUI CreateHotel;
    private ViewHotelGUI ViewHotel;
    private ManageHotelGUI ManageHotel;
    private SimulateBookingGUI SimulateBooking;
    private SimulateBookingGUIPage2 SimulateBookingP2;
    private SimulateBookingGUIPage3 SimulateBookingP3;

    private static Color beige = new Color(254, 243, 226);
    private static Color darkBlue1 = new Color(96, 102, 118);
    private static Color darkBlue2 = new Color(127, 135, 156);
    private static Color darkBlue3 = new Color(158, 168, 194);
    private static Color paleGreen1 = new Color(112, 136, 113);
    private static Color paleGreen2 = new Color(92, 112, 93);
    private static Color paleGreen3 = new Color (50, 60, 50);
    private static ImageIcon logo = new ImageIcon("./src/photos/Logo.png");

    public View() {
        this.MainMenu = new MainMenuGUI();
        this.CreateHotel = new CreateHotelGUI();
        this.ViewHotel = new ViewHotelGUI();
        this.ManageHotel = new ManageHotelGUI();
        this.SimulateBooking = new SimulateBookingGUI();
        this.SimulateBookingP2 = new SimulateBookingGUIPage2();
        this.SimulateBookingP3 = new SimulateBookingGUIPage3();


        frame = new JFrame();
        parentPanel = new JPanel();
        panelSwitcher = new CardLayout();

        parentPanel.setBackground(beige);
        parentPanel.setBorder(null);
        parentPanel.setLayout(panelSwitcher);

        
        parentPanel.add(SimulateBooking.getParentPanel(), "1");
        parentPanel.add(MainMenu.getParentPanel(), "2");
        parentPanel.add(CreateHotel.getParentPanel(), "3");
        parentPanel.add(ViewHotel.getParentPanel(), "4");
        parentPanel.add(ManageHotel.getParentPanel(), "5");
        parentPanel.add(SimulateBookingP2.getParentPanel(), "1.2");
        parentPanel.add(SimulateBookingP3.getParentPanel(), "1.3");

        panelSwitcher.show(parentPanel, "1");

        addMouseListenerToButton(this.SimulateBooking.getBtnAdminMode(), darkBlue1, darkBlue2, darkBlue3);
        addMouseListenerToButton(this.SimulateBooking.getBtnSearchButton(), darkBlue1, darkBlue2, darkBlue3);
        addMouseListenerToButton(this.SimulateBookingP2.getBtnnextButton(), darkBlue1, darkBlue2, darkBlue3);
        addMouseListenerToButton(this.SimulateBookingP3.getBtnnextButton(), darkBlue1, darkBlue2, darkBlue3);

        addMouseListenerToButton(this.MainMenu.getlogoButton(), null, null, null);
        addMouseListenerToButton(this.MainMenu.getBtnCreateHotel(), paleGreen1, paleGreen2, paleGreen3);
        addMouseListenerToButton(this.MainMenu.getBtnViewHotel(), paleGreen1, paleGreen2, paleGreen3);
        addMouseListenerToButton(this.MainMenu.getBtnManageHotel(), paleGreen1, paleGreen2, paleGreen3);
        addMouseListenerToButton(this.MainMenu.getBtnSimulateBooking(), paleGreen1, paleGreen2, paleGreen3);

        addMouseListenerToButton(this.CreateHotel.getsubmitButton(), darkBlue1, darkBlue2, darkBlue3);
        addMouseListenerToButton(this.CreateHotel.getMainMenuButton(), darkBlue1, darkBlue2, darkBlue3);

        addMouseListenerToButton(this.ViewHotel.getBtnViewHighLevelHotelInformation(), paleGreen1, paleGreen2, paleGreen3);
        addMouseListenerToButton(this.ViewHotel.getBtnViewHotelsAvailableandBookedRooms(), paleGreen1, paleGreen2, paleGreen3);
        addMouseListenerToButton(this.ViewHotel.getBtnViewInfoOfSelectedReservation(), paleGreen1, paleGreen2, paleGreen3);
        addMouseListenerToButton(this.ViewHotel.getBtnViewInfoOfSelectedRoom(), paleGreen1, paleGreen2, paleGreen3);
        addMouseListenerToButton(this.ViewHotel.getMainMenuButton(), darkBlue1, darkBlue2, darkBlue3);

        addMouseListenerToButton(this.ManageHotel.getBtnChangeNameofHotel(), paleGreen1, paleGreen2, paleGreen3);
        addMouseListenerToButton(this.ManageHotel.getBtnAddRooms(), paleGreen1, paleGreen2, paleGreen3);
        addMouseListenerToButton(this.ManageHotel.getBtnRemoveRooms(), paleGreen1, paleGreen2, paleGreen3);
        addMouseListenerToButton(this.ManageHotel.getBtnUpdateBasePriceofRooms(), paleGreen1, paleGreen2, paleGreen3);
        addMouseListenerToButton(this.ManageHotel.getRemoveReservation(), paleGreen1, paleGreen2, paleGreen3);
        addMouseListenerToButton(this.ManageHotel.getRemoveHotel(), paleGreen1, paleGreen2, paleGreen3);
        addMouseListenerToButton(this.ManageHotel.getMainMenuButton(), darkBlue1, darkBlue2, darkBlue3);
        
        setPlaceholder(this.SimulateBooking.getcheckInField(), " DD-MM-YYYY", beige, 22);
        setPlaceholder(this.SimulateBooking.getcheckOutField(), " DD-MM-YYYY", beige, 22);
        setPlaceholder(this.CreateHotel.getnewHotelTextField(), " Enter name of new hotel here: ", darkBlue1, 30);
        setPlaceholder(this.SimulateBookingP2.getcheckInField(), " DD-MM-YYYY", beige, 22);
        setPlaceholder(this.SimulateBookingP2.getcheckOutField(), " DD-MM-YYYY", beige, 22);
        setPlaceholder(this.SimulateBookingP2.getguestNameTextField(), " Enter your name here: ", beige, 35);
        setPlaceholder(this.SimulateBookingP3.getcheckInField(), " DD-MM-YYYY", beige, 22);
        setPlaceholder(this.SimulateBookingP3.getcheckOutField(), " DD-MM-YYYY", beige, 22);
        setPlaceholder(this.SimulateBookingP3.getdiscountTextField(), " CCPROG3_EZ4.0 ", beige, 35);


        frame.setTitle("Opulence Oasis");
        frame.add(parentPanel);
        frame.setIconImage(logo.getImage());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000, 1000));
        frame.setMaximumSize(new Dimension(1000, 1000));
        frame.pack();
        frame.getContentPane().setBackground(beige);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ((JFrame) e.getSource()).dispose();
            }
        });
    }

    public static void addMouseListenerToButton(JButton btn, Color color1, Color color2, Color color3) {        
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                String currentText = btn.getText();
                if (!currentText.startsWith("<html>"))
                    btn.setText("<html><b>" + currentText + "</b></html>");
                else
                    btn.setText(currentText.replace("<html>", "<html><b>").replace("</html>", "</b></html>"));
                // btn.setSize(btn.getSize().width + 5, btn.getSize().height + 5);
                btn.setBackground(color2);
            }
                
            public void mouseExited(MouseEvent e) {
                String currentText = btn.getText();
                if (currentText.contains("<b>") && currentText.contains("</b>")) 
                    btn.setText(currentText.replace("<html><b>", "<html>").replace("</b></html>", "</html>"));
                else 
                    btn.setText("<html>" + currentText.replace("<b>", "").replace("</b>", "") + "</html>");

                // btn.setSize(btn.getSize().width - 5, btn.getSize().height - 5);
                btn.setBackground(color1);
            }

            public void mouseClicked(MouseEvent e) {
                btn.setBackground(color1);
            }

            public void mousePressed(MouseEvent e) {
                btn.setBackground(color3);
            }
        });
    }

    public void setPlaceholder(JTextField textField, String placeholder, Color color, float size) {
        textField.setText(placeholder);
        textField.setForeground(color);

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent fe) {
                try {
                    File fontStyle = new File("./src/fonts/NotoSerifEthiopic_ExtraCondensed-Medium.ttf");
                    Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(size);
                    textField.setFont(font);
                } catch (Exception e) {
                    e.printStackTrace();
                    Font font = new Font("Serif", Font.PLAIN, (int) size);
                    textField.setFont(font);
                }
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(color);
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                try {
                    File fontStyle = new File("./src/fonts/NotoSerifEthiopic_ExtraCondensed-Light.ttf");
                    Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(size);
                    textField.setFont(font);
                } catch (Exception e) {
                    e.printStackTrace();
                    Font font = new Font("Serif", Font.PLAIN, (int) size);
                    textField.setFont(font);
                }
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(color);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public void exitApplication() {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getParentPanel() {
		return parentPanel;
	}

	public void setParentPanel(JPanel parentPanel) {
		this.parentPanel = parentPanel;
	}

	public CardLayout getPanelSwitcher() {
		return panelSwitcher;
	}

	public void setPanelSwitcher(CardLayout panelSwitcher) {
		this.panelSwitcher = panelSwitcher;
	}

    public MainMenuGUI getMainMenu(){
        return MainMenu;
    }
    public CreateHotelGUI getCreateHotel(){
        return CreateHotel;
    }
    public ViewHotelGUI getViewHotel(){
        return ViewHotel;
    }
    public ManageHotelGUI getManageHotel(){
        return ManageHotel;
    }
    public SimulateBookingGUI getSimulateBooking(){
        return SimulateBooking;
    }

    public SimulateBookingGUIPage2 getSimulateBookingP2() {
        return SimulateBookingP2;
    }

    public SimulateBookingGUIPage3 getSimulateBookingP3() {
        return SimulateBookingP3;
    }

	public void setMainMenu(MainMenuGUI mainMenu) {
		MainMenu = mainMenu;
	}
	public void setCreateHotel(CreateHotelGUI createHotel) {
		CreateHotel = createHotel;
	}
	public void setViewHotel(ViewHotelGUI viewHotel) {
		ViewHotel = viewHotel;
	}
	public void setManageHotel(ManageHotelGUI manageHotel) {
		ManageHotel = manageHotel;
	}
	public void setSimulateBooking(SimulateBookingGUI simulateBooking) {
		SimulateBooking = simulateBooking;
	}
}