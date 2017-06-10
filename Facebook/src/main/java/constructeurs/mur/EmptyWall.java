package constructeurs.mur;

import generiqueI.mur.IWall;
import generiqueI.post.IPost;

/**
 * Create by casoc on 02/06/2017.
 */
public class EmptyWall implements IWall {

    public EmptyWall() {
    }

    @Override
    public IWall likeApost(int id)  {
         throw new  UnsupportedOperationException();
    }

    @Override
    public IWall disLikeApost(int id)  {
        throw new UnsupportedOperationException();
    }

    @Override
    public IWall moderateApost(int id, String c) {
       throw  new UnsupportedOperationException();
    }

    @Override
    public IWall removeApost(int id) {
      throw  new UnsupportedOperationException();
    }

    @Override
    public int idMax() {
        return 0;
    }

    @Override
    public IWall getRemainder() {
        return new EmptyWall();
    }

    @Override
    public IPost getMostFamous() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existePost(int id) {
        return false;
    }

    @Override
    public IPost getPostById(int id) {
        return null;
    }
}
