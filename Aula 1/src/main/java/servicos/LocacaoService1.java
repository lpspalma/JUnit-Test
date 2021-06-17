package servicos;

import static utils.DataUtils.adicionarDias;

import java.util.Date;

import entidades.Filme;
import entidades.Locacao;
import entidades.Usuario;

public class LocacaoService1 {

    public Locacao alugarFilme(Usuario usuario, Filme filme) {
        Locacao locacao = new Locacao();
        locacao.setFilme(filme);
        locacao.setUsuario(usuario);
        locacao.setDataLocacao(new Date());
        locacao.setValor(filme.getPrecoLocacao());

        //Entrega no dia seguinte
        Date dataEntrega = new Date();
        dataEntrega = adicionarDias(dataEntrega, 1);
        locacao.setDataRetorno(dataEntrega);

        //Salvando a locacao...
        //TODO adicionar método para salvar

        return locacao;
    }

    public static void main(String[] args) {
        //cenario - inicializar tudo que preciso
        LocacaoService1 service = new LocacaoService1();
        Usuario usuario = new Usuario("Nome1");
        Filme filme = new Filme("Filme1", 3, 5.0);


        //acao - execucao do metodo a ser testado
        Locacao locacao=service.alugarFilme(usuario,filme);

        //verificacao - ver se o resultado retorna oq eh esperado
        System.out.println(locacao.getValor());
        System.out.println(locacao.getDataLocacao());
        System.out.println(locacao.getDataRetorno());

    }
}
