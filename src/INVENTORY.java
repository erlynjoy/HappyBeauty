import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.util.Calendar;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
public class INVENTORY extends javax.swing.JFrame {

    
    Connection conn = null;
    ResultSet rs= null;
    PreparedStatement pst=null;
    ResultSet rs1= null;
    PreparedStatement pst1=null;
    Connection conn2 = null;
    ResultSet rs2= null;
    PreparedStatement pst2=null;
    ResultSet rs3= null;
    PreparedStatement pst3=null;
    ResultSet rs4= null;
    PreparedStatement pst4=null;
    ResultSet rs5= null;
    PreparedStatement pst5=null;
    ResultSet rsact= null;
    PreparedStatement pstact=null;
    /**
     * Creates new form INVENTORY
     */
    public INVENTORY() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("pics/logo3.png")).getImage());
    }
    
    public void tableResize(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15;
            for(int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width+1, width);
            }
            if(width > 300) {
                width = 300;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
    
    
    void StockTable()
    {
        String sql="select p_barcode AS 'Barcode', p_name AS 'Product name', p_brand AS 'Brand', p_weight AS 'Weight', c_stock AS 'Current stock' from product where p_barcode!='ARCHIVE' order by p_name ASC";
        try{
            pst= conn.prepareStatement(sql);
            rs=pst.executeQuery();
            stockTable.setModel(DbUtils.resultSetToTableModel(rs));
            tableResize(stockTable);
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public static String now() {
       String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }
    
    public static String nowToday() {
        
       String DATE_FORMAT_NOW = "yyyy-MM-dd";

    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
    return sdf.format(cal.getTime());

  }
    
    public static String nowMonth() {
        
       String DATE_FORMAT_NOW = "MM";

    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
    return sdf.format(cal.getTime());

  }
     
      public static String nowYear() {
        
       String DATE_FORMAT_NOW = "yyyy";

    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
    return sdf.format(cal.getTime());

  }
    
    public void blackText(){
        i_name.setForeground(Color.black);
        i_barcode.setForeground(Color.black);
        qty.setForeground(Color.black);
    }

    public void clear(){
        i_name.setText("");
        i_barcode.setText("");
        qty.setText("");
        errorQty.setText("");
        c_stock.setText("");
        imglbl.setIcon(null);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stockInOutPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        i_brand = new javax.swing.JLabel();
        i_weight = new javax.swing.JLabel();
        i_barcode = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        i_name = new javax.swing.JLabel();
        SAVEBtn = new javax.swing.JLabel();
        SAVEBtn_out = new javax.swing.JLabel();
        imglbl = new javax.swing.JLabel();
        line = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        c_stock = new javax.swing.JLabel();
        errorQty = new javax.swing.JLabel();
        currentStock = new javax.swing.JLabel();
        bgpopup = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        searchInventory = new javax.swing.JTextField();
        minimize = new javax.swing.JLabel();
        BACKlbl = new javax.swing.JLabel();
        inventorybg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1350, 720));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stockInOutPanel.setBackground(new java.awt.Color(255, 250, 240));
        stockInOutPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        stockInOutPanel.setMinimumSize(new java.awt.Dimension(500, 500));
        stockInOutPanel.setPreferredSize(new java.awt.Dimension(500, 500));
        stockInOutPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Barcode");
        stockInOutPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 60, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Quantity");
        stockInOutPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 70, 30));
        stockInOutPanel.add(i_brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 80, 20));
        stockInOutPanel.add(i_weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 40, 20));

        i_barcode.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        i_barcode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        i_barcode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                i_barcodeFocusGained(evt);
            }
        });
        i_barcode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                i_barcodeMouseClicked(evt);
            }
        });
        i_barcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                i_barcodeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                i_barcodeKeyTyped(evt);
            }
        });
        stockInOutPanel.add(i_barcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 190, 40));

        qty.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        qty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        qty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                qtyFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                qtyFocusLost(evt);
            }
        });
        qty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qtyMouseClicked(evt);
            }
        });
        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qtyKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qtyKeyTyped(evt);
            }
        });
        stockInOutPanel.add(qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 190, 40));

        i_name.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        i_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stockInOutPanel.add(i_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 280, 30));

        SAVEBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        SAVEBtn.setText("STOCK IN");
        SAVEBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SAVEBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SAVEBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SAVEBtnMouseExited(evt);
            }
        });
        stockInOutPanel.add(SAVEBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 70, 30));

        SAVEBtn_out.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        SAVEBtn_out.setText("STOCK OUT");
        SAVEBtn_out.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SAVEBtn_outMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SAVEBtn_outMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SAVEBtn_outMouseExited(evt);
            }
        });
        stockInOutPanel.add(SAVEBtn_out, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, -1, 30));

        imglbl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(210, 156, 50), 2, true));
        stockInOutPanel.add(imglbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 120, 120));

        line.setBackground(new java.awt.Color(0, 0, 0));
        line.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 3));
        stockInOutPanel.add(line, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 280, 3));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Available stock:");
        stockInOutPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 100, 30));

        c_stock.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        c_stock.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        c_stock.setToolTipText("");
        stockInOutPanel.add(c_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 390, 50, 30));

        errorQty.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        errorQty.setForeground(new java.awt.Color(255, 0, 0));
        errorQty.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stockInOutPanel.add(errorQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 190, 20));

        currentStock.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        stockInOutPanel.add(currentStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 40, 50));

        bgpopup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/POPUP-ADDINVENTORY.PNG"))); // NOI18N
        stockInOutPanel.add(bgpopup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 500));

        getContentPane().add(stockInOutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 300, 500));

        mainPanel.setMinimumSize(new java.awt.Dimension(1350, 720));
        mainPanel.setPreferredSize(new java.awt.Dimension(1350, 720));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(210, 156, 50));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 18))); // NOI18N

        stockTable = new javax.swing.JTable(){
            public boolean isCellEditable (int rowIndex, int colIndex){
                return false;
            }
        };
        stockTable.setBackground(new java.awt.Color(210, 156, 50));
        stockTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        stockTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        stockTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        stockTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        stockTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(stockTable);

        mainPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 890, 600));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Search:");
        mainPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 60, 30));

        searchInventory.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        searchInventory.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchInventory.setToolTipText("");
        searchInventory.setName(""); // NOI18N
        searchInventory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchInventoryKeyReleased(evt);
            }
        });
        mainPanel.add(searchInventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 230, 40));

        minimize.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        minimize.setForeground(new java.awt.Color(255, 255, 255));
        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setText("–");
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeMouseExited(evt);
            }
        });
        mainPanel.add(minimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 10, 12, 20));

        BACKlbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        BACKlbl.setForeground(new java.awt.Color(255, 255, 255));
        BACKlbl.setText("BACK");
        BACKlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BACKlblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BACKlblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BACKlblMouseExited(evt);
            }
        });
        mainPanel.add(BACKlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 60, 30));

        inventorybg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/INVENTORY_UI.PNG"))); // NOI18N
        mainPanel.add(inventorybg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 720));

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BACKlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BACKlblMouseClicked
        String stat = LOGIN.status;
            if(stat.equals("Stock-in user")) {
                this.dispose();
                USERMENU u= new USERMENU();
                u.setVisible(true);
            }
               
            else if(stat.equals("Stock-out user")) {
                this.dispose();
                USERMENU u= new USERMENU();
                u.setVisible(true);
            }

            else if (stat.equals("admin")){
                this.dispose();
                HOME h = new HOME();
                h.setVisible(true);
            }
    }//GEN-LAST:event_BACKlblMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        conn = mysqlconnect.ConnectDb();
        blackText();
        clear();
        StockTable();
        tableResize(stockTable);
        i_brand.setVisible(false);
        i_weight.setVisible(false);
        //c_stock.setVisible(false);
       // clr.setVisible(false);
       
       String stat = LOGIN.status;
        try{
        if(stat.equals("Stock-out user"))
        {
            stockInOutPanel.setVisible(true);
            SAVEBtn.setVisible(false);
            SAVEBtn_out.setVisible(true);
        }
        else if(stat.equals("Stock-in user"))
        {
            stockInOutPanel.setVisible(true);
            SAVEBtn.setVisible(true);
            SAVEBtn_out.setVisible(false);
        }
        else if(stat.equals("Admin"))
        {
            stockInOutPanel.setVisible(true);
            mainPanel.setVisible(true);
            SAVEBtn.setVisible(true);
            SAVEBtn_out.setVisible(true);
        }
        }catch(Exception e)
          {
            JOptionPane.showMessageDialog(null, e);
          }
        
    }//GEN-LAST:event_formWindowOpened

    private void i_barcodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_i_barcodeFocusGained
        if((i_barcode.getText()).equals("Please fill out this field"))
        {
            i_barcode.setText("");
            i_barcode.setForeground(Color.black);
        }
        
    }//GEN-LAST:event_i_barcodeFocusGained

    private void i_barcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_i_barcodeKeyTyped
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))||!(Character.isDigit(enter))){
            evt.consume();
        }
        
        if(i_barcode.getText().length()>=13) {  
         evt.consume();
        }
        //char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))||!(Character.isDigit(enter))){
            evt.consume();
        }
    }//GEN-LAST:event_i_barcodeKeyTyped

    private void i_barcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_i_barcodeKeyReleased
    String stat = LOGIN.status;
    String sql1="select * from product";    
    String sql2="select c_stock AS 'Stock' from product where p_barcode='"+i_barcode.getText()+"'";
    Boolean check=true;
     try{
        pst=conn.prepareStatement(sql1);
        rs=pst.executeQuery();       
        while(rs.next()){
            String b= rs.getString(3);
            String n= rs.getString(2);   
            String br= rs.getString(4);
            String w= rs.getString(5);
            String c= rs.getString(7);
            if((i_barcode.getText()).equals(b))
            {   
                pst2=conn.prepareStatement(sql2);
                rs2=pst2.executeQuery();       
                while(rs2.next()){
                    String s= rs2.getString("Stock");
                    if(s.equals("0"))
                    {
                        SAVEBtn_out.setVisible(false);
                    }
                    if((!(s.equals("0"))) && (!(stat.equals("Stock-in user"))))
                    {
                        SAVEBtn_out.setVisible(true);
                    }
                }
                
                i_name.setForeground(Color.black);
                i_name.setText(n);
                i_brand.setText(br);
                i_weight.setText(w);
                c_stock.setText(c);
                
                try{
                   String sql ="select * from product where p_barcode="+b;
                   pst=conn.prepareStatement(sql);
                   rs=pst.executeQuery();
                   while (rs.next()) {  
                   byte[] img = rs.getBytes("p_img");
                   ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(imglbl.getWidth(), imglbl.getHeight(), Image.SCALE_SMOOTH));
                   imglbl.setIcon(imageIcon);
                   }
                }catch(Exception e){
                   JOptionPane.showMessageDialog(null, e); 
                }
                check=false;
            }
        }
        if(i_barcode.getText().isEmpty()) {
            i_name.setText("");
            i_brand.setText("");
            i_weight.setText("");
            c_stock.setText("");
            imglbl.setIcon(null);
        }
        if(check==true && !(i_barcode.getText().isEmpty()))
        {
           i_name.setText("Barcode does not exist");
           i_name.setForeground(Color.red);
           i_brand.setText("");
           i_weight.setText("");
           c_stock.setText("");
           imglbl.setIcon(null);
        }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_i_barcodeKeyReleased

    private void SAVEBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SAVEBtnMouseClicked
    boolean check = true;
        
    if(i_name.getText().equals("Barcode does not exist")){
                check=false;
            }
            if(errorQty.getText().equals("Invalid quantity")){
                check=false;
            }
            if(i_name.getText().equals("")){
                i_barcode.setText("Please fill out this field");
                i_barcode.setForeground(Color.red);
                check=false;
            }
            if(i_barcode.getText().equals("")){
                i_barcode.setText("Please fill out this field");
                i_barcode.setForeground(Color.red);
                check=false;
            }
            if(qty.getText().equals("Please fill out this field")){
                check=false;
            }
            if(qty.getText().equals("")){
                qty.setText("Please fill out this field");
                qty.setForeground(Color.red);
                check=false;
            }
    if(check==true)
            {
                      
        int result = JOptionPane.showConfirmDialog(null,
            "Proceed STOCK IN?",null, JOptionPane.YES_NO_OPTION);
        if(result == JOptionPane.YES_OPTION) {
            String un=LOGIN.username;
        String iu="Select * from account where username='"+un+"'";
        String q = qty.getText();
        String sql = "INSERT into added_by (emp_id, Abarcode, date_in, qty_in) value (?,?,?,?)";
        String stock = "select c_stock AS 'CStock' from product where p_barcode='"+i_barcode.getText()+"'";
        String sqlC = "UPDATE product set c_stock=? where p_barcode=?";
        String sql_act="INSERT INTO activity (act_details,act_user,act_date) values (?,?,?)";
        try{
            pst = conn.prepareStatement(sql);       
            String date = ""+ now();
            String date2 = ""+ nowToday();
            String Uusername = LOGIN.username;
           

            pst4=conn.prepareStatement(stock);
            rs4=pst4.executeQuery();
            while(rs4.next()){
                String in = rs4.getString("CStock");
                
                int cs = Integer.parseInt(in)+Integer.parseInt(q);
                    
                    pst5=conn.prepareStatement(sqlC);
                    pst5.setString(1, cs+"");
                    pst5.setString(2, i_barcode.getText());
            }
                             

              pst5.executeUpdate();
                pst2=conn.prepareStatement(iu);
                rs2=pst2.executeQuery();
                while(rs2.next()){
                String id = rs2.getString(1);
                pst.setString(1, id);
                }

                pst.setString(2, i_barcode.getText());
                pst.setString(3, date2);
                pst.setString(4, q);
                pst.execute();

                pstact=conn.prepareStatement(sql_act);
                pstact.setString(1, q+" "+i_name.getText()+" was stocked in");
                pstact.setString(2, Uusername);
                pstact.setString(3, date);
                pstact.execute();

                JOptionPane.showMessageDialog(null, "Successfully stocked in");
                StockTable();
                clear();
                blackText();
            
        }catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
                
        }
        else{
            StockTable();
                clear();
                blackText();
        }
     }   
    }//GEN-LAST:event_SAVEBtnMouseClicked

    private void SAVEBtn_outMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SAVEBtn_outMouseClicked
    boolean check = true;
    if(i_name.getText().equals("Barcode does not exist")){
                check=false;
            }
            if(errorQty.getText().equals("Invalid quantity")){
                check=false;
            }
            if(i_name.getText().equals("")){
                i_barcode.setText("Please fill out this field");
                i_barcode.setForeground(Color.red);
                check=false;
            }
            if(i_barcode.getText().equals("")){
                i_barcode.setText("Please fill out this field");
                i_barcode.setForeground(Color.red);
                check=false;
            }
            if(qty.getText().equals("")){
                qty.setText("Please fill out this field");
                qty.setForeground(Color.red);
                check=false;
            }  
    if(check==true && !(qty.getText().equals("Please fill out this field")))
            {
        int result = JOptionPane.showConfirmDialog(null,
            "Proceed STOCK OUT?",null, JOptionPane.YES_NO_OPTION);
        if(result == JOptionPane.YES_OPTION) {
            String un=LOGIN.username;
        String iu="Select * from account where username='"+un+"'";
        String q = qty.getText();
        String sql = "INSERT into released_by (eid, Rbarcode, date_out, qty_out) value (?,?,?,?)";
        String stock = "select c_stock AS 'CStock' from product where p_barcode='"+i_barcode.getText()+"'";
        String sqlC = "UPDATE product set c_stock=? where p_barcode=?";
        String sql_act="INSERT INTO activity (act_details,act_user,act_date) values (?,?,?)";
        try{
            pst = conn.prepareStatement(sql);       
            String date = ""+ now();
            String date2 = ""+ nowToday();
            String Uusername = LOGIN.username;
            
            c_stock.getText();

            pst4=conn.prepareStatement(stock);
            rs4=pst4.executeQuery();
            while(rs4.next()){
                String in = rs4.getString("CStock");
                int cs = Integer.parseInt(in)-Integer.parseInt(q);
                
                    pst5=conn.prepareStatement(sqlC);
                    pst5.setString(1, cs+"");
                    pst5.setString(2, i_barcode.getText());
                    
            }
            
                             

            
                pst5.executeUpdate();
                
                pst2=conn.prepareStatement(iu);
                rs2=pst2.executeQuery();
                while(rs2.next()){
                String id = rs2.getString(1);
                pst.setString(1, id);
                }

                pst.setString(2, i_barcode.getText());
                pst.setString(3, date2);
                pst.setString(4, q);
                pst.execute();

                pstact=conn.prepareStatement(sql_act);
                pstact.setString(1, q+" "+i_name.getText()+" was stocked out");
                pstact.setString(2, Uusername);
                pstact.setString(3, date);
                pstact.execute();

                JOptionPane.showMessageDialog(null, "Successfully stocked out");
                StockTable();
                clear();
                blackText();
            
        }catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
                
        }
        else{
            StockTable();
                clear();
                blackText();
        }
    }    
    }//GEN-LAST:event_SAVEBtn_outMouseClicked

    private void SAVEBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SAVEBtnMouseEntered
        SAVEBtn.setForeground(Color.decode("#d29c32"));
    }//GEN-LAST:event_SAVEBtnMouseEntered

    private void SAVEBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SAVEBtnMouseExited
        SAVEBtn.setForeground(Color.black);
    }//GEN-LAST:event_SAVEBtnMouseExited

    private void SAVEBtn_outMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SAVEBtn_outMouseEntered
        SAVEBtn_out.setForeground(Color.decode("#d29c32"));
    }//GEN-LAST:event_SAVEBtn_outMouseEntered

    private void SAVEBtn_outMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SAVEBtn_outMouseExited
        SAVEBtn_out.setForeground(Color.black);
    }//GEN-LAST:event_SAVEBtn_outMouseExited

    private void qtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyTyped
        if(qty.getText().length()>=5) {  
         evt.consume();
        }
        
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))||!(Character.isDigit(enter))){
            evt.consume();
        }
    }//GEN-LAST:event_qtyKeyTyped

    private void searchInventoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchInventoryKeyReleased
        if(!searchInventory.getText().isEmpty()) {
            String sql= "select p_barcode AS 'Barcode', p_name AS 'Product name', p_brand AS 'Brand', p_weight AS 'Weight', c_stock AS 'Current stock' from product where (p_barcode like ? OR p_name like ? OR p_brand like ? OR p_weight like ? OR c_stock like ?) AND p_barcode!='ARCHIVE' order by p_name ASC";
            try{
                pst = conn.prepareStatement(sql);
                pst.setString(1, "%" + searchInventory.getText() + "%");
                pst.setString(2, "%" + searchInventory.getText() + "%");
                pst.setString(3, "%" + searchInventory.getText() + "%");
                pst.setString(4, "%" + searchInventory.getText() + "%");
                pst.setString(5, "%" + searchInventory.getText() + "%");

                rs=pst.executeQuery();
                stockTable.setModel(DbUtils.resultSetToTableModel(rs));
                tableResize(stockTable);
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        if(searchInventory.getText().isEmpty()) {
            StockTable();
            tableResize(stockTable);
        }
    }//GEN-LAST:event_searchInventoryKeyReleased

    private void qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyReleased
    String stat = LOGIN.status;
    String q = qty.getText();
    String cs = c_stock.getText();
    String qF=qty.getText();
    Boolean check=true;
    try{
        int currentS = Integer.parseInt(cs);
        int quant = Integer.parseInt(q);
        
            if(quant > currentS){
                errorQty.setText("Insufficient stock");
                SAVEBtn_out.setVisible(false);
                check=false;
            }
            if((quant < currentS) && (!(stat.equals("Stock-in user")))){
                errorQty.setText("");
                SAVEBtn_out.setVisible(true);
                check=false;
            }
            if(qF.charAt(0)=='0')
            {
                errorQty.setText("Invalid quantity");
                check=false;
            }
            if((qty.getText().isEmpty()) && (!(stat.equals("Stock-in user")))) {
                errorQty.setText("");
                SAVEBtn_out.setVisible(true);
            }
            if((check==true) && (!(stat.equals("Stock-in user")))){
            errorQty.setText("");
            SAVEBtn_out.setVisible(true);
            }
        }
        catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
    
    if(qty.getText().isEmpty()) {
        errorQty.setText("");
    }
    }//GEN-LAST:event_qtyKeyReleased

    private void qtyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qtyFocusGained
        if((qty.getText()).equals("Please fill out this field"))
        {
            qty.setText("");
            qty.setForeground(Color.black);
        }
    }//GEN-LAST:event_qtyFocusGained

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        this.setState(INVENTORY.ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseEntered
        minimize.setForeground(Color.decode("#d29c32"));
    }//GEN-LAST:event_minimizeMouseEntered

    private void minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseExited
        minimize.setForeground(Color. white);
    }//GEN-LAST:event_minimizeMouseExited

    private void BACKlblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BACKlblMouseExited
        BACKlbl.setForeground(Color. white);
    }//GEN-LAST:event_BACKlblMouseExited

    private void BACKlblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BACKlblMouseEntered
        BACKlbl.setForeground(Color.decode("#d29c32"));
    }//GEN-LAST:event_BACKlblMouseEntered

    private void i_barcodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_i_barcodeMouseClicked
       if((i_barcode.getText()).equals("Please fill out this field"))
        {
            i_barcode.setText("");
            i_barcode.setForeground(Color.black);
        }
    }//GEN-LAST:event_i_barcodeMouseClicked

    private void qtyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qtyMouseClicked
        if((qty.getText()).equals("Please fill out this field"))
        {
            qty.setText("");
            qty.setForeground(Color.black);
        }
    }//GEN-LAST:event_qtyMouseClicked

    private void qtyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qtyFocusLost
        String stat = LOGIN.status;
        if((qty.getText().isEmpty()) && (!(stat.equals("Stock-in user")))) {
                errorQty.setText("");
                SAVEBtn_out.setVisible(true);
            }
    }//GEN-LAST:event_qtyFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(INVENTORY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(INVENTORY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(INVENTORY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(INVENTORY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new INVENTORY().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BACKlbl;
    private javax.swing.JLabel SAVEBtn;
    private javax.swing.JLabel SAVEBtn_out;
    private javax.swing.JLabel bgpopup;
    private javax.swing.JLabel c_stock;
    private javax.swing.JLabel currentStock;
    private javax.swing.JLabel errorQty;
    private javax.swing.JTextField i_barcode;
    private javax.swing.JLabel i_brand;
    private javax.swing.JLabel i_name;
    private javax.swing.JLabel i_weight;
    private javax.swing.JLabel imglbl;
    private javax.swing.JLabel inventorybg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField line;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel minimize;
    private javax.swing.JTextField qty;
    private javax.swing.JTextField searchInventory;
    private javax.swing.JPanel stockInOutPanel;
    private javax.swing.JTable stockTable;
    // End of variables declaration//GEN-END:variables
}
