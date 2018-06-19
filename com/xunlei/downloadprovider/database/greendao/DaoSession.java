package com.xunlei.downloadprovider.database.greendao;

import com.xunlei.downloadprovider.cardslide.a.e;
import com.xunlei.downloadprovider.database.a.a;
import com.xunlei.downloadprovider.personal.a.b.b.b;
import com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord;
import com.xunlei.downloadprovider.web.website.b.c;
import com.xunlei.downloadprovider.web.website.b.d;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

public class DaoSession extends AbstractDaoSession {
    private final BTSubTaskVisitRecordDao bTSubTaskVisitRecordDao = new BTSubTaskVisitRecordDao(this.bTSubTaskVisitRecordDaoConfig, this);
    private final DaoConfig bTSubTaskVisitRecordDaoConfig;
    private final CardSlideInfoDao cardSlideInfoDao = new CardSlideInfoDao(this.cardSlideInfoDaoConfig, this);
    private final DaoConfig cardSlideInfoDaoConfig;
    private final CollectWebsiteInfoDao collectWebsiteInfoDao = new CollectWebsiteInfoDao(this.collectWebsiteInfoDaoConfig, this);
    private final DaoConfig collectWebsiteInfoDaoConfig;
    private final HistoryWebsiteInfoDao historyWebsiteInfoDao = new HistoryWebsiteInfoDao(this.historyWebsiteInfoDaoConfig, this);
    private final DaoConfig historyWebsiteInfoDaoConfig;
    private final UserGridDataInfoDao userGridDataInfoDao = new UserGridDataInfoDao(this.userGridDataInfoDaoConfig, this);
    private final DaoConfig userGridDataInfoDaoConfig;
    private final VideoPlayRecordDao videoPlayRecordDao = new VideoPlayRecordDao(this.videoPlayRecordDaoConfig, this);
    private final DaoConfig videoPlayRecordDaoConfig;

    public DaoSession(Database database, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(database);
        this.cardSlideInfoDaoConfig = ((DaoConfig) map.get(CardSlideInfoDao.class)).clone();
        this.cardSlideInfoDaoConfig.initIdentityScope(identityScopeType);
        this.bTSubTaskVisitRecordDaoConfig = ((DaoConfig) map.get(BTSubTaskVisitRecordDao.class)).clone();
        this.bTSubTaskVisitRecordDaoConfig.initIdentityScope(identityScopeType);
        this.videoPlayRecordDaoConfig = ((DaoConfig) map.get(VideoPlayRecordDao.class)).clone();
        this.videoPlayRecordDaoConfig.initIdentityScope(identityScopeType);
        this.userGridDataInfoDaoConfig = ((DaoConfig) map.get(UserGridDataInfoDao.class)).clone();
        this.userGridDataInfoDaoConfig.initIdentityScope(identityScopeType);
        this.collectWebsiteInfoDaoConfig = ((DaoConfig) map.get(CollectWebsiteInfoDao.class)).clone();
        this.collectWebsiteInfoDaoConfig.initIdentityScope(identityScopeType);
        this.historyWebsiteInfoDaoConfig = ((DaoConfig) map.get(HistoryWebsiteInfoDao.class)).clone();
        this.historyWebsiteInfoDaoConfig.initIdentityScope(identityScopeType);
        registerDao(e.class, this.cardSlideInfoDao);
        registerDao(a.class, this.bTSubTaskVisitRecordDao);
        registerDao(VideoPlayRecord.class, this.videoPlayRecordDao);
        registerDao(b.class, this.userGridDataInfoDao);
        registerDao(c.class, this.collectWebsiteInfoDao);
        registerDao(d.class, this.historyWebsiteInfoDao);
    }

    public void clear() {
        this.cardSlideInfoDaoConfig.clearIdentityScope();
        this.bTSubTaskVisitRecordDaoConfig.clearIdentityScope();
        this.videoPlayRecordDaoConfig.clearIdentityScope();
        this.userGridDataInfoDaoConfig.clearIdentityScope();
        this.collectWebsiteInfoDaoConfig.clearIdentityScope();
        this.historyWebsiteInfoDaoConfig.clearIdentityScope();
    }

    public CardSlideInfoDao getCardSlideInfoDao() {
        return this.cardSlideInfoDao;
    }

    public BTSubTaskVisitRecordDao getBTSubTaskVisitRecordDao() {
        return this.bTSubTaskVisitRecordDao;
    }

    public VideoPlayRecordDao getVideoPlayRecordDao() {
        return this.videoPlayRecordDao;
    }

    public UserGridDataInfoDao getUserGridDataInfoDao() {
        return this.userGridDataInfoDao;
    }

    public CollectWebsiteInfoDao getCollectWebsiteInfoDao() {
        return this.collectWebsiteInfoDao;
    }

    public HistoryWebsiteInfoDao getHistoryWebsiteInfoDao() {
        return this.historyWebsiteInfoDao;
    }
}
