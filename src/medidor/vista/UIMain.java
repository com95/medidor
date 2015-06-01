package medidor.vista;

import medidor.controlador.IMain;

public class UIMain extends javax.swing.JFrame {
    
    private IMain interfaceMain;

    public UIMain(IMain interfaceMain) {
        this.setVisible(true);
        initComponents();
        this.interfaceMain = interfaceMain;
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCalidad = new javax.swing.JButton();
        btnRiesgos = new javax.swing.JButton();
        btnDimens = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnNorma = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCalidad.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        btnCalidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/medidor2.png"))); // NOI18N
        btnCalidad.setText("MEDICIÓN DE CALIDAD");
        btnCalidad.setBorder(null);
        btnCalidad.setBorderPainted(false);
        btnCalidad.setContentAreaFilled(false);
        btnCalidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCalidad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCalidad.setIconTextGap(-3);
        btnCalidad.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/medidor3.png"))); // NOI18N
        btnCalidad.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/medidor1.png"))); // NOI18N
        btnCalidad.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCalidad.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalidadActionPerformed(evt);
            }
        });

        btnRiesgos.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        btnRiesgos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/risk2.png"))); // NOI18N
        btnRiesgos.setText("GESTIÓN DE RIESGOS");
        btnRiesgos.setBorder(null);
        btnRiesgos.setBorderPainted(false);
        btnRiesgos.setContentAreaFilled(false);
        btnRiesgos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRiesgos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRiesgos.setIconTextGap(-3);
        btnRiesgos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/risk3.png"))); // NOI18N
        btnRiesgos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/risk1.png"))); // NOI18N
        btnRiesgos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnRiesgos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRiesgos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRiesgosActionPerformed(evt);
            }
        });

        btnDimens.setText("Dimensionamiento");
        btnDimens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDimensActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("<Nombre del Software>");

        btnNorma.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDimens, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNorma, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRiesgos, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel1)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCalidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRiesgos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDimens, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(btnNorma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalidadActionPerformed
        interfaceMain.mostrarMedidorCalidad();
    }//GEN-LAST:event_btnCalidadActionPerformed

    private void btnDimensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDimensActionPerformed
        interfaceMain.mostrarDimensionamiento();
    }//GEN-LAST:event_btnDimensActionPerformed

    private void btnRiesgosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRiesgosActionPerformed
        interfaceMain.mostrarRiesgos();
    }//GEN-LAST:event_btnRiesgosActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalidad;
    private javax.swing.JButton btnDimens;
    private javax.swing.JButton btnNorma;
    private javax.swing.JButton btnRiesgos;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
