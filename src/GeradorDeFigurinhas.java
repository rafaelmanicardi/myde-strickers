import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {

    public void criar() throws Exception{

        //  leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.jpg"));

        //  cria nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //  copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte
        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 70);
        graphics.setColor(Color.ORANGE);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString("DAHORA", 520, novaAltura - 100);

        //  escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/figurinha.png"));

    }
    public static void main(String[] args) throws Exception {
        GeradorDeFigurinhas geradora = new GeradorDeFigurinhas();
        geradora.criar();
    }    
}
