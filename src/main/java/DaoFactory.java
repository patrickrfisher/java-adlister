public class DaoFactory {
    private static Ads adsDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(new Config());
        }
        return adsDao;
    }
}
//public class DaoFactory {
//    private static Ads adsDao;
//    private static Config config;
//    public static Ads getAdsDao() {
//        if (adsDao == null) {
//            adsDao = new MySQLAdsDao(config);
//        }
//        return adsDao;
//    }
//}
