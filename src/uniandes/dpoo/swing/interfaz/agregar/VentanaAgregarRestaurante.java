package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaAgregarRestaurante extends JFrame
{
    /**
     * El panel donde se editan los detalles del restaurante
     */
    private PanelEditarRestaurante panelDetalles;

    /**
     * El panel con los botones para agregar un restaurante o cerrar la ventana
     */
    private PanelBotonesAgregar panelBotones;

    /**
     * El panel para marcar la ubicación del restaurante
     */
    private PanelMapaAgregar panelMapa;

    /**
     * La ventana principal de la aplicación
     */
    private VentanaPrincipal ventanaPrincipal;

    public VentanaAgregarRestaurante( VentanaPrincipal principal )
    {
        this.ventanaPrincipal = principal;
        setLayout( new BorderLayout( ) );
        
        setTitle("Agregar Restaurante");
        setSize(800, 600);
        
        panelMapa = new PanelMapaAgregar();
        add(panelMapa, BorderLayout.CENTER);
        
        JPanel panelSur = new JPanel(new BorderLayout());

        // Panel de detalles
        panelDetalles = new PanelEditarRestaurante();
        panelSur.add(panelDetalles, BorderLayout.CENTER);

        // Panel de botones
        panelBotones = new PanelBotonesAgregar(this);
        panelSur.add(panelBotones, BorderLayout.SOUTH);

        // Agrega el panel sur a la ventana
        add(panelSur, BorderLayout.SOUTH);


        // Termina de configurar la ventana
        pack( );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setResizable( false );
    }

    /**
     * Le pide al panelDetalles los datos del nuevo restaurante y se los envía a la ventana principal para que cree el nuevo restaurante, y luego cierra la ventana.
     */
    public void agregarRestaurante( )
    {
    	String nombre = panelDetalles.getNombre();
        int calificacion = panelDetalles.getCalificacion();
        boolean visitado = panelDetalles.getVisitado();
        int[] coordenadas = panelMapa.getCoordenadas();
        int coordenadaX = coordenadas[0];
        int coordenadaY = coordenadas[1];
        
        // Valida que el nombre no esté vacío
        if (nombre.isEmpty()) {
            System.out.println("El nombre del restaurante no puede estar vacío.");
            return;
        }

        // Llama a un método de ventanaPrincipal para agregar el restaurante
        ventanaPrincipal.agregarRestaurante(nombre, calificacion,coordenadaX, coordenadaY, visitado);

        // Cierra la ventana después de agregar
        cerrarVentana();
    }

    /**
     * Cierra la ventana sin crear un nuevo restaurante
     */
    public void cerrarVentana( )
    {
        dispose( );
    }

}
