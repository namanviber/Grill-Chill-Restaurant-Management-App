import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.ECField;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.File;
import java.io.FileWriter;
import java.lang.*;
import java.util.*;
import java.text.SimpleDateFormat;

class Home extends JFrame implements ActionListener{

    //    HOME SCREEN DEFAULT
    ImageIcon bg = new ImageIcon("Images\\Img3.png");
    JLabel background = new JLabel("",bg,JLabel.CENTER);
    JButton logout = new JButton("Log Out");
    JButton show = new JButton("Show Menu");
    JButton order = new JButton("Manage Orders");
    JButton Emp = new JButton("Manage Employees");
    JButton sale = new JButton("Show Sales Report");
    JButton pay = new JButton("Show Payment Details");
    JInternalFrame Screen = new JInternalFrame();

    //    MENU
    JInternalFrame menuscreen = new JInternalFrame();
    JButton Continental = new JButton("Continental");
    JButton Add = new JButton("Add Items");
    JButton Del = new JButton("Delete Items");
    JButton Edit = new JButton("Edit Menu Items");
    JButton All = new JButton("All Items");
    JButton Italian = new JButton("Italian");
    JButton Chinese = new JButton("Chinese");
    JButton Indian = new JButton("Indian");
    JButton Beverages = new JButton("Beverages");
    JPanel Filter = new JPanel();
    JInternalFrame Items = new JInternalFrame();
    JTable table = new JTable();

    //    EMPLOYEE SCREEEN
    JInternalFrame empscreen = new JInternalFrame();
    JPanel Manage = new JPanel();
    JButton showemp = new JButton("Show Details");
    JButton AddEmp = new JButton("Add Employees");
    JButton DelEmp = new JButton("Delete Employees");
    JButton EditEmp = new JButton("Edit Employees");

    JInternalFrame EmpDetails = new JInternalFrame();
    JTable emptable = new JTable();

    //    PAYMENT SCREEN
    JInternalFrame paymentscreen = new JInternalFrame();
    JPanel Transaction = new JPanel();
    JButton Trans = new JButton("Generate Transaction Bill");
    JButton addTrans = new JButton("Add Transaction");
    JButton showTrans = new JButton("Show Transactions");
    JInternalFrame TransDetails = new JInternalFrame();
    JTable transtable = new JTable();
    static int billid;

    //    SALE SCREEN
    JInternalFrame salescreen = new JInternalFrame();
    JPanel Sales = new JPanel();
    JButton Txt = new JButton("Generate Total Sales Txt File");
    JButton showTxt = new JButton("Show Sales");
    JInternalFrame SaleDetails = new JInternalFrame();
    JTable salestable = new JTable();

    //    ORDER SCREEN
    JInternalFrame orderscreen = new JInternalFrame();
    JPanel Orders = new JPanel();
    JButton New = new JButton("New");
    JButton Editorder = new JButton("Edit");
    JButton Close = new JButton("Close");
    JButton Cancel = new JButton("Cancel");
    JButton showorder = new JButton("Show Orders");
    JButton additems = new JButton("Add Item");
    JInternalFrame OrderDetails = new JInternalFrame();
    JInternalFrame MenuDetails = new JInternalFrame();
    JTable OrderTable = new JTable();
    static int orderid;

    Home(){

        // Menu Bar
        JPanel Menu = new JPanel();
        Menu.setSize(250,700);
        Menu.setLayout(null);
        Menu.setBounds(0,0,250,700);
        Menu.setBackground(new Color(0,0,0,150));

        show.setBounds(0,0,250,135);
        show.setBackground(Color.orange);
        Menu.add(show);
        show.addActionListener(this);

        order.setBounds(0,135,250,135);
        order.setBackground(Color.orange);
        Menu.add(order);
        order.addActionListener(this);

        Emp.setBounds(0,270,250,135);
        Emp.setBackground(Color.orange);
        Menu.add(Emp);
        Emp.addActionListener(this);

        sale.setBounds(0,405,250,135);
        sale.setBackground(Color.orange);
        Menu.add(sale);
        sale.addActionListener(this);

        pay.setBounds(0,540,250,135);
        pay.setBackground(Color.orange);
        Menu.add(pay);
        pay.addActionListener(this);

        // Main Frame
        setSize(1200,700);
        setLocation(170,60);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Background
        background.setBounds(0,0,1200,700);
        add(background);
        background.add(Menu);
        setVisible(true);

        //Logout
        logout.setBounds(1010,10,160,40);
        logout.setBackground(Color.white);
        background.add(logout);
        logout.addActionListener(this);


        // Screen
        Screen.setBounds(260,60,910,590);
//        Screen.setResizable(false);
        Screen.setBackground(Color.white);
        Screen.setVisible(true);
        Screen.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));
        background.add(Screen);
        repaint();
        revalidate();

    }
    void MenuItems(){

        menuscreen.setBounds(260,60,910,590);
        menuscreen.setBackground(new Color(0,0,0,90));
        menuscreen.setVisible(true);
        menuscreen.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));

        Items.setBounds(20,90,870,380);
        Items.setBackground(new Color(0,0,0,90));
        Items.setVisible(true);
        Items.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));



        Filter.setLayout(null);


        Add.setBounds(100,490,200,50);
        Add.setBackground(Color.orange);
        Add.addActionListener(this);
        menuscreen.add(Add);


        Del.setBounds(350,490,200,50);
        Del.setBackground(Color.orange);
        Del.addActionListener(this);
        menuscreen.add(Del);

        Edit.setBounds(600,490,200,50);
        Edit.setBackground(Color.orange);
        Edit.addActionListener(this);
        menuscreen.add(Edit);


        All.setBounds(150,20,100,50);
        All.setBackground(Color.orange);
        All.addActionListener(this);
        Filter.add(All);


        Italian.setBounds(250,20,100,50);
        Italian.addActionListener(this);
        Italian.setBackground(Color.orange);
        Filter.add(Italian);

        Chinese.setBounds(350,20,100,50);
        Chinese.setBackground(Color.orange);
        Chinese.addActionListener(this);
        Filter.add(Chinese);


        Continental.setBounds(450,20,100,50);
        Continental.setBackground(Color.orange);
        Continental.addActionListener(this);
        Filter.add(Continental);


        Indian.setBounds(550,20,100,50);
        Indian.setBackground(Color.orange);
        Indian.addActionListener(this);
        Filter.add(Indian);


        Beverages.setBounds(650,20,100,50);
        Beverages.setBackground(Color.orange);
        Beverages.addActionListener(this);
        Filter.add(Beverages);

        String q = "select * from menu";
        MenuItems(q);

        JScrollPane sp = new JScrollPane(table);
        Items.add(sp);
        menuscreen.add(Items);

        menuscreen.add(Filter);
        background.add(menuscreen);
        Screen.dispose();
        empscreen.dispose();
        paymentscreen.dispose();
        salescreen.dispose();
        orderscreen.dispose();
        repaint();
        revalidate();
    }
    void MenuItems(String str){
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "NAME", "PRICE","CATEGORY"}, 0);

        try
        {
            conn c = new conn();
            String q = str;
            ResultSet rs = c.s.executeQuery(q);


            while(rs.next())
            {
                String d = rs.getString("menu_id");
                String n = rs.getString("name");
                String f = rs.getString("price");
                String g = rs.getString("category");
                model.addRow(new Object[]{d, n, f,g});
            }
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

        table.setModel(model);
    }
    void additem() {
        JPanel popup = new JPanel(new GridLayout(4,2));
        JTextField id = new JTextField(10);
        JTextField name = new JTextField(10);
        JTextField price = new JTextField(10);
        JTextField category = new JTextField(10);

        JLabel idlabel = new JLabel("Enter Id :");
        JLabel namelabel = new JLabel("Enter Item Name :");
        JLabel pricelabel = new JLabel("Enter Price :");
        JLabel catlabel = new JLabel("Enter Category :");

        popup.add(idlabel);
        popup.add(id);
        popup.add(namelabel);
        popup.add(name);
        popup.add(pricelabel);
        popup.add(price);
        popup.add(catlabel);
        popup.add(category);
        JOptionPane.showMessageDialog(null, popup);

        try
        {
            conn c = new conn();
            String q = ("insert into menu values ('"+id.getText()+"','"+name.getText()+"','"+price.getText()+"','"+category.getText()+"')");
            Statement st = c.c.createStatement();
            st.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Item Added Succesfully");
        }

        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Please Try Again");
        }

    }
    void deleteitem() {
        JPanel popup = new JPanel(new GridLayout(4,2));
        JTextField id = new JTextField(10);

        JLabel idlabel = new JLabel("Enter Item Id :");

        popup.add(idlabel);
        popup.add(id);
        JOptionPane.showMessageDialog(null, popup);

        try
        {
            conn c = new conn();
            String q = ("delete from menu where menu_id = '"+id.getText()+"'");
            Statement st = c.c.createStatement();
            st.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Item Deleted Succesfully");
        }catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Please Try Again");
        }

    }
    void modifyitem() {
        JPanel popup = new JPanel(new GridLayout(4,2));
        JTextField id = new JTextField(10);
        JTextField names = new JTextField(10);
        JTextField price = new JTextField(10);
        JTextField category = new JTextField(10);

        JLabel idlabel = new JLabel("Enter Id :");
        JLabel namelabel = new JLabel("Enter Item Name :");
        JLabel pricelabel = new JLabel("Enter Price :");
        JLabel catlabel = new JLabel("Enter Category :");

        popup.add(idlabel);
        popup.add(id);
        popup.add(namelabel);
        popup.add(names);
        popup.add(pricelabel);
        popup.add(price);
        popup.add(catlabel);
        popup.add(category);
        JOptionPane.showMessageDialog(null, popup);

        try
        {
            conn c = new conn();
            String q = ("update menu set category = '"+category.getText()+"', name = '"+names.getText()+"', price = '"+price.getText()+"' where menu_id = '"+id.getText()+"'");
            Statement st = c.c.createStatement();
            st.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Item Modified Succesfully");
        }

        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Please Try Again");
        }

    }
    void Employees(){

        empscreen.setBounds(260,60,910,590);
        empscreen.setBackground(new Color(0,0,0,90));
        empscreen.setVisible(true);
        empscreen.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));

        EmpDetails.setBounds(20,20,870,450);
        EmpDetails.setBackground(new Color(0,0,0,90));
        EmpDetails.setVisible(true);
        EmpDetails.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));

        Emp_data();
        JScrollPane sp = new JScrollPane(emptable);
        EmpDetails.add(sp);
        empscreen.add(EmpDetails);

        Manage.setLayout(null);

        showemp.setBounds(250,490,180,50);
        showemp.setBackground(Color.orange);
        showemp.addActionListener(this);
        Manage.add(showemp);

        AddEmp.setBounds(25,490,180,50);
        AddEmp.setBackground(Color.orange);
        AddEmp.addActionListener(this);
        Manage.add(AddEmp);

        DelEmp.setBounds(475,490,180,50);
        DelEmp.setBackground(Color.orange);
        DelEmp.addActionListener(this);
        Manage.add(DelEmp);

        EditEmp.setBounds(700,490,180,50);
        EditEmp.setBackground(Color.orange);
        EditEmp.addActionListener(this);
        Manage.add(EditEmp);

        empscreen.add(Manage);
        background.add(empscreen);
        Screen.dispose();
        menuscreen.dispose();
        paymentscreen.dispose();
        salescreen.dispose();
        orderscreen.dispose();
        repaint();
        revalidate();

    }
    void Emp_data(){
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "NAME","CONTACT","DESIGNATION"}, 0);

        try
        {
            conn c = new conn();
            String q = "select * from employee";
            ResultSet rs = c.s.executeQuery(q);

            while(rs.next())
            {
                String d = rs.getString("Id");
                String e = rs.getString("Name");
                String f = rs.getString("Contact");
                String g = rs.getString("Designantion");

                model.addRow(new Object[]{d,e,f,g});
            }
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        emptable.setModel(model);
    }
    void addemp(){
        JPanel Add_emp = new JPanel(new GridLayout(6,2));

        JTextField empid=new JTextField(10);
        JTextField empname=new JTextField(10);
        JTextField empcontact=new JTextField(10);
        JTextField designation=new JTextField(10);
        JTextField uname=new JTextField(10);
        JTextField password=new JTextField(10);

        JLabel l_ID= new JLabel("Emp ID");
        JLabel l_Name= new JLabel("Emp Name");
        JLabel l_Contact= new JLabel("Emp contact");
        JLabel l_designation= new JLabel("Designation");
        JLabel l_Username= new JLabel("UserName");
        JLabel l_Password= new JLabel("Create Password");

        Add_emp.add(l_ID);
        Add_emp.add(empid);
        Add_emp.add(l_Name);
        Add_emp.add(empname);
        Add_emp.add(l_Contact);
        Add_emp.add(empcontact);
        Add_emp.add(l_designation);
        Add_emp.add(designation);
        Add_emp.add(l_Username);
        Add_emp.add(uname);
        Add_emp.add(l_Password);
        Add_emp.add(password);
        JOptionPane.showMessageDialog(null, Add_emp);

        try
        {
            conn c = new conn();
            String q = ("insert into employee values ('"+empid.getText()+"','"+empname.getText()+"','"+empcontact.getText()+"','"+designation.getText()+"','"+password.getText()+"','"+uname.getText()+"')");
            Statement st = c.c.createStatement();
            st.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Employee Added Succesfully");
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Please Try Again");
        }
    }
    void deleteemp() {
        JPanel popup = new JPanel(new GridLayout(1,1));
        JTextField id = new JTextField(10);
        JLabel idlabel = new JLabel("Enter Emp Id :");

        popup.add(idlabel);
        popup.add(id);

        JOptionPane.showMessageDialog(null, popup);

        try
        {
            conn c = new conn();
            String q = ("delete from employee where ID = '"+id.getText()+"'");
            Statement st = c.c.createStatement();
            st.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Employee Record Deleted Succesfully");
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Please Try Again");
        }

    }
    void modifyemp() {
        JPanel Add_emp = new JPanel(new GridLayout(6,2));

        JTextField empid=new JTextField(10);
        JTextField empname=new JTextField(10);
        JTextField empcontact=new JTextField(10);
        JTextField designation=new JTextField(10);
        JTextField uname=new JTextField(10);
        JTextField password=new JTextField(10);

        JLabel l_ID= new JLabel("Emp ID");
        JLabel l_Name= new JLabel("Emp Name");
        JLabel l_Contact= new JLabel("Emp contact");
        JLabel l_designation= new JLabel("Designation");
        JLabel l_Username= new JLabel("UserName");
        JLabel l_Password= new JLabel("Create Password");

        Add_emp.add(l_ID);
        Add_emp.add(empid);
        Add_emp.add(l_Name);
        Add_emp.add(empname);
        Add_emp.add(l_Contact);
        Add_emp.add(empcontact);
        Add_emp.add(l_designation);
        Add_emp.add(designation);
        Add_emp.add(l_Username);
        Add_emp.add(uname);
        Add_emp.add(l_Password);
        Add_emp.add(password);
        JOptionPane.showMessageDialog(null, Add_emp);

        try
        {
            conn c = new conn();
            String q = ("update employee set ID = '"+empid.getText()+"', name = '"+empname.getText()+"', contact = '"+empcontact.getText()+"', designantion = '"+designation.getText()+"', username = '"+uname.getText()+"', password = '"+password.getText()+"'where ID = '"+empid.getText()+"'");
            Statement st = c.c.createStatement();
            st.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Employee Record Modified Succesfully");
        }

        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Please Try Again");
        }

    }
    void Payments(){
        paymentscreen.setBounds(260,60,910,590);
        paymentscreen.setBackground(new Color(0,0,0,90));
        paymentscreen.setVisible(true);
        paymentscreen.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));

        TransDetails.setBounds(20,20,870,450);
        TransDetails.setBackground(new Color(0,0,0,90));
        TransDetails.setVisible(true);
        TransDetails.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));

        PayTable(1,1);
        JScrollPane sp = new JScrollPane(transtable);
        TransDetails.add(sp);
        paymentscreen.add(TransDetails);

        Transaction.setLayout(null);


        Trans.setBounds(600,490,200,50);
        Trans.setBackground(Color.orange);
        Trans.addActionListener(this);
        Transaction.add(Trans);

        addTrans.setBounds(350,490,200,50);
        addTrans.setBackground(Color.orange);
        addTrans.addActionListener(this);
        Transaction.add(addTrans);

        showTrans.setBounds(100,490,200,50);
        showTrans.setBackground(Color.orange);
        showTrans.addActionListener(this);
        Transaction.add(showTrans);

        paymentscreen.add(Transaction);
        background.add(paymentscreen);
        Screen.dispose();
        menuscreen.dispose();
        empscreen.dispose();
        salescreen.dispose();
        orderscreen.dispose();
        repaint();
        revalidate();

    }
    void PayTable(int x,int z){
        DefaultTableModel model = new DefaultTableModel(new String[]{"Bill ID","Order ID","Menu ID","Menu Name","Quantity","Price","Total Price","Employee ID","Date of Purchase"}, 0);
        int count = 0;
        String a = "";
        String b = "";
        String jj[] = new String[10];
        String dd[] = new String[10];
        String ee[] = new String[10];
        String ff[] = new String[10];
        String gg[] = new String[10];
        try
        {
            conn c = new conn();
            String i;
            if(x==0){
                i = "select payment.bill_id,orders.orderid,menu.menu_id,menu.name,orders.quantity,menu.price,(menu.price*orders.quantity) as Total,payment.emp_id,payment.purchase_date from orders join payment on payment.order_id=orders.orderid join menu on menu.menu_id=orders.menu_id where orders.orderid = '"+z+"'";
            }
            else{
                i = "select payment.bill_id,orders.orderid,menu.menu_id,menu.name,orders.quantity,menu.price,(menu.price*orders.quantity) as Total,payment.emp_id,payment.purchase_date from orders join payment on payment.order_id=orders.orderid join menu on menu.menu_id=orders.menu_id ";

            }
            ResultSet rs = c.s.executeQuery(i);

            while(rs.next())
            {
                a = rs.getString("payment.bill_id");
                b = rs.getString("orders.orderid");
                String j = rs.getString("menu.menu_id");
                jj[count] = j;
                String d = rs.getString("menu.name");
                dd[count] = d;
                String e = rs.getString("orders.quantity");
                ee[count] = e;
                String f = rs.getString("menu.price");
                ff[count] = f;
                String g = rs.getString("total");
                gg[count] = g;
                String h = rs.getString("payment.emp_id");
                String k = rs.getString("payment.purchase_date");
                count++;
                model.addRow(new Object[]{a,b,j,d,e,f,g,h,k});
            }
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        if(x==0){
            generateReport(a, b, jj,dd,ee,ff,gg,count);
        }

        transtable.setModel(model);
    }
    void addpayment(){
        JPanel popup = new JPanel(new GridLayout(4,2));
        JTextField empid = new JTextField(10);
        JTextField orderid = new JTextField(10);
        JTextField mode = new JTextField(10);

        JLabel empidlabel = new JLabel("Enter Employee Id :");
        JLabel orderidlabel = new JLabel("Enter Order Id :");
        JLabel modelabel = new JLabel("Enter Mode of Payment :");

        popup.add(empidlabel);
        popup.add(empid);
        popup.add(orderidlabel);
        popup.add(orderid);
        popup.add(modelabel);
        popup.add(mode);
        JOptionPane.showMessageDialog(null, popup);
        try{
            conn c = new conn();
            String query= ("SELECT * FROM payment ORDER BY bill_id DESC LIMIT 1;");
            ResultSet rs= c.s.executeQuery(query);
            if(rs.next()){
                String s =  rs.getString("bill_id");
                billid  = Integer.parseInt(s);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        try
        {
            conn c = new conn();
            String q = ("insert into payment values ('"+(billid+1)+"','"+orderid.getText()+"',curdate(),'"+empid.getText()+"','"+mode.getText()+"')");
            Statement st = c.c.createStatement();
            st.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Item Added Succesfully");
        }

        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Please Try Again");
        }

    }
    void generateReport(String a,String b,String[] jj,String[] dd,String[] ee,String[] ff,String[] gg,int count){
        try{
            File file = new File("Notepad Files\\PaymentReport.txt");
            if(!file.exists()){
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());

            fw.write("\t\t\t\t--------------------Invoice-----------------\n\n");
            fw.write("\t\t\t\t\t\t "+"  "+"Grill & Chill\n\n");
            fw.write("\t\t\t\t\t\tBML Munjal University\n\n");
            fw.write("\t\t\t\t\t"  +"    " +"Kapriwas Sidhrawali Haryana\n\n");
            fw.write("GSTIN: 03AWBPP8756K592"+"\t\t\t\t\t\t\t\t\tContact: (+91) 8307607758\n\n");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
            fw.write("Date: "+formatter.format(date)+"  "+days[calendar.get(Calendar.DAY_OF_WEEK) - 1]+"\t\t\t\t\t\t\t (+91) 8822554411\n\n");

            fw.write("------------------------------------------------------------------------------------------------------------------");
            fw.write("\nProduct ID \t\tName\t\tQuantity\t\tRate \t\t\t\tTotal Price\n");
            fw.write("--------------------------------------------------------------------------------------------------------------------\n");

            for (int i=0;i < count; i++) {
                fw.write(jj[i]+"\t\t\t\t");
                fw.write(dd[i]+"\t\t\t\t");
                fw.write(ee[i]+"\t\t\t\t");
                fw.write(ff[i]+"\t\t\t\t");
                fw.write(gg[i]+"\n");
            }

            int y = 0;
            for (int i=0;i < count; i++) {
                y += Integer.parseInt(gg[i]);
            }

            double sgst = 0.05*y;
            double cgst = 0.05*y;
            fw.write("\n\n\nBill Id: " +a);
            fw.write("\nOrder Id: " +b);
            fw.write("\nMode of Transaction:  " +"Cash");
            fw.write("\n\n\nTotal Amount (Rs.):   " +y);
            fw.write("\nSGST (5%):                "+sgst);
            fw.write("\nCGST (5%):                "+cgst);
            fw.write("\nNet Amount:               "+(y+sgst+cgst));

            fw.write("\n\n\t\t\t\t----------------Thank You for Shopping!!-----------------\n\n");
            fw.write("\t\t\t\t                     Visit Again");

            fw.close();
            JOptionPane.showMessageDialog(null, "Data Exported Succesfully");

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Please Try Again");
        }

    }
    void generateSalesReport(String[] ord, String[] totpay, int count){
        try{
            File file = new File("Notepad Files\\SalesReport.txt");
            if(!file.exists()){
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());

            fw.write("\t\t\t\t--------------------Sales Report-----------------\n\n");
            fw.write("\t\t\t\t\t\t "+"  "+"Grill & Chill\n\n");
            fw.write("\t\t\t\t\t\tBML Munjal University\n\n");
            fw.write("\t\t\t\t\t"  +"    " +"Kapriwas Sidhrawali Haryana\n\n");
            fw.write("GSTIN: 03AWBPP8756K592"+"\t\t\t\t\t\t\t\t\tContact: (+91) 8307607758\n\n");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
            fw.write("Date: "+formatter.format(date)+"  "+days[calendar.get(Calendar.DAY_OF_WEEK) - 1]+"\t\t\t\t\t\t\t (+91) 8822554411\n\n");

            fw.write("------------------------------------------------------------------------------------------------------------------");
            fw.write("\nOrder ID \t\tTotal Amount\n");
            fw.write("--------------------------------------------------------------------------------------------------------------------\n");

            for (int i=0; i < count; i++){
                fw.write(ord[i]+"\t\t\t\t");
                fw.write(totpay[i]+"\n");
            }
            int y =0;
            for (int i=0; i < count; i++){
                y += Integer.parseInt(totpay[i]);
            }

            fw.write("\n\n\nTotal Sales: " +y);

            fw.close();
            JOptionPane.showMessageDialog(null, "Data Exported Succesfully");

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Please Try Again");
        }

    }
    void TotalSale(){

        salescreen.setBounds(260,60,910,590);
        salescreen.setBackground(new Color(0,0,0,90));
        salescreen.setVisible(true);
        salescreen.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));

        SaleDetails.setBounds(20,20,870,450);
        SaleDetails.setBackground(new Color(0,0,0,90));
        SaleDetails.setVisible(true);
        SaleDetails.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));

        SaleTable(1);

        JScrollPane sp = new JScrollPane(salestable);
        SaleDetails.add(sp);
        salescreen.add(SaleDetails);

        Sales.setLayout(null);

        Txt.setBounds(500,490,300,50);
        Txt.setBackground(Color.orange);
        Txt.addActionListener(this);
        Sales.add(Txt);

        showTxt.setBounds(150,490,300,50);
        showTxt.setBackground(Color.orange);
        showTxt.addActionListener(this);
        Sales.add(showTxt);

        salescreen.add(Sales);
        background.add(salescreen);
        Screen.dispose();
        menuscreen.dispose();
        empscreen.dispose();
        paymentscreen.dispose();
        orderscreen.dispose();
        revalidate();
        repaint();
    }
    void SaleTable(int a){
        DefaultTableModel model = new DefaultTableModel(new String[]{"Order ID","Bill Amount"}, 0);
        int count = 0;
        String dd[] = new String[10];
        String hh[] = new String[10];
        try
        {
            conn c = new conn();
            String q = "select orders.orderid,sum(menu.price*orders.quantity) as Total from orders join payment on payment.order_id=orders.orderid join menu on menu.menu_id=orders.menu_id where payment.purchase_date=curdate() group by orders.orderid ;";
            ResultSet rs = c.s.executeQuery(q);

            while(rs.next())
            {
                String d = rs.getString("orderid");
                dd[count] = d;
                String h = rs.getString("total");
                hh[count] = h;

                count++;
                model.addRow(new Object[]{d,h});
            }
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        if (a == 0){
            generateSalesReport(dd,hh,count);
        }

        salestable.setModel(model);
    }
    void ManageOrders(){

        orderscreen.setBounds(260,60,910,590);
        orderscreen.setBackground(new Color(0,0,0,90));
        orderscreen.setVisible(true);
        orderscreen.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));

        OrderDetails.setBounds(20,20,420,460);
        OrderDetails.setBackground(new Color(0,0,0,90));
        OrderDetails.setVisible(true);
        OrderDetails.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));

        MenuDetails.setBounds(460,20,420,460);
        MenuDetails.setBackground(new Color(0,0,0,90));
        MenuDetails.setVisible(true);
        MenuDetails.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));

        String q = "select * from menu";
        MenuItems(q);

        orderprint();
        JScrollPane sp = new JScrollPane(OrderTable);
        JScrollPane sp1 = new JScrollPane(table);
        OrderDetails.add(sp);
        orderscreen.add(OrderDetails);
        MenuDetails.add(sp1);
        orderscreen.add(MenuDetails);
        Orders.setLayout(null);

        showorder.setBounds(30,490,120,50);
        showorder.setBackground(Color.orange);
        showorder.addActionListener(this);
        Orders.add(showorder);

        New.setBounds(180,490,120,50);
        New.setBackground(Color.orange);
        New.addActionListener(this);
        Orders.add(New);

        Editorder.setBounds(320,490,120,50);
        Editorder.setBackground(Color.orange);
        Editorder.addActionListener(this);
        Orders.add(Editorder);

        additems.setBounds(460,490,120,50);
        additems.setBackground(Color.orange);
        additems.addActionListener(this);
        Orders.add(additems);

        Close.setBounds(600,490,120,50);
        Close.setBackground(Color.orange);
        Close.addActionListener(this);
        Orders.add(Close);

        Cancel.setBounds(740,490,120,50);
        Cancel.setBackground(Color.orange);
        Cancel.addActionListener(this);
        Orders.add(Cancel);

        orderscreen.add(Orders);
        background.add(orderscreen);
        Screen.dispose();
        menuscreen.dispose();
        empscreen.dispose();
        paymentscreen.dispose();
        salescreen.dispose();
        revalidate();
        repaint();
    }
    void orderprint() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"ORDER ID", "Menu ID","QTY","DATE","EMPID","STATUS","CANCELLED"}, 0);

        try
        {
            conn c = new conn();
            String q = "select * from orders";
            ResultSet rs = c.s.executeQuery(q);

            while(rs.next())
            {
                String d = rs.getString("orderid");
                String e = rs.getString("menu_id");
                String f = rs.getString("quantity");
                String g = rs.getString("Date");
                String h = rs.getString("emp_id");
                String i = rs.getString("status");
                String j = rs.getString("cancelled");

                model.addRow(new Object[]{d,e,f,g,h,i,j});
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        OrderTable.setModel(model);
    }
    void takeorder() {
        JTextField no = new JTextField();
        JLabel nolab= new JLabel("Enter Number of Dishes : ");
        JTextField emp = new JTextField();
        JLabel emplab= new JLabel("Enter Employee ID : ");
        JPanel number = new JPanel(new GridLayout(2,2));
        number.add(emplab);
        number.add(emp);
        number.add(nolab);
        number.add(no);
        JOptionPane.showMessageDialog(null,number );


            String x = no.getText();
            int n = Integer.parseInt(x);

        JPanel order = new JPanel(new GridLayout(n,2));

        JTextField dish[]=new JTextField[n];
        JTextField qty[]=new JTextField[n];

        for (int i = 0; i < n; i++)
        {
            JLabel dl= new JLabel("Enter Dish");
            JLabel ql= new JLabel("Enter Quantity");
            dish[i]=new JTextField();
            qty[i]=new JTextField();

            order.add(dl);
            order.add(dish[i]);
            order.add(ql);
            order.add(qty[i]);
        }
        JOptionPane.showMessageDialog(null,order);
        try{
            conn c = new conn();
            String query= ("SELECT * FROM orders ORDER BY orderid DESC LIMIT 1;");
            ResultSet rs= c.s.executeQuery(query);
            if(rs.next()){
                String s =  rs.getString("orderid");
                orderid  = Integer.parseInt(s);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        boolean flag =  false;
        for (int i = 0; i <n ; i++)
        {
            try {
                conn c = new conn();
                String q = ("insert into orders(orderid,menu_id,quantity,date,emp_id) values ('" +(orderid+1)+ "','" + dish[i].getText() + "','" + qty[i].getText() + "',curdate(),'" + emp.getText() + "')");
                Statement st = c.c.createStatement();
                st.executeUpdate(q);
                flag = true;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please Try Again");
            }
        }
        if (flag == true){
            JOptionPane.showMessageDialog(null, "Order Placed Succesfully");
        }
    }
    void editorder(){
        JPanel popup = new JPanel(new GridLayout(4,2));
        JTextField id = new JTextField(10);
        JLabel idlabel = new JLabel("Enter Order Id:");
        JTextField menuid = new JTextField(10);
        JLabel menuidlabel = new JLabel("Enter Item Id:");
        JTextField qty = new JTextField(10);
        JLabel qtylabel = new JLabel("Enter Quantity of Item:");

        popup.add(idlabel);
        popup.add(id);
        popup.add(menuidlabel);
        popup.add(menuid);
        popup.add(qtylabel);
        popup.add(qty);
        JOptionPane.showMessageDialog(null, popup);

        try
        {
            conn c = new conn();
            String q = ("update orders set quantity = '"+qty.getText()+"' where orderid = '"+id.getText()+"' and menu_id = '"+menuid.getText()+"'");
            Statement st = c.c.createStatement();
            st.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Order Modified Succesfully");
        }

        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Please Try Again");
        }}
    void addorderitem(){
        JPanel popup = new JPanel(new GridLayout(4,2));
        JTextField id = new JTextField(10);
        JLabel idlabel = new JLabel("Enter Order Id:");
        JTextField menuid = new JTextField(10);
        JLabel menuidlabel = new JLabel("Enter Item Id:");
        JTextField qty = new JTextField(10);
        JLabel qtylabel = new JLabel("Enter Quantity of Item:");

        popup.add(idlabel);
        popup.add(id);
        popup.add(menuidlabel);
        popup.add(menuid);
        popup.add(qtylabel);
        popup.add(qty);
        JOptionPane.showMessageDialog(null, popup);

        try
        {
            conn c = new conn();
            String q = ("insert into orders(orderid,menu_id,quantity,date,emp_id) values ('" +id.getText()+ "','" + menuid.getText() + "','" + qty.getText() + "','2022-08-07','" + orderid + "')");
            Statement st = c.c.createStatement();
            st.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Item Added to Order Succesfully");
        }

        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Please Try Again");
        }}
    void closeorder(){
        JPanel popup = new JPanel(new GridLayout(4,2));
        JTextField id = new JTextField(10);

        JLabel idlabel = new JLabel("Enter Order Id :");

        popup.add(idlabel);
        popup.add(id);
        JOptionPane.showMessageDialog(null, popup);

        try
        {
            conn c = new conn();
            String q = ("update orders set status = 'Closed' where orderid = '"+Integer.parseInt(id.getText())+"'");
            Statement st = c.c.createStatement();
            st.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Order Closed Succesfully");
        }

        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Please Try Again");
        }
    }
    void cancelorder(){
        JPanel popup = new JPanel(new GridLayout(4,2));
        JTextField id = new JTextField(10);

        JLabel idlabel = new JLabel("Enter Order Id :");

        popup.add(idlabel);
        popup.add(id);
        JOptionPane.showMessageDialog(null, popup);

        try
        {
            conn c = new conn();
            String q = ("update orders set cancelled = 'Yes' where orderid = '"+id.getText()+"'");
            Statement st = c.c.createStatement();
            st.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Order Cancelled Succesfully");
        }

        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Please Try Again");
        }}
    void chkManager(){

        JPanel popup = new JPanel(new GridLayout(4,2));
        JTextField pass = new JPasswordField(10);
        JLabel pass_label = new JLabel("Password");
        JTextField username = new JTextField(10);
        JLabel user_label = new JLabel("Username");

        popup.add(user_label);
        popup.add(username);
        popup.add(pass_label);
        popup.add(pass);
        JOptionPane.showMessageDialog(null, popup);

        try
        {
            conn c =new conn();
            String query= ("select * from employee where username ='"+username.getText()+ "'and password = '"+pass.getText()+"'and Designantion = 'Manager'");
            ResultSet rs= c.s.executeQuery(query);

            if(rs.next()){
                Employees();
                setVisible(true);
            }else
            {
                JOptionPane.showMessageDialog(null,"Access Denied");
            }
        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed (ActionEvent e){
        if (e.getSource() == logout){
            setVisible(false);
            new Form();
        }
        else if (e.getSource() == show){
            MenuItems();
            setVisible(true);
        }
        else if (e.getSource() == All){
            String q = ("select * from menu");
            MenuItems(q);
        }
        else if (e.getSource() == Italian){
            String q = ("select * from menu where category ='Italian'");
            MenuItems(q);
        }
        else if (e.getSource() == Chinese){
            String q = ("select * from menu where category ='Chinese'");
            MenuItems(q);
        }
        else if (e.getSource() == Continental){
            String q = ("select * from menu where category ='Continental'");
            MenuItems(q);
        }
        else if (e.getSource() == Indian){
            String q = ("select * from menu where category ='Indian'");
            MenuItems(q);
        }
        else if (e.getSource() == Beverages){
            String q = ("select * from menu where category ='Beverages'");
            MenuItems(q);
        }
        else if (e.getSource() == Add){
            additem();
        }
        else if (e.getSource() == Del){
            deleteitem();
        }
        else if (e.getSource() == Edit){
            modifyitem();
        }
        else if (e.getSource() == Emp){
            chkManager();
        }
        else if (e.getSource() == showemp){
            Emp_data();
            setVisible(true);
        }
        else if (e.getSource() == AddEmp){
            addemp();
        }

        else if (e.getSource() == DelEmp)
        {
            deleteemp();
        }

        else if (e.getSource() == EditEmp)
        {
            modifyemp();
        }
        else if (e.getSource() == order){
            ManageOrders();
            setVisible(true);
        }
        else if (e.getSource() == showorder){
            orderprint();
            String q = ("select * from menu");
            MenuItems(q);
            setVisible(true);
        }
        else if (e.getSource() == New){
            takeorder();
        }
        else if (e.getSource() == additems){
            addorderitem();
        }
        else if (e.getSource() == Editorder){
            editorder();
        }
        else if (e.getSource() == Close){
            closeorder();
        }
        else if (e.getSource() == Cancel){
            cancelorder();
        }
        else if (e.getSource() == sale){
            TotalSale();
            setVisible(true);
        }
        else if (e.getSource() == Txt){
            SaleTable(0);
            setVisible(true);
        }
        else if (e.getSource() == pay){
            Payments();
            setVisible(true);
        }
        else if (e.getSource() == Trans){
            try {
                JPanel popup = new JPanel(new GridLayout(4,2));
                JTextField orderid=new JTextField(10);
                JLabel orderid_label= new JLabel("Enter Order ID");
                popup.add(orderid_label);
                popup.add(orderid);
                JOptionPane.showMessageDialog(null, popup);
                PayTable(0, Integer.parseInt(orderid.getText()));
                setVisible(true);
            }catch (Exception ae){
                JOptionPane.showMessageDialog(null, "Please Try Again");

            }
        }
        else if (e.getSource() == addTrans){
            addpayment();
        }
        else if (e.getSource() == showTrans){
            PayTable(1,1);
            setVisible(true);
        }
        else if (e.getSource() == showTxt){
            SaleTable(1);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
