package generiqueI.post;

/**
 *  Operations commmunes aux
 *  différents Constructeurs
 */
public interface IPost {

    /* --------- Extenseurs ------- */

    /** Change le contenu d'un post
     *
     *
     * @param content String
     * @return IPost
     */
    IPost changeContent(String content);

    /**
     * ajoute de 1 le nombre de like
     *
     *
     * @return IPost
     * @throws UnsupportedOperationException U
     */
    IPost likeIt() throws  UnsupportedOperationException ;

    /**
     * ajoute de 1 le nombre de dislike
     * @return IPost
     * @throws UnsupportedOperationException U
     */
    IPost disLikeIt() throws  UnsupportedOperationException;

    /* ---------- Observateur  */

    /**
     * recupère le nombre de like d'un post
     * @return int
     */
    int getLike() ;

    /**
     * recupère le nombre de dislike d'un post
     * @return int
     */
    int getDislike();

    /**
     * recupère l'id d'un post
     * @return int
     */
    int getIdPost();

    /**
     * Retourne le contenu
     * d'un Post
     * @return String
     */
    String getContent();

}
