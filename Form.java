import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
class Form extends JFrame implements ActionListener {
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JButton signin = new JButton("Log In");

    String EmpIDUser;

    Form(){
        //Header
        JPanel heading;
        heading = new JPanel();
        heading.setBackground(new Color(0,0,0,80));
        heading.setBounds(0,0,1200,140);
        ImageIcon logo = new ImageIcon("Images\\Grill & chill.png");
        JLabel background2 = new JLabel("",logo,JLabel.CENTER);
        background2.setBounds(200,25,400,50);
        heading.add(background2);

        // Login Frame
        JPanel login = new JPanel();
        login.setSize(400,350);
        login.setLayout(null);
        login.setBackground(new Color(0,0,0,150));
        login.setBounds(120,200,400,350);

        username.setBounds(75,80,250,30);
        JLabel user_id= new JLabel("Username");
        user_id.setBounds(75,50,250,30);
        user_id.setForeground(Color.WHITE);
        login.add(user_id);
        login.add(username);

        password.setBounds(75,150,250,30);
        JLabel user_pass= new JLabel("Password");
        user_pass.setBounds(75,120,250,30);
        user_pass.setForeground(Color.WHITE);
        login.add(user_pass);
        login.add(password);

        signin.setBounds(140,250,120,30);
        signin.setBackground(Color.white);
        login.add(signin);
        signin.addActionListener(this);

        // Main Frame
        setSize(1200,700);
        setLocation(170,60);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Background
        ImageIcon bg = new ImageIcon("Images\\Img1.png");
        JLabel background = new JLabel("",bg,JLabel.CENTER);

        background.add(login);
        background.add(heading);
        background.setBounds(0,0,1200,700);
        add(background);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){
        String user = username.getText();
        String pass = password.getText();
        try
        {
            conn c =new conn();
            String query= ("select * from employee where username ='"+user+ "'and password = '"+pass+"'");
            ResultSet rs= c.s.executeQuery(query);

            if(rs.next()){
            EmpIDUser= rs.getString("ID");
            setVisible(false);

            new Home();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid Username or Password");
            }
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Form();
    }
}
