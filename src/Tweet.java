public class Tweet {

    private int tweetId;
    private String icerik;
    private String hashtag;

    public Tweet(int tweetId, String icerik, String hashtag) {

        this.tweetId = tweetId;
        this.icerik = icerik;
        this.hashtag = hashtag;

    }

    // Getter ve Setter metotları
    public int getTweetId() {

        return tweetId;

    }

    public void setTweetId(int tweetId) {
        this.tweetId = tweetId;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

}
