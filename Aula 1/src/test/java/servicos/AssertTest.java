package servicos;

import entidades.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class AssertTest {
    @Test
    public void test(){
        Assert.assertTrue(true);
        Assert.assertFalse(false);
        Assert.assertEquals(2,2);

        //comparacoes de double e float precisa do delta para comparar as casas decimais
        Assert.assertEquals(2.54,2.54,0.01);

        //para comparar objetos de classes primitivas deve converter para deixar os tipos iguais
        int i =2;
        Integer i2 = 2;
        Assert.assertEquals(Integer.valueOf(i),i2);
        Assert.assertEquals(i,i2.intValue());

        //comparando String
        Assert.assertEquals("bola","bola");
        Assert.assertNotEquals("bola","casa");
        Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
        Assert.assertTrue("bola".startsWith("bo"));

        //para comparar objetos eh importante garantir que o objeto diga se eles sao iguais
        //pq senao o java vai usar o defaut de comparar instancias e nao valores
        //por isso eh importante usar o metodo equal do metodo

        Usuario usuario1 = new Usuario("Usuario1");
        Usuario usuario2 = new Usuario("Usuario1");
        Usuario usuario3 = null;
        //implementei o equal no objeto usuario
        Assert.assertEquals(usuario1,usuario2);
        Assert.assertTrue(usuario1.equals(usuario2));
        //verifica se os objetos sao da mesma instancia
        Assert.assertSame(usuario1,usuario1);
        Assert.assertNull(usuario3);


    }
}
