import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {

    public void criar() throws Exception{

        //  leitura da imagem
        //InputStream inputStream = new FileInputStream("entrada/filme.jpg");
        InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BYWFlZGY2NDktY2ZjOS00ZWNkLTg0ZDAtZDY4MTM1ODU4ZjljXkEyXkFqcGdeQXVyMjUzOTY1NTc@.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //  cria nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //  copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte
        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 120);
        graphics.setColor(Color.ORANGE);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString("DAHORA", 400, novaAltura - 100);

        //  escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));

    }
    public static void main(String[] args) throws Exception {
        GeradorDeFigurinhas geradora = new GeradorDeFigurinhas();
        geradora.criar();
    }    
}
