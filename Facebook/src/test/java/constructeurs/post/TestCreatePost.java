package constructeurs.post;

import generiqueI.post.IPost;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by casoc on 07/06/2017
 */
public class TestCreatePost {
    private IPost post ; 
    private int id = 0,like =0,dislike;
    private  String contenu = " post de Test ";
    @Before
    public void setUp() throws Exception {
       
        post = new CreatePost(id,like,dislike,contenu);
    }


    @Test
    public void testDislikeIt() throws Exception
    {
        post = post.disLikeIt();
        Assert.assertEquals("Post disliké ",dislike+1,post.getDislike());
    }
    /**
     * Like d'un Post
     * @throws Exception X
     */
    @Test
    public void testLikeIt() throws Exception{
        post = post.likeIt();
        Assert.assertEquals("Post Liké ",like+1,post.getLike());

    }
    /**
     * Teste La mise du contenu
     * d'un Post
     * @throws Exception X
     */
    @Test
    public void testChangeContent() throws Exception {
        String nouveuContenu = " nouveau contenu ";

        post = post.changeContent(nouveuContenu);

        Assert.assertTrue("Post Mis à Jour ", nouveuContenu.equals(post.getContent()));
    }
}
