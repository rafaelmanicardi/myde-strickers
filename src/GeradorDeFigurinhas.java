import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {

    public void criar() throws Exception{

        //  leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.jpg"));

        //  cria nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;

        //  copiar a imagem original para nova imagem (em memória)

        // escrever uma frase na nova imagem

        //  escrever a nova imagem em um arquivo


    }
    
}
