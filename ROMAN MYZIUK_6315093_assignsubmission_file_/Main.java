import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;



public class Main {
    public static void main (String[] args) {
        CrearMarcoCentrado miMarco = new CrearMarcoCentrado(1000,1000);
    }
}

class CrearMarcoCentrado extends JFrame {
    CrearMarcoCentrado (int tamx,int tamy) {
        this.setSize(tamx,tamy);
        Toolkit myScreen = Toolkit.getDefaultToolkit();
        Dimension resolution = myScreen.getScreenSize();
        int resx=resolution.width;
        int resy=resolution.height;
        this.setLocation(resx/2-tamx/2,resy/2-tamy/2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CrearLamina miLamina = new CrearLamina(); //Creo mi lamina transparente con mi dibujo
        add(miLamina); //Añado mi lamina al Frame
        this.setVisible(true);
    }
}

class CrearMarcoSlider1 extends JFrame {
    CrearMarcoSlider1 (int tamx,int tamy) {
        this.setSize(tamx,tamy);
        Toolkit myScreen = Toolkit.getDefaultToolkit();
        Dimension resolution = myScreen.getScreenSize();
        int resx=resolution.width;
        int resy=resolution.height;
        this.setLocation(resx/2-tamx/2,resy/2-tamy/2);
        CrearLamina.CrearLaminaSliderFuente CrearLaminaSliderFuente1 = new CrearLamina.CrearLaminaSliderFuente(); //Creo mi lamina transparente con mi dibujo
        add(CrearLaminaSliderFuente1); //Añado mi lamina al Frame
        this.setVisible(true);
    }
}

class CrearMarcoSlider2 extends JFrame {
    CrearMarcoSlider2 (int tamx,int tamy) {
        this.setSize(tamx,tamy);
        Toolkit myScreen = Toolkit.getDefaultToolkit();
        Dimension resolution = myScreen.getScreenSize();
        int resx=resolution.width;
        int resy=resolution.height;
        this.setLocation(resx/2-tamx/2,resy/2-tamy/2);
        CrearLamina.CrearLaminaSliderColor CrearLaminaSliderColor1 = new CrearLamina.CrearLaminaSliderColor(); //Creo mi lamina transparente con mi dibujo
        add(CrearLaminaSliderColor1); //Añado mi lamina al Frame
        this.setVisible(true);
    }
}


class CrearLamina extends JPanel { //Añadimos la interfaz

    JLabel Texto = new JLabel("Texto");

    static int color1;
    static int color2;
    static int color3;

    ButtonGroup grupoBotones = new ButtonGroup();
    ButtonGroup grupoFuentes = new ButtonGroup();
    ButtonGroup grupoTamanio = new ButtonGroup();

    JButton personalizarFuente;
    JButton personalizarColor;

    JRadioButton radio1, radio2, radio3, radio4, radio5, radio6;

    JRadioButton fuente1, fuente2, fuente3, fuente4;

    JRadioButton tamanio1, tamanio2, tamanio3, tamanio4,tamanio5,tamanio6;


    Color colorchange = new Color(color1, color2, color3);

    static int tamanio = 5;

    JLabel espacio = new JLabel("");


    public CrearLamina(){
        GridLayout GestorUbiGrid = new GridLayout(2,2);
        setLayout(GestorUbiGrid);
        LaminaNorOeste laminaNorOeste1 = new LaminaNorOeste();
        add(laminaNorOeste1);
        LaminaNorEste LaminaNorEste1 = new LaminaNorEste();
        add(LaminaNorEste1);
        LaminaSurOeste LaminaSurOeste1= new LaminaSurOeste();
        add(LaminaSurOeste1);
        LaminaSurEste LaminaSurEste1 = new LaminaSurEste();
        add(LaminaSurEste1);
    }

    static class CrearLaminaSliderFuente extends JPanel{
        JSlider miSlider;
        JTextField miSliderNum;

        CrearLaminaSliderFuente(){
            miSlider= new JSlider(0,50,5);
            miSlider.setMajorTickSpacing(10);
            miSlider.setMinorTickSpacing(1);
            miSlider.setPaintTicks(true); //Hace los ticks visibles
            miSlider.setPaintLabels(true);
            miSlider.setPreferredSize(new Dimension(350, 80));
            add(miSlider);

            miSliderNum = new JTextField(40);
            add(miSliderNum);
            miSliderNum.setText(""+miSlider.getValue());

            miSlider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent changeEvent) {
                    miSliderNum.setText(String.valueOf(miSlider.getValue()));
                    tamanio = miSlider.getValue();
                }
            });
        }
    }

    static class CrearLaminaSliderColor extends JPanel{
        JSlider miSlider1, miSlider2, miSlider3;
        JTextField miSliderNum1, miSliderNum2, miSliderNum3;
        CrearLaminaSliderColor(){
            miSlider1 = new JSlider(0,255,5);
            miSlider1.setMajorTickSpacing(25);
            miSlider1.setMinorTickSpacing(1);
            miSlider1.setPaintTicks(true); //Hace los ticks visibles
            miSlider1.setPaintLabels(true);
            miSlider1.setPreferredSize(new Dimension(350, 80));

            miSlider2 = new JSlider(0,255,5);
            miSlider2.setMajorTickSpacing(25);
            miSlider2.setMinorTickSpacing(1);
            miSlider2.setPaintTicks(true); //Hace los ticks visibles
            miSlider2.setPaintLabels(true);
            miSlider2.setPreferredSize(new Dimension(350, 80));

            miSlider3 = new JSlider(0,255,5);
            miSlider3.setMajorTickSpacing(25);
            miSlider3.setMinorTickSpacing(1);
            miSlider3.setPaintTicks(true); //Hace los ticks visibles
            miSlider3.setPaintLabels(true);
            miSlider3.setPreferredSize(new Dimension(350, 80));

            add(miSlider1);
            miSliderNum1 = new JTextField(40);
            add(miSliderNum1);
            miSliderNum1.setText(""+ miSlider1.getValue());
            add(miSlider2);
            miSliderNum2 = new JTextField(40);
            add(miSliderNum2);
            miSliderNum2.setText(""+ miSlider1.getValue());
            add(miSlider3);
            miSliderNum3 = new JTextField(40);
            add(miSliderNum3);
            miSliderNum3.setText(""+ miSlider1.getValue());




            miSlider1.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent changeEvent) {
                    miSliderNum1.setText(String.valueOf(miSlider1.getValue()));
                    color1 = miSlider1.getValue();
                    miSliderNum2.setText(String.valueOf(miSlider1.getValue()));
                    color2 = miSlider2.getValue();
                    miSliderNum3.setText(String.valueOf(miSlider1.getValue()));
                    color3 = miSlider3.getValue();
                }
            });
        }
    }

    class LaminaNorOeste extends JPanel{
        public LaminaNorOeste(){
            GridLayout GestorUbiGrid = new GridLayout(6,1);
            setLayout(GestorUbiGrid);
            radio1 = new JRadioButton("Rojo", true);
            radio1.setFont(new Font("broadway", Font.BOLD,17));
            radio2 = new JRadioButton("Azul");
            radio2.setFont(new Font("broadway", Font.BOLD,17));
            radio3 = new JRadioButton("Amarillo");
            radio3.setFont(new Font("broadway", Font.BOLD,17));
            radio4 = new JRadioButton("Verde");
            radio4.setFont(new Font("broadway", Font.BOLD,17));
            radio5 = new JRadioButton("Naranja" );
            radio5.setFont(new Font("broadway", Font.BOLD,17));
            radio6 = new JRadioButton("Marron");
            radio6.setFont(new Font("broadway", Font.BOLD,17));
            grupoBotones.add(radio1);
            grupoBotones.add(radio2);
            grupoBotones.add(radio3);
            grupoBotones.add(radio4);
            grupoBotones.add(radio5);
            grupoBotones.add(radio6);
            add(radio1);
            add(radio2);
            add(radio3);
            add(radio4);
            add(radio5);
            add(radio6);

            personalizarFuente = new JButton("Personalizar color");
            // add(personalizarColor);
            // cambiarSliders cambiarSliders2 = new cambiarSliders();
            // personalizarColor.addActionListener(cambiarSliders2);

            ComprobarColores ComprobarColores1 = new ComprobarColores();
            radio1.addActionListener(ComprobarColores1);
            radio2.addActionListener(ComprobarColores1);
            radio3.addActionListener(ComprobarColores1);
            radio4.addActionListener(ComprobarColores1);
            radio5.addActionListener(ComprobarColores1);
            radio6.addActionListener(ComprobarColores1);
        }
    }

    class LaminaNorEste extends JPanel{
        private Image background;

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2D=(Graphics2D)g; //Conversion de Graphics en Graphics2D
            Color gualda= new Color(250,189,0);
            Font myComic = new Font("Comic Sans",Font.BOLD,100);
            this.setBackground(colorchange);
        }
    }

    class LaminaSurOeste extends JPanel{

        public LaminaSurOeste(){
            GridLayout GestorUbiGrid = new GridLayout(6,2);
            setLayout(GestorUbiGrid);
            fuente1 = new JRadioButton("ComicSans", true);
            fuente1.setFont(new Font("ComicSans", Font.BOLD,17));
            fuente2 = new JRadioButton("Serif");
            fuente2.setFont(new Font("Serif", Font.BOLD,17));
            fuente3 = new JRadioButton("Magneto");
            fuente3.setFont(new Font("Magneto", Font.BOLD,17));
            fuente4 = new JRadioButton("Broadway");
            fuente4.setFont(new Font("Broadway", Font.BOLD,17));

            grupoFuentes.add(fuente1);
            grupoFuentes.add(fuente2);
            grupoFuentes.add(fuente3);
            grupoFuentes.add(fuente4);


            personalizarFuente = new JButton("Personalizar Tamaño de fuente");




            ComprobarFuentes ComprobarFuentes1 = new ComprobarFuentes();


            tamanio1 = new JRadioButton("5", true);
            tamanio1.setFont(new Font("ComicSans", Font.BOLD,17));
            tamanio2 = new JRadioButton("10");
            tamanio2.setFont(new Font("ComicSans", Font.BOLD,17));
            tamanio3 = new JRadioButton("15");
            tamanio3.setFont(new Font("ComicSans", Font.BOLD,17));
            tamanio4 = new JRadioButton("20");
            tamanio4.setFont(new Font("ComicSans", Font.BOLD,17));
            tamanio5 = new JRadioButton("30");
            tamanio5.setFont(new Font("ComicSans", Font.BOLD,17));
            tamanio6= new JRadioButton("50");
            tamanio6.setFont(new Font("ComicSans", Font.BOLD,17));

            grupoTamanio.add(tamanio1);
            grupoTamanio.add(tamanio2);
            grupoTamanio.add(tamanio3);
            grupoTamanio.add(tamanio4);
            grupoTamanio.add(tamanio5);
            grupoTamanio.add(tamanio6);

            add(fuente1);
            add(fuente2);
            add(fuente3);
            add(fuente4);
            add(espacio);
            add(espacio);
            add(espacio);
            add(personalizarFuente);


            fuente1.addActionListener(ComprobarFuentes1);
            fuente2.addActionListener(ComprobarFuentes1);
            fuente3.addActionListener(ComprobarFuentes1);
            fuente4.addActionListener(ComprobarFuentes1);

            cambiarSliders cambiarSliders1 = new cambiarSliders();
            personalizarFuente.addActionListener(cambiarSliders1);

        }

    }

    class cambiarSliders implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Object fuente1=actionEvent.getSource();
            if (fuente1==personalizarFuente){
                CrearMarcoSlider1 crearMarcoSlider1 = new CrearMarcoSlider1(500,500);
            }else {
                CrearMarcoSlider2 crearMarcoSlider2 = new CrearMarcoSlider2(500,500);
            }
        }
    }

    class LaminaSurEste extends JPanel{

        public LaminaSurEste(){
            add(Texto);
        }
    }

    class ComprobarColores implements ActionListener{
        Color colorRojo = new Color(255,0,0);
        Color colorAzul = new Color(0,0,255);
        Color colorAmarillo = new Color(255,255,0);
        Color colorVerde = new Color(0,255,0);
        Color colorNaranja = new Color(255,165,0);
        Color colorMarron = new Color(52, 44, 4);
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==radio1){
                colorchange = colorRojo;
                repaint();
            } else if (e.getSource()==radio2) {
                colorchange = colorAzul;
                repaint();

            } else if (e.getSource()==radio3) {
                colorchange = colorAmarillo;
                repaint();

            } else if (e.getSource()==radio4) {
                colorchange = colorVerde;
                repaint();

            } else if (e.getSource()==radio5) {
                colorchange = colorNaranja;
                repaint();

            } else if (e.getSource()==radio6) {
                colorchange = colorMarron;
                repaint();

            }

        }
    }

    class ComprobarFuentes implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==fuente1){
                Texto.setFont(new Font("ComicSans", Font.PLAIN, tamanio));
                repaint();
            } else if (e.getSource()==fuente2) {
                Texto.setFont(new Font("Serif", Font.PLAIN, tamanio));
                repaint();
            } else if (e.getSource()==fuente3) {
                Texto.setFont(new Font("Magneto", Font.PLAIN, tamanio));
                repaint();
            } else if (e.getSource()==fuente4) {
                Texto.setFont(new Font("Broadway", Font.PLAIN, tamanio));
                repaint();
            }
        }
    }
}


