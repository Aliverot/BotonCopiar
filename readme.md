# Explicacion del codigo
1. Importación de librerías:
Estas importaciones incluyen clases esenciales de la biblioteca de Java para crear interfaces gráficas (JTextArea, JPopupMenu, JButton, etc.), así como clases para manejar el portapapeles (Clipboard, StringSelection) y eventos del mouse (MouseAdapter, MouseEvent).

![image](https://github.com/user-attachments/assets/cf8b22b8-b473-4329-a04e-8eb756dd36c1)

2. Definición de la clase AreaBotonEmergente:
Esta clase extiende JTextArea, lo que significa que hereda toda la funcionalidad de un área de texto y añade características adicionales, como el botón de copiado.
Se declaran dos atributos:
- menuEmergente, que es un menú emergente (JPopupMenu) para contener el botón de copiar.
- botonCopiar, un botón (JButton) que será utilizado para copiar el texto seleccionado.

![image](https://github.com/user-attachments/assets/7f98c807-1ce1-413b-952e-0b562c38f2b5)

3. Constructor AreaBotonEmergente:
- Este constructor inicializa la configuración básica del área de texto.
- setLineWrap(true): Hace que el texto se ajuste automáticamente a la siguiente línea cuando llega al final del área de texto.
- setWrapStyleWord(true): Ajusta el texto en la palabra completa, evitando cortar palabras al final de la línea.

![image](https://github.com/user-attachments/assets/75e33c0a-6404-47bf-b4be-427b906bacfb)

4. Creación del botón de copiar botonCopiar:
- Se crea una instancia de JButton sin texto, ya que se usará un icono como etiqueta visual.
- new ImageIcon(getClass().getResource("/imagen/Copiar.png")): Carga la imagen ubicada en el directorio /imagen/.
- getScaledInstance(20, 20, Image.SCALE_SMOOTH): Redimensiona la imagen a 20x20 píxeles para que el icono sea pequeño y uniforme.
- setBackground(Color.lightGray): Configura el color de fondo del botón en gris claro.
- addActionListener(...): Añade una acción al botón que llama al método copiarPortapapeles cuando el usuario hace clic en el botón.

![image](https://github.com/user-attachments/assets/c0297b76-c3b0-4f4f-a844-2b291c2de7ba)

5. Creación del menú emergente menuEmergente:
- Se instancia menuEmergente como un JPopupMenu y se añade botonCopiar como su único elemento.
- setBackground(new Color(0, 0, 0, 0)) y setOpaque(false): Configuran el menú para que sea transparente.
  
![image](https://github.com/user-attachments/assets/9565d30f-e805-4d58-a69f-22e6bb47d037)

6. Escuchar eventos del ratón:
- Estos dos MouseAdapter gestionan el comportamiento del menú emergente.
- Primer MouseAdapter:
-- En el evento mouseClicked, el menú se oculta al hacer clic en cualquier lugar fuera del botón.
-Segundo MouseAdapter:
-- En mouseReleased, se llama a mostrarMenu para abrir el menú emergente solo si hay texto seleccionado.
  
# Video
https://github.com/user-attachments/assets/aafe63a1-e09c-4d20-b1d0-be73ea7f31d0

