/**
 * Nguyễn Thái Nguyên
 *
 * <Nhập mô tả tại đây>
 */
package view;

import dao.StudentDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.Student;

/**
 *
 * @author nguye
 */
public class View extends javax.swing.JFrame {

    /**
     * Creates new form alo
     */
    public View() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        model = (DefaultTableModel) tblInfoStudent.getModel();
        StudentDAO = new StudentDAO();
        
        fillToTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chkHaveGift = new javax.swing.JCheckBox();
        btnAdd = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInfoStudent = new javax.swing.JTable();
        lblIDStudent = new javax.swing.JLabel();
        txtIDStudent = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        lblFullname = new javax.swing.JLabel();
        lblMarks = new javax.swing.JLabel();
        lblMajor = new javax.swing.JLabel();
        lblRank = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        txtMarks = new javax.swing.JTextField();
        cboMajor = new javax.swing.JComboBox<>();
        txtRank = new javax.swing.JTextField();
        btnSortByName = new javax.swing.JButton();
        btnSortByMark = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chkHaveGift.setText("Có phần thưởng ?");

        btnAdd.setText("Thêm");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnDel.setText("Xóa");
        btnDel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDelMouseClicked(evt);
            }
        });

        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setText("Nhập mới");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        tblInfoStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "HỌ VÀ TÊN", "ĐIỂM", "NGÀNH", "HỌC LỰC", "THƯỞNG"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblInfoStudent);

        lblIDStudent.setText("ID ");

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 51, 51));
        lblTitle.setText("QUẢN LÝ SINH VIÊN");

        lblFullname.setText("HỌ VÀ TÊN");

        lblMarks.setText("ĐIỂM");

        lblMajor.setText("NGÀNH");

        lblRank.setText("HỌC LỰC");

        cboMajor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vui lòng chọn", "Phát triển phần mềm", "Lập trình web", "Ứng dụng phần mềm", "Digital Marketing", " " }));

        txtRank.setEditable(false);

        btnSortByName.setText("Sắp xếp theo tên");
        btnSortByName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSortByNameMouseClicked(evt);
            }
        });

        btnSortByMark.setText("Sắp xếp theo điểm");
        btnSortByMark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSortByMarkMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(lblTitle)
                        .addGap(0, 127, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnSortByName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSortByMark)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFullname)
                    .addComponent(lblMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMajor)
                    .addComponent(lblRank)
                    .addComponent(lblIDStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear))
                    .addComponent(cboMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMarks)
                    .addComponent(txtFullname)
                    .addComponent(txtRank, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addComponent(chkHaveGift, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDStudent))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIDStudent)
                    .addComponent(txtIDStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFullname)
                    .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarks)
                    .addComponent(txtMarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMajor)
                    .addComponent(cboMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRank)
                    .addComponent(txtRank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkHaveGift)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDel)
                    .addComponent(btnUpdate)
                    .addComponent(btnClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSortByName)
                    .addComponent(btnSortByMark))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        Student student = readForm();
        String grade;
        if (student != null) {
            StudentDAO.createStudent(student);
            model.addRow(new Object[]{student.getId(), student.getName(),
                student.getMarks(), student.getMajor(), student.getGrade(), student.isHaveGift()});
            rowCnt++;
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtFullname.setText("");
        txtIDStudent.setText("");
        txtMarks.setText("");
        txtRank.setText("");
        chkHaveGift.setSelected(false);
        cboMajor.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (rowCnt > 0) {
            updateRow();
        } else {
            JOptionPane.showMessageDialog(this, "Chưa thể cập nhật");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelMouseClicked
        // TODO add your handling code here:
        remove();
    }//GEN-LAST:event_btnDelMouseClicked

    private void btnSortByNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSortByNameMouseClicked
        // TODO add your handling code here:
        sortByName();
    }//GEN-LAST:event_btnSortByNameMouseClicked

    private void btnSortByMarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSortByMarkMouseClicked
        // TODO add your handling code here:
        sortByMark();
    }//GEN-LAST:event_btnSortByMarkMouseClicked

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
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnSortByMark;
    private javax.swing.JButton btnSortByName;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboMajor;
    private javax.swing.JCheckBox chkHaveGift;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFullname;
    private javax.swing.JLabel lblIDStudent;
    private javax.swing.JLabel lblMajor;
    private javax.swing.JLabel lblMarks;
    private javax.swing.JLabel lblRank;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblInfoStudent;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtIDStudent;
    private javax.swing.JTextField txtMarks;
    private javax.swing.JTextField txtRank;
    // End of variables declaration//GEN-END:variables

    DefaultTableModel model;
    dao.StudentDAO StudentDAO;
    int rowCnt = 0;

    Student readForm() {
        boolean check = true;
        while (true) {
            if (txtIDStudent.getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this, "Vui lòng nhập trường id");
                check = false;
                break;
            }
            if (txtFullname.getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this, "Vui lòng nhập trường tên");
                check = false;
                break;
            }
            if (!txtMarks.getText().isEmpty()
                    && Double.isNaN(Double.parseDouble(txtMarks.getText()))) {
                JOptionPane.showMessageDialog(
                        this, "Vui lòng nhập trường điểm");
                break;
            }
            if (cboMajor.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn ngành");
                check = false;
                break;
            }
            break;
        }
        if (check) {
            return new Student(txtIDStudent.getText(), txtFullname.getText(),
                    Double.parseDouble(txtMarks.getText()),
                    (String) cboMajor.getSelectedItem(), chkHaveGift.isSelected());
        } else {
            return null;
        }
    }

    public void updateRow() {
        int index = tblInfoStudent.getSelectedRow();

        if (index != -1) {
            StudentDAO.getAllStudent().set(index, readForm());

            model.setValueAt(readForm().getId(), index, 0);
            model.setValueAt(readForm().getName(), index, 1);
            model.setValueAt(readForm().getMarks(), index, 2);
            model.setValueAt(readForm().getMajor(), index, 3);
            model.setValueAt(readForm().getGrade(), index, 4);
            model.setValueAt(readForm().isHaveGift(), index, 5);

            model.fireTableRowsUpdated(index, index);
        } else {
            JOptionPane.showMessageDialog(this, "Bạn hãy click vào mục muốn chỉnh sửa");
        }
    }

    public void remove() {
        int index = tblInfoStudent.getSelectedRow();
        if(index != -1) {
            rowCnt--;
            StudentDAO.getAllStudent().remove(index);
            model.removeRow(index);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn row muốn xóa");
        }
    }

    public void fillToTable() {
        for (Student item : StudentDAO.getAllStudent()) {
            rowCnt++;
            model.addRow(new Object[] {item.getId(), item.getName(), 
                item.getMarks(), item.getMajor(), item.getGrade(), item.isHaveGift()});
        }
     }
    
    public void sortByName () {
        
        Comparator<Student> compByName = Comparator.
                comparing(e -> e.getName().substring(e.getName().lastIndexOf(" ") + 1));
        
        Comparator<Student> comp = compByName.thenComparing(Student::getName);
        Collections.sort(StudentDAO.getAllStudent(), comp);
            
        model.setRowCount(0);
        fillToTable();
    }
    
    public void sortByMark () {
        Comparator<Student> compByMark = Comparator.comparing(e -> e.getMarks());
        Collections.sort(StudentDAO.getAllStudent(), compByMark);
        
        model.setRowCount(0);
        fillToTable();
    }
    
}