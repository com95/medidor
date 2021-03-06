package medidor.vista;

import medidor.controlador.ICalidad;

public class UICalidad extends javax.swing.JFrame {
  
    private ICalidad interfaceCalidad;
    
    public UICalidad(ICalidad interfaceCalidad) {
        this.getContentPane().setBackground(new java.awt.Color(221, 238, 255));
        this.setVisible(true);
        initComponents();
        
        this.interfaceCalidad = interfaceCalidad;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnEvaluar = new javax.swing.JButton();
        lblEscoger = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtModelos = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        btnAyuda = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstModelos = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Medidor de Calidad");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/recursos/medidor1.png")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Cambria", 1, 32)); // NOI18N
        lblTitulo.setText("MEDIDOR DE CALIDAD");

        btnEvaluar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEvaluar.setForeground(new java.awt.Color(0, 51, 153));
        btnEvaluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/A2.png"))); // NOI18N
        btnEvaluar.setText("EVALUAR");
        btnEvaluar.setBorder(null);
        btnEvaluar.setBorderPainted(false);
        btnEvaluar.setContentAreaFilled(false);
        btnEvaluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEvaluar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEvaluar.setIconTextGap(-3);
        btnEvaluar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/A3.png"))); // NOI18N
        btnEvaluar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/A1.png"))); // NOI18N
        btnEvaluar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEvaluar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEvaluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEvaluarActionPerformed(evt);
            }
        });

        lblEscoger.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblEscoger.setText("Seleccione un estandar de calidad:");

        txtModelos.setColumns(20);
        txtModelos.setFont(new java.awt.Font("Franklin Gothic Book", 2, 14)); // NOI18N
        txtModelos.setRows(5);
        jScrollPane2.setViewportView(txtModelos);

        btnAyuda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAyuda.setForeground(new java.awt.Color(0, 51, 153));
        btnAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/help2.png"))); // NOI18N
        btnAyuda.setText("Ayuda");
        btnAyuda.setBorder(null);
        btnAyuda.setBorderPainted(false);
        btnAyuda.setContentAreaFilled(false);
        btnAyuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAyuda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAyuda.setIconTextGap(-3);
        btnAyuda.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/help3.png"))); // NOI18N
        btnAyuda.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/help1.png"))); // NOI18N
        btnAyuda.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAyuda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lstModelos.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lstModelos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Modelo ISO 9126", "Modelo McCall", "Modelo Peruano" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstModelos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lstModelosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(lstModelos);

        jButton1.setText("VOLVER AL MENÚ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblTitulo))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addComponent(lblEscoger)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAyuda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addGap(18, 18, 18)
                        .addComponent(btnEvaluar))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEscoger)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEvaluar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAyuda)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstModelosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstModelosMousePressed
        interfaceCalidad.mostrarDescripcion(lstModelos, txtModelos);
    }//GEN-LAST:event_lstModelosMousePressed

    private void btnEvaluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEvaluarActionPerformed
        interfaceCalidad.evaluar(lstModelos);
    }//GEN-LAST:event_btnEvaluarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnEvaluar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEscoger;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList lstModelos;
    private javax.swing.JTextArea txtModelos;
    // End of variables declaration//GEN-END:variables
}
