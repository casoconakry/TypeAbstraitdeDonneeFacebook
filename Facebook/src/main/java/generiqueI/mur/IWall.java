package generiqueI.mur;

import generiqueI.post.IPost;

/**
 * Create by casoc on 02/06/2017.
 */
public interface IWall {

    /* ------------ Extenseurs -----------*/

    /**
     * Like le post à l'id en paramètre
     * sur le mur
     * @param id int
     * @return  IWall
     * @throws UnsupportedOperationException u
     */
    IWall likeApost(int id) throws UnsupportedOperationException;

    /**
     * DisLike le post à l'id en paramètre
     * sur le mur
     * @param id int
     * @return IWall
     * @throws UnsupportedOperationException u
     */
    IWall disLikeApost(int id) throws  UnsupportedOperationException;

    /**
     * Modere le post à l'id en paramètre,
     * en mettant à jour son contenu avec
     * le param c
     *
     * sur le mur
     * @param id int
     * @param c String
     * @return IWall
     * @throws UnsupportedOperationException u
     */
    IWall moderateApost(int id,String c) throws UnsupportedOperationException;

    /**
     * Supprime le post à l'id en paramètre
     * sur le mur
     * @param id int
     * @return IWall
     * @throws UnsupportedOperationException u
     */
    IWall removeApost(int id) throws UnsupportedOperationException;

    /* ----------- Observateurs --------- */

    /**
     *  Retourne l'id Max
     *  des posts sur le mur
     * @return int
     */
    int   idMax() ;

    /**
     *  Retourne le mur
     *  sans le premier
     *  post
     * @return IWall
     */
    IWall getRemainder() ;

    /**
     * Recupère le post ayant le plus
     * de like sur le mur
     * @return IWall
     * @throws UnsupportedOperationException u
     */
    IPost getMostFamous() throws UnsupportedOperationException;

}
