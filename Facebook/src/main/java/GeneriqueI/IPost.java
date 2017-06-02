package GeneriqueI;

/**
 *  Operations commmunes aux
 *  différents Constructeurs
 */
public interface IPost {

    /* --------- Extenseurs ------- */
    IPost changeContent(String content);
    IPost likeIt() ;
    IPost disLikeIt();

    /* ---------- Observateur  */

    int getLike() ;
    int getDislike();
    int getIdPost();

}
