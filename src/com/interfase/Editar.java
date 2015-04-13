/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interfase;
import com.negocio.Archivo;
import com.negocio.Consulta;
import com.negocio.MakeEnterDoAction;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author tutor
 */

public class Editar extends javax.swing.JDialog {
    private Frame Ingresar;

    /**
     * Creates new form Ingresar
     */
    public Editar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);        
        initComponents();
        String fecha = null;
        Date d = new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy h:mm a");
        fecha=sdf.format(d).toString();
        txt_fecha.setText(fecha);
        setJTexFieldChanged(txt_code);
        txt_code.addKeyListener(new MakeEnterDoAction()); // convert Enter to an ActionEvent
        
    }

    Editar(Borrar aThis, boolean b, String cedula) {
        super(aThis, b);   
        initComponents();
        String fecha = null;
        Date d = new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy h:mm a");
        fecha=sdf.format(d).toString();
        txt_fecha.setText(fecha);
        txt_cedula.setText(cedula);
        setJTexFieldChanged(txt_code);
        txt_code.addKeyListener(new MakeEnterDoAction()); // convert Enter to an ActionEvent
        //inicializa la ventana con los datos del antes seleccionado
        Consulta intcn=new Consulta();
        ResultSet resultado=null;
        ResultSet resultado1=null;
        if(txt_cedula.getText()==null||"".equals(txt_cedula.getText())||" ".equals(txt_cedula.getText())||txt_cedula.getText().length()<10){
            JOptionPane.showMessageDialog(null, "Ingrese la cedula o cedula incompleta");
        }else{
            //llenar datos estudiante
            resultado=intcn.consulta_estudiante(txt_cedula.getText());
            resultado1=intcn.consulta_prestamos(txt_cedula.getText());
            try {
                if(resultado.next()){
                    txt_estudiante.setText(resultado.getObject(2).toString());
                    txt_cod.setText(resultado.getObject(3).toString());                   
                }
            } catch (SQLException e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
            //LLENAR TABLA PRESTAMOS
            DefaultTableModel searchListModel = new DefaultTableModel();
            this.tbl_prestamos.setModel(searchListModel);
            searchListModel.addColumn("FECHA");
            searchListModel.addColumn("CODIGO");
            searchListModel.addColumn("NOMBRE");
            searchListModel.addColumn("DESCRIPCION");
            searchListModel.addColumn("OBSERVACION");

            //ASIGNAR TAMAÑO A CADA COLUMNA
            tbl_prestamos.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbl_prestamos.getColumnModel().getColumn(1).setPreferredWidth(80);
            tbl_prestamos.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbl_prestamos.getColumnModel().getColumn(3).setPreferredWidth(80);
            tbl_prestamos.getColumnModel().getColumn(4).setPreferredWidth(80);
            try{
                while(resultado1.next()){
                    //Se crea un array q sera una de las filas de la tabla
                    Object [] fila = new Object[5];//Hay 5 columnas en la tabla
                    //Se rellena cada posicion del array con una de las colimnas de la tabla
                    fila[0] = resultado1.getObject(5);//El primer indice en rs es el 1 no el cero por eso se suma 1
                    fila[1] = resultado1.getObject(1);
                    fila[2] = resultado1.getObject(2);
                    fila[3] = resultado1.getObject(3);
                    fila[4] = resultado1.getObject(4);
                    // Se añade al modelo la Fila completa
                    searchListModel.addRow(fila);                
                }
            }catch(SQLException e){
                System.out.println("Error de MySQL: "+e.getMessage());
            }
                txt_cedula.enable(false);
            }
        
    }

    private void setJTexFieldChanged(JTextField txt)
    {
        DocumentListener documentListener = new DocumentListener() {

        @Override
        public void changedUpdate(DocumentEvent documentEvent) {
            printIt(documentEvent);
        }

        @Override
        public void insertUpdate(DocumentEvent documentEvent) {
            printIt(documentEvent);
        }

        @Override
        public void removeUpdate(DocumentEvent documentEvent) {
            printIt(documentEvent);
        }
        };
        txt.getDocument().addDocumentListener(documentListener);

    }
    
        private void printIt(DocumentEvent documentEvent) {
        DocumentEvent.EventType type = documentEvent.getType();

        if (type.equals(DocumentEvent.EventType.CHANGE))
        {

        }
        else if (type.equals(DocumentEvent.EventType.INSERT))
        {
            txtEjemploJTextFieldChanged();
        }
        else if (type.equals(DocumentEvent.EventType.REMOVE))
        {
            txtEjemploJTextFieldChanged();
        }
    }
        
    private void txtEjemploJTextFieldChanged()
    {
        //Copiar el contenido del jtextfield al jlabel
        this.lbl_Ejemplo.setText(this.txt_code.getText());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_prestamos = new javax.swing.JTable();
        txt_estudiante = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_elementos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_elemento = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        btn_agregar = new javax.swing.JButton();
        btn_otro = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_borrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_cod = new javax.swing.JTextField();
        btn_bestudiante = new javax.swing.JButton();
        txt_code = new javax.swing.JTextField();
        lbl_Ejemplo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LabLEND 1.0 - Editar Prestamos");

        tbl_prestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "NO SE ENCONTRARON DATOS"
            }
        ));
        jScrollPane1.setViewportView(tbl_prestamos);

        txt_estudiante.setEditable(false);

        jLabel1.setText("Estudiante:");

        jLabel2.setText("Cedula:");

        txt_cedula.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cedulaKeyTyped(evt);
            }
        });

        tbl_elementos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_elementos);

        jLabel3.setText("Fecha:");

        txt_fecha.setEditable(false);
        txt_fecha.setText("jTextField1");

        jLabel4.setText("Buscar:");

        txt_elemento.setText("jTextField1");

        btn_buscar.setText("Buscar");
        btn_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_buscarMouseClicked(evt);
            }
        });

        btn_agregar.setText("Agregar");
        btn_agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_agregarMouseClicked(evt);
            }
        });
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        btn_otro.setText("Agregar Otro");
        btn_otro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_otroMouseClicked(evt);
            }
        });

        btn_guardar.setText("Actualizar Registro");
        btn_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_guardarMouseClicked(evt);
            }
        });

        btn_borrar.setText("Borrar");
        btn_borrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_borrarMouseClicked(evt);
            }
        });

        jLabel5.setText("Cod:");

        txt_cod.setEditable(false);

        btn_bestudiante.setText("Buscar Est");
        btn_bestudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_bestudianteMouseClicked(evt);
            }
        });

        txt_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codeActionPerformed(evt);
            }
        });

        lbl_Ejemplo.setText("CODIGO");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/resources/facu.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_estudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_bestudiante)))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_fecha)
                    .addComponent(txt_cod, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_agregar)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(237, 237, 237)
                                .addComponent(btn_borrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_otro)
                                .addGap(72, 72, 72)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_elemento, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btn_buscar)
                .addGap(49, 49, 49)
                .addComponent(txt_code, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(lbl_Ejemplo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_bestudiante)
                                .addComponent(jLabel2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_estudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_otro)
                        .addComponent(btn_borrar))
                    .addComponent(btn_guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_elemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar)
                    .addComponent(txt_code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Ejemplo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_agregar)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarMouseClicked
        
        ResultSet resultado=null;
        Consulta instconsulta= new Consulta();
        String texto=null;
        texto=txt_elemento.getText();
        resultado= instconsulta.consulta_elementos(texto);
        DefaultTableModel searchListModel = new DefaultTableModel();
        this.tbl_elementos.setModel(searchListModel);
        searchListModel.addColumn("CODIGO");
        searchListModel.addColumn("NOMBRE");
        searchListModel.addColumn("DESCRIPCION");
        searchListModel.addColumn("OBSERVACION");
        
        //ASIGNAR TAMAÑO A CADA COLUMNA
        tbl_elementos.getColumnModel().getColumn(0).setPreferredWidth(80);
        tbl_elementos.getColumnModel().getColumn(1).setPreferredWidth(80);
        tbl_elementos.getColumnModel().getColumn(2).setPreferredWidth(80);
        tbl_elementos.getColumnModel().getColumn(3).setPreferredWidth(80);
        try{
            while(resultado.next()){
                //Se crea un array q sera una de las filas de la tabla
                Object [] fila = new Object[4];//Hay 5 columnas en la tabla
                //Se rellena cada posicion del array con una de las colimnas de la tabla
                fila[0] = resultado.getObject(1);//El primer indice en rs es el 1 no el cero por eso se suma 1
                fila[1] = resultado.getObject(3);
                fila[2] = resultado.getObject(4);
                fila[3] = resultado.getObject(16);
                // Se añade al modelo la Fila completa
                searchListModel.addRow(fila);                
            }
        }catch(SQLException e){
            System.out.println("Error de MySQL: "+e.getMessage());
        }// TODO add your handling code here:
    }//GEN-LAST:event_btn_buscarMouseClicked

    private void btn_agregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregarMouseClicked
        int fila = tbl_elementos.getSelectedRow();
        TableModel modelo = tbl_elementos.getModel();
        DefaultTableModel searchListModel;
        Archivo intArc=new Archivo();//escribe el archivo        
        searchListModel = (DefaultTableModel)tbl_prestamos.getModel();
		if (fila != -1) {
                    intArc.escribir_linea(txt_cedula.getText(),"\n\t"+txt_fecha.getText());
                    int nColumns = tbl_elementos.getColumnCount();
                    Object[] filaSeleccionada = new Object[nColumns+1];
                    filaSeleccionada[0]=txt_fecha.getText();
                    for (int i = 0; i < filaSeleccionada.length-1; ++i) {
                        filaSeleccionada[i+1] = modelo.getValueAt(fila, i);
                    }
                    for(int i=1;i<4;i++){
                        intArc.escribir_linea(txt_cedula.getText(),"\t"+ filaSeleccionada[i].toString());
                    }
                    intArc.escribir_linea(txt_cedula.getText(),"\tPRESTAMO");
                    searchListModel.addRow(filaSeleccionada);
                        
		}
		else	{
                    JOptionPane.showMessageDialog(this, "No hay registro seleccionado");
                }// TODO add your handling code here:
                

        this.tbl_prestamos.setModel(searchListModel);
       
    }//GEN-LAST:event_btn_agregarMouseClicked

    private void btn_borrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_borrarMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tbl_prestamos.getModel();
        Archivo intArc=new Archivo();//escribe el archivo
        Object obj[]=new Object[model.getColumnCount()];
        int fila = tbl_prestamos.getSelectedRow();
        if (fila != -1) {
            intArc.escribir_linea(txt_cedula.getText(),"\n\t"+txt_fecha.getText());
            for(int i=0;i<4;i++){
                obj[i]=model.getValueAt(fila, i);                
            }
            for(int i=1;i<4;i++){
                intArc.escribir_linea(txt_cedula.getText(),"\t"+ obj[i].toString());
            }
            intArc.escribir_linea(txt_cedula.getText(),"\tDEVOLUCION");
            model.removeRow(tbl_prestamos.getSelectedRow());
        }
    }//GEN-LAST:event_btn_borrarMouseClicked

    private void btn_otroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_otroMouseClicked
        JOptionPane.showMessageDialog(this, "Ingrese los datos del Elemento en la linea vacia de la tabla... xD");
        DefaultTableModel searchListModel;
        searchListModel = (DefaultTableModel)tbl_prestamos.getModel();
        int nColumns = tbl_prestamos.getColumnCount();
        int nRows = tbl_prestamos.getRowCount();
        Object[] filaSeleccionada = new Object[nColumns];
        searchListModel.addRow(filaSeleccionada);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_otroMouseClicked

    private void btn_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guardarMouseClicked
        Consulta instC=new Consulta();
        if(txt_estudiante.getText()==null||"".equals(txt_estudiante.getText())||" ".equals(txt_estudiante.getText())
                ||txt_cedula.getText()==null||"".equals(txt_cedula.getText())||" ".equals(txt_cedula.getText())){
            JOptionPane.showMessageDialog(null, "Cedula y Nombre Son Campos Obligatorios");
        }else{
            //instC.ingresa_Est(txt_cedula.getText(), txt_estudiante.getText(),txt_cod.getText());
            instC.borra_prestamos(txt_cedula.getText());
            int r=0;
            int n =tbl_prestamos.getRowCount();
            int c =tbl_prestamos.getColumnCount();
            Object[] filaSeleccionada;
            filaSeleccionada = new Object[c];
            for(int j = 0; j< n; ++j){
                for (int i = 0; i < filaSeleccionada.length; i++) {                
                            filaSeleccionada[i] = tbl_prestamos.getValueAt(j, i);                            
                }
                instC.ingresa_Prest(filaSeleccionada[1].toString(), filaSeleccionada[2].toString(),filaSeleccionada[3].toString(), filaSeleccionada[4].toString(), filaSeleccionada[0].toString(), txt_cedula.getText());
                r++;
            }
            JOptionPane.showMessageDialog(this, "Registro de Prestamo y Estudiante Guardado Exitosamente\nElementos Prestados "+String.valueOf(r));
            this.dispose();
        }// TODO add your handling code here:
    }//GEN-LAST:event_btn_guardarMouseClicked

    private void txt_cedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cedulaKeyTyped
        int i = txt_cedula.getText().length();
        if(txt_cedula.getText().trim().length()<10){
            System.out.println(String.valueOf(i));
        }else{
            i=10;
            String com=txt_cedula.getText().substring(0, 9);
            txt_cedula.setText("");
            txt_cedula.setText(com);
        }// TODO add your handling code here:
    }//GEN-LAST:event_txt_cedulaKeyTyped

    private void btn_bestudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bestudianteMouseClicked
        Consulta intcn=new Consulta();
        ResultSet resultado=null;
        ResultSet resultado1=null;
        if(txt_cedula.getText()==null||"".equals(txt_cedula.getText())||" ".equals(txt_cedula.getText())||txt_cedula.getText().length()<10){
            JOptionPane.showMessageDialog(null, "Ingrese la cedula o cedula incompleta");
        }else{
            //llenar datos estudiante
            resultado=intcn.consulta_estudiante(txt_cedula.getText());
            resultado1=intcn.consulta_prestamos(txt_cedula.getText());
            try {
                if(resultado.next()){
                    txt_estudiante.setText(resultado.getObject(2).toString());
                    txt_cod.setText(resultado.getObject(3).toString());                   
                }
            } catch (SQLException e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
            //LLENAR TABLA PRESTAMOS
            DefaultTableModel searchListModel = new DefaultTableModel();
            this.tbl_prestamos.setModel(searchListModel);
            searchListModel.addColumn("FECHA");
            searchListModel.addColumn("CODIGO");
            searchListModel.addColumn("NOMBRE");
            searchListModel.addColumn("DESCRIPCION");
            searchListModel.addColumn("OBSERVACION");

            //ASIGNAR TAMAÑO A CADA COLUMNA
            tbl_prestamos.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbl_prestamos.getColumnModel().getColumn(1).setPreferredWidth(80);
            tbl_prestamos.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbl_prestamos.getColumnModel().getColumn(3).setPreferredWidth(80);
            tbl_prestamos.getColumnModel().getColumn(4).setPreferredWidth(80);
            try{
                while(resultado1.next()){
                    //Se crea un array q sera una de las filas de la tabla
                    Object [] fila = new Object[5];//Hay 5 columnas en la tabla
                    //Se rellena cada posicion del array con una de las colimnas de la tabla
                    fila[0] = resultado1.getObject(5);//El primer indice en rs es el 1 no el cero por eso se suma 1
                    fila[1] = resultado1.getObject(1);
                    fila[2] = resultado1.getObject(2);
                    fila[3] = resultado1.getObject(3);
                    fila[4] = resultado1.getObject(4);
                    // Se añade al modelo la Fila completa
                    searchListModel.addRow(fila);                
                }
            }catch(SQLException e){
                System.out.println("Error de MySQL: "+e.getMessage());
            }
                txt_cedula.enable(false);
            }// TODO add your handling code here:
    }//GEN-LAST:event_btn_bestudianteMouseClicked

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void txt_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codeActionPerformed
        txt_code.addKeyListener(new MakeEnterDoAction());
        if(txt_code.getText()==null||"".equals(txt_code.getText())||" ".equals(txt_code.getText())){
            JOptionPane.showMessageDialog(null, "Ingrese el codigo con el lector de barras");
        }else{
            Consulta cons=new Consulta();        
            ResultSet resultado=null;
            resultado=cons.consulta_elemCod(lbl_Ejemplo.getText());
            DefaultTableModel searchListModel = new DefaultTableModel();
            this.tbl_elementos.setModel(searchListModel);
            searchListModel.addColumn("CODIGO");
            searchListModel.addColumn("NOMBRE");
            searchListModel.addColumn("DESCRIPCION");
            searchListModel.addColumn("OBSERVACION");

            //ASIGNAR TAMAÑO A CADA COLUMNA
            tbl_elementos.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbl_elementos.getColumnModel().getColumn(1).setPreferredWidth(80);
            tbl_elementos.getColumnModel().getColumn(2).setPreferredWidth(80);
            tbl_elementos.getColumnModel().getColumn(3).setPreferredWidth(80);
               // TODO add your handling code here:
            try{
                Object [] fila = new Object[4];//Hay 5 columnas en la tabla
                while(resultado.next()){
                    //Se crea un array q sera una de las filas de la tabla 
                    //Se rellena cada posicion del array con una de las colimnas de la tabla
                    fila[0] = resultado.getObject(1);//El primer indice en rs es el 1 no el cero por eso se suma 1
                    fila[1] = resultado.getObject(3);
                    fila[2] = resultado.getObject(4);
                    fila[3] = resultado.getObject(16);
                    // Se añade al modelo la Fila completa
                    searchListModel.addRow(fila);
                }
                Archivo intArc=new Archivo();//escribe el archivo 
                searchListModel = (DefaultTableModel)tbl_prestamos.getModel();        
                intArc.escribir_linea(txt_cedula.getText(),"\n\t"+txt_fecha.getText());
                int nColumns = tbl_prestamos.getColumnCount();
                Object[] filaSeleccionada = new Object[nColumns];
                filaSeleccionada[0]=txt_fecha.getText();
                for (int i = 0; i < filaSeleccionada.length-1; ++i) {
                    filaSeleccionada[i+1] = fila[i];
                }
                for(int i=1;i<4;i++){
                    intArc.escribir_linea(txt_cedula.getText(),"\t"+ filaSeleccionada[i].toString());
                }
                intArc.escribir_linea(txt_cedula.getText(),"\tPRESTAMO");
                searchListModel.addRow(filaSeleccionada);
            }catch(SQLException e){
                System.out.println("Error de MySQL: "+e.getMessage());
            }
            txt_code.setText(null);// TODO add your handling code here:     
        }
    }//GEN-LAST:event_txt_codeActionPerformed

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
            java.util.logging.Logger.getLogger(Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Editar dialog = new Editar(new javax.swing.JFrame(), true);                
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_bestudiante;
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_otro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Ejemplo;
    private javax.swing.JTable tbl_elementos;
    private javax.swing.JTable tbl_prestamos;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_cod;
    private javax.swing.JTextField txt_code;
    private javax.swing.JTextField txt_elemento;
    private javax.swing.JTextField txt_estudiante;
    private javax.swing.JTextField txt_fecha;
    // End of variables declaration//GEN-END:variables
}
