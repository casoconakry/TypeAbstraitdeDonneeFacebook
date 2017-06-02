package GeneriqueI;

/**
 *  Operations commmunes aux
 *  différents Constructeurs
 */
public interface IPost {

    /* --------- Extenseurs ------- */
    IPost changeContent(String content);
    IPost likeIt() throws  UnsupportedOperationException ;
    IPost disLikeIt() throws  UnsupportedOperationException;

    /* ---------- Observateur  */

    int getLike() ;
    int getDislike();
    int getIdPost();

}
