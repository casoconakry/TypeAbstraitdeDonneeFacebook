package constructeurs.mur;

import generiqueI.mur.IWall;
import generiqueI.post.IPost;

/**
 * Create by casoc on 03/06/2017.
 */
public class AddPost implements IWall {

    private IPost post;
    private IWall nextWall; // Pointeur Sur le reste du Mur

    public AddPost(IPost post, IWall nextWall) {
        this.post = post;
        this.nextWall = nextWall;
    }

    @Override
    public IWall likeApost(int id) throws UnsupportedOperationException {
        //S'assure que le Post existe bien
        assert (existePost(id));

        if(post.getIdPost() == id)
        {
          // Mets à jour le nombre de Like
          // Avec un nouveau pointeur sur l'entete
           return new AddPost(post.likeIt(),nextWall);
        }
        // Dans le cas ou c'est pas le Bon
        //Post on réconstruit récurssivement
        //Le mur Sans quoi on perdrait des Post

           return new AddPost(post,nextWall.likeApost(id));
    }

    @Override
    public IWall disLikeApost(int id) throws UnsupportedOperationException {
        //S'assure que le Post existe bien
        assert( existePost(id));

        if(post.getIdPost() == id)
        {
            // Mets à jour le nombre de Like
            // Avec un nouveau pointeur sur l'entete
            return new AddPost(post.disLikeIt(),nextWall);
        }

        return  new AddPost(post,nextWall.disLikeApost(id));
    }

    @Override
    public boolean existePost(int id) {

        // Arret de la Recurvité
        if(post.getIdPost() == id) return true;

        // Si pas Trouvé descente en profondeur
        // Dans le mur
        return nextWall.existePost(id);
    }

    @Override
    public IPost getPostById(int id) {
       // S'assure que le post existe dans le mur
        assert (existePost(id));

        //Condidtion d'arret de la recursité
        if(post.getIdPost() == id ) return  post;

        //Descente Recursive dans le reste du mur
        return nextWall.getPostById(id);
    }

    @Override
    public IWall moderateApost(int id, String c) throws UnsupportedOperationException {
        // S'assure que le postexiste
        assert(existePost(id));
        // Arret de la récursité
        if(post.getIdPost() == id) return new AddPost(post.changeContent(c),nextWall);

        //Descente Recursive
        return nextWall.moderateApost(id,c);
    }

    @Override
    public IWall removeApost(int id) throws UnsupportedOperationException {
        assert (existePost(id));

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

        if(nextWall instanceof EmptyWall) return post;

        if(post.getLike() > nextWall.getMostFamous().getLike())
        return post;

        return  nextWall.getMostFamous();
    }


}
