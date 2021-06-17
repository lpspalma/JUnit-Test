package sender;

import mock.article.Article;
import mock.article.Type;
import mock.client.Channel;
import mock.client.EntertainmentChannel;
import mock.client.OtherChannel;
import mock.client.SportChannel;
import mock.database.ArticleDataAccess;
import mock.sender.ArticleDistributor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatcher.*;

@RunWith(MockitoJUnitRunner.class)
public class ArticleDistributorTest {
    @Mock
    private SportChannel sport;
    @Mock
    private EntertainmentChannel entertainment;
    @Mock
    private OtherChannel other;
    @Mock
    private ArticleDataAccess dataAccess;

    @InjectMocks
    ArticleDistributor distributor;

    @Test
    public void sportGoesToSportPoliticsGoesToOther(){
        /*Channel sport = mock(Channel.class);
        Channel entertainment = mock(Channel.class);
        Channel other = mock(Channel.class);
        ArticleDataAccess dataAccess = mock(ArticleDataAccess.class);

        ArticleDistributor distributor = new ArticleDistributor(sport, entertainment, other, dataAccess);*/

        //given this list of articles
        List<Article> list = asList(
                new Article("Sports today", Type.SPORT),
                new Article("Politics is boring", Type.POLITICS)
        );
        when(dataAccess.getTodaysArticles()).thenReturn(list);
        //when we distribute

        distributor.distributeTodays();

        //then one goes to sport and one goes to other

        verify(sport).accept((Article) any());
        verify(other).accept((Article) any());
        verify(entertainment, never()).accept((Article) any());

    }

}