import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        //  fazer uma conexão HTTP e buscar os top 250 filmes
        //String url = "https://imdb-api.com/en/API/Top250Movies/k_9zt1zkfd";
        String url = "https://api.nasa.gov/planetary/apod?api_key=HlQnYCLJ0Lp9j7qft1doxfMP9l6adZHEfKdmMCN7";

        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request,BodyHandlers.ofString());
        String body = response.body();

        //  extrair apenas os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeConteudos = parser.parse(body);
        
        //  Exibir e manipular os dados
         
        //for (Map<String,String> filme : listaDeFilmes) {
        for (int i = 0; i < 3; i++){

            Map<String, String> filme = listaDeConteudos.get(i);

            //String urlImagem = filme.get("image")
            String urlImagem = filme.get("url")
            .replaceAll("(@+)(.*).jpg$","$1.jpg");

            String titulo = filme.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = "saida/" + titulo + ".png";

            GeradorDeFigurinhas geradora = new GeradorDeFigurinhas();
            geradora.criar(inputStream, nomeArquivo);

            System.out.println(titulo);
            System.out.println();
            /*System.out.println(filme.get("imDbRating"));
            System.out.println();          
            System.out.println(filme.get("year"));
            System.out.println();*/
        }
    }
}
 