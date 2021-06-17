package mock.sender;

import mock.article.Article;
import mock.client.Channel;
import mock.client.EntertainmentChannel;
import mock.client.OtherChannel;
import mock.client.SportChannel;
import mock.database.ArticleDataAccess;

public class ArticleDistributor {
    private SportChannel sport;
    private EntertainmentChannel entertainment;
    private OtherChannel others;
    private ArticleDataAccess dataAccess;

    public ArticleDistributor(SportChannel sport, EntertainmentChannel entertainment, OtherChannel others, ArticleDataAccess dataAccess) {
        this.sport = sport;
        this.entertainment = entertainment;
        this.others = others;
        this.dataAccess = dataAccess;
    }

    public void distributeTodays() {
        for(Article article: dataAccess.getTodaysArticles()){
            switch (article.getType()){
                case SPORT:
                    sport.accept(article);
                    break;
                case ENTERTAINMENT:
                    entertainment.accept(article);
                    break;
                default:
                    others.accept(article);
                    break;
            }
        }
    }
}
