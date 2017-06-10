package constructeurs.mur;

import constructeurs.post.CreatePost;
import generiqueI.mur.IWall;
import generiqueI.post.IPost;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by casoc on 07/06/2017
 */
public class TestAddPost {

    private IWall murVide;
    private IWall murNonVide;
    private IPost postDebut;
    private int id =0 ,like =0,dislike =0;
    private String contenu =" contenu ";

    @Before
    public void setUp() throws Exception {
        murVide = new EmptyWall();
        postDebut = new CreatePost(id,like,dislike,contenu);
        murNonVide = new AddPost(postDebut,murVide);
    }

    @Test
    public void moderatePost() throws Exception
    {
        remplirLeMur();
        contenu ="nouveau contenu";
        murNonVide = murNonVide.moderateApost(0,contenu);

        Assert.assertTrue(murNonVide.getPostById(0).getContent() == contenu);
    }
    /**
     * Supprime Un post
     * dans un Mur
     * @throws Exception
     */
    @Test
    public void testRemoveAPost() throws Exception
    {
        remplirLeMur();
        //Supprime le post avec l'id 1
        murNonVide = murNonVide.removeApost(1);

        Assert.assertFalse(murNonVide.existePost(1));

    }

    /**
     * Le post qui a le plus
     * de like Sur le mur
     *
     * @throws Exception
     */
    @Test
    public void testGetMostFamous() throws Exception
    {
        remplirLeMur();
        murNonVide = murNonVide.likeApost(0);
        murNonVide = murNonVide.likeApost(0);
        murNonVide = murNonVide.likeApost(0);
        murNonVide = murNonVide.likeApost(0);

        IPost postFam = murNonVide.getMostFamous();

        Assert.assertTrue(postFam.getIdPost() == 0);
    }
    /**
     * Dislike un post dans le mur
     * @throws Exception
     */
    @Test
    public void testDislikeAPost() throws Exception
    {
        remplirLeMur();
        murNonVide = murNonVide.disLikeApost(2);
        murNonVide = murNonVide.disLikeApost(3);

        IPost post = murNonVide.getPostById(2);
        IPost post1 = murNonVide.getPostById(3);

        Assert.assertTrue(post.getDislike() == 1 &&
                          post1.getDislike() == 1);
    }
    /**
     * Like un Post Dans le
     * mur
     */
    @Test
    public void testLikeAPost() throws Exception
    {
        remplirLeMur();
        murNonVide =  murNonVide.likeApost(4);
        murNonVide = murNonVide.likeApost(4);
        IPost post = murNonVide.getPostById(4);

        Assert.assertTrue("post Liké deux fois",post.getLike() == 2);
    }

    /**
     * Retourne l'id Maximal du
     * mur
      * @throws Exception x
     */
    @Test
    public void testIdmax() throws Exception
    {
        remplirLeMur();

        Assert.assertEquals("Id Max est 4 ",4 ,murNonVide.idMax()  );
    }
    /**
     * Ajoute des Posts dans
     * le mur
     */
    private void remplirLeMur()
    {
        murNonVide = new AddPost( new CreatePost(murNonVide.idMax()+1,like,dislike,contenu), murNonVide);
        murNonVide =  new AddPost(new CreatePost(murNonVide.idMax()+1,like,dislike,contenu),murNonVide);
        murNonVide = new AddPost(new CreatePost(murNonVide.idMax()+1, like,dislike,contenu),murNonVide);
        murNonVide = new AddPost(new CreatePost(murNonVide.idMax()+1, like,dislike,contenu),murNonVide);
    }

    /**
     * Cas ou le Post existe
     * bien dans le mur
     */
    @Test
    public void testExisPoste2() throws Exception
    {
      remplirLeMur();
      Assert.assertTrue("Retourne vrai car le post existe",murNonVide.existePost(murNonVide.idMax()));
    }

    /**
     * Cas ou le post
     * n'existe pas.
     */
    @Test
    public void testExistePost() throws Exception
    {
      remplirLeMur();
      Assert.assertFalse("Retourne bien faux ",murNonVide.existePost(murNonVide.idMax()+1));
    }



}
