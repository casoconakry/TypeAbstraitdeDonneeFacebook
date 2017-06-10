package constructeurs.post;

import generiqueI.post.IPost;

/**
 * Constructeur POST PAR DEFAUT
 */
public class DefaultPost implements IPost {

   private int id;
   private String contenu;

    public DefaultPost(int id, String contenu) {
        assert (id > 0 );
        this.id = id;
        this.contenu = contenu;

    }

    @Override
    public IPost changeContent(String content) {
        return new  DefaultPost(id,content);
    }

    @Override
    public IPost likeIt()  {
       throw new UnsupportedOperationException();
    }

    @Override
    public IPost disLikeIt() {
      throw  new UnsupportedOperationException();
    }

    @Override
    public int getLike() {
        return 0;
    }

    @Override
    public int getDislike() {
        return 0;
    }

    @Override
    public int getIdPost() {
        return id;
    }

    @Override
    public String getContent() {
        return contenu;
    }
}
