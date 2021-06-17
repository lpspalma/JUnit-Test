package mock.client;

import mock.article.Article;

public interface Channel {
    void accept(Article article);
}
