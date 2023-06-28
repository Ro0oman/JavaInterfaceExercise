import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;

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

class CrearLamina extends JPanel implements ActionListener{ //Añadimos la interfaz
    File apuntafich = new File("log.txt");
    JSlider miSlider;
    JLabel temNucleo, estable;

    JTextField tempNucleoNum;

    JButton guardar;

    FileWriter objetoFW=null;
    BufferedWriter objetoBW=null;
    FileReader fr = null;
    BufferedReader br = null;
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    Date date = new Date();

    int [] temperaturas;

    public CrearLamina() { //Constructor
        FlowLayout GestorUbiFlow = new FlowLayout(FlowLayout.CENTER);
        setLayout(GestorUbiFlow);
        File apuntafich = new File("log.txt");

        miSlider= new JSlider(0,3000,200);
        miSlider.setMajorTickSpacing(1000);
        miSlider.setMinorTickSpacing(200);
        miSlider.setPaintTicks(true); //Hace los ticks visibles
        miSlider.setPaintLabels(true);
        miSlider.setPreferredSize(new Dimension(850, 80));
        add(miSlider);

        temNucleo = new JLabel("Temperatura del nucleo");
        temNucleo.setFont(new Font("Arial", Font.PLAIN, 70));
        add(temNucleo);

        tempNucleoNum = new JTextField(40);
        add(tempNucleoNum);
        tempNucleoNum.setText(""+miSlider.getValue());

        estable = new JLabel("");
        estable.setFont(new Font("Arial", Font.PLAIN, 70));
        add(estable);

        guardar = new JButton("Guardar");
        add(guardar);
        guardar.addActionListener(this);


        miSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                tempNucleoNum.setText(String.valueOf(miSlider.getValue()));
                if (miSlider.getValue()<1000){
                    estable.setText("Estable");
                    estable.setForeground(Color.GREEN);
                }
                if (miSlider.getValue()>1000){
                    estable.setText("PRECAUCION");
                    estable.setForeground(Color.YELLOW);
                }
                if (miSlider.getValue()>1500){
                    estable.setText("RIESGO DE FUSION");
                    estable.setForeground(Color.RED);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente=e.getSource();

        if (apuntafich.exists()){
            try {
                objetoFW = new FileWriter("log.txt", true);
                objetoBW = new BufferedWriter(objetoFW);
                objetoBW.write(formatter.format(date)+"->"+miSlider.getValue()+"\n");
                objetoBW.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }else {
            try {
                apuntafich.createNewFile();
                try {
                    objetoFW = new FileWriter("log.txt", true);
                    objetoBW = new BufferedWriter(objetoFW);
                    objetoBW.write(formatter.format(date)+"->"+miSlider.getValue()+"\n");
                    objetoBW.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }catch (IOException ex) {
                System.out.println("Ha habido un problema al crear el fichero");
                ex.printStackTrace();
            }
        }
        } 
    }



