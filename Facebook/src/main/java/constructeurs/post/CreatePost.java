package constructeurs.post;

import generiqueI.post.IPost;

/**
 *  Constructeurs  CreatePost,
 *
 */
public class CreatePost implements IPost {

    private int id ;
    private int like;
    private int dislike;
    private String contenu;

    public CreatePost(int id, int like, int dislike, String contenu) {

        assert(id >= 0) ;
        this.id = id;
        this.like = like;
        this.dislike = dislike;
        this.contenu = contenu;
    }

    @Override
    public IPost changeContent(String content) {
        return new CreatePost(id,like,dislike,content);
    }

    @Override
    public IPost likeIt() {
        return new CreatePost(id,like+1,dislike,contenu);
    }

    @Override
    public IPost disLikeIt() {
        return new CreatePost(id,like,dislike + 1, contenu);
    }

    @Override
    public int getLike() {
        return like;
    }

    @Override
    public int getDislike() {
        return dislike;
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
