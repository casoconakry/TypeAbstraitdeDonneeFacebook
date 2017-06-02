package constructeurs.mur;

import generiqueI.mur.IWall;
import generiqueI.post.IPost;

/**
 * Create by casoc on 03/06/2017.
 */
public class AddPost implements IWall {

    private IPost post;
    private IWall nextWall;

    public AddPost(IPost post, IWall nextWall) {
        this.post = post;
        this.nextWall = nextWall;
    }

    @Override
    public IWall likeApost(int id) throws UnsupportedOperationException {

        if(post.getIdPost() == id)
        {
           return new AddPost(post.likeIt(),nextWall);
        }
           return new AddPost(post,nextWall.likeApost(id));
    }

    @Override
    public IWall disLikeApost(int id) throws UnsupportedOperationException {
        if(post.getIdPost() == id)
        {
            return new AddPost(post.disLikeIt(),nextWall);
        }
        return  new AddPost(post,nextWall.disLikeApost(id));
    }

    @Override
    public IWall moderateApost(int id, String c) throws UnsupportedOperationException {
        return null;
    }

    @Override
    public IWall removeApost(int id) throws UnsupportedOperationException {

        if(post.getIdPost() == id)
        {
           return nextWall;
        }
        return new  AddPost(post,nextWall.removeApost(id));
    }

    @Override
    public int idMax() {

          if(post.getIdPost() > nextWall.idMax()) { return post.getIdPost();}
          else {
            return   nextWall.idMax() ;}
    }

    @Override
    public IWall getRemainder() {
        return nextWall;
    }

    @Override
    public IPost getMostFamous() throws UnsupportedOperationException {

       return this.post;
    }
}
