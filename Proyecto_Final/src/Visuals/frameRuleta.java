/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Visuals;
import Code.*;
import java.awt.Color;

import java.util.concurrent.*;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author jesus
 */
public class frameRuleta extends javax.swing.JFrame {
    Timer time;
    boolean ruleta, estrella;
    public int tema;
    Jugador jug1,jug2;
    //Graphics graphic;
    /**
     * Creates new form frameRuleta
     */
    public frameRuleta() {
        initComponents();
        iniciarRuleta();
    }
    public frameRuleta(Jugador jug1,Jugador jug2, boolean estrella){
        initComponents();
        this.jug1 = jug1;
        this.jug2 = jug2;
        this.estrella = estrella;
        setEnvironment();
        iniciarRuleta();
    }
    private void setEnvironment(){
        checkProgress();
        if(this.jug1.enturno){
            txtJug.setText("Jugador en turno: " + this.jug1.nombre);
            txtJug2.setText("Progreso de: " + this.jug2.nombre);
            setBarras(jug1.progreso);
            setEstrellas(true);
        }else{
            txtJug.setText("Jugador en turno: " + this.jug2.nombre);
            txtJug2.setText("Progreso de: " + this.jug1.nombre);
            setBarras(jug2.progreso);
            setEstrellas(false);
        }
    }
    private void setEstrellas(boolean i){
        boolean [] estrellasarriba,estrellasabajo;
        estrellasarriba = new boolean[5];
        estrellasabajo = new boolean[5];
        if(i){
            System.out.println("Si entre");
            for(int cont=0;cont<jug1.estrellas;cont++){
                estrellasarriba[cont]=true;
            }
            for(int cont=0;cont<jug2.estrellas;cont++){
                estrellasabajo[cont]=true;
            }
        }else{
            for(int cont=0;cont<jug2.estrellas;cont++){
                estrellasarriba[cont]=true;
            }
            for(int cont=0;cont<jug1.estrellas;cont++){
                estrellasabajo[cont]=true;
            }
        }
        //Para arriba
        if(!estrellasarriba[0]){estrella11.setVisible(false);}
        if(!estrellasarriba[1]){estrella12.setVisible(false);}
        if(!estrellasarriba[2]){estrella13.setVisible(false);}
        if(!estrellasarriba[3]){estrella14.setVisible(false);}
        if(!estrellasarriba[4]){estrella15.setVisible(false);}
        //Para abajo
        if(!estrellasabajo[0]){estrella16.setVisible(false);}
        if(!estrellasabajo[1]){estrella17.setVisible(false);}
        if(!estrellasabajo[2]){estrella18.setVisible(false);}
        if(!estrellasabajo[3]){estrella19.setVisible(false);}
        if(!estrellasabajo[4]){estrella20.setVisible(false);}
    }
    private void checkProgress(){
        if(jug1.progreso>3){
            jug1.progreso = 0;
            estrella=true;
        }
        if(jug2.progreso>3){
            jug2.progreso = 0;
            estrella=true;
        }
    }
    private void setBarras(int i){
        switch(i){
            case 0->{
                panProgreso1.setBackground(Color.white);
                panProgreso2.setBackground(Color.white);
                panProgreso3.setBackground(Color.white);
            }
            case 1->{
                panProgreso1.setBackground(Color.green);
                panProgreso2.setBackground(Color.white);
                panProgreso3.setBackground(Color.white);
            }
            case 2->{
                panProgreso1.setBackground(Color.green);
                panProgreso2.setBackground(Color.green);
                panProgreso3.setBackground(Color.white);
            }
            case 3->{
                panProgreso1.setBackground(Color.green);
                panProgreso2.setBackground(Color.green);
                panProgreso3.setBackground(Color.green);
            }
        }
        if(estrella){
            panProgreso1.setBackground(new Color(191,147,13));
            panProgreso2.setBackground(new Color(191,147,13));
            panProgreso3.setBackground(new Color(191,147,13));
        }
    }
    private void iniciarRuleta(){
        ruleta = true;
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        final Runnable runnable = new Runnable() {
            int i = 4;
            @Override
            public void run() {
                i--;
                if (i < 0) {
                    i = 4;
                }
                setBordes(i);
                if(!ruleta){
                    scheduler.shutdown();
                    Random rnd = new Random();
                    int pregunta;
                    if(estrella){
                        pregunta = rnd.nextInt(3);
                        if(jug1.enturno){pregunta+=(jug1.estrellas*3)+25;}
                        else{pregunta+=(jug2.estrellas*3)+24;}
                        System.out.println(pregunta);
                    }
                    else{
                        pregunta = rnd.nextInt(5);
                        pregunta+=(i*5);
                    }
                    new framePreguntas(pregunta,jug1,jug2,estrella).setVisible(true);
                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 75, MILLISECONDS);
    }
    public void setBordes(int i){
        switch(i){
            case 4 -> {
                icDigitales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100),3));
                icDigitales.setBackground(new Color(100,100,100));
                icProgramacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0),1));
                icProgramacion.setBackground(bgdelaruleta.getBackground());
            }
            case 3 -> {
                icProbabilidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100),3));
                icDigitales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0),1));
            }
            case 2 ->{
                icMerca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100),3));
                icProbabilidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0),1));
            }
            case 1 ->{
                icIngles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100),3));
                icMerca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0),1));
            }
            case 0 ->{
                icProgramacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100),3));
                icIngles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0),1));
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnBackground = new javax.swing.JPanel();
        bgdelaruleta = new javax.swing.JPanel();
        icIngles = new ImagenIngles();
        icMerca = new ImagenMerca();
        icProgramacion = new ImagenProgramacion();
        icProbabilidad = new ImagenProbabilidad();
        icDigitales = new Imagen();
        panParar = new javax.swing.JPanel();
        txtParar = new javax.swing.JLabel();
        panJug = new javax.swing.JPanel();
        txtJug = new javax.swing.JLabel();
        panProgreso1 = new javax.swing.JPanel();
        panProgreso2 = new javax.swing.JPanel();
        panProgreso3 = new javax.swing.JPanel();
        estrella1 = new Imagenestrella1();
        estrella11 = new Imagenestrella2();
        estrella2 = new Imagenestrella1();
        estrella12 = new Imagenestrella2();
        estrella3 = new Imagenestrella1();
        estrella13 = new Imagenestrella2();
        estrella4 = new Imagenestrella1();
        estrella14 = new Imagenestrella2();
        estrella5 = new Imagenestrella1();
        estrella15 = new Imagenestrella2();
        estrella9 = new Imagenestrella1();
        estrella19 = new Imagenestrella3();
        estrella6 = new Imagenestrella1();
        estrella16 = new Imagenestrella3();
        estrella8 = new Imagenestrella1();
        estrella18 = new Imagenestrella3();
        estrella7 = new Imagenestrella1();
        estrella17 = new Imagenestrella3();
        estrella10 = new Imagenestrella1();
        estrella20 = new Imagenestrella3();
        txtJug2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(640, 960));

        pnBackground.setBackground(new java.awt.Color(102, 153, 255));
        pnBackground.setPreferredSize(new java.awt.Dimension(640, 960));
        pnBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bgdelaruleta.setBackground(new java.awt.Color(51, 153, 0));
        bgdelaruleta.setPreferredSize(new java.awt.Dimension(500, 500));

        icIngles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout icInglesLayout = new javax.swing.GroupLayout(icIngles);
        icIngles.setLayout(icInglesLayout);
        icInglesLayout.setHorizontalGroup(
            icInglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        icInglesLayout.setVerticalGroup(
            icInglesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        icMerca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout icMercaLayout = new javax.swing.GroupLayout(icMerca);
        icMerca.setLayout(icMercaLayout);
        icMercaLayout.setHorizontalGroup(
            icMercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        icMercaLayout.setVerticalGroup(
            icMercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        icProgramacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout icProgramacionLayout = new javax.swing.GroupLayout(icProgramacion);
        icProgramacion.setLayout(icProgramacionLayout);
        icProgramacionLayout.setHorizontalGroup(
            icProgramacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        icProgramacionLayout.setVerticalGroup(
            icProgramacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        icProbabilidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout icProbabilidadLayout = new javax.swing.GroupLayout(icProbabilidad);
        icProbabilidad.setLayout(icProbabilidadLayout);
        icProbabilidadLayout.setHorizontalGroup(
            icProbabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        icProbabilidadLayout.setVerticalGroup(
            icProbabilidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        icDigitales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout icDigitalesLayout = new javax.swing.GroupLayout(icDigitales);
        icDigitales.setLayout(icDigitalesLayout);
        icDigitalesLayout.setHorizontalGroup(
            icDigitalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        icDigitalesLayout.setVerticalGroup(
            icDigitalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panParar.setBackground(new java.awt.Color(255, 102, 102));
        panParar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panPararMouseClicked(evt);
            }
        });

        txtParar.setFont(new java.awt.Font("NanumGothic", 1, 24)); // NOI18N
        txtParar.setText("PARAR");

        javax.swing.GroupLayout panPararLayout = new javax.swing.GroupLayout(panParar);
        panParar.setLayout(panPararLayout);
        panPararLayout.setHorizontalGroup(
            panPararLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPararLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtParar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panPararLayout.setVerticalGroup(
            panPararLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPararLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtParar, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout bgdelaruletaLayout = new javax.swing.GroupLayout(bgdelaruleta);
        bgdelaruleta.setLayout(bgdelaruletaLayout);
        bgdelaruletaLayout.setHorizontalGroup(
            bgdelaruletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgdelaruletaLayout.createSequentialGroup()
                .addGroup(bgdelaruletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgdelaruletaLayout.createSequentialGroup()
                        .addGroup(bgdelaruletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgdelaruletaLayout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(icMerca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107)
                                .addComponent(icProbabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bgdelaruletaLayout.createSequentialGroup()
                                .addGap(220, 220, 220)
                                .addGroup(bgdelaruletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(panParar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(icProgramacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 112, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgdelaruletaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(icIngles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(icDigitales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        bgdelaruletaLayout.setVerticalGroup(
            bgdelaruletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgdelaruletaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgdelaruletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgdelaruletaLayout.createSequentialGroup()
                        .addComponent(icProgramacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panParar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(bgdelaruletaLayout.createSequentialGroup()
                        .addGap(0, 209, Short.MAX_VALUE)
                        .addGroup(bgdelaruletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(icIngles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(icDigitales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(111, 111, 111)))
                .addGroup(bgdelaruletaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icMerca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(icProbabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnBackground.add(bgdelaruleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 560, 550));

        panJug.setBackground(new java.awt.Color(255, 102, 102));
        panJug.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panJugMouseClicked(evt);
            }
        });

        txtJug.setFont(new java.awt.Font("NanumGothic", 0, 14)); // NOI18N
        txtJug.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtJug.setText("PARAR");

        javax.swing.GroupLayout panJugLayout = new javax.swing.GroupLayout(panJug);
        panJug.setLayout(panJugLayout);
        panJugLayout.setHorizontalGroup(
            panJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panJugLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtJug, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );
        panJugLayout.setVerticalGroup(
            panJugLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panJugLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtJug, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnBackground.add(panJug, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 290, -1));

        panProgreso1.setPreferredSize(new java.awt.Dimension(150, 20));

        javax.swing.GroupLayout panProgreso1Layout = new javax.swing.GroupLayout(panProgreso1);
        panProgreso1.setLayout(panProgreso1Layout);
        panProgreso1Layout.setHorizontalGroup(
            panProgreso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        panProgreso1Layout.setVerticalGroup(
            panProgreso1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        pnBackground.add(panProgreso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        panProgreso2.setPreferredSize(new java.awt.Dimension(150, 20));

        javax.swing.GroupLayout panProgreso2Layout = new javax.swing.GroupLayout(panProgreso2);
        panProgreso2.setLayout(panProgreso2Layout);
        panProgreso2Layout.setHorizontalGroup(
            panProgreso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        panProgreso2Layout.setVerticalGroup(
            panProgreso2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        pnBackground.add(panProgreso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, -1));

        panProgreso3.setPreferredSize(new java.awt.Dimension(150, 20));

        javax.swing.GroupLayout panProgreso3Layout = new javax.swing.GroupLayout(panProgreso3);
        panProgreso3.setLayout(panProgreso3Layout);
        panProgreso3Layout.setHorizontalGroup(
            panProgreso3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        panProgreso3Layout.setVerticalGroup(
            panProgreso3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        pnBackground.add(panProgreso3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));

        estrella1.setBackground(new java.awt.Color(102, 102, 102));
        estrella1.setMinimumSize(new java.awt.Dimension(50, 50));
        estrella1.setPreferredSize(new java.awt.Dimension(50, 50));

        estrella11.setBackground(new java.awt.Color(102, 102, 102));
        estrella11.setMinimumSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout estrella11Layout = new javax.swing.GroupLayout(estrella11);
        estrella11.setLayout(estrella11Layout);
        estrella11Layout.setHorizontalGroup(
            estrella11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        estrella11Layout.setVerticalGroup(
            estrella11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout estrella1Layout = new javax.swing.GroupLayout(estrella1);
        estrella1.setLayout(estrella1Layout);
        estrella1Layout.setHorizontalGroup(
            estrella1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(estrella1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(estrella1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(estrella11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        estrella1Layout.setVerticalGroup(
            estrella1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(estrella1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(estrella1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(estrella11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnBackground.add(estrella1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));

        estrella2.setBackground(new java.awt.Color(102, 102, 102));
        estrella2.setMinimumSize(new java.awt.Dimension(50, 50));

        estrella12.setBackground(new java.awt.Color(102, 102, 102));
        estrella12.setMinimumSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout estrella12Layout = new javax.swing.GroupLayout(estrella12);
        estrella12.setLayout(estrella12Layout);
        estrella12Layout.setHorizontalGroup(
            estrella12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        estrella12Layout.setVerticalGroup(
            estrella12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout estrella2Layout = new javax.swing.GroupLayout(estrella2);
        estrella2.setLayout(estrella2Layout);
        estrella2Layout.setHorizontalGroup(
            estrella2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(estrella2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(estrella2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(estrella12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        estrella2Layout.setVerticalGroup(
            estrella2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(estrella2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(estrella2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(estrella12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnBackground.add(estrella2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        estrella3.setBackground(new java.awt.Color(102, 102, 102));
        estrella3.setMinimumSize(new java.awt.Dimension(50, 50));

        estrella13.setBackground(new java.awt.Color(102, 102, 102));
        estrella13.setMinimumSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout estrella13Layout = new javax.swing.GroupLayout(estrella13);
        estrella13.setLayout(estrella13Layout);
        estrella13Layout.setHorizontalGroup(
            estrella13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        estrella13Layout.setVerticalGroup(
            estrella13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout estrella3Layout = new javax.swing.GroupLayout(estrella3);
        estrella3.setLayout(estrella3Layout);
        estrella3Layout.setHorizontalGroup(
            estrella3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(estrella3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(estrella3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(estrella13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        estrella3Layout.setVerticalGroup(
            estrella3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(estrella3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(estrella3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(estrella13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnBackground.add(estrella3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, -1));

        estrella4.setBackground(new java.awt.Color(102, 102, 102));
        estrella4.setMinimumSize(new java.awt.Dimension(50, 50));

        estrella14.setBackground(new java.awt.Color(102, 102, 102));
        estrella14.setMinimumSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout estrella14Layout = new javax.swing.GroupLayout(estrella14);
        estrella14.setLayout(estrella14Layout);
        estrella14Layout.setHorizontalGroup(
            estrella14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        estrella14Layout.setVerticalGroup(
            estrella14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout estrella4Layout = new javax.swing.GroupLayout(estrella4);
        estrella4.setLayout(estrella4Layout);
        estrella4Layout.setHorizontalGroup(
            estrella4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(estrella4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(estrella4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(estrella14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        estrella4Layout.setVerticalGroup(
            estrella4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(estrella4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(estrella4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(estrella14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnBackground.add(estrella4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        estrella5.setBackground(new java.awt.Color(102, 102, 102));
        estrella5.setMinimumSize(new java.awt.Dimension(50, 50));

        estrella15.setBackground(new java.awt.Color(102, 102, 102));
        estrella15.setMinimumSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout estrella15Layout = new javax.swing.GroupLayout(estrella15);
        estrella15.setLayout(estrella15Layout);
        estrella15Layout.setHorizontalGroup(
            estrella15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        estrella15Layout.setVerticalGroup(
            estrella15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout estrella5Layout = new javax.swing.GroupLayout(estrella5);
        estrella5.setLayout(estrella5Layout);
        estrella5Layout.setHorizontalGroup(
            estrella5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(estrella5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(estrella5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(estrella15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        estrella5Layout.setVerticalGroup(
            estrella5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(estrella5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(estrella5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(estrella15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnBackground.add(estrella5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, -1));

        estrella9.setBackground(new java.awt.Color(102, 102, 102));
        estrella9.setMinimumSize(new java.awt.Dimension(50, 50));

        estrella19.setBackground(new java.awt.Color(102, 102, 102));
        estrella19.setMinimumSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout estrella19Layout = new javax.swing.GroupLayout(estrella19);
        estrella19.setLayout(estrella19Layout);
        estrella19Layout.setHorizontalGroup(
            estrella19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        estrella19Layout.setVerticalGroup(
            estrella19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout estrella9Layout = new javax.swing.GroupLayout(estrella9);
        estrella9.setLayout(estrella9Layout);
        estrella9Layout.setHorizontalGroup(
            estrella9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(estrella9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(estrella9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(estrella19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        estrella9Layout.setVerticalGroup(
            estrella9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(estrella9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(estrella9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(estrella19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnBackground.add(estrella9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 870, -1, -1));

        estrella6.setBackground(new java.awt.Color(102, 102, 102));
        estrella6.setMinimumSize(new java.awt.Dimension(50, 50));

        estrella16.setBackground(new java.awt.Color(102, 102, 102));
        estrella16.setMinimumSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout estrella16Layout = new javax.swing.GroupLayout(estrella16);
        estrella16.setLayout(estrella16Layout);
        estrella16Layout.setHorizontalGroup(
            estrella16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        estrella16Layout.setVerticalGroup(
            estrella16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout estrella6Layout = new javax.swing.GroupLayout(estrella6);
        estrella6.setLayout(estrella6Layout);
        estrella6Layout.setHorizontalGroup(
            estrella6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(estrella6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(estrella6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(estrella16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        estrella6Layout.setVerticalGroup(
            estrella6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(estrella6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(estrella6Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(estrella16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnBackground.add(estrella6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 870, -1, -1));

        estrella8.setBackground(new java.awt.Color(102, 102, 102));
        estrella8.setMinimumSize(new java.awt.Dimension(50, 50));

        estrella18.setBackground(new java.awt.Color(102, 102, 102));
        estrella18.setMinimumSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout estrella18Layout = new javax.swing.GroupLayout(estrella18);
        estrella18.setLayout(estrella18Layout);
        estrella18Layout.setHorizontalGroup(
            estrella18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        estrella18Layout.setVerticalGroup(
            estrella18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout estrella8Layout = new javax.swing.GroupLayout(estrella8);
        estrella8.setLayout(estrella8Layout);
        estrella8Layout.setHorizontalGroup(
            estrella8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(estrella8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(estrella8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(estrella18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        estrella8Layout.setVerticalGroup(
            estrella8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(estrella8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(estrella8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(estrella18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnBackground.add(estrella8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 870, -1, -1));

        estrella7.setBackground(new java.awt.Color(102, 102, 102));
        estrella7.setMinimumSize(new java.awt.Dimension(50, 50));

        estrella17.setBackground(new java.awt.Color(102, 102, 102));
        estrella17.setMinimumSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout estrella17Layout = new javax.swing.GroupLayout(estrella17);
        estrella17.setLayout(estrella17Layout);
        estrella17Layout.setHorizontalGroup(
            estrella17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        estrella17Layout.setVerticalGroup(
            estrella17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout estrella7Layout = new javax.swing.GroupLayout(estrella7);
        estrella7.setLayout(estrella7Layout);
        estrella7Layout.setHorizontalGroup(
            estrella7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(estrella7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(estrella7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(estrella17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        estrella7Layout.setVerticalGroup(
            estrella7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(estrella7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(estrella7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(estrella17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnBackground.add(estrella7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 870, -1, -1));

        estrella10.setBackground(new java.awt.Color(102, 102, 102));
        estrella10.setMinimumSize(new java.awt.Dimension(50, 50));

        estrella20.setBackground(new java.awt.Color(102, 102, 102));
        estrella20.setMinimumSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout estrella20Layout = new javax.swing.GroupLayout(estrella20);
        estrella20.setLayout(estrella20Layout);
        estrella20Layout.setHorizontalGroup(
            estrella20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        estrella20Layout.setVerticalGroup(
            estrella20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout estrella10Layout = new javax.swing.GroupLayout(estrella10);
        estrella10.setLayout(estrella10Layout);
        estrella10Layout.setHorizontalGroup(
            estrella10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(estrella10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(estrella10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(estrella20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        estrella10Layout.setVerticalGroup(
            estrella10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(estrella10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(estrella10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(estrella20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnBackground.add(estrella10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 870, -1, -1));

        txtJug2.setFont(new java.awt.Font("NanumGothic", 1, 18)); // NOI18N
        txtJug2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtJug2.setText("jLabel1");
        pnBackground.add(txtJug2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 840, 270, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panJugMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panJugMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panJugMouseClicked

    private void panPararMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panPararMouseClicked
        ruleta = false;
    }//GEN-LAST:event_panPararMouseClicked

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
            java.util.logging.Logger.getLogger(frameRuleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frameRuleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frameRuleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frameRuleta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new frameRuleta().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgdelaruleta;
    private javax.swing.JPanel estrella1;
    private javax.swing.JPanel estrella10;
    private javax.swing.JPanel estrella11;
    private javax.swing.JPanel estrella12;
    private javax.swing.JPanel estrella13;
    private javax.swing.JPanel estrella14;
    private javax.swing.JPanel estrella15;
    private javax.swing.JPanel estrella16;
    private javax.swing.JPanel estrella17;
    private javax.swing.JPanel estrella18;
    private javax.swing.JPanel estrella19;
    private javax.swing.JPanel estrella2;
    private javax.swing.JPanel estrella20;
    private javax.swing.JPanel estrella3;
    private javax.swing.JPanel estrella4;
    private javax.swing.JPanel estrella5;
    private javax.swing.JPanel estrella6;
    private javax.swing.JPanel estrella7;
    private javax.swing.JPanel estrella8;
    private javax.swing.JPanel estrella9;
    private javax.swing.JPanel icDigitales;
    private javax.swing.JPanel icIngles;
    private javax.swing.JPanel icMerca;
    private javax.swing.JPanel icProbabilidad;
    private javax.swing.JPanel icProgramacion;
    private javax.swing.JPanel panJug;
    private javax.swing.JPanel panParar;
    private javax.swing.JPanel panProgreso1;
    private javax.swing.JPanel panProgreso2;
    private javax.swing.JPanel panProgreso3;
    private javax.swing.JPanel pnBackground;
    private javax.swing.JLabel txtJug;
    private javax.swing.JLabel txtJug2;
    private javax.swing.JLabel txtParar;
    // End of variables declaration//GEN-END:variables
    class Imagen extends JPanel{
        private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("icoDigitales.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    class ImagenIngles extends JPanel{
        private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("icoIngles.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    class ImagenProbabilidad extends JPanel{
        private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("icoProbabilidad.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    class ImagenProgramacion extends JPanel{
        private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("icoProgramacion.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    class ImagenMerca extends JPanel{
        private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("icoMerca.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    class Imagenestrella1 extends JPanel{
        private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("estrellanegra.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    class Imagenestrella3 extends JPanel{
        private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("estrellaroja.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    class Imagenestrella2 extends JPanel{
        private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("estrelladorada.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
