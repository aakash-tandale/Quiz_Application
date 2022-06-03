
import Project.ConnectionProvider;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.Timer;







/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author HP
 */
public class quizExamStudent extends javax.swing.JFrame {

    /**
     * Creates new form quizExamStudent
     */
    String questionId="1";
    String answer;
    int marks=0;
    int min;
    int sec;
    
    
    
    public void answerCheck()
    {
        String studentAnswer="";
        if(jRadioButton1.isSelected())
        {
            studentAnswer=jRadioButton1.getText();
        }
        else  if(jRadioButton2.isSelected())
        {
            studentAnswer=jRadioButton2.getText();
        }
        else  if(jRadioButton3.isSelected())
        {
            studentAnswer=jRadioButton3.getText();
        }
        else
             studentAnswer=jRadioButton4.getText();
        
        
        if(studentAnswer.equals(answer))
        {
            marks+=1;
         }
       
        
        int questionId1=Integer.parseInt(questionId);
        questionId1+=1;
        questionId=String.valueOf(questionId1);
        
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(false);
        
        if(questionId.equals("4"))
        {
            jButton1.setVisible(false);
        }
        
    }
    public void question()
    {
          try{
           Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            
           
            
              ResultSet rs1=st.executeQuery("select * from question where id='"+questionId+"'");
              
              while(rs1.next())
              {
                  jLabel14.setText(rs1.getString(1));
                  jLabel10.setText(rs1.getString(2));
                  jRadioButton1.setText(rs1.getString(3));
                  jRadioButton2.setText(rs1.getString(4));
                  jRadioButton3 .setText(rs1.getString(5));       
                  jRadioButton4.setText(rs1.getString(6));
                  
                  answer=rs1.getString(7);
                  
                  
                          
              }
            
            
       }
       catch(Exception e)
       {
        JOptionPane.showMessageDialog(null, e);
        
       }
    }
    public void submit()
    {
        String rollNo=jLabel13.getText();
        answerCheck();
        try{
              Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            st.executeUpdate("update student set marks='"+marks+"' where rollNo='"+rollNo+"'");
            String marks1=String.valueOf(marks);
            setVisible(false);
            String send=String.valueOf(marks);
            new successfullySubmitted(send).setVisible(true);
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    public quizExamStudent() {
        initComponents();
       
        
}
    
     
    
    
    Timer time;
 public quizExamStudent(String rollNo) {
        initComponents();
        jLabel13.setText(rollNo);
       try{
           Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            
            ResultSet rs=st.executeQuery("select * from student where rollNo='"+rollNo+"'");
            
            while(rs.next())
            {
                jLabel12.setText(rs.getString(1));
            }
            
              ResultSet rs1=st.executeQuery("select * from question where id='"+questionId+"'");
              
              while(rs1.next())
              {
                  jLabel14.setText(rs1.getString(1));
                  jLabel10.setText(rs1.getString(2));
                  jRadioButton1.setText(rs1.getString(3));
                  jRadioButton2.setText(rs1.getString(4));
                  jRadioButton3 .setText(rs1.getString(5));       
                  jRadioButton4.setText(rs1.getString(6));
                  
                  answer=rs1.getString(7);
                  
                  
                          
              }
            
            
       }
       catch(Exception e)
       {
        JOptionPane.showMessageDialog(null, e);
        
       }
       setLocationRelativeTo(this);
       time=new Timer(1000,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              jLabel7.setText(String.valueOf(sec));
              jLabel6.setText(String.valueOf(min));
              if(sec==60)
       {
           sec=0;
           min++;
           if(min==10)
       {
           time.stop();
       }
       }
              sec++;
            }
           
       });
       time.start();
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/index student.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Algerian", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Welcome!");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel3.setText("Total time:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1113, 12, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel4.setText("10 min");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1226, 12, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel5.setText("Time taken");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1113, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("00");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1229, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("00");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1263, 50, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Name:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 44, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Seat No:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 101, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Question no:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 169, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Aakash Tandale");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 44, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("19141070");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 101, -1, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("1");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 169, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 350, 670));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel10.setText("Question");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 191, -1, -1));

        jRadioButton1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 271, -1, -1));

        jRadioButton2.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jRadioButton2.setText("jRadioButton2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 350, -1, -1));

        jRadioButton3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jRadioButton3.setText("jRadioButton3");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 431, -1, -1));

        jRadioButton4.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jRadioButton4.setText("jRadioButton4");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 499, -1, -1));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Next.png"))); // NOI18N
        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 616, -1, -1));

        jButton2.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 616, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       answerCheck();
       question();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
        int a=JOptionPane.showConfirmDialog(null, "Do you want to submit?","Select",JOptionPane.YES_NO_OPTION);
       
        if(a==0)
        {
             
      submit();
     
        }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
       if(jRadioButton1.isSelected())
       {
           jRadioButton2.setSelected(false);
           jRadioButton3.setSelected(false);
           jRadioButton4.setSelected(false);
           
       }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if(jRadioButton2.isSelected())
       {
           jRadioButton1.setSelected(false);
           jRadioButton3.setSelected(false);
           jRadioButton4.setSelected(false);
           
       }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
       if(jRadioButton3.isSelected())
       {
           jRadioButton1.setSelected(false);
           jRadioButton2.setSelected(false);
           jRadioButton4.setSelected(false);
           
       }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
      if(jRadioButton4.isSelected())
       {
           jRadioButton2.setSelected(false);
           jRadioButton3.setSelected(false);
           jRadioButton1.setSelected(false);
           
       }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(quizExamStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quizExamStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quizExamStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quizExamStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quizExamStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration//GEN-END:variables
}
