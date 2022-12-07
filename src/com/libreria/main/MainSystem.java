package com.libreria.main;

import com.libreria.event.EventMenuSelected;
import com.libreria.form.Form_Producto;
import com.libreria.form.Form_3;
import com.libreria.form.Form_Home;
import com.libreria.form.Form_Producto;
import com.libreria.form.Form_Proveedor;
import com.libreria.model.ModelUser;
import com.libreria.form.Form_Egreso;
import java.awt.Color;
import javax.swing.JComponent;

public class MainSystem extends javax.swing.JFrame {

    private final ModelUser user;
    private Form_Home home;
    private Form_Producto form1;
    private Form_Proveedor form2;
    private Form_3 form3;
    private Form_Egreso formEgreso;

    public MainSystem(ModelUser user) {
        this.user = user;
        initComponents();
        
        setBackground(new Color(0, 0, 0, 0));
        home = new Form_Home();
        form1 = new Form_Producto();
        form2 = new Form_Proveedor();
        form3 = new Form_3();
        formEgreso = new Form_Egreso();
        
        menu.initMoving(MainSystem.this);
        menu.addEventMenuSelected(new EventMenuSelected() {
            @Override
            public void selected(int index) {
                if (index == 0) {
                    setForm(home);
                } else if (index == 1) {
                    setForm(form1);
                } else if (index == 2) {
                    setForm(form2);
                } else if (index == 3) {
                    setForm(form3);
                }else if (index == 4){
                        setForm(formEgreso);
                }else if(index == 13){
                    System.exit(0);
                }
            }
        });
	setForm(new Form_Home());
    }
    

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.libreria.swing.PanelBorder();
        menu = new com.libreria.component.Menu();
        header2 = new com.libreria.component.Header();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(242, 242, 242));

        header2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header2, javax.swing.GroupLayout.DEFAULT_SIZE, 965, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(header2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(ModelUser user) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainSystem(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.libreria.component.Header header2;
    private javax.swing.JPanel mainPanel;
    private com.libreria.component.Menu menu;
    private com.libreria.swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
