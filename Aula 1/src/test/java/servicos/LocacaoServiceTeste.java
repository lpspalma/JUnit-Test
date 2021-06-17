package servicos;

import entidades.Filme;
import entidades.Locacao;
import entidades.Usuario;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import utils.DataUtils;

import java.util.Date;

public class LocacaoServiceTeste {

    @Test
    public void teste() {
        //cenario - inicializar tudo que preciso
        LocacaoService2 service = new LocacaoService2();
        Usuario usuario = new Usuario("Nome1");
        Filme filme = new Filme("Filme1", 3, 5.0);


        //acao - execucao do metodo a ser testado
        Locacao locacao=service.alugarFilme(usuario,filme);

        //verificacao - ver se o resultado retorna oq eh esperado
        Assert.assertThat(locacao.getValor(), CoreMatchers.is(5.0));
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(),
                DataUtils.obterDataComDiferencaDias(1)));


    }

}
