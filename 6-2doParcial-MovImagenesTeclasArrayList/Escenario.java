import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
//Librerias para Evento de Mov Teclas
import java.awt.event.KeyListener;//Evento de Teclas (Key)
import java.awt.event.KeyEvent;//Evento de Accion de Teclas
import java.util.ArrayList;
public class Escenario extends JPanel implements KeyListener
{
    //Variable Global
    Fondo f;
    Carro c;
    //Carro ca[];
    ArrayList<Carro> ca;//=null
    String imagencarro="imagenes/carro.png";
    public Escenario()
    {
        inicializarFondo();
        inicializarCarro();
        inicializarCarros();//Creando carros en ArrayList
        
        this.setBackground(Color.WHITE);//Cambiar el Fondo a Blanco
        this.setFocusable(true);//Vuelve prioridad este panel
        this.setSize(f.ancho,f.alto);//Tamanio del Panel
        this.addKeyListener(this);//Agregando el Evento de Teclas en el Panel
        this.setVisible(true);//Muestra el Panel
    }
    public void inicializarCarros()
    {
        ca=new ArrayList<Carro>();
        for(int i=0;i<5;i++)
        {
            int x=ClaseFM.generaAleatorio(10,750);
            ca.add(new Carro(x,260,imagencarro,5));
        }
    }
    public void dibujarCarros(Graphics g)
    {
        for(int i=0;i<ca.size();i++)
        {
            //Carro temp=ca.get(i);//Sacar del arraylist y convertir a carro
            //temp.dibujar(g);
            ca.get(i).dibujar(g);
        }
    }
    public void moverCarros(char dir)
    {
        for(int i=0;i<ca.size();i++)
        {
            //Carro temp=ca.get(i);//Sacar del arraylist y convertir a carro
            //temp.dibujar(g);
            ca.get(i).mover(dir);
        }
    }
    public void keyReleased(KeyEvent evt)//Soltar una Tecla
    {
        
    }
    
    public void keyPressed(KeyEvent evt)//Presionar una Tecla
    {
         int codigo=evt.getKeyCode();
        //System.out.println("Codigo "+codigo);
        if(codigo==39)//Mov Derecha
        {
            c.mover('d');
            moverCarros('d');
        }
        else if(codigo==37)//Mov Izq
        {
            c.mover('i');
            moverCarros('i');
        }
        repaint();
    }
    public void keyTyped(KeyEvent evt)//Tocar la tecla
    {
        
    }
    public void inicializarFondo()
    {
        f=new Fondo(0,0,"imagenes/fondo.jpg");
    }
    public void inicializarCarro()
    {
        int x=ClaseFM.generaAleatorio(10,750);
        c=new Carro(x,260,"imagenes/carro.png",5);
    }
    public void paint(Graphics g)
    {
        super.paint(g);//Linea obligatoria para dibujar
        
        g.drawString("DISPLAY toString Carro "+c.toString(),0,430);
        f.dibujar(g);
        c.dibujar(g);
        dibujarCarros(g);
    }
}