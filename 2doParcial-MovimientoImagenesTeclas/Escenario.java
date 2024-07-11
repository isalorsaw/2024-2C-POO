import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
//Librerias para Evento de Mov Teclas
import java.awt.event.KeyListener;//Evento de Teclas (Key)
import java.awt.event.KeyEvent;//Evento de Accion de Teclas
public class Escenario extends JPanel implements KeyListener
{
    //Variable Global
    Fondo f;
    Carro c;
    public Escenario()
    {
        inicializarFondo();
        inicializarCarro();
        
        
        this.setBackground(Color.WHITE);//Cambiar el Fondo a Blanco
        this.setFocusable(true);//Vuelve prioridad este panel
        this.setSize(f.ancho,f.alto);//Tamanio del Panel
        this.addKeyListener(this);//Agregando el Evento de Teclas en el Panel
        this.setVisible(true);//Muestra el Panel
    }
    public void keyReleased(KeyEvent evt)//Soltar una Tecla
    {
        
    }
    public void keyPressed(KeyEvent evt)//Presionar una Tecla
    {
         int codigo=evt.getKeyCode();
        System.out.println("Codigo "+codigo);
        if(codigo==39)//Mov Derecha
        {
            c.mover('d');
        }
        else if(codigo==37)//Mov Izq
        {
            c.mover('i');
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
        
        g.drawString("toString Carro "+c.toString(),0,430);
        f.dibujar(g);
        c.dibujar(g);
        //g.drawOval(150,150,40,40);
        //g.drawRect(250,150,40,40);
        //g.drawImage();
    }
}