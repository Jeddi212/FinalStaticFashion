package view;

import model.MemberManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class CartScreenMenu implements ActionListener {
    //Deklarasi
    JFrame frame = new JFrame("Final Static Fashion");
    JPanel panelTop = new JPanel();
    JPanel panelLeft = new JPanel();
    JPanel panelRight = new JPanel();
    JPanel panelBottom = new JPanel();
    JPanel panelCenter = new JPanel();
    JPanel panelTitle = new JPanel(new GridLayout(2,1));

    //Title
    JLabel labelTitleWelcome = new JLabel("Welcome to Cart Menu");
    JLabel labelTitle = new JLabel("Final Static Fashion");

    //Button
    JButton logoutButton = new JButton("Logout");
    JButton shoppingMenuButton = new JButton("Back To Shopping Menu");

    public CartScreenMenu(){
        if(MemberManager.getInstance().getMember()!=null){
            labelTitleWelcome = new JLabel("Welcome "+MemberManager.getInstance().getMember().getUsername()+" to Shopping Menu");
        }else{
            new MainMenus();
            frame.dispose();
        }
        // Set Title Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("media/logoFSF.png");
        frame.setIconImage(icon);

        frame.setSize(1280,720);
        frame.setLayout(new BorderLayout());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Set Panel Size
        panelTop.setPreferredSize(new Dimension(1280,40));
        panelLeft.setPreferredSize(new Dimension(20, 600));
        panelCenter.setPreferredSize(new Dimension(1240, 600));
        panelRight.setPreferredSize(new Dimension(20, 600));
        panelBottom.setPreferredSize(new Dimension(1280, 80));
        panelTitle.setPreferredSize(new Dimension(1280, 130));

        // Set Panel Background Color
        panelTop.setBackground(Color.BLACK);
        panelLeft.setBackground(Color.BLACK);
        panelCenter.setBackground(Color.BLACK);
        panelRight.setBackground(Color.BLACK);
        panelBottom.setBackground(Color.BLACK);
        panelTitle.setBackground(Color.BLACK);

        // ADD FONT : Cramer Regular
        try {
            //create the font to use. Specify the size!
            MainMenus.crafterFont = Font.createFont(Font.TRUETYPE_FONT, new File("media/Crafter Regular.otf")).deriveFont(15f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(MainMenus.crafterFont);
        } catch (IOException | FontFormatException ignored) {}

        // ADD FONT : Mindfully Alternate Italic
        try {
            //create the font to use. Specify the size!
            MainMenus.mindfullyFont = Font.createFont(Font.TRUETYPE_FONT, new File("media/Mindfully Alternate Italic.ttf")).deriveFont(80f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(MainMenus.mindfullyFont);
        } catch (IOException | FontFormatException ignored) {}

        //Logout Button
        logoutButton.setFont(new Font("Arial", Font.BOLD, 15));
        logoutButton.setActionCommand("Logout");
        logoutButton.addActionListener(this);

        //Cart Button
        shoppingMenuButton.setFont(new Font("Arial", Font.BOLD, 15));
        shoppingMenuButton.setActionCommand("Shopping Menu");
        shoppingMenuButton.addActionListener(this);

        panelTop.setBorder(new EmptyBorder(0, 900, 0, 0));
        panelTop.add(shoppingMenuButton);
        panelTop.add(logoutButton);

        //Title Welcome
        labelTitleWelcome.setFont(MainMenus.crafterFont);
        labelTitleWelcome.setForeground(new Color(255,145,0));
        labelTitleWelcome.setHorizontalAlignment(JLabel.CENTER);
        panelTitle.add(labelTitleWelcome);

        //Title Final Static Fashion
        labelTitle.setFont(MainMenus.mindfullyFont);
        labelTitle.setForeground(new Color(255,145,0));
        labelTitle.setHorizontalAlignment(JLabel.CENTER);
        panelTitle.add(labelTitle);

        panelCenter.add(panelTitle);

        frame.add(panelTop,BorderLayout.NORTH);
        frame.add(panelLeft,BorderLayout.WEST);
        frame.add(panelCenter,BorderLayout.CENTER);
        frame.add(panelRight,BorderLayout.EAST);
        frame.add(panelBottom,BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Shopping Menu":
                new ShoppingScreenMenu();
                frame.dispose();
                break;
            case "Logout":
                // Logout account
                new MainMenus();
                frame.dispose();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }
}
