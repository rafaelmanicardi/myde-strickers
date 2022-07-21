import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        //  fazer uma conexão HTTP e buscar os top 250 filmes

        String url = "https://imdb-api.com/en/API/Top250Movies/k_9zt1zkfd";
        ExtratorDeConteudoDoIMDB extrator = new ExtratorDeConteudoDoIMDB();

        //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        //ExtratorDeConteudoDaNasa extrator = new ExtratorDeConteudoDaNasa();     

        ClienteHttp http = new ClienteHttp();
        String json = http.buscaDados(url);

        //  Exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
         
        //for (Map<String,String> filme : listaDeFilmes) {
        for (int i = 0; i < 3; i++){

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            GeradorDeFigurinhas geradora = new GeradorDeFigurinhas();
            geradora.criar(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();


            /*System.out.println(conteudo.get("imDbRating"));
            System.out.println();          
            System.out.println(conteudo.get("year"));
            System.out.println();*/
        }
    }
}
 